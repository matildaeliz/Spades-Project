import java.util.Scanner;

public class Player {

    LinkedList hand;

    protected int bid;

    protected int totalpoint;

    public Player() {
        hand = new LinkedList();


}





    public void bidsForEnter(){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Please enter your bid: ");
        int value = sc.nextInt();
        bid = value;


    }

public int getBid(){
        return bid;
}

    public int getTotalpoint() {
        return totalpoint;
    }

    public void sharetheCards(LinkedList deck, BotPlayer botPlayer1, BotPlayer botPlayer2, BotPlayer botPlayer3, Player player) {
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j <= 13; j++) {
                if (i == 1) {
                    player.hand.newLinkedListinsert(deck.getFirst());
                }
                if (i == 2) {
                    botPlayer1.hand.newLinkedListinsert(deck.getFirst());
                }
                if (i == 3) {
                    botPlayer2.hand.newLinkedListinsert(deck.getFirst());
                }
                if (i == 4) {
                    botPlayer3.hand.newLinkedListinsert(deck.getFirst());

                }
            }
        }
    }


    public Node play(boolean breaking, int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Warning: You need to write position number of card what you see on your hand ");
        System.out.print("Select Card: ");
        int chosencardindex = sc.nextInt();
        int tur = i;
        int numberofnonspades = calculatingnumberofnonSpades();
        Node playedcard =null;

        if(breaking == false ){

            while (true){
                if(hand.getNode(chosencardindex).getCard().getSuit().equals("Spades")){
                    System.out.println("You cannot play Spades until you dont have any card except Spades or open the game with Spades");
                    System.out.print("Select Card: ");
                    chosencardindex = sc.nextInt();
                }else{

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

        } else if(breaking == true || numberofnonspades == 0){
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
        return null;
    }


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







}
