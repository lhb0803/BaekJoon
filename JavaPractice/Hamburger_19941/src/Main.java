import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        String hp = br.readLine();
        int answer = 0;

        int[] hpArr = new int[N];
        for (int i=0; i<N; i++) {
            char c = hp.charAt(i);

            if (c=='H') {
                hpArr[i] = 1;
            }
            else {
                hpArr[i] = -1;
            }
        }

        for (int i=0; i<N; i++) {
            if (hpArr[i] == -1) { // human
                int findIx = i-K;
                if (findIx < 0) {
                    findIx = 0;
                }
                while(findIx <= i+K) {
                    if (hpArr[findIx] > 0) {
                        hpArr[findIx]--;
                        answer++;
                        break;
                    }
                    findIx++;
                    if (findIx >= N) {
                        break;
                    }
                }
            }
        }


        System.out.println(answer);
        br.close();
    }
}
