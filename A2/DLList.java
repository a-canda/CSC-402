public class DLList {
    Node front = null;
    Node last = null;
    
    public void addNode(int data) {
        // new node
        Node newNode = new Node(data);
        
        // check if list is empty
        if(front == null) {
            front = last = newNode;
            front.previous = null;
            last.next = null;
        }
        else {
            // add newNode to end of list. then the tail is set to null.
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
            last.next = null;
        }
    }
}

class Node {
    int data;
    Node next;
    Node previous;
    
    public Node(int data){
        this.data = data;
    }
}