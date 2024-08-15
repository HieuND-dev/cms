package fa.training.assignment03cms.controllers;

import fa.training.assignment03cms.entities.Member;
import fa.training.assignment03cms.repositories.MemberRepository;
import fa.training.assignment03cms.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping
    private String getLogin() {
        return "login";
    }

    @PostMapping
    private String login(Member member, HttpSession session, RedirectAttributes ra) {

        if(memberService.validLoginAccount(member.getEmail(), member.getPassword())) {
            session.setAttribute("member", memberRepository.findByEmail(member.getEmail()));
            System.out.println(session.getAttribute("member"));
            ra.addFlashAttribute("loginSuccess", "Login successfully!");
            System.out.println("success");
            return "redirect:/view-content";
        }

        System.out.println("error");
        ra.addFlashAttribute("error", "Invalid username or password.");
        return "redirect:/login";
    }
}
