import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        List<Integer> resultList = new LinkedList<>();
        while (a!=0 || b!=0) {
            int result = a+b;

            resultList.add(result);

            a = sc.nextInt();
            b = sc.nextInt();
        }

        for (int i=0; i<resultList.size(); i++) {
            System.out.println(resultList.get(i));
        }

        sc.close();
    }
}