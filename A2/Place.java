class Petri {
    Box[] box;
    Transition[] transition;
    Place[] place;
}

class Place {
    String label;
    int shape;
    Token[] token;
    Transition[] incoming;
    Transition[] outgoing;
}

class Token {
    int shape;
}

class Box {
    String label;
    int color;
    int shape;
    Transition[] incoming;
    Transition[] outgoing;
}

class Transition {
    String label;
    int capacity;
    Box startsFrom;
    Box endsAt;
    Place starts;
    Place ends;
}