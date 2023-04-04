
public class Game {
    private final int endgamepoint = 500;




    /**
     * Method starts the game
     */
    public void play() {


        Player player = new Player();
        BotPlayer botPlayer1 = new BotPlayer();
        BotPlayer botPlayer2 = new BotPlayer();
        BotPlayer botPlayer3 = new BotPlayer();


        while(true) {

            LinkedList deck = new LinkedList();
            Card card = new Card();

            System.out.println("botPlayer 1 is sharing the cards...");

            card.createCards(deck);
            deck.shuffle(deck);

            player.sharetheCards(deck, botPlayer1, botPlayer2, botPlayer3, player);

            player.hand.printList();

            player.bidsForEnter();
            botPlayer1.bidsForEnter();
            botPlayer2.bidsForEnter();
            botPlayer3.bidsForEnter();
            boolean flag = false;


            for(int el = 1 ; el <=13; el++){
                Node throwedCard ;
                String cardInTable ="";
                Node valuablecard = null;
                Node initialcard = null;
            for (int tur = 1; tur<=4; tur++){

                    if(tur == 1){
                        System.out.println("");
                        player.hand.printList();
                        throwedCard = player.play(flag,initialcard);

                        cardInTable = throwedCard.getCard().getECard();
                        System.out.println("ThrowedCard :"+cardInTable);
                  if(valuablecard==null){
                 initialcard = throwedCard;

                   }
                       if (throwedCard.getCard().getSuit().equals("Spades")){
                           flag = true;
                       }

                        if(valuablecard == null){
                            valuablecard = throwedCard;
                        }else if(throwedCard.getCard().getValue() > valuablecard.getCard().getValue()){
                            valuablecard = throwedCard;
                        }

                    } else if (tur == 2) {
                        System.out.println("BotPlayer1");


                        throwedCard = botPlayer1.play(flag,initialcard,valuablecard);
                        cardInTable = throwedCard.getCard().getECard();


                        System.out.println("ThrowedCard :"+cardInTable);
                        if(valuablecard == null){
                            valuablecard = throwedCard;
                        }else if(throwedCard.getCard().getValue() > valuablecard.getCard().getValue()){
                            valuablecard = throwedCard;
                        }
                        if (throwedCard.getCard().getSuit().equals("Spades")){
                            flag = true;
                        }
                    }else if (tur == 3){
                        System.out.println("BotPlayer2");
                        throwedCard = botPlayer2.play(flag,initialcard,valuablecard);
                        cardInTable = throwedCard.getCard().getECard();
                        System.out.println("ThrowedCard :"+cardInTable);
                        if(valuablecard == null){
                            valuablecard = throwedCard;
                        }else if(throwedCard.getCard().getValue() > valuablecard.getCard().getValue()){
                            valuablecard = throwedCard;
                        }

                        if (throwedCard.getCard().getSuit().equals("Spades")){
                            flag = true;
                        }
                    } else if (tur == 4) {
                        System.out.println("BotPlayer3");

                        throwedCard = botPlayer3.play(flag,initialcard,valuablecard);
                        cardInTable = throwedCard.getCard().getECard();

                        System.out.println("");
                        System.out.println("ThrowedCard :"+cardInTable);
                        if(valuablecard == null){
                            valuablecard = throwedCard;
                        }else if(throwedCard.getCard().getValue() > valuablecard.getCard().getValue()){
                            valuablecard = throwedCard;
                        }
                        if (throwedCard.getCard().getSuit().equals("Spades")){
                            flag = true;
                        }
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