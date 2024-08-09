package fa.training.assignment03cms.service;

import fa.training.assignment03cms.entities.Member;
import fa.training.assignment03cms.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public void save(Member member) {
        memberRepository.save(member);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> findById(Integer id) {
        return memberRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        memberRepository.deleteById(id);
    }

    @Override
    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    @Override
    public boolean validLoginAccount(String email, String password) {
        return memberRepository.findAll()
                .stream()
                .anyMatch(member -> member.getEmail().equals(email)
                        && member.getPassword().equals(password));
    }

    @Override
    public boolean validRegisterAccount(String email, String username) {
        return memberRepository.findAll()
                .stream()
                .noneMatch(member -> member.getEmail().equals(email)
                        || member.getUsername().equals(username));
    }

}
