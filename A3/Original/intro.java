class intro extends I {
   String name;

   intro(String name) { this.name = name; }

   public Tree apply( I i ) { return new intsum( i, this ); }

   public Tree apply( A a ) { return new advprog( a, this ); }

   public Tree apply( G g ) { return new gadvprog( g, this ); }

   public Tree apply( H h ) { return this; }
   
   public String toString() { return name; }

   public String eval( String fnc ) { return fnc + name; }
}
