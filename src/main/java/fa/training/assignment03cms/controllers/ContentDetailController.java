package fa.training.assignment03cms.controllers;

import fa.training.assignment03cms.entities.Content;
import fa.training.assignment03cms.service.ContentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/content-detail")
@RequiredArgsConstructor
public class ContentDetailController {
    private final ContentService contentService;

    @GetMapping("{id}")
    private String getContentDetail (Model model, @PathVariable Integer id) {
        model.addAttribute("content", (Content) contentService.findById(id).orElse(null));
        return "/content-detail";
    }

    @PostMapping("/{id}")
    private String updateContentDetail ( Content content) {

//        if (bindingResult.hasErrors()) {
//            return "/content-detail";
//        }

        content.setUpdateTime(LocalDateTime.now());
        contentService.save(content);
        return "redirect:/view-content";
    }

    @PostMapping("/delete/{id}")
    private String deleteContent(@PathVariable Integer id) {
        contentService.deleteById(id);
        return "redirect:/view-content";
    }
}
