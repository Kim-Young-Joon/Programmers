package codingTest;

import java.util.ArrayList;

// 다트 게임
public class Dart {
    /*
        S : 1제곱
        D : 2제곱
        T : 3제곱

        * : 해당 점수 앞의 숫자까지 모두2배
        # : 해당 점수 -1배
    */
    public int solution(String dartResult) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(dartResult);
        ArrayList<Integer> myData = new ArrayList<>();
        int index = 0;

        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) >= 48 && sb.charAt(i) <= 57) {
                if(sb.charAt(i) == 49) { // 해당 인덱스의 값이 1인 경우,
                    if(sb.charAt(i+1) == 48) { // 다음으로 숫자 0이 온다면
                        myData.add(10);
                        i++; // 0 에 해당하는 값을 확인하지 않도록 해준다.
                    } else {
                        myData.add(1);
                    }
                } else {
                    myData.add(Character.getNumericValue(sb.charAt(i)));
                }
            } else if(sb.charAt(i) == 'S') {
                index++; // 1제곱이라 다른 연산을 하지 않아도 되지만 다음 번으로 제어를 이동시키기 위함
            } else if(sb.charAt(i) == 'D') {
                myData.set(index, myData.get(index)*myData.get(index));
                index++;
            } else if(sb.charAt(i) == 'T') {
                myData.set(index, myData.get(index) * myData.get(index) * myData.get(index));
                index++;
            } else if(sb.charAt(i) == '*') {
                if(myData.size() == 1) {
                    myData.set(0, myData.get(0) * 2);
                } else if(myData.size() == 2) {
                    myData.set(0, myData.get(0) * 2);
                    myData.set(1, myData.get(1) * 2);
                } else if(myData.size() == 3) {
                    myData.set(1, myData.get(1) * 2);
                    myData.set(2, myData.get(2) * 2);
                }
            } else if(sb.charAt(i) == '#') {
                if(myData.size() == 1) {
                    myData.set(0, myData.get(0) * (-1));
                } else if(myData.size() == 2) {
                    myData.set(1, myData.get(1) * (-1));
                } else if(myData.size() == 3) {
                    myData.set(2, myData.get(2) * (-1));
                }
            }
        }

        for(int i = 0; i < myData.size(); i++) {
            answer += myData.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Dart myTest = new Dart();
        String dartResult = "1S2D*3T";
        System.out.println(myTest.solution(dartResult));

        dartResult = "1D2S#10S";
        System.out.println(myTest.solution(dartResult));

        dartResult = "1D2S0T";
        System.out.println(myTest.solution(dartResult));

        dartResult = "1S*2T*3S";
        System.out.println(myTest.solution(dartResult));

        dartResult = "1D#2S*3S";
        System.out.println(myTest.solution(dartResult));

        dartResult = "1T2D3D#";
        System.out.println(myTest.solution(dartResult));

        dartResult = "1D2S3T*";
        System.out.println(myTest.solution(dartResult));
    }
}