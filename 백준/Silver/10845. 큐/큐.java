import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static int[] queue = new int[10001];
    static int first = 0;
    static int last = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            String[] commandAndValue = getCommandAndValue(br.readLine());

            String command = commandAndValue[0];
            int value = Integer.parseInt(commandAndValue[1]);

            execute(command, value);
        }
    }

    private static void execute(String command, int value) {
        switch (command) {
            case "push":
                push(value);
                break;
            case "pop":
                System.out.println(pop());
                break;
            case "size":
                System.out.println(size());
                break;
            case "empty":
                System.out.println(empty());
                break;
            case "front":
                System.out.println(front());
                break;
            case "back":
                System.out.println(back());
                break;
        }
    }

    private static String[] getCommandAndValue(String command) {
        if(command.startsWith("push")) {
            return command.split(" ");
        }
        return new String[]{command, "0"};
    }

    private static void push(int value) {
        queue[last++] = value;
    }

    private static int pop() {
        if(isEmpty()) {
            return -1;
        }
        return queue[first++];
    }

    private static int size() {
        return last - first;
    }

    private static int empty() {
        if(isEmpty()) {
            return 1;
        }
        return 0;
    }

    private static int front() {
        if(isEmpty()) {
            return -1;
        }
        return queue[first];
    }

    private static int back() {
        if(isEmpty()) {
            return -1;
        }
        return queue[last-1];
    }

    private static boolean isEmpty() {
        return last - first == 0;
    }
}