package Tuan3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.UF;

import java.util.Scanner;

public class Main {
    public static int[] diem = new int[1000];
    public static int[] root = new int[1000];
    public static int res;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        res = scanner.nextInt();

        for (int i = 0; i < res; i++) {
            diem[i] = i;
        }
        for (int i = 0; i < res; i++) {
            root[i] = -1;
        }
        int tmp=1;

        while (!StdIn.isEmpty()) {
            int p,q;
            try {
                p = StdIn.readInt();
                q = StdIn.readInt();
                Union(p, q);
                if (res == 1) {
                    System.out.println( tmp);
                    return;
                }
                tmp++;
            }catch (Exception e) {
                System.out.println("Falied");
                return;
            }
        }
    }

    public static int GetRoot(int x) {
        if (root[x] < 0) return x;
        return GetRoot(root[x]);
    }

    public static void Union(int a, int b) {
        if (GetRoot(a) == GetRoot(b)) {
            return;
        }

        if (root[GetRoot(a)] < root[GetRoot(b)]) {
            root[b] = GetRoot(a);
            root[GetRoot(a)] += root[GetRoot(b)];
        } else {
            root[a] = GetRoot(b);
            root[GetRoot(b)] += root[GetRoot(a)];
        }
        res--;
    }
}