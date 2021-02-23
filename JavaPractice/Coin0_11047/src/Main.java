import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] coins = new int[N];
        for (int i=0; i<N; i++) {
            coins[i] = sc.nextInt();
        }

        int answer = Solution.solution(K, coins);
        System.out.println(answer);
    }
}

class Solution {
    public static int solution(int K, int[] coins) {
        int answer = 0;
        for (int i=coins.length-1; i>=0; i--) {
            while(K - coins[i] >= 0) {
                K -= coins[i];
                answer++;
            }
        }

        return answer;
    }
}
