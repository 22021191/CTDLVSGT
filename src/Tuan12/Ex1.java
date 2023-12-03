package Tuan12;
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


public class Ex1 {
    static int[] array = {-1, 0, 1};
    static int[][] grid;
    static boolean[][] visited;
    static int N, M;
    static int count=0;
    static boolean check(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static void Dfs(int x, int y) {
        if(grid[x][y]==1){
            count++;
        }
        visited[x][y] = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(check(x+array[i], y+array[j])){
                    if (!visited[x + array[i]][y + array[j]] &&grid[x+array[i]][ y+array[j]]==1){
                        Dfs(x + array[i], y + array[j]);
                    }
                }
            }
        }
    }

    static int count_connected(int row, int col) {
        int cnt = 0;
        Dfs(row, col);
        cnt=count;
        count=0;
        return cnt;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        grid = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                grid[i][j] = scanner.nextInt();
                visited[i][j] = false;
            }
        }
        int max = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                int cnt = count_connected(i, j);
                if (max < cnt) max = cnt;
            }
        }

        System.out.println(max);

    }

}
