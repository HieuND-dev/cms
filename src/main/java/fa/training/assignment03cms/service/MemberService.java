package fa.training.assignment03cms.service;

import fa.training.assignment03cms.entities.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    void save(Member member);
    List<Member> findAll();
    Optional<Member> findById(Integer id);
    void deleteById(Integer id);

    Member findByEmail(String email);

    boolean validLoginAccount(String email, String password);
    boolean validRegisterAccount(String email, String username);
}
