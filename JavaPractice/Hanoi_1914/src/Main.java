import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(move(N));
        if (N <= 20) {
            move(N,1,3,2);
        }
    }

    private static void move(int n, int src, int dest, int spare) {

        if (n == 1) {
            System.out.println(src + " " + dest);
        }
        else {
            move(n-1, src, spare, dest);
            System.out.println(src + " " + dest);
            move(n-1, spare, dest, src);
        }

    }

    private static BigInteger move(int n) {
        return new BigInteger("2").pow(n).subtract(BigInteger.ONE);
    }
}