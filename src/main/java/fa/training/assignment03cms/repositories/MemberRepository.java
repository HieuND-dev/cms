package fa.training.assignment03cms.repositories;

import fa.training.assignment03cms.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findByEmail(String email);
}
