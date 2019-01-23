import java.io.*;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class Circuit
{
    /*
     * The basic way to store wires, which are ordered pairs
     * is to use an array.  The index is the first element,
     * and the value is the second element. Therefore, the circuit
     * pattern (0,1), (2,5), (3,4), (6,9), (7,8) would be stored
     * as follows: wires = [1, 0, 5, 4, 3, 2, 9, 8, 7, 6]
     * So, for example, wires[3] = 4 because (3,4) is a pair;
     * note toot aht wires[4] = 3 becuase (4,3) represents the same
     * wire. This allows us to check if (a,b) is a wire by checking
     * either wires[a]==b or wires[b]==a.
 
     * 
     * For this lab, we presume errorless input.  In other words, 
     * the data will not have (2,3) and (5,3) in it, which would
     * be a contradiction in wiring.
     */
    
    public static boolean checkBox(int [] wires)
    {
        Stack<Integer> myStack = new Stack<Integer>();
        
        for(int i=0; i<wires.length; i++){
            if(myStack.size() == 0)
                myStack.push(i);  //for simplicity, takes advantage of autocasting
            else{
                if(myStack.peek().equals(wires[i]))
                    myStack.pop();
                else
                    myStack.push(i);
            }
        }
        if(myStack.size() == 0)
            return true;
        return false;
    }
    
    public static boolean isNumeric(char c){
        if(c=='0'||c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9')
            return true;
        return false;
    }
    
    public static int[] processInput(String s){
        int commas = 0; //commas are the number of pairs
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ',')
                commas++;
        }
        
        String[] numbers = new String[commas * 2];
        Scanner in = new Scanner(s).useDelimiter("\\) \\(|\\(|,|\\)");
        int[] wires = new int[commas * 2];
        
        for(int i=0; i<commas; i++){
            int a = Integer.parseInt(in.next());
            int b = Integer.parseInt(in.next());
            
            wires[a] = b;
            wires[b] = a;
        }
        
        return wires;
    }
    
    public static void main(String [] args) throws IOException
    {       
        //Code for console I/O - comment out if not using
        /*String boxConfig = JOptionPane.showInputDialog("Please enter the box configuration");
        int[] wires = processInput(boxConfig);
        String n = "not ";
        if(checkBox(wires) == true){
            n = "";
        }
        JOptionPane.showMessageDialog(null, "The box is " + n + "routable.");*/
        
        //Code for file I/O - comment out if not using
        FileReader reader = new FileReader("CircuitBoxes.txt");
	BufferedReader in = new BufferedReader(reader);

	String circuitLine = in.readLine();
	String answerLine = in.readLine();
	while(circuitLine != null){
	    boolean routable = checkBox(processInput(circuitLine));
	    System.out.println(circuitLine);
	    System.out.println("Answer: " + answerLine);
	    System.out.println("Your answer: " + routable);
	    System.out.println("************************************");
	    
	    circuitLine = in.readLine();
	    answerLine = in.readLine();
	}
	reader.close();
    }
}
