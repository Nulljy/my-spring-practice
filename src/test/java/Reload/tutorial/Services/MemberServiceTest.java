package Reload.tutorial.Services;

import Reload.tutorial.Domain.Member;
import Reload.tutorial.Repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach // 테스트는 독립적으로 시행되어야한다.
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("고객1");
        //when
        Long saveId = memberService.join(member);
        //then
        memberService.findOne(saveId);
        Assertions.assertThat(member.getId()).isEqualTo(saveId);
    }

    @Test
    public void 중복회원검증() {
        // given
        Member member1 = new Member();
        member1.setName("고객");
        Member member2 = new Member();
        member2.setName("고객");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertEquals("이미 존재하는 아이디입니다.", e.getMessage());
        //        memberService.join(member1);
//        try {
//            memberService.join(member2);
//            fail();
//        } catch(IllegalStateException e) {
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 아이디입니다.123");
//        }
//        Long joinId = memberService.join(member1);
//        Assertions.assertThat(joinId).isEqualTo(member2);

    }

    @Test
    void isDuplicated() {
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}