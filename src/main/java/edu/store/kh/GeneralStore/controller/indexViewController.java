package edu.store.kh.GeneralStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexViewController {
    @GetMapping("/")
    public String index() {
        // index.html → 회원가입 / 로그인 버튼 클릭해서 이동 설정
        // 피자 메뉴 목록 모두 조회 버튼 클릭해서 이동 설정
        return "index";
    }
}
