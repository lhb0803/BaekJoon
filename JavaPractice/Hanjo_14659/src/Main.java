import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] mountainsStr = br.readLine().split(" ");
        int answer = 0;
        int cnt = 0;
        int currMountain = Integer.parseInt(mountainsStr[0]);

        for (int i=1; i<N; i++) {
            int mountain = Integer.parseInt(mountainsStr[i]);
            if (currMountain < mountain) {
                currMountain = mountain;
                cnt = 0;
            }
            else {
                cnt++;
                if (cnt > answer) {
                    answer = cnt;
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}