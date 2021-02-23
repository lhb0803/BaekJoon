package BackUp_1150;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] companyArr = new int[n];
        for (int i=0; i<n; i++) {
            companyArr[i] = sc.nextInt();
        }
        
        int answer = Solution.solution(n, k, companyArr);
        
        // System.out.println("<Input>");
        // System.out.print("n: ");
        // System.out.println(n);
        // System.out.print("k: ");
        // System.out.println(k);
        // System.out.print("company: <");
        // for (int i=0; i<n; i++) {
        //     System.out.print(companyArr[i]);
        //     if (i < n-1) {
        //         System.out.print(" ");
        //     }
        // }
        // System.out.println(">");
        // System.out.println("<Answer>");
        System.out.println(answer);
        sc.close();
    }
}