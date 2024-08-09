package fa.training.assignment03cms.repositories;

import fa.training.assignment03cms.entities.Content;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ContentRepository extends JpaRepository<Content, Integer> {

    Page<Content> findByTitleContaining(String keyword, Pageable pageable);
}
