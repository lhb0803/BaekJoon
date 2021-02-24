import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String input = br.readLine();

        int xCount = 0;
        int i=0;

        while (i <= input.length()) {
            if (i == input.length() || input.charAt(i) == '.') {
                int numOfA = xCount / 4;
                int numOfB = xCount % 4;

                if (numOfB % 2 == 1) {
                    System.out.println(-1);
                    br.close();
                    return;
                }
                else {
                    while (numOfA-- > 0) {
                        answer.append("AAAA");
                    }
                    while (numOfB > 0) {
                        answer.append("BB");
                        numOfB -= 2;
                    }
                }

                if (i < input.length()) {
                    answer.append('.');
                }
                xCount = 0;
            }
            else {
                xCount++;
            }

            i++;
        }

        System.out.println(answer);
        br.close();
    }
}
