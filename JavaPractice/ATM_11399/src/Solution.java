import java.util.Arrays;

public class Solution {
    public static int solution(int[] people) {
        int answer = 0;
        int n = people.length;

        Arrays.sort(people);
        for (int i=0; i<n; i++) {
            int time = people[i];

            answer += time*(n-i);

        }

        return answer;
    }
}
