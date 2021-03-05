import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer;
        long checkAnswer = 0;

        while(N > 0) {
            if (N < 10) {
                answer = 0;
            }
            else {
                int pick = N-10;
                int k;
                if (pick == 0) {
                    answer = 1;
                }
                else if (pick % 2 == 0) {
                    k = pick / 2;
                    answer = (3 * combination(25, k-1) + combination(25, k)) % 1000000000;
                }
                else {
                    k = (pick-1) / 2;
                    answer = (2 * combination(27, k)) % 1000000000;
                }

            }
            checkAnswer += answer;
            System.out.print("N:"); System.out.print(N); System.out.print("-> ");
            System.out.println(answer);
            N--;
        }
        System.out.println(checkAnswer);
        br.close();
    }

    private static int combination(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        }
        else if (r==1) {
            return n % 1000000000;
        }
        else {
            return (combination(n-1, r-1) + combination(n-1, r)) % 1000000000;
        }
    }

    private static int combinationRep(int n, int r) {
        return combination(n+r-1,r);
    }
}

