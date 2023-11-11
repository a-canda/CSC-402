class hoasum extends H {
   H left;
   H right;

   hoasum( H left, H right ) { this.left = left; this.right = right; }

   public Tree apply( H h ) { return new hoasum( h, this ); }

   public String toString() { return left + " * " + right; }

   public String eval( String fnc ) { return left.eval(fnc)+right.eval(fnc); }
}
