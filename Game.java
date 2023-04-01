
public class Game {
    private final int endgamepoint = 500;

    /**
     * Method starts the game
     */
    public void play() {

        Card card = new Card();
        LinkedList deck = new LinkedList();
        Player player = new Player();
        BotPlayer botPlayer1 = new BotPlayer();
        BotPlayer botPlayer2 = new BotPlayer();
        BotPlayer botPlayer3 = new BotPlayer();
        boolean flag = false;
        System.out.println("botPlayer 1 is sharing the cards...");
        card.createCards(deck);
        deck.shuffle(deck);
        player.sharetheCards(deck, botPlayer1, botPlayer2, botPlayer3, player);


        while(player.getBid()<=500||botPlayer1.getBid()<=500||botPlayer2.getBid()<=500||botPlayer3.getBid()<=500) {
            player.hand.printList();

            player.bidsForEnter();
            botPlayer1.bidsForEnter();
            botPlayer2.bidsForEnter();
            botPlayer3.bidsForEnter();



            player.play(flag,1);

            for(int el = 1 ; el <=13; el++){



                for (int tur = 1; tur<=4; tur++){
                    Node throwedCard;
                    String cardInTable;
                    int valuablecard = 0;
                    Node initialcard = null;

                    if(tur == 1){
                         

                    } else if (tur == 2) {

                    }else if (tur == 3){

                    } else if (tur == 4) {

                    }





                }
            }
        }
    }








}