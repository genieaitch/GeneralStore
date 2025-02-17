package kh.edu.react.provider.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //id 값 자동 증가가 없기 때문에 @Id @GenerateValue 값 사용 XX
    private String userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userRole;
}
