package edu.store.kh.GeneralStore.controller;

import edu.store.kh.GeneralStore.dto.User;
import edu.store.kh.GeneralStore.service.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/user")
public class UserAPIController {
    @Autowired
    private UserServiceImpl userService;

    // 로그인
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody User user, HttpSession session) {
        User loginUser = userService.loginUser(user.getUserId(), user.getPassword());

        Map<String, Object> response = new HashMap<>();

        if (loginUser != null) {
            session.setAttribute("user", loginUser);
            response.put("status", "success");
            response.put("user", loginUser);
            return ResponseEntity.ok(response); // 로그인 성공 시 상태번호 200 제공
        } else {
            response.put("status", "fail");
            response.put("message", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return ResponseEntity.status(401).body(response);
        }
    }

    // 로그아웃
    @PostMapping("/logout")
    public ResponseEntity<Map<String, Object>> logout(HttpSession session) {
        session.invalidate();
        Map<String, Object> response = new HashMap<>();
        response.put("status", "logout");
        return ResponseEntity.ok(response); // 성공적으로 로그아웃이 됐다면 200
    }

    // 로그인 상태 확인 → DB를 거치지 않고 오직 세션에서만 정보가 존재하는지 확인
    @GetMapping("/checkLogin")
    public ResponseEntity<?> checkLogin(HttpSession session) {
        User loginUser = (User) session.getAttribute("user");
        if (loginUser != null) {
            return ResponseEntity.ok(loginUser);
        } else {
            return ResponseEntity.status(401).body(Map.of("message", "로그인 상태가 아닙니다."));
        }
    }

    // 특정 유저 정보 조회 → mypage
    @GetMapping("/{userId}")
    public ResponseEntity<?> findUserId(@PathVariable("userId") String userId) {
        User user = userService.findUserId(userId);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(404).body(Map.of("message", "로그인 상태가 아닙니다."));
        }
    }
}
