public class CardNode {


    private Card card;

    private CardNode next;

    public CardNode(Card card){
        this.card = card;
        this.next = null;
    }


    public CardNode getNext() {
        return next;
    }

    public void setNext(CardNode next){
        this.next = next;
    }

    public Card getCard(){
        return  card;
    }
}
