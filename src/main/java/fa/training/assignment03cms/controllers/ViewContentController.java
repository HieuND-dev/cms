package fa.training.assignment03cms.controllers;

import fa.training.assignment03cms.entities.Content;
import fa.training.assignment03cms.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/view-content")
@RequiredArgsConstructor
public class ViewContentController {

    private final ContentService contentService;

    @GetMapping
    private String viewContent(Model model, @RequestParam(value = "keyword", required = false) String keyword,
                               @RequestParam(name = "page", defaultValue = "1") Integer pageNumber) {

        Page<Content> page;
        if(keyword != null) {
            page = contentService.searchContent(keyword, pageNumber);
            model.addAttribute("keyword", keyword);
        }else {
            page = contentService.getAllContents(pageNumber);
        }

        if (pageNumber > page.getTotalPages() && pageNumber != 1) {
            throw new IllegalStateException("");
        }

        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("contents", page);
        return "view-content";
    }
}
