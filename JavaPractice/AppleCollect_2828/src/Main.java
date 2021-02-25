import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int J = Integer.parseInt(br.readLine());
        int answer = 0;
        int left = 1, right = left+(M-1);

        for (int i=0; i<J; i++) {
            int apple = Integer.parseInt(br.readLine());
            int move;
            if (apple > right) { // right move
                move = apple-right;
                answer += move;
                right = apple;
                left = right-(M-1);
            }
            else if (apple < left){ // left move
                move = left-apple;
                answer += move;
                left = apple;
                right = left +(M-1);
            }
            // in the basket -> don't move
        }

        System.out.println(answer);
        br.close();
    }
}