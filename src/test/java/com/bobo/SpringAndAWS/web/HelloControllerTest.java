package com.bobo.SpringAndAWS.web;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Test
    public void hello가_리턴한다(@Autowired MockMvc mvc) throws Exception {
        String hello = "hello";
        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));

    }

    @Test
    public void helloDto가_리터된다(@Autowired MockMvc mvc) throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name) // API 테스트할 때 사용될 요청 파라미터를 설정, 단 값은 String만 허용
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
        // jsonPath -> JSON 응답값을 필드별로 검증할 수 있는 메소드
        // $를 기준으로 필드명을 명시
    }
}