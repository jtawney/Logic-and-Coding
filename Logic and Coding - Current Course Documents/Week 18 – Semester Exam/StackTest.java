

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;

/**
 * The test class StackTest.
 *
 * @author  (Jake Tawney)
 * @version (January 16, 2019)
 */
public class StackTest
{
    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
 
    @Before
    public void setUpStreams() {
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }
 
    @After
    public void revertStreams() {
        System.setOut(sysOut);
    }
    
    @Test
    public void testConstructor()
    {
        // Setup
        final Stack myStack = new Stack();
        
        // Method under test
        assertEquals(myStack.size(), 0);
        assertEquals(outContent.toString(), "");
    }
    
    @Test
    public void testPushAndPeek()
    {
        // Setup
        final Stack myStack = new Stack();
        myStack.push("Hello");
        
        // Method under test
        assertEquals(myStack.size(), 1);
        assertEquals(myStack.peek(), "Hello");
        assertEquals(outContent.toString(), "");
    }
    
    @Test
    public void testPop()
    {
        final Stack myStack = new Stack();
        myStack.push("Hello");
        String y = myStack.pop();
        
        // Method under test
        assertEquals(myStack.size(), 0);
        assertEquals(y, "Hello");
        assertEquals(outContent.toString(), "");
    }
    
    @Test
    public void testSize()
    {
        // Setup
        final Stack myStack = new Stack();
        int sizeTest = 50;
        for(int i=0; i<sizeTest; i++)
            myStack.push("Hello " + i);
        
        // Method under test
        assertEquals(myStack.size(), sizeTest);
        assertEquals(outContent.toString(), "");
    }
    
    @Test
    public void testPeekEmpty()
    {
        // Setup
        final Stack myStack = new Stack();
        
        // Method under test
        assertNull(myStack.peek());
        assertEquals(myStack.size(), 0);
        assertEquals(outContent.toString(), "Error - Empty Stack\n");
    }
    
    @Test
    public void testPopEmpty()
    {
        // Setup
        final Stack myStack = new Stack();
        
        // Method under test
        assertNull(myStack.pop());
        assertEquals(myStack.size(), 0);
        assertEquals(outContent.toString(), "Error - Empty Stack\n");
    }
    
    @Test
    public void testNumerousPushes()
    {
        // Setup
        final Stack mySmallStack = new Stack();
        int smallSize = 100;
        for(int i=0; i<smallSize; i++)
            mySmallStack.push("Hello " + i);
        
        final Stack myMediumStack = new Stack();
        int mediumSize = 150;
        for(int i=0; i<mediumSize; i++)
            myMediumStack.push("Hello " + i);
            
        final Stack myLargeStack = new Stack();
        int largeSize = 1050;
        for(int i=0; i<largeSize; i++)
            myLargeStack.push("Hello " + i);
        
        // Method under test
        assertEquals(mySmallStack.size(), smallSize);
        assertEquals(myMediumStack.size(), mediumSize);
        assertEquals(myLargeStack.size(), largeSize);
        assertEquals(outContent.toString(), "");
    }
    
    @Test
    public void testPushAndPop()
    {
        // Setup
        final Stack mySmallStack = new Stack();
        int smallSize = 50;
        for(int i=0; i<smallSize; i++)
            mySmallStack.push("Hello " + i);
        String test1 = mySmallStack.pop(); //should be "Hello smallSize – 1"
        String test2 = mySmallStack.pop(); //should be "Hello smallSize – 2"
        String test3 = mySmallStack.pop(); //should be "Hello smallSize – 3"
        mySmallStack.push("Hello A");
        mySmallStack.push("Hello B");
        String test4 = mySmallStack.pop(); //should be "Hello B"
        String test5 = mySmallStack.pop(); //should be "Hello A"
        String test6 = mySmallStack.pop(); //should be "Hello smallSize - 4"
        String test7 = mySmallStack.pop(); //should be "Hello smallSize - 5"
        mySmallStack.push("Hello C");
        String test8 = mySmallStack.pop(); //should be "Hello C"
        
        final Stack myLargeStack = new Stack();
        int largeSize = 203;
        for(int i=0; i<largeSize; i++)
            myLargeStack.push("Goodbye " + i);
        for(int j=0; j<10; j++)
            myLargeStack.pop();
        String test9 = myLargeStack.pop(); //should be "Goodbye largeSize – 11"
        for(int k=0; k<20; k++)
            myLargeStack.push("Goodbye Again " + k);
        String test10 = myLargeStack.pop(); //should be "Goodbye Again 19"
        for(int a = 0; a<20; a++)
            myLargeStack.pop();
        String test11 = myLargeStack.pop(); //should be "Goodbye largeSize - 13"
    
        // Method under test
        assertEquals(test1, "Hello " + (smallSize - 1));
        assertEquals(test2, "Hello " + (smallSize - 2));
        assertEquals(test3, "Hello " + (smallSize - 3));
        assertEquals(test4, "Hello B");
        assertEquals(test5, "Hello A");
        assertEquals(test6, "Hello " + (smallSize - 4));
        assertEquals(test7, "Hello " + (smallSize - 5));
        assertEquals(test8, "Hello C");
        assertEquals(test9, "Goodbye " + (largeSize - 11));
        assertEquals(test10, "Goodbye Again 19");
        assertEquals(test11, "Goodbye " + (largeSize - 13));
        
        assertEquals(mySmallStack.size(), smallSize - 5);
        assertEquals(myLargeStack.size(), largeSize - 13);
        assertEquals(outContent.toString(), "");
    }
    
    @Test
    public void fillAndEmpty()
    {
        // Setup
        final Stack myStack = new Stack();
        int mySize = 1025;
        for(int i = 0; i<mySize; i++)
            myStack.push("Hello " + i);
        for(int j = 0; j<mySize; j++)
            myStack.pop();
        
        // Method under test
        assertNull(myStack.peek());
        assertEquals(myStack.size(), 0);
        assertEquals(outContent.toString(), "Error - Empty Stack\n");
    }
}
