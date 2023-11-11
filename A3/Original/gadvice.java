class gadvice extends G {
   String name;

   gadvice( String name ) { this.name = name; }

   public Tree apply( G g ) { return new gadvsum( g, this ); }

   public Tree apply( H h ) { return new ghoaadv( h, this ); }

   public String toString() { return name; }

   public String eval( String fnc ) { return fnc+name; }
}
