package GameMaking_2847;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] scoreArr = new int[N];

        for (int i=N-1; i>=0; i--) {
            scoreArr[i] = sc.nextInt();
        }

        System.out.println(Solution.solution(scoreArr));
        sc.close();
    }
    
}

class Solution {
    public static int solution(int[] scoreArr) {
        int answer = 0;
        for (int i=1; i<scoreArr.length; i++) {
            int prev = scoreArr[i-1];
            int target = scoreArr[i];

            if (target >= prev) {
                answer += (target-prev)+1;
                scoreArr[i] = prev-1;
            }
        }
        return answer;
    }
}
