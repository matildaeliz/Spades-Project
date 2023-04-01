public class Node {


    private Card card;

    private Node next;

    public Node(Card card){
        this.card = card;
        this.next = null;
    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public Card getCard(){
        return  card;
    }
}
