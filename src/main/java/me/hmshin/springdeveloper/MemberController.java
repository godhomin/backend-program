package me.hmshin.springdeveloper;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    // 요청을 받아서 적절한 비즈니스 로직으로 연결
    // http://localhost:8080/member 요청과 메서드를 연결
//    @PostMapping()
//    public ResponseEntity<Member> createMember(@RequestBody Member member){
//        return ResponseEntity.ok(memberService.saveMember(member));
//    }


    @GetMapping()
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();

    }
    // 회원정보를 등록하는 요청
    // http::/localhost/8080/member 요청을 post 방식으로 헀을 때 회원목록을 처리하도록 구현
    @PostMapping()
    public ResponseEntity<Member> createMember(@RequestBody Member member){
       // 비즈니스 로직을 호출
//       return ResponseEntity.ok(memberService.saveMember(member));
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.saveMember(member));
    }
}
