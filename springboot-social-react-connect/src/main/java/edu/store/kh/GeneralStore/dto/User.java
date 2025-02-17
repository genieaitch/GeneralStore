package edu.store.kh.GeneralStore.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;
    private String name;
    private String password;
    private String email;
    private String role;
    // 현재 기준 : 유저만 로그인했는지 확인
    // private String role; → 1: 관리자  2:기업  3:사용자
}
