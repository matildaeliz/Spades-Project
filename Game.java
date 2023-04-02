
public class Game {
    private final int endgamepoint = 500;

    Card card = new Card();
    LinkedList deck = new LinkedList();
    Player player = new Player();
    BotPlayer botPlayer1 = new BotPlayer();
    BotPlayer botPlayer2 = new BotPlayer();
    BotPlayer botPlayer3 = new BotPlayer();


    /**
     * Method starts the game
     */
    public void play() {


        boolean flag = false;
        System.out.println("botPlayer 1 is sharing the cards...");
        card.createCards(deck);
        deck.shuffle(deck);
        player.sharetheCards(deck, botPlayer1, botPlayer2, botPlayer3, player);


        while(player.getForcestedBid()<=500||botPlayer1.getForcestedBid()<=500||botPlayer2.getForcestedBid()<=500||botPlayer3.getForcestedBid()<=500) {
            player.hand.printList();

            player.bidsForEnter();
            botPlayer1.bidsForEnter();
            botPlayer2.bidsForEnter();
            botPlayer3.bidsForEnter();





            for(int el = 1 ; el <=13; el++){
                Node throwedCard ;
                String cardInTable ="";
                Node valuablecard = null;
                Node initialcard = null;

                for (int tur = 1; tur<=4; tur++){


                    if(tur == 1){
                        player.hand.printList();
                        throwedCard = player.play(flag);
                        cardInTable = throwedCard.getCard().getECard();
                        System.out.println("ThrowedCard :"+cardInTable);

                        if(initialcard ==null && throwedCard != null){
                            initialcard = throwedCard;
                        }

                        if(valuablecard == null){
                            valuablecard = throwedCard;
                        }else if(throwedCard.getCard().getValue() > valuablecard.getCard().getValue()){
                            valuablecard = throwedCard;
                        }

                    } else if (tur == 2) {

                    }else if (tur == 3){

                    } else if (tur == 4) {

                    }

                }
                if(valuablecard.getCard().getOwner().equals("Player")){
                    player.increaseActualbid();
                } else if(valuablecard.getCard().getOwner().equals("BotPlayer1")){
                   botPlayer1.increaseActualbid();
                } else if(valuablecard.getCard().getOwner().equals("BotPlayer2")){
                   botPlayer2.increaseActualbid();
                } else if(valuablecard.getCard().getOwner().equals("BotPlayer3")){
                    botPlayer3.increaseActualbid();
                }

            }





        }





    }







}