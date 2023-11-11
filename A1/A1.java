/**
 * CSC 402-02 Assignment #1
 *
 * On my honor, Aaron Canda, this assignment is my own work.
 * I, Aaron Canda, will follow the instructor's rules and processes
 * related to academic integrity as directed in the course syllabus.
 *
 */

public class A1 {

    // Do NOT change the following line except the SIZE value.
    public static int SIZE = 3;

    public static void main(String[] args) {

        // Do NOT change the following two lines.
        if(args.length > 0 && args[0] != null)
            SIZE = Integer.parseInt(args[0]);

        //---------------------------------------------------------------------
        // Fill in your code here
        
        topBlock();
        middleBlock();
        bottomBlock();


        //
        //---------------------------------------------------------------------
    }

    //---------------------------------------------------------------------
    // Fill in your code here
    public static void topBlock() {
        
        //hashtag line
        for (int space = 1; space <= SIZE*4 + 2; space++) {
            System.out.print(" ");
        }

        for (int hashtag = 1; hashtag <= SIZE*2 - 1; hashtag++) {
            System.out.print("#");
        }
        System.out.println();
        
        // plus signs
        for (int line = 1; line <= SIZE*3 - 2; line++) {
            for (int space = 1; space <= SIZE*4 + 2; space++) {
                System.out.print(" ");
            }
            
            for (int plus = 1; plus <= SIZE*2 - 1; plus++) {
                System.out.print("+");
            }
            System.out.println();
        }
        
        // hashtag line
        for (int space = 1; space <= SIZE*4 + 2; space++) {
            System.out.print(" ");
        }
                  
        for (int hashtag = 1; hashtag <= SIZE*2 - 1; hashtag++) {
            System.out.print("#");
        }
        System.out.println();
    }
    
    public static void middleBlock() {
        
        // carrot line
        for (int space = 1; space <= SIZE*4; space++) {
            System.out.print(" ");
        }
        
        for (int carrot = 1; carrot <= SIZE*2 + 3; carrot++) {
            System.out.print("^");
        }
        System.out.println();
        
        // below carrot line \-+-+-/ increment lines by N^2 + 1
        for (int line = 1; line <= SIZE*SIZE + 1; line++) {
            for (int space = 1; space <= SIZE*4; space++) {
                System.out.print(" ");
            }
            
            System.out.print("\\-");
            
            // inside line
            for (int plusMinus = 1; plusMinus <= SIZE; plusMinus++) {
                System.out.print("+-");
            }
           
            System.out.print("/");
            
            System.out.println();
            
            for (int space = 1; space <= SIZE*4; space++) {
                System.out.print(" ");
            }
            
            for (int carrot = 1; carrot <= SIZE*2 + 3; carrot++) {
                System.out.print("^");
            }
            System.out.println();
        }
    }

    public static void bottomBlock(){
        
    //top lines
        for (int line = 1; line <= (SIZE/2) + 1; line++) {

            for (int space = 1; space <=  line * -3 + (SIZE/2*3) + 3; space++){
                System.out.print(" ");
            }
            System.out.print("/=");
            
            //inside line
            for (int minusEqual = 1; minusEqual <= line * 3 + (SIZE%2 * 3) + (-SIZE%2 * 2) + (SIZE/2 + 3); minusEqual++){
                System.out.print("-=");
                
            }
            System.out.print("\\");
            System.out.println();
        }
        
        //bottom lines
        for (int line = 1; line <= (2*SIZE) - 1; line++) {
            
            System.out.print("/" + '\u0022');
            
            
            for (int percentQuote = 1; percentQuote <= SIZE*5; percentQuote++) {
                
                System.out.print("%" + '\u0022');
            }
            
            System.out.print("\\");
            System.out.println();
        }
        
        System.out.println();
        
    }

    // You are not allowed to use anything besides println/print statements,
    // static methods, method calls, loops, nested loops, local variables, and class constants.

    // You are NOT allowed to use method parameters, methods that return values, or
    // conditional statements (i.e., if, if/else statements).





    //
    //---------------------------------------------------------------------
}
