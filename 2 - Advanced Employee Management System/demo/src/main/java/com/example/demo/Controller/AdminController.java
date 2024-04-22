package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.DTO.UserDetailsDTO;
import com.example.demo.Entity.UserDetails;
import com.example.demo.Service.EmployeeServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	
	@GetMapping("/AdminPage")
	public String AdminPage(Model model, HttpSession session) {
	    // Retrieve user details from session
	    model.addAttribute("userID", session.getAttribute("userID"));
	    model.addAttribute("fullName", session.getAttribute("fullName"));
	    model.addAttribute("email", session.getAttribute("email"));
	    model.addAttribute("phoneNumber", session.getAttribute("phoneNumber"));

	    return "AdminPage";
	}
	
	@GetMapping("/AdminTaskPage")
	public String AdminTaskPage() {
		return "AdminTaskPage";
	}

	@GetMapping("/AdminLeavePage")
	public String AdminLeavePage() {
		return "AdminLeavePage";
	}

	@GetMapping("/employees")
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeServiceImpl.getAllUsers());
		return "employees";
	}
	
	@GetMapping("/employees/new")
	public String createEmployee(Model model) {
		UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
		model.addAttribute("userDetailsDTO", userDetailsDTO);
		return "create_employee";
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("userDetailsDTO") UserDetailsDTO userDetailsDTO) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		UserDetails userDetails = new UserDetails();
		userDetails.setFullName(userDetailsDTO.getFullName());
		userDetails.setEmail(userDetailsDTO.getEmail());
		userDetails.setPhoneNumber(userDetailsDTO.getPhoneNumber());
		userDetails.setPassword(encoder.encode(userDetailsDTO.getPassword()));
		employeeServiceImpl.save(userDetails);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/edit/{id}")
	public String editEmployee(@PathVariable int id, Model model) {
		model.addAttribute("userDetailsDTO", employeeServiceImpl.findUserById(id).orElse(new UserDetails()));
		return "edit_employee";
	}
	
	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable int id, @ModelAttribute("employee") UserDetailsDTO userDetailsDTO, Model model) {
	    Optional<UserDetails> findEmployeeOptional = employeeServiceImpl.findUserById(id);
	    if (findEmployeeOptional.isPresent()) {
	        UserDetails findEmployee = findEmployeeOptional.get();
	        findEmployee.setFullName(userDetailsDTO.getFullName());
	        findEmployee.setEmail(userDetailsDTO.getEmail());
	        findEmployee.setPhoneNumber(userDetailsDTO.getPhoneNumber());
	        employeeServiceImpl.save(findEmployee);
	    }
	    return "redirect:/employees";
	}
	
	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {
		employeeServiceImpl.deleteEmployeeByID(id);
		return "redirect:/employees";
	}

	
}
