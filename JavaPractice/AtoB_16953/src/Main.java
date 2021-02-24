import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int A = Integer.parseInt(inputArr[0]);
        int B = Integer.parseInt(inputArr[1]);
        int answer = 0;

        while (B > A) {
            if (B % 10 == 1) {
                B = B/10;
                answer++;
            }
            else if (B % 2 == 0) {
                B = B/2;
                answer++;
            }
            else {
                answer = -1;
                break;
            }
        }

        if (B == A) {
            answer++;
        }
        else {
            answer = -1;
        }

        System.out.println(answer);
        br.close();
    }
}
