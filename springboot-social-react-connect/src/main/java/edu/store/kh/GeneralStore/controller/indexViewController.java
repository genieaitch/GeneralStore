package edu.store.kh.GeneralStore.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexViewController {

    @Value("${kakao.javascript.app.key}")
    private String kakaoJSAppKey;

    @GetMapping("/")
    public String index() {
        // index.html → 회원가입 / 로그인 버튼 클릭해서 이동 설정
        // 피자 메뉴 목록 모두 조회 버튼 클릭해서 이동 설정
        return "index";
    }

    @GetMapping("/kakao/map")
    public String map(Model model) {
        model.addAttribute("appkey", kakaoJSAppKey);
        return "kakaoMap";
    }
}
