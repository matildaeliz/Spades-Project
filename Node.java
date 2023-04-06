public class Node {

    /**
     * Card instance
     */
    private Card card;
    /**
     * next instance
     */
    private Node next;

    public Node(Card card){
        this.card = card;
        this.next = null;
    }

    /**
     * gets next adress
     * @return
     */
    public Node getNext() {
        return next;
    }

    /**
     * sets the next adress
     * @param next
     */
    public void setNext(Node next){
        this.next = next;
    }

    /**
     * gets the card object
     * @return
     */
    public Card getCard(){
        return  card;
    }
}
