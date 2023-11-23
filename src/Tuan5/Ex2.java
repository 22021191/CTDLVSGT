package Tuan5;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class ResultEx2 {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
    // Write your code here
        Stack<Character> tmp=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{'||s.charAt(i)=='['||s.charAt(i)=='('){
                tmp.push(s.charAt(i));
            }else{
                if(tmp.size()==0) return "NO";
                switch (s.charAt(i)){
                    case '}' :
                        if(tmp.peek()!='{'){
                        return "NO";
                        }
                        tmp.pop();
                        break;
                    case ')' :
                        if(tmp.peek()!='('){
                            return "NO";
                        }
                        tmp.pop();
                        break;
                    case ']' :
                        if(tmp.peek()!='['){
                            return "NO";
                        }
                        tmp.pop();
                        break;
                }
            }
        }
        if(tmp.size()!=0){
            return "NO";
        }
        return "YES";
    }

}

public class Ex2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = ResultEx2.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
