import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputString = sc.nextLine();
        int answer = Solution.solution(inputString);
        System.out.println(answer);
        sc.close();
    }
}

class Solution {
    public static int solution(String inputString) {
        int answer = 0;
        String[] initStringArr = inputString.split("-");
        for (int i=0; i< initStringArr.length; i++) {
            String numString = initStringArr[i];

            int num = 0;
            if (numString.contains("+")) {
                num = sumValues(numString);
            }
            else {
                num = changeToInt(numString);
            }

            if (i==0) {
                answer += num;
            }
            else {
                answer -= num;
            }

        }

        return answer;
    }

    private static int changeToInt(String s) {
        int digit = s.length();
        int frontZeroIx = 0;
        int result = 0;

        char firstNum = s.charAt(0);
        if (firstNum == '0') {
            for (int i=1; i<digit; i++) {
                if (s.charAt(i) == '0') {
                    frontZeroIx++;
                }
                else {
                    break;
                }
            }
        }

        for (int ix=frontZeroIx; ix<digit; ix++) {
            int n = s.charAt(ix) - '0';
            int tens = (int) Math.pow(10, digit-ix-1);
            result += n * tens;
        }

        return result;
    }

    private static int sumValues(String s) {
        String[] sumNumArr = s.split("\\+");
        int result = 0;

        for (String num : sumNumArr) {
            int numInt = changeToInt(num);
            result += numInt;
        }
        return result;
    }
}