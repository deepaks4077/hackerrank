import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static boolean isPalindrome(String string){
        StringBuilder myPalindrome = new StringBuilder(string);
        StringBuilder newPalindrome = new StringBuilder(string);
        newPalindrome.reverse();
        
        if(myPalindrome.toString().compareTo(newPalindrome.toString()) == 0){
            return true;
        }
        
        return false;
    }
    
    
    public static int indexForPalindrome(String string){
        StringBuilder firstString = new StringBuilder(string);
        
        if(isPalindrome(string)){
            return -1;
        }
        
        StringBuilder secondString = new StringBuilder(string);
        secondString.reverse();
        
        for(int i=0;i<firstString.length();i++){
            if(secondString.charAt(i) != firstString.charAt(i)){
               if(isPalindrome(firstString.deleteCharAt(i).toString())){
                   return i;
               }else{
                   return string.length() - 1 - i;
               }
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for(int i =0;i<T;i++){
            System.out.println(indexForPalindrome(scanner.nextLine()));
        }
    }
}
