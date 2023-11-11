class advprog extends I {
   A left;
   I right;

   advprog( A left, I right ) { this.left = left; this.right = right; }

   public Tree apply( I i ) { return new intsum( i, this ); }

   public Tree apply( G g ) { return new gadvprog( g, this ); }

   public Tree apply(A a) { return new advprog( new advsum( a, left ), right); }

   public Tree apply(H h) { return new advprog((A) left.apply(h), (I) right.apply(h)); }

   public String toString() { return left + "(" + right + ")"; }

   public String eval( String fnc ) {  return right.eval(fnc+left.eval("")); }
}
 
