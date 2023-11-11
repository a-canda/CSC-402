abstract class Tree {
   public abstract Tree accept( I i, Visitor v );
   public abstract Tree apply( A a );
   public abstract Tree apply( H h );
   public abstract Tree apply( G g );
   public abstract String toString();
   public abstract String eval( String fnc );
   public void print() { System.out.println( this.toString() ); }
}
