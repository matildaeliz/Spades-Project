import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    /**
     * hand of player
     */
    LinkedList hand;
    /**
     * forcestedbid for player
     */
    protected int forcestedbid;
    /**
     * actualbid for player
     */
    protected int actualbid;

    /**
     * total point for playet
     */

    protected int totalpoint;

    public Player() {
        hand = new LinkedList();
}

    /**
     * player enter the bids;
     */
    public void bidsForEnter(){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Please enter your bid: ");
        int value = sc.nextInt();
        forcestedbid = value;


    }

    /**
     * gets the forcestedbid
     * @return
     */
    public int getForcestedBid(){
        return forcestedbid;
}

    /**
     * gets the actual bid;
     * @return
     */
    public int getActualbid() {
        return actualbid;
    }

    /**
     * every win the tour, increasr the bid 1;
     */
    public void increaseActualbid(){
        actualbid++;
    }

    /**
     * get total point,
     * @return
     */
    public int getTotalpoint() {
        return totalpoint;
    }

    /**
     *  Player shares the card from the deck linkedlist and shares eqully 13 card
     * @param deck
     * @param botPlayer1
     * @param botPlayer2
     * @param botPlayer3
     * @param player
     */

    public void sharetheCards(LinkedList deck, BotPlayer botPlayer1, BotPlayer botPlayer2, BotPlayer botPlayer3, Player player) {
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j <= 13; j++) {
                if (i == 1) {
                    player.hand.newLinkedListinsert(deck.getFirst());
                     player.hand.getNode(j).getCard().setOwner("Player");
                }
                else if (i == 2) {
                    botPlayer1.hand.newLinkedListinsert(deck.getFirst());
                    botPlayer1.hand.getNode(j).getCard().setOwner("BotPlayer1");
                }
               else  if (i == 3) {
                    botPlayer2.hand.newLinkedListinsert(deck.getFirst());
                    botPlayer2.hand.getNode(j).getCard().setOwner("BotPlayer2");
                }
               else  if (i == 4) {
                    botPlayer3.hand.newLinkedListinsert(deck.getFirst());
                    botPlayer3.hand.getNode(j).getCard().setOwner("BotPlayer3");
                }
            }
        }
    }

    /**
     * the method to play for player object. First the cart is wants to select. Then Checks the condition for the game and
     *  returns or wants a new card number due to the condition of game
     * @param breaking
     * @param initialcard
     * @return
     */
    public Node play(boolean breaking,Node initialcard) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Warning: You need to write position number of card what you see on your hand ");
        System.out.print("Select Card: ");

        int chosencardindex = sc.nextInt();

        int numberofnonspades = calculatingnumberofnonSpades();
        Node playedcard = null;
       if(breaking == true){

           if (calculateInitialcard(initialcard)>0) {

               if(initialcard.getCard().getSuit().equals("Spades")){

                   playedcard = hand.getNode(chosencardindex);
                   if(playedcard == hand.getHead() ){
                       hand.setHead(playedcard.getNext());
                       playedcard.setNext(null);
                       return playedcard;
                   }else{
                       Node previous = hand.getPrevious(playedcard);
                       Node currentnext = playedcard.getNext();
                       previous.setNext(currentnext);
                       playedcard.setNext(null);

                       return playedcard;
                   }
               }

               if((hand.getNode(chosencardindex).getCard().getSuit().equals(initialcard.getCard().getSuit())) || hand.getNode(chosencardindex).getCard().getSuit().equals("Spades")){


                   playedcard = hand.getNode(chosencardindex);
                   if(playedcard == hand.getHead() ){
                       hand.setHead(playedcard.getNext());
                       playedcard.setNext(null);
                       return playedcard;
                   }else{
                       Node previous = hand.getPrevious(playedcard);
                       Node currentnext = playedcard.getNext();
                       previous.setNext(currentnext);
                       playedcard.setNext(null);

                       return playedcard;
                   }

               } else {
                   System.out.println("You need to choose correct suit");
                   System.out.print("Select Card: ");

                   chosencardindex = sc.nextInt();
               }


           } else {

               playedcard = hand.getNode(chosencardindex);
               if(playedcard == hand.getHead() ){
                   hand.setHead(playedcard.getNext());
                   playedcard.setNext(null);
                   return playedcard;
               }else{
                   Node previous = hand.getPrevious(playedcard);
                   Node currentnext = playedcard.getNext();
                   previous.setNext(currentnext);
                   playedcard.setNext(null);

                   return playedcard;
               }

           }

        }
        else if(breaking == false ){

            while (true){
                if(hand.getNode(chosencardindex).getCard().getSuit().equals("Spades")){
                    System.out.println("You cannot play Spades until you dont have any card except Spades or open the game with Spades");
                    System.out.print("Select Card: ");
                    chosencardindex = sc.nextInt();
                }
                if (calculateInitialcard(initialcard)>0) {
                    if(hand.getNode(chosencardindex).getCard().getSuit().equals(initialcard.getCard().getSuit())){
                        playedcard = hand.getNode(chosencardindex);
                        if(playedcard == hand.getHead() ){
                            hand.setHead(playedcard.getNext());
                            playedcard.setNext(null);
                            return playedcard;
                        }else{
                            Node previous = hand.getPrevious(playedcard);
                            Node currentnext = playedcard.getNext();
                            previous.setNext(currentnext);
                            playedcard.setNext(null);

                            return playedcard;
                        }

                    } else {
                        System.out.println("You need to choose correct suit");
                        System.out.print("Select Card: ");
                        chosencardindex = sc.nextInt();
                    }


                } else if(calculateInitialcard(initialcard) == 0){

                    playedcard = hand.getNode(chosencardindex);
                    if(playedcard == hand.getHead() ){
                        hand.setHead(playedcard.getNext());
                        playedcard.setNext(null);
                        return playedcard;
                    }else{
                        Node previous = hand.getPrevious(playedcard);
                        Node currentnext = playedcard.getNext();
                        previous.setNext(currentnext);
                        playedcard.setNext(null);

                        return playedcard;
                    }

                }
            }

        }
        return null;
    }


    /**
     * this methos calcutes point using forcested bid and actual bid
     */
    public void calculatepoint(){
             if(forcestedbid == 0 && actualbid>=1){
                    totalpoint -= 100;
                }
                else if(forcestedbid == 0 && actualbid ==0){
                    totalpoint += 100;
                }


                if(forcestedbid == actualbid){
                    totalpoint += actualbid*10;

                }

                if(actualbid > forcestedbid){
                    int remains = actualbid-forcestedbid;
                    int  point = (actualbid-remains)*10;
                    totalpoint += point;

                    if(remains > 0){
                        totalpoint+=remains;
                    }


                }


                if(forcestedbid > actualbid){
                    totalpoint -= actualbid*10;
                }











    }

    /**
     * Calculates number of non spades card;
     * @return
     */
    public int  calculatingnumberofnonSpades(){
        int number = 0;
        for(int j = 1; j<=hand.getSizeofHand(); j++){
            String card = hand.getNode(j).getCard().getSuit();
            if(card.equals("Spades")){

            }else{
                number++;
            }
        }
        return number;
    }

    /**
     * calculates the initial card due to checking if there are  any inital card
     * @param initialcard
     * @return
     */
 public int calculateInitialcard(Node initialcard){
       int number = 0;
       for(int i = 1 ; i<=this.hand.getSizeofHand();i++){

            if (initialcard == null){
                break;
            }

            else if (hand.getNode(i).getCard().getSuit().equals(initialcard.getCard().getSuit())){
                number++;
            }

       }
       return number;
 }







}
