package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.DTO.LoginDetailsDTO;
import com.example.demo.Entity.AdminDetails;
import com.example.demo.Entity.UserDetails;
import com.example.demo.Service.EmployeeServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class LoginController {
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	
    @GetMapping("/")
    public String showLoginPage(Model model, HttpServletRequest request) {
        model.addAttribute("loginDetailsDTO", new LoginDetailsDTO());
        return "LoginPage";
    }

	@PostMapping(value = "/")
	public String validateLoginDetails(@Valid LoginDetailsDTO loginDetailsDTO, BindingResult bindingResult, HttpSession session) {
		if(bindingResult.hasErrors()) {
			return "LoginPage";
		}
		Optional<UserDetails> checkUser = employeeServiceImpl.findUserById(loginDetailsDTO.getUserID());
		Optional<AdminDetails> checkAdmin = employeeServiceImpl.findAdminById(loginDetailsDTO.getUserID());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(checkUser.isPresent() == true) {
			UserDetails user = checkUser.get();
			if(encoder.matches(loginDetailsDTO.getUserPassword(), user.getPassword()) == true) {
			    session.setAttribute("userID", user.getId());
			    session.setAttribute("fullName", user.getFullName());
			    session.setAttribute("email", user.getEmail());
			    session.setAttribute("phoneNumber", user.getPhoneNumber());
				return "redirect:/UserPage";
			}
			return "LoginPage";
		}
		else if(checkAdmin.isPresent() == true) {
			AdminDetails admin = checkAdmin.get();
			if(encoder.matches(loginDetailsDTO.getUserPassword(), admin.getPassword()) == true) {
			    session.setAttribute("userID", admin.getId());
			    session.setAttribute("fullName", admin.getFullName());
			    session.setAttribute("email", admin.getEmail());
			    session.setAttribute("phoneNumber", admin.getPhoneNumber());
				return "redirect:/AdminPage";
			}
			return "LoginPage";
		}
		
		return "LoginPage";
	}
	
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "LoginPage"; // Redirect to your login page
    }
}
