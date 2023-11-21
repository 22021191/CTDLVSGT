package Tuan4;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result1 {

    /*
     * Complete the 'deleteNode' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts following parameters:
     *  1. INTEGER_SINGLY_LINKED_LIST llist
     *  2. INTEGER position
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

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        // Write your code here
        SinglyLinkedListNode head=llist;
        if(position==0){
            return llist.next;
        }
        for(int i=0;i<position-1;i++){
            llist=llist.next;
        }
        SinglyLinkedListNode pos=llist.next;
        llist.next=pos.next;
        return head;

    }

}

public class Ex5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

        int position = Integer.parseInt(bufferedReader.readLine().trim());

        SinglyLinkedListNode llist1 = Result1.deleteNode(llist.head, position);

        SinglyLinkedListPrintHelper.printList(llist1, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
