package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@GetMapping("/UserPage")
	public String UserPage(Model model, HttpSession session) {
	    // Retrieve user details from session
	    model.addAttribute("userID", session.getAttribute("userID"));
	    model.addAttribute("fullName", session.getAttribute("fullName"));
	    model.addAttribute("email", session.getAttribute("email"));
	    model.addAttribute("phoneNumber", session.getAttribute("phoneNumber"));

	    return "UserPage";
	}
	
	@GetMapping("/UserTaskPage")
	public String UserTaskPage() {
		return "UserTaskPage";
	}
	
	@GetMapping("/UserLeaveRequestPage")
	public String UserLeaveRequestPage() {
		return "UserLeaveRequestPage";
	}
	
    @GetMapping("/UserLeaveRequestForm") // Define the URL path
    public String UserLeaveRequestForm() {
        return "UserLeaveRequestForm"; // Return the name of the HTML file without extension
    }
	
}
