import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long prev = 0;
        long curr = 1;

        for (int i=0; i<N; i++) {
            long temp = curr;
            curr += prev;
            prev = temp;
        }
        long answer = 2*(prev + curr);

        System.out.println(answer);
        br.close();
    }
}