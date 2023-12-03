package Tuan8;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi văn bản:");
        String inputText = scanner.nextLine();
        scanner.close();

        // Tách các từ từ chuỗi
        String[] words = inputText.split("\\s+");

        // Sử dụng TreeMap để đếm số lần xuất hiện của mỗi từ
        TreeMap<String, Integer> wordCountMap = new TreeMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // In kết quả
        for (String word : wordCountMap.keySet()) {
            System.out.println(word + ": " + wordCountMap.get(word) + " lần");
        }
    }
}
