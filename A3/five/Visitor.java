/**
 * CSC 402-02 Assignment #3
 * 
 * On my honor, Aaron Canda, this assignment is my own work.  
 * I, Aaron Canda, will follow the instructor's rules and processes 
 * related to academic integrity as directed in the course syllabus.
 *
 */

public class Visitor {
	//---------------------------------------------------------------------
	// Fill in your code here
        private Visitor(){}
        private static Visitor instance = null;
        public static Visitor getInstance(){
            if(instance == null)
                instance = new Visitor();
            return instance;
        }
        
        public Tree visit( I i, advprog ap ) {
            return new intsum( i, ap );
        }
        
        public Tree visit( I i, gadvprog gp ) {
            return new gadvprog( gp.left, (I) gp.right.accept( i, this ));
        }
        
        public Tree visit( I i, intro in ) {
            return new intsum( i, in );
        }
        
        public Tree visit( I i, intsum is ) {
            return new intsum( i, is );
        }
        
        public Tree visit( I i, A a ) {
            System.out.println( "cannot apply introduction to A node" );
            System.exit(1);
            return null;
        }
        
        public Tree visit( I i, G g ) {
            System.out.println( "cannot apply introduction to A node" );
            System.exit(1);
            return null;
        }
        
        public Tree visit( I i, H h ) {
            System.out.println( "cannot apply introduction to higher order advice" );
            System.exit(1);
            return null;
        }
        
        //
	//---------------------------------------------------------------------	
}
