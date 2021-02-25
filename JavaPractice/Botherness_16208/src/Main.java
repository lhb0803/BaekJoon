import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] sticksS = br.readLine().split(" ");
        long[] sticks = new long[n];
        long wholeLength = 0;
        for (int i=0; i<n; i++) {
            sticks[i] = Integer.parseInt(sticksS[i]);
            wholeLength += sticks[i];
        }

        long answer = 0;
        Arrays.sort(sticks);
        for (int i=0; i<n-1; i++) {
            long first = sticks[i];
            wholeLength -= first;

            answer += first*wholeLength;
        }

        System.out.println(answer);
        br.close();
    }
}