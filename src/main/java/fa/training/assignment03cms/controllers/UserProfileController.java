package fa.training.assignment03cms.controllers;

import fa.training.assignment03cms.entities.Member;
import fa.training.assignment03cms.repositories.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/user-profile")
@RequiredArgsConstructor
public class UserProfileController {

    private final MemberRepository memberRepository;

    @GetMapping
    private String getUserProfile(Model model, @SessionAttribute("member") Member member) {
        model.addAttribute("member", member);
        return "user-profile";
    }

    @PostMapping
    private String updateUserProfile( Member member, RedirectAttributes ra, HttpSession session) {
        member.setUpdateTime(LocalDateTime.now());
        memberRepository.save(member);
        session.setAttribute("member", member);
        ra.addFlashAttribute("successMessage", "Profile updated successfully");
        return "redirect:/user-profile";
    }
}
