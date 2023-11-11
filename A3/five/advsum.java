class advsum extends A {
   A left;
   A right;

   advsum( A left, A right ) { this.left = left; this.right = right; }

   public Tree apply(A a) { return new advsum( a, this ); }

   public String toString() { return left + " . " + right; }

   public String eval( String fnc ) { return left.eval(fnc) + right.eval(fnc); }
}
