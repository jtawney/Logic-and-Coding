//SearchingMachine.java

/**
 * The searching machine fills an array with random numbers and
 * searches through the array for a value using both
 * linear search and binary search
 *
 * @author (Jake Tawney) 
 * @version (1.0)
 */

import java.util.Random;

public class SearchingMachine
{
    static Random randomGenerator = new Random();
    
    public static void fillArray(int[] data){
        for(int i=0; i<data.length; i++){
            data[i] = randomGenerator.nextInt();
        }
    }
    
    public static boolean linearSearch(int[] data, int value){
        return true;  //delete and fill in code for linear search
    }
    
    public static boolean binarySearch(int[] data, int value){
        return true;  //delete and fill in code for binary search
    }
    
    //Okay, let's use these methods
    public static void main(String[] args){
        int size = 10000;
        int[] A = new int[size];
        fillArray(A);
        
        //Search for a value that is likely not in the array
        int searchValue = randomGenerator.nextInt();
        boolean isThere = linearSearch(A, searchValue);
        System.out.println(searchValue + ": " + isThere);
        
        //Search for a value that is definitely in the array
        int index = randomGenerator.nextInt(size);
        isThere = linearSearch(A, A[index]);
        System.out.println(A[index] + ": " + isThere);
    }
}