class hoa extends H {
   String name;

   hoa(String name) { this.name = name; }

   public Tree apply( H h ) { return new hoasum( h, this ); }

   public String toString() { return name; }

   public String eval( String fnc ) { return fnc + name; }
}
