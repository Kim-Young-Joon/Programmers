package codingTest;

// 음양 더하기
public class IntegerManage {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int index = 0; index < absolutes.length; index++) {
            if(signs[index]) {
                absolutes[index] = Math.abs(absolutes[index]);
            } else {
                absolutes[index] = (-1) * Math.abs(absolutes[index]);
            }
            answer += absolutes[index];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] test_ab1 = {4, 7, 12};
        boolean[] test_signs1 = {true, false, true};
        int[] test_ab2 = {1, 2, 3};
        boolean[] test_signs2 = {false, false, true};
        IntegerManage myTest = new IntegerManage();

        System.out.println(myTest.solution(test_ab1, test_signs1));
        System.out.println(myTest.solution(test_ab2, test_signs2));
    }
}
