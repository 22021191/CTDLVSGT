package Tuan4;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;


class ResultEx6 {

    /*
     * Complete the 'reversePrint' function below.
     *
     * The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static void reversePrint(SinglyLinkedListNode llist) {
        if(llist==null){
            return ;
        }
        reversePrint(llist.next);
        System.out.print(llist.data+"\n");
    }

}

public class Ex6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int tests = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, tests).forEach(testsItr -> {
            try {
                SinglyLinkedList llist = new SinglyLinkedList();

                int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

                IntStream.range(0, llistCount).forEach(i -> {
                    try {
                        int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                        llist.insertNode(llistItem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                ResultEx6.reversePrint(llist.head);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
