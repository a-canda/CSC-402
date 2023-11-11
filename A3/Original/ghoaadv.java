class ghoaadv extends G {
   H left;
   G right;

   ghoaadv( H left, G right ) { this.left = left; this.right = right; }

   public Tree apply( G g ) { return new gadvsum( g, this ); }

   public Tree apply(H h) { return new ghoaadv( new hoasum(h, left), right ); }

   public String toString() { return left + "[" + right + "]"; }

   public String eval( String fnc ) { return right.eval(left.eval(fnc)); }
}
