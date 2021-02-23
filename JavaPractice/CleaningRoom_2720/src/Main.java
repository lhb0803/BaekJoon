import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseNum = sc.nextInt();
        int[] testCaseArr = new int[testCaseNum];

        int quarter = 25; int dime = 10; int nickel = 5; int penny = 1;
        int[] coins = {quarter, dime, nickel, penny};

        for (int i=0; i<testCaseNum; i++) {
            testCaseArr[i] = sc.nextInt();
        }

        int[][] answerCase = new int[testCaseNum][coins.length];
        for (int i=0; i<testCaseNum; i++) {
            int testCase = testCaseArr[i];

            for (int j=0; j<coins.length; j++) {
                int coin = coins[j];
                int coinNum = 0;
                while (testCase - coin >= 0) {
                    testCase -= coin;
                    coinNum++;
                }
                answerCase[i][j] = coinNum;
            }
        }
        for (int i=0; i<testCaseNum; i++) {
            for (int j=0; j<coins.length; j++) {
                System.out.print(answerCase[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        sc.close();

    }
}