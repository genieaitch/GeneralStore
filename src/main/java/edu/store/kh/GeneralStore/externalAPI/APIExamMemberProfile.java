package edu.store.kh.GeneralStore.externalAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// 만약에 외부에서 작성한 코드를 참조해서 사용하길 원한다면 프로젝트에 맞게 코드 수정 필요

// 네이버 API 예제 - 회원프로필 조회
public class APIExamMemberProfile {

    /*
    외부 java 코드를 가져올 때 주의해야할 점
    프로젝트에서 static void main(String[] args) 은 프로젝트 시작과 같은 의미를 가지고 있다.
    프로젝트는 메인으로 시작하는 메서드를 최초 1회만 보유하고 있으며, 최초 1회 이외에는 static void main(String[] args)을 사용하면 안됨

    BUT 메서드 명칭이 static void main(String[] args) 된 메서드를 가져와서 사용하길 원한다면

    static void main(String[] args) → mathod1() 과 같은 명칭으로 변경해서 사용

    작성한 method1() 을 Controller나 ServiceImpl 에서 호출하여 사용하길 원한다면
    APIExamMemberProfile a = new APIExamMemberProfile();
    a.method1(); 과 같은 형태로 사용할 수 있음

    method1() 이 반환해야할 자료가 없다면 void 사용
                 반환해야할 자료가 있다면 자료형 사용 (String, int, ... 본인이 만든 자바 파일명)

    public static void main(String[] args) {
     */
    public void method1() {
        String token = "YOUR_ACCESS_TOKEN";// 네아로 접근 토큰 값";
        String header = "Bearer " + token; // Bearer 다음에 공백 추가
        try {
            String apiURL = "https://openapi.naver.com/v1/nid/me";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", header);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}