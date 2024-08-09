package fa.training.assignment03cms.controllers;

import fa.training.assignment03cms.entities.Content;
import fa.training.assignment03cms.entities.Member;
import fa.training.assignment03cms.service.ContentService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/form-content")
@RequiredArgsConstructor
public class FormContentController {

    private final ContentService contentService;

    @GetMapping
    private String formContent(Model model, @SessionAttribute("member") Member member) {
        Content content = new Content();
        content.setAuthor(member);
        model.addAttribute("content", content);
        return "form-content";
    }

    @PostMapping
    private String submitContent( Content content,  RedirectAttributes ra) {

//        if (bindingResult.hasErrors()) {
//            return "form-content";
//        }

        content.setCreateDate(LocalDateTime.now());
        contentService.save(content);
        ra.addFlashAttribute("saveContentSuccess", "Content saved successfully!");
        return "redirect:/view-content";
    }


}
