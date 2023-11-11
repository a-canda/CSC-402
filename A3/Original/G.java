abstract class G extends Tree {

   // set of default methods common to advice
   // may be overridden by specific types
 
   public Tree apply( I i ) {
      System.out.println( "cannot apply introduction to A node" );
      System.exit(1);
      return null;
   }

   public Tree apply( A a ) {
      System.out.println( "cannot apply local advice to G node" );
      System.exit(1);
      return null;
   }
}
