class gadvprog extends I {
   G left;
   I right;

   gadvprog( G left, I right ) { this.left = left; this.right = right; }

   public Tree accept( I i, Visitor v ) { return v.visit( i, this ); }

   public Tree apply( A a ) { return new gadvprog( left, (I) right.apply(a)); }

   public Tree apply( G g ) { return new gadvprog(new gadvsum(g,left), right) ; }

   public Tree apply( H h ) { return new gadvprog((G) left.apply(h), (I) right.apply(h)); }

   public String toString() { return left + "(" + right + ")"; }

   public String eval( String fnc ) {  return right.eval(fnc+left.eval("")); }
}
