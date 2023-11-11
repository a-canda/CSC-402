abstract class A extends Tree {

   // set of default methods common to advice
   // may be overridden by specific types
 
   public Tree accept( I i, Visitor v ) {
      return v.visit(i, this);
   }

   public Tree apply( A a ) {
      return new advsum( a, this );
   }

   public Tree apply( G g ) {
      System.out.println( "cannot apply global advice to A node" );
      System.exit(1);
      return null;
   }

   public Tree apply( H h ) {
      return new hoaadv( h, this );
   }
}
