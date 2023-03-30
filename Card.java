public class Card {

    private String suit;
    private String number;

    private String Ecard;
    private int value;


    public Card(String suit, String number, int value){
        this.suit = suit;
        this.number = number;
        this.value = value;
        this.Ecard = suit+","+number;
    }
    public Card() {
    }






    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public String getECard() {
        return Ecard;
    }


    /**
     * Method creates the all 53 cards with loop
     * @param list
     */
    public void createCards(CardLinkedList list){
        for(int suit = 1; suit < 5; suit++) {
            for(int number = 2; number<11; number++){
                if(suit == 1){
                    list.insertLast(new CardNode(new Card("Spades", Integer.toString(number),number)));
                } if(suit == 2){
                    list.insertLast(new CardNode(new Card("Diamonds", Integer.toString(number),number)));
                } if(suit == 3){
                    list.insertLast(new CardNode(new Card("Hearts", Integer.toString(number),number)));
                } if(suit == 4){
                    list.insertLast(new CardNode(new Card("Clubs", Integer.toString(number),number)));
                }
            }
        }




        list.insertLast(new CardNode(new Card("Spades", "Joker",11)));
        list.insertLast(new CardNode(new Card("Clubs", "Joker",11)));
        list.insertLast(new CardNode(new Card("Diamonds", "Joker",11)));
        list.insertLast(new CardNode(new Card("Hearts", "Joker",11)));

        list.insertLast(new CardNode(new Card("Spades", "Queen",12)));
        list.insertLast(new CardNode(new Card("Clubs", "Queen",12)));
        list.insertLast(new CardNode(new Card("Diamonds", "Queen",12)));
        list.insertLast(new CardNode(new Card("Hearts", "Queen",12)));

        list.insertLast(new CardNode(new Card("Spades", "King",13)));
        list.insertLast(new CardNode(new Card("Clubs", "King",13)));
        list.insertLast(new CardNode(new Card("Diamonds", "King",13)));
        list.insertLast(new CardNode(new Card("Hearts", "King",13)));

        list.insertLast(new CardNode(new Card("Spades", "Ace",14)));
        list.insertLast(new CardNode(new Card("Clubs", "Ace",14)));
        list.insertLast(new CardNode(new Card("Diamonds", "Ace",14)));
        list.insertLast(new CardNode(new Card("Hearts", "Ace",14)));
    }



}
