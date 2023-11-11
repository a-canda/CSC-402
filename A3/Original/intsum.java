class intsum extends I {
   I left;
   I right;

   intsum( I left, I right ) { this.left = left; this.right = right; }

   public Tree apply( I i ) { return new intsum( i, this ); }

   public Tree apply( A a ) { return new advprog( a, this ); }

   public Tree apply( G g ) { return new gadvprog( g, this ); }

   public Tree apply( H h ) { 
      return new intsum( (I) left.apply(h), (I) right.apply(h) ); 
   }

   public String toString() { return left + " + " + right; }

   public String eval( String fnc ) { 
      return left.eval(fnc) + " + " + right.eval(fnc); }
}
