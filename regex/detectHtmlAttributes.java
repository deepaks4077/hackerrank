import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static StringBuilder htmlBuilder = new StringBuilder("");
    private static Pattern rgxForTagAtEnd = Pattern.compile("(<[a-z0-9]+)$");
    private static Pattern rgxForTagAtStart = Pattern.compile("^[a-z0-9]+");
    private static Pattern rgxToExtractTags = Pattern.compile("(<[a-z]+[^>]*>)");
    private static Pattern rgxToExtractTagName = Pattern.compile("(?:<)[a-z0-9]+");
    private static Pattern rgxToExtractAttribute = Pattern.compile("[a-z]+(?:=[\"\'])");
    
    public static boolean checkForBeginningOfTag(){
        Matcher beginningOfTag = rgxForTagAtEnd.matcher(htmlBuilder.toString());
        Boolean B = beginningOfTag.find();
        return B;
    }
    
    public static boolean doesTagEndInTheSameLine(String remainingHtml){
        Matcher endingOfTag = rgxForTagAtStart.matcher(remainingHtml);
        Boolean B = endingOfTag.find();
        return B;
    }
    
    public static void printTagsAndAttributes(){
        Matcher M = rgxToExtractTags.matcher(htmlBuilder.toString());
        Map<String,TreeSet<String>> tagsAndAttributes = new TreeMap<String,TreeSet<String>>();
        while(M.find()){
            String tag = M.group();
            Matcher tagName = rgxToExtractTagName.matcher(tag);
            Matcher attrName = rgxToExtractAttribute.matcher(tag);
            TreeSet<String> attributes = new TreeSet<String>();
            while(attrName.find()){
                attributes.add(attrName.group(0));
            }
            while(tagName.find()){
                String nameOfTag = tagName.group(0);
                if(tagsAndAttributes.containsKey(nameOfTag)){
                    TreeSet<String> tmpSet = new TreeSet<String>(tagsAndAttributes.get(nameOfTag));
                    tmpSet.addAll(attributes);
                    tagsAndAttributes.put(nameOfTag,tmpSet);
                }else{
                    tagsAndAttributes.put(tagName.group(),attributes);
                }
            }
        }
        
        for(String tag: tagsAndAttributes.keySet()){
            String result = "";
            result = result + tag.substring(1,tag.length()) + ":";
            for(String attribute: tagsAndAttributes.get(tag)){
                result+=attribute.substring(0,attribute.length()-2)+",";
            }
            if(result.charAt(result.length()-1) == ','){
                System.out.print(result.substring(0,result.length()-1));
            }else{
                System.out.print(result);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<T;i++){
            if(scanner.hasNextLine()){
                String nextLine = scanner.nextLine();
                if(checkForBeginningOfTag()){
                    if(!doesTagEndInTheSameLine(nextLine)){
                        htmlBuilder.append(" ");
                    }
                }
                htmlBuilder.append(nextLine);
            }
        }
        
        printTagsAndAttributes();
    }
}
