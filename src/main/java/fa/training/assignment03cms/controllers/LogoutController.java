package fa.training.assignment03cms.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {
    @GetMapping
    private String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
