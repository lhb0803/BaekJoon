import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        MyQueue myQueue = new MyQueue(N);
        while (N > 0) {
            String command = br.readLine();
            if (command.equals("pop")) {
                myQueue.pop();
            }
            else if (command.substring(0, 4).equals("push")) {
                int n = Integer.parseInt(command.split(" ")[1]);
                myQueue.push(n);
            }
            else if (command.equals("front")) {
                myQueue.front();
            }
            else if (command.equals("back")) {
                myQueue.back();
            }
            else if (command.equals("size")) {
                myQueue.size();
            }
            else if (command.equals("empty")) {
                myQueue.empty();
            }

            N--;
        }
    }
}

class MyQueue {
    private int queSize;
    private int[] queArray;
    private int front, back;

    public MyQueue(int queSize) {
        this.queSize = 0;
        queArray = new int[queSize];
        front = -1;
        back = -1;
    }

    public void push(int n){
        if (front == -1 && back == -1) {
            queArray[0] = n;
            front = 0;
            back = 0;
        }
        else {
            queArray[++back] = n;
        }
        queSize++;
    }

    public void pop() {
        if (front != -1 && front <= back) {
            System.out.println(queArray[front++]);
            queSize--;
        }
        else {
            System.out.println(-1);
        }

        if (front > back) {
            front = back = -1;
        }
    }

    public void front() {
        if (front != -1 && front <= back) {
            System.out.println(queArray[front]);
        }
        else {
            System.out.println(-1);
        }
    }

    public void back() {
        if (back != -1 && front <= back) {
            System.out.println(queArray[back]);
        }
        else {
            System.out.println(-1);
        }
    }

    public void size() {
        System.out.println(queSize);
    }

    public void empty() {
        if (queSize == 0) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}