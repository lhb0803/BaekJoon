import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ansArr = new int[N];
        int[] ixArr = new int[N];
        for (int i=0; i<N; i++) {
            ixArr[i] = i;
        }

        int n = 0;
        while(N-- > 0) {
            n++;
            int curr = Integer.parseInt(br.readLine());
            int ix = ixArr[curr];
            ansArr[ix] = n;
            for (int j=curr; j<N; j++) {
                ixArr[j] = ixArr[j+1];
            }
        }

        for (int num : ansArr) {
            System.out.println(num);
        }
        br.close();
    }
}
