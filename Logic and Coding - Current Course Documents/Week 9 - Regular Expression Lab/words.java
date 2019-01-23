import java.util.*;
import java.io.*;
import java.util.regex.Pattern; 
import java.util.regex.Matcher;

public class words{
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(new File("WORD.txt"));
    
        //This example find all words that have at least two a's in a row
        //It also demonstrates file processing
        while(input.hasNextLine()){
            String word = input.nextLine();
        
            Pattern p = Pattern.compile(".*aa.*");
            Matcher m = p.matcher(word);
            if(m.matches()){
                System.out.println(word);
            }
        }
    }
    
}

    
