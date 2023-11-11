class hoaadv extends A {
   H left;
   A right;

   hoaadv( H left, A right ) { this.left = left; this.right = right; }

   public Tree apply(H h) { return new hoaadv( new hoasum( h, left ), right ); }

   public String toString() { return left + "[" + right + "]"; }

   public String eval( String fnc ) { return right.eval( left.eval(fnc) ); }
}
