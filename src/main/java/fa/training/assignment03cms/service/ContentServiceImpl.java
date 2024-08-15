package fa.training.assignment03cms.service;

import fa.training.assignment03cms.entities.Content;
import fa.training.assignment03cms.repositories.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {
    private final ContentRepository contentRepository;

    @Override
    public void save(Content content) {
        contentRepository.save(content);
    }

    @Override
    public List<Content> findAll() {
        return contentRepository.findAll();
    }

    @Override
    public Optional<Content> findById(Integer id) {
        return contentRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        contentRepository.deleteById(id);
    }

    @Override
    public Page<Content> getAllContents(Integer page) {
        Pageable pageable = PageRequest.of(page - 1, 3);
        return contentRepository.findAll(pageable);
    }

    @Override
    public Page<Content> searchContent(String keyword, Integer page) {
        return contentRepository.findByTitleContaining(keyword, PageRequest.of(page - 1, 3));
    }
}
