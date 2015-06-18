import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static HashMap<Character, Integer> createCharacterHash(String string){
        HashMap<Character,Integer> result = new HashMap<Character,Integer>();
        for(int i=0;i<string.length();i++){
            char key = string.charAt(i);
            if(result.containsKey(new Character(key))){
                result.put(key,result.get(key) + 1);
            }else{
                result.put(key,1);
            }
        }
                           
        return result;
    }
    
    public static int findAnagramIndex(String anagram, String input){
        Map<Character, Integer> anagramMap = createCharacterHash(anagram);
        
        //System.out.print(anagram + " " + input + " ");
        
        for(int i =0;i<input.length();i++){
            if(anagramMap.containsKey(new Character(input.charAt(i)))){
                if((anagram.length() + i)<=input.length()){
                    Map<Character,Integer> inputMap = createCharacterHash(input.substring(i,i + anagram.length()));
                    if(anagramMap.entrySet().containsAll(inputMap.entrySet())){
                        return i;
                    }    
                }
            }
        }
        
        return -1;
    }
    
    public static int checkForAnagramPairs(String substring, String string){
        //find index of next anagram
        //repeat until no anagram present 
        int index = 0;
        int anagramIndex = 0;
        int count = 0;
        while(index<string.length()){
            anagramIndex = findAnagramIndex(substring,string.substring(index,string.length()));
            if(anagramIndex > -1){
                count++;
                index += anagramIndex + 1;
            }else{
                break;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        int count;
        
        for(int i =0;i<T;i++){
            count =  0;
            String input = scanner.nextLine();
            for(int j =0;j<input.length()-1;j++){
                for(int k=j+1;k<=input.length();k++){
                    String substring = input.substring(j,k);
                    count += checkForAnagramPairs(substring, input.substring(j+1,input.length()));
                }
            }
            System.out.println(count);
        }
    }
}