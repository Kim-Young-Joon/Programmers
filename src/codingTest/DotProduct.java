package codingTest;

// 내적
public class DotProduct {
    public int solution(int[] a, int[] b) {
        int answer = 0;

        for(int index=0; index < a.length; index++) {
            answer += a[index] * b[index];
        }

        return answer;
    }

    public static void main(String[] args) {
        DotProduct myTest = new DotProduct();
        int[] test1_a = {1, 2, 3, 4};
        int[] test1_b = {-3, -1, 0, 2};
        int[] test2_a = {-1, 0, 1};
        int[] test2_b = {1, 0, -1};

        System.out.println(myTest.solution(test1_a, test1_b));
        System.out.println(myTest.solution(test2_a, test2_b));
    }
}
