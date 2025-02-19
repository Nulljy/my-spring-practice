package Reload.tutorial.Services;

import Reload.tutorial.Domain.Member;
import Reload.tutorial.Repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemoryMemberRepository memberRepository;

    // 생성자 DI
    @Autowired
    public MemberService(MemoryMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        // 중복 확인하기
        isDuplicated(member);
        // db에 저장
        memberRepository.save(member);
        System.out.println("회원가입에 성공하였습니다.");
        return member.getId();
    }

    public void isDuplicated(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 아이디입니다.");
                });
        System.out.println("중복된 아이디가 존재하지 않습니다.");
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 하나 찾기
    public Optional<Member> findOne(Long id) {
        return memberRepository.findById(id);
    }


}
