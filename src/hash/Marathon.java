package hash;

import java.util.HashMap;

// 코딩테스트 연습 - 해시 - 완주하지 못한 선수
public class Marathon {
    public String solution(String[] participant, String[] completion) {
        String answer="";

        HashMap<String, Integer> myData = new HashMap<>();
        String str = "";
        int cnt = 0;

        // HashMap 에 참가자 목록 저장하기 (동명이인이 있을 경우 value 값을 증가시켜줌)
        for(int i = 0; i < participant.length; i++) {
            str = participant[i];
            if(myData.containsKey(str)) {
                str = participant[i];
                cnt = myData.get(str);
                myData.put(str, ++cnt);
            } else {
                myData.put(str, 1);
            }
        }

        // HashMap 에 저장된 참가자 목록에서 완주자 빼기
        for(int i = 0; i < completion.length; i++) {
            str = completion[i];
            cnt = myData.get(str);
            if(cnt == 1) {
                myData.remove(str);
            } else {
                myData.put(str, --cnt);
            }
        }

        // 남아있는 key 값 변환
        String temp = myData.keySet().toString();
        answer = temp.substring(1, temp.length()-1);
        return answer;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> myData = new HashMap<>();
        Marathon test = new Marathon();

        String[] par1 = {"leo", "kiki", "eden"};
        String[] com1 = {"eden", "kiki"};
        System.out.println("test case 1 : " + test.solution(par1, com1));

        String[] par2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] com2 = {"josipa", "filipa", "marina", "nikola"};
        System.out.println("test case 2 : " + test.solution(par2, com2));

        String[] par3 = {"mislav", "stanko", "mislav", "ana"};
        String[] com3 = {"stanko", "ana", "mislav"};
        System.out.println("test case 3 : " + test.solution(par3, com3));
    }
}