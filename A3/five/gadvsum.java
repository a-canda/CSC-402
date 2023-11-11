class gadvsum extends G {
   G left;
   G right;

   gadvsum( G left, G right ) { this.left = left; this.right = right; }

   public Tree apply(A a) { return new gadvsum( left, (G) right.apply(a)); }

   public Tree apply( G g ) { return new gadvsum( g, this ); }

   public Tree apply( H h ) { return new ghoaadv( h, this ); }

   public String toString() { return left + " . " + right; }

   public String eval( String fnc ) { return left.eval(fnc)+right.eval(fnc); }
}
