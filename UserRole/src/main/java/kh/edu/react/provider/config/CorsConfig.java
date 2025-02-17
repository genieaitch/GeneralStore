package kh.edu.react.provider.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//리액트 3000포트와 연결을 주고 받을 때 어디까지 react 가 springboot 가 springboot 에서
// 제공되는 값을 사용할 수 있는가? 설정
// !!! Controller 에서 @CrossOrigin 이랑 같이 사용 XX
@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // registry.addMapping("/**")  -> 3000 port 에서 요청하는 모든 url api 허용
                registry.addMapping("/api/**") // 3000 port 에서 /api/ 라는 주소 명칭으로 시작하는 url api 요청 허용
                       // .allowedOrigins("http://localhost:3000","http://localhost:3001") // react 서버 3000 ~ 3001 포트에서 SpringBoot 접속 허용
                        .allowedOrigins("http://localhost:3000") // react 서버 3000 포트에서 SpringBoot 접속 허용
                        .allowCredentials(true) // 3000에서 API 요청을 보낼 때 쿠키나 세션 정보를 포함해서 요청을 받게 해줄 수 있는가
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*"); //
            }
        };
    }
}
