package edu.store.kh.GeneralStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SocialViewController {

    // 카카오 네이버 로그인 html 연결
    //IndexViewController 에서 index.html 내 카카오 네이버  로그인 버튼 설정

    // 카카오 회원가입 html 연결
    @GetMapping("/signup/kakao")
    public String kakaoSignup() {
        return "signup/kakao";
    }

    // 네이버 회원가입 html 연결
    @GetMapping("/signup/naver")
    public String naverSignup() {
        return "signup/naver";
    }
}
