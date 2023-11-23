package Tuan5;

import java.util.Scanner;
import java.util.Stack;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        String text = "";
        Stack<String> oldVer = new Stack<>();

        for (int i = 0; i < Q; i++) {
            int request = scanner.nextInt();

            switch (request) {
                case 1:
                {
                    oldVer.push(text);
                    String append = scanner.next();
                    text += append;
                    break;
                }
                case 2:
                {
                    oldVer.push(text);
                    int k = scanner.nextInt();
                    String newText = text.substring(0, text.length() - k);
                    text = newText;
                    break;
                }
                case 3:
                {
                    int k = scanner.nextInt();
                    System.out.println(text.charAt(k - 1));
                    break;
                }
                case 4:
                {
                    if (!oldVer.isEmpty()) {
                        String oldText = oldVer.pop();
                        text = oldText;
                    }
                    break;
                }
            }
        }

    }
}
