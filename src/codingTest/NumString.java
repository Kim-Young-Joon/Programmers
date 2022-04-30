package codingTest;

import java.util.ArrayList;
import java.util.HashMap;

// 2021 카카오 채용연계형 인턴십 - 숫자 문자열과 영단어
public class NumString {
    public int solution(String s){
        int answer = 0;
        String[] numStr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int index = 0; index < 10; index++) {
            s = s.replace(numStr[index], Integer.toString(index));
        }
        answer = Integer.parseInt(s);

        return answer;
    }

    public static void main(String[] args) {
       NumString test = new NumString();
       String[] sendStr = {"one4seveneight", "23four5six7", "2three45sixseven", "123"};
       int myData = 0;
       for(int i = 0; i < sendStr.length; i++) {
           myData = test.solution(sendStr[i]);
           System.out.println(myData);
       }
    }
}
