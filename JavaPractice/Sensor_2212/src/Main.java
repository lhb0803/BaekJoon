import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        String[] sensorsS = br.readLine().split(" ");
        int[] sensors = new int[N];

        int answer = 0;

        if (N > K) {
            for (int i=0; i<N; i++) {
                sensors[i] = Integer.parseInt(sensorsS[i]);
            }
            Arrays.sort(sensors);

            int[] distArr = new int[N-1];
            for (int i=0; i<N-1; i++) {
                distArr[i] = sensors[i+1] - sensors[i];
            }
            Arrays.sort(distArr);

            for (int j=0; j<N-K; j++) {
                answer += distArr[j];
            }
        }

        System.out.println(answer);
        br.close();
    }
}
