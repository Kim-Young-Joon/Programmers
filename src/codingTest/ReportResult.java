package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 신고 결과 받기
/*
    한 사람이 똑같은 사람을 계속 해서 신고하더라도 그 횟수는 1회로 친다. => HashMap 사용
    1. 신고 당한 수를 정리하고
    2. 그 값이 k 보다 크면
    3. 신고 당한 사람으로 판정
    4. id 순서대로 신고 결과 회신 메일 보내기
*/
public class ReportResult {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> id_report = new HashMap<>(); // id_list 에 신고 받은 횟수를 붙여서 저장
        HashMap<String, ArrayList<String>> who_report = new HashMap<>(); // 누가 누구를 신고 했는지 저장
        boolean isReported = false; // 같은 유저가 동일한 사람을 신고한 경우가 있는지 확인하는 변수
        ArrayList<String> stopID = new ArrayList<>(); // 정지 대상 아이디를 저장할 리스트

        // 1. String 배열의 값들을 HashMap 으로 옮겨서 저장
        for(int i = 0; i < id_list.length; i++) {
            id_report.put(id_list[i], 0);
        }
        for(int i = 0; i < report.length; i++) {
            String[] myReport = report[i].split(" ");
            isReported = false;
            if(who_report.containsKey(myReport[0])) { // 신고한 경우가 있는 유저라면,
                for(int j = 0; j < who_report.get(myReport[0]).size(); j++) { // 신고자의 신고 로그 확인
                    if(who_report.get(myReport[0]).get(j).equals(myReport[1])) { // equals 를 통해 로그에 동일한 이름 존재 여부 확인
                        isReported = true;
                        break;
                    }
                }
                if(isReported == false) { // 동일한 사람을 신고한 것이 아니라면
                    who_report.get(myReport[0]).add(myReport[1]); // 신고 로그에 추가하고
                    id_report.put(myReport[1], id_report.get(myReport[1]) + 1); // 신고 받은 횟수를 추가한다.
                }
            } else { // 신고한 경우가 없는 유저라면 로그 데이터를 생성해주면서 신고 횟수를 올린다.
                who_report.put(myReport[0], new ArrayList<>()); // HashMap 의 value 로 ArrayList 를 만들어 주고
                who_report.get(myReport[0]).add(myReport[1]); // 신고 로그에 추가하고
                id_report.put(myReport[1], id_report.get(myReport[1]) + 1); // 신고 받은 횟수를 추가한다.
            }
        }

        // 2. 아이디의 정지 여부 판별
        for(int i = 0; i < id_report.size(); i++) {
            if(id_report.get(id_list[i]) >= k) {
                stopID.add(id_list[i]);
            }
        }

        // 3. 회신 메일의 수 계산
        for(int i = 0; i < who_report.size(); i++) {
            for(String str : stopID) {
                if(who_report.get(id_list[i]).contains(str)){
                    answer[i]++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        ReportResult myTest = new ReportResult();

        String[] id_list1 = {"muzi", "frodo", "apeach", "neo"};
        String[] report1 = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k1 = 2;
        System.out.println(Arrays.toString(myTest.solution(id_list1, report1, k1)));

        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k2 = 3;
        System.out.println(Arrays.toString(myTest.solution(id_list2, report2, k2)));
    }
}
