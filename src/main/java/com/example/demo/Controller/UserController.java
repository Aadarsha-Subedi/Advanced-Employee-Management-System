package com.example.demo.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.DTO.UserLeaveRequestDTO;
import com.example.demo.Entity.AdminDetails;
import com.example.demo.Entity.UpdateDetails;
import com.example.demo.Entity.UserDetails;
import com.example.demo.Entity.UserLeaveRequest;
import com.example.demo.Repository.EmployeeLeaveRepository;
import com.example.demo.Service.EmployeeServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	@Autowired
	EmployeeLeaveRepository employeeLeaveRepository;
	
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

	@GetMapping("/UserPage")
	public String UserPage(Model model, HttpSession session) {
	    // Retrieve user details from session
	    model.addAttribute("userID", session.getAttribute("userID"));
	    model.addAttribute("fullName", session.getAttribute("fullName"));
	    model.addAttribute("email", session.getAttribute("email"));
	    model.addAttribute("phoneNumber", session.getAttribute("phoneNumber"));
	    List<UpdateDetails> updateDetails = employeeServiceImpl.getallUpdates();
	    model.addAttribute("updateDetails", updateDetails);
	    return "UserPage";
	}
	
	@GetMapping("/UserTaskPage")
	public String UserTaskPage(Model model, HttpSession session) {
	    // Retrieve user details from session
	    model.addAttribute("userID", session.getAttribute("userID"));
	    model.addAttribute("fullName", session.getAttribute("fullName"));
	    model.addAttribute("email", session.getAttribute("email"));
	    model.addAttribute("phoneNumber", session.getAttribute("phoneNumber"));
		return "UserTaskPage";
	}
	
	@GetMapping("/UserLeaveRequestPage")
	public String UserLeaveRequestPage(Model model, HttpSession session) {
	    // Retrieve user details from session
	    int userID = (int) session.getAttribute("userID");
	    
	    // Retrieve leave requests associated with the current user
	    List<UserLeaveRequest> userLeaveRequests = employeeServiceImpl.findUserByLeaveRequest(userID);
	    
	    model.addAttribute("userLeaveRequests", userLeaveRequests);
	    model.addAttribute("userID", session.getAttribute("userID"));
	    model.addAttribute("fullName", session.getAttribute("fullName"));
	    model.addAttribute("email", session.getAttribute("email"));
	    model.addAttribute("phoneNumber", session.getAttribute("phoneNumber"));
	    return "UserLeaveRequestPage";
	}

	
	@PostMapping("/UserLeaveRequestPage")
	public String handleLeaveRequest(@ModelAttribute UserLeaveRequestDTO userLeaveRequestDTO, Model model, HttpSession session) {
	    UserLeaveRequest userLeaveRequest = new UserLeaveRequest();
	    Optional<AdminDetails> adminDetails = employeeServiceImpl.findAdminById(userLeaveRequestDTO.getAdminID());
	    Optional<UserDetails> userDetails = employeeServiceImpl.findUserById(userLeaveRequestDTO.getUserID());
	    userLeaveRequest.setId(userLeaveRequestDTO.getId());
	    userLeaveRequest.setEmployee(userDetails.get());
	    userLeaveRequest.setAdmin(adminDetails.get());
	    userLeaveRequest.setDescription(userLeaveRequestDTO.getDescription());
	    userLeaveRequest.setStartDate(userLeaveRequestDTO.getStartDate());
	    userLeaveRequest.setEndDate(userLeaveRequestDTO.getEndDate());
	    employeeLeaveRepository.save(userLeaveRequest);
	    return "redirect:/UserLeaveRequestPage";
	}


	@GetMapping("/UserLeaveRequestForm")
	public String UserLeaveRequestForm(Model model, HttpSession session) {
	    // Retrieve user details from session
	    List<AdminDetails> admins = employeeServiceImpl.getAllAdmins();
	    model.addAttribute("userLeaveRequestDTO", new UserLeaveRequestDTO());
	    model.addAttribute("userID", session.getAttribute("userID"));
	    model.addAttribute("fullName", session.getAttribute("fullName"));
	    model.addAttribute("email", session.getAttribute("email"));
	    model.addAttribute("phoneNumber", session.getAttribute("phoneNumber"));
	    model.addAttribute("admins", admins);
	    model.addAttribute("adminID", session.getAttribute("adminID"));
	    return "UserLeaveRequestForm";
	}

	@GetMapping("/UserLeaveRequestPage/{id}")
	public String deleteUserLeaveRequest(@PathVariable int id) {
		employeeServiceImpl.deleteUserLeaveRequestById(id);
		return "redirect:/UserLeaveRequestPage";
	}
	
}
