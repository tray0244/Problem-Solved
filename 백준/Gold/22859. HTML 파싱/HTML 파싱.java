import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 한 줄의 입력을 읽음
        String s = br.readLine();

        // title 속성을 가진 <div> 태그를 찾기 위한 정규 표현식
        Matcher m1 = Pattern.compile("<div title=\"(\\w|_|\\s)*\"").matcher(s);
        // <p> 태그와 그 내용을 찾기 위한 정규 표현식
        Matcher m2 = Pattern.compile("<p>(\\w|\\s|</?[^p]>|</?\\w{2,}\\s?>|\\.)*</p>").matcher(s);

        // 일치한 문자열과 해당 값을 저장할 맵 생성
        Map<Integer, String> map = new HashMap<>();

        // <div> 태그에서 title 속성을 찾아 맵에 저장
        while (m1.find()) {
            // 일치한 문자열에서 title 값을 추출
            String title = m1.group().split("\"")[1];
            // 시작 인덱스와 포맷된 출력을 맵에 저장
            map.put(m1.start(), "title : " + title + "\n");
        }

        // <p> 태그와 그 내용을 찾아 처리
        while (m2.find()) {
            // 일치한 문자열에서 HTML 태그 제거
            String p = m2.group().replaceAll("<[\\w\\s/]*>", "");
            // 여러 공백을 하나의 공백으로 대체
            String cleanedText = p.replaceAll("\\s{2,}", " ") + "\n";
            // 시작 인덱스와 정리된 텍스트를 맵에 저장
            map.put(m2.start(), cleanedText);
        }

        // 맵의 키(시작 인덱스)를 리스트로 생성하고 정렬
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        // 정렬된 순서로 맵의 값을 StringBuilder에 추가
        for (int i : list) {
            sb.append(map.get(i));
        }

        System.out.println(sb);
    }
}