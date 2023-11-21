package Tuan4;
import java.io.*;
import java.util.*;

public class Ex8 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

    }
    public static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode temp1 =head1;
        SinglyLinkedListNode temp2 = head2;
        int count1=0;
        int count2=0;
        while (count1==count2){
            if (temp1.data == temp2.data){
                if (head1!=null){
                    head1=head1.next;
                    count1++;
                }
                if (head2!=null){
                    head2=head2.next;
                    count2++;
                }
                else break;
            }
            else return false;
        }
        if (count1==count2) return true;
        else   return false;
    }
}
