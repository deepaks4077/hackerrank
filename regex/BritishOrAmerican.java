import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static StringBuilder testString = new StringBuilder();
    
    public static int countOccurences(String input){
        String subPattern = input.substring(0,input.length()-2);
        Pattern P = Pattern.compile(subPattern+"[zs]e");
        Matcher M = P.matcher(testString.toString());
        int count = 0;
        while(M.find()){
            count++;
        }
        return count;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        for(int i =0;i<N;i++){
            testString.append(" ");
            testString.append(scanner.nextLine());
        }
                
        int T = scanner.nextInt();
        scanner.nextLine();
        for(int i =0;i<T;i++){
            System.out.println(countOccurences(scanner.nextLine()));
        }
    }
}