public class Card {
    /**
     * card suit
     */
    private String suit;

    /**
     * card number
     */
    private String number;

    /**
     * full of card
     */

    private String Ecard;

    /**
     * value of the card
     */
    private int value;
    /**
     * owner of the card
     */
    String owner;


    public Card(String suit, String number, int value){
        this.suit = suit;
        this.number = number;
        this.value = value;
        this.Ecard = suit+" "+number;
    }
    public Card() {
    }

    /**
     * gets owner
     * @return
     */
    public String getOwner() {
        return owner;
    }

    /**
     * sets the owner
     * @param owner
     */

    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * gets the value of card
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * gets the suit of card
     * @return
     */
    public String getSuit() {
        return suit;
    }

    /**
     * gets total of card
     * @return
     */

    public String getECard() {
        return Ecard;
    }


    /**
     * this method creates all 52 cards
     * @param list
     */
    public void createCards(LinkedList list){
        for(int suit = 1; suit < 5; suit++) {
            for(int number = 2; number<11; number++){
                if(suit == 1){
                    list.insertLast(new Node(new Card("Spades", Integer.toString(number),number)));
                } if(suit == 2){
                    list.insertLast(new Node(new Card("Diamonds", Integer.toString(number),number)));
                } if(suit == 3){
                    list.insertLast(new Node(new Card("Hearts", Integer.toString(number),number)));
                } if(suit == 4){
                    list.insertLast(new Node(new Card("Clubs", Integer.toString(number),number)));
                }
            }
        }




        list.insertLast(new Node(new Card("Spades", "Joker",11)));
        list.insertLast(new Node(new Card("Clubs", "Joker",11)));
        list.insertLast(new Node(new Card("Diamonds", "Joker",11)));
        list.insertLast(new Node(new Card("Hearts", "Joker",11)));

        list.insertLast(new Node(new Card("Spades", "Queen",12)));
        list.insertLast(new Node(new Card("Clubs", "Queen",12)));
        list.insertLast(new Node(new Card("Diamonds", "Queen",12)));
        list.insertLast(new Node(new Card("Hearts", "Queen",12)));

        list.insertLast(new Node(new Card("Spades", "King",13)));
        list.insertLast(new Node(new Card("Clubs", "King",13)));
        list.insertLast(new Node(new Card("Diamonds", "King",13)));
        list.insertLast(new Node(new Card("Hearts", "King",13)));

        list.insertLast(new Node(new Card("Spades", "Ace",14)));
        list.insertLast(new Node(new Card("Clubs", "Ace",14)));
        list.insertLast(new Node(new Card("Diamonds", "Ace",14)));
        list.insertLast(new Node(new Card("Hearts", "Ace",14)));
    }



}