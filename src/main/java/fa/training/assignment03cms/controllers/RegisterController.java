package fa.training.assignment03cms.controllers;

import fa.training.assignment03cms.entities.Member;
import fa.training.assignment03cms.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    private final MemberService memberService;

    @GetMapping
    private String getRegister() {
        return "register";
    }

    @PostMapping
    private String register(Member member,  RedirectAttributes ra) {

//        if (bindingResult.hasErrors()) {
//            return "register";
//        }

        if (memberService.validRegisterAccount(member.getEmail(), member.getUsername())) {
            member.setCreatedDate(LocalDateTime.now());
            memberService.save(member);
            ra.addFlashAttribute("successMessage", "Registration successful!");
            return "redirect:/login";
        }

        ra.addFlashAttribute("errorMessage", "Email or username already exists.");
        return "redirect:/register";

    }

}
