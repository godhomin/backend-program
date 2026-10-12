package me.hmshin.springdeveloper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

// 💡 import 수정: MockMvcResultMatchers의 jsonPath 사용
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void deleteAll() {
        memberRepository.deleteAll();
    }

    @Test
    void getAllMembers() throws Exception { // 💡 throws Exception 추가

        // 준비 (given)
        final String url = "/member";
        Member savedMember = memberRepository.save(new Member("신호민"));

        // 실행 (when)
        final ResultActions result = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON));

        // 검증 (then)
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName())); // 💡 세미콜론(;) 추가
    }
}