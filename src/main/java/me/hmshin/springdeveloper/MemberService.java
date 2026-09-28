package me.hmshin.springdeveloper;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository;
    // 멤버 테이블에 있는 모든 레코드들을 읽어서 반환
    public List<Member> getAllMembers() {

        return memberRepository.findAll();

    }

    // 회원 저장
    public Member saveMember(Member member){
        return memberRepository.save(member);
    }


}
