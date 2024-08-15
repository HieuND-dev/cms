package fa.training.assignment03cms.service;

import fa.training.assignment03cms.entities.Content;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ContentService {
    void save(Content content);
    List<Content> findAll();
    Optional<Content> findById(Integer id);
    void deleteById(Integer id);

    Page<Content> getAllContents(Integer page);
    Page<Content> searchContent(String keyword, Integer page);
}
