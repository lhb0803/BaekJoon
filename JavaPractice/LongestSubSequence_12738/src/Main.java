import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] arrStr = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        int answer = solution(arr);
        bw.write(Integer.toString(answer));
        bw.close();
        br.close();
    }

    private static int solution(int[] arr) {
        List<Integer> ansList = new ArrayList<>();
        ansList.add(Integer.MIN_VALUE);

        for (int i=0; i<arr.length; i++) {
            int num = arr[i];
            int left = 0, right = ansList.size()-1;

            if (num > ansList.get(right)) {
                ansList.add(num);
            }
            else {
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (ansList.get(mid) >= num) {
                        right = mid;
                    }
                    else {
                        left = mid + 1;
                    }
                }
                ansList.set(right, num);
            }
        }
        return ansList.size()-1;
    }
}
