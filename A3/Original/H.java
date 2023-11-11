abstract class H extends Tree {

   // set of methods common to all higher-order advice
 
   public Tree apply( I i ) {
      System.out.println( "cannot apply introduction to higher order advice" );
      System.exit(1);
      return null;
   }

   public Tree apply( A a ) {
      System.out.println( "cannot apply local advice to higher order advice" );
      System.exit(1);
      return null;
   }

   public Tree apply( G g ) {
      System.out.println( "cannot apply global advice to higher order advice" );
      System.exit(1);
      return null;
   }
}
