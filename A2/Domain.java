class Category {
    Domain[] domain;
    Arrow[] arrow;
}
class Domain {
    String label;
    Arrow[] incoming;
    Arrow[] outgoing;
}

class Arrow {
    String label;
    Domain startsFrom;
    Domain endsAt;
}

