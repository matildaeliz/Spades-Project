import java.util.Random;

public class Game {

    /**
     * initial point to end the game
     */
    private final int endgamepoint = 500;




    /**
     * Method starts the game gets players instance and creates a deck and shuffle it. After that players share with their bits. and the game starts
     * Every 13 tour, the dealers changes and If 4 cards throwed the dealer starts first always.
     */
    public void play() {


        Player player = new Player();
        BotPlayer botPlayer1 = new BotPlayer();
        BotPlayer botPlayer2 = new BotPlayer();
        BotPlayer botPlayer3 = new BotPlayer();


        while(true) {
            Random rn = new Random();

           int play=  rn.nextInt(3)+1;

            LinkedList deck = new LinkedList();
            Card card = new Card();



            card.createCards(deck);
            deck.shuffle(deck);

            player.sharetheCards(deck, botPlayer1, botPlayer2, botPlayer3, player);

            player.hand.printList();

            player.bidsForEnter();
            botPlayer1.bidsForEnter();
            botPlayer2.bidsForEnter();
            botPlayer3.bidsForEnter();
            boolean flag = false;
          Random math = new Random();

          int chosen = math.nextInt(3)+1;

                 if (chosen == 1){
                     humanstarts(player,botPlayer1,botPlayer2,botPlayer3,flag);
                 } else if (chosen == 2) {
                     bot2starts(player,botPlayer1,botPlayer2,botPlayer3,flag);
                 } else if (chosen == 3) {
                     bot3starts(player,botPlayer1,botPlayer2,botPlayer3,flag);
                 } else if (chosen == 4 ) {
                     bot1starts(player,botPlayer1,botPlayer2,botPlayer3,flag);
                 }






            System.out.println(player.actualbid +"  "+player.forcestedbid);
            System.out.println(botPlayer1.actualbid+"  "+ botPlayer1.forcestedbid);
            System.out.println(botPlayer2.actualbid+"  "+botPlayer2.forcestedbid);
            System.out.println(botPlayer3.actualbid+"  "+botPlayer3.forcestedbid);


            player.calculatepoint();
            botPlayer1.calculatepoint();
            botPlayer2.calculatepoint();
            botPlayer3.calculatepoint();
            System.out.println("                           Your Point  " + "             botPlayer1 Point      " +   "      BotPlayer2 Point  " + "                      BotPlayer 3 Point  ");
            System.out.println("                               "+player.totalpoint +"           "+       "          " +           botPlayer1.totalpoint+"                           "+ botPlayer2.totalpoint +"                                        "+ botPlayer3.totalpoint);


            if(player.totalpoint>=500 ||botPlayer1.totalpoint>=500||botPlayer2.totalpoint>=500||botPlayer3.totalpoint>=500){
                if (botPlayer1.totalpoint>=500){
                    System.out.println("BotPlayer 1 won the game");
                    break;
                } if (botPlayer2.totalpoint>=500){
                    System.out.println("BotPlayer 2 won the game");
                    break;
                } if (botPlayer3.totalpoint>=500){
                    System.out.println("BotPlayer 3 won the game");
                    break;
                } if (player.totalpoint>=500){
                    System.out.println("You won the game");
                    break;
                }


            }



        }





    }

    /**
     * Human variant for game which is started by Human player
     * when a card throwed the play method runs and throws a card on table
     * @param player
     * @param botPlayer1
     * @param botPlayer2
     * @param botPlayer3
     * @param flag
     */

public void humanstarts(Player player, BotPlayer botPlayer1,BotPlayer botPlayer2,BotPlayer botPlayer3,boolean flag){

    for(int el = 1 ; el <=13; el++){
        Node throwedCard ;
        String cardInTable ="";
        Node valuablecard = null;
        Node initialcard = null;
        for (int tur = 1; tur<=4; tur++){

            if(tur == 1){
                System.out.println("Your turn");
                System.out.println("");
                player.hand.printList();

                throwedCard = player.play(flag,initialcard);

                cardInTable = throwedCard.getCard().getECard();
                System.out.println("ThrowedCard :"+cardInTable);


                if(initialcard==null){
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
                System.out.println("");
                System.out.println("BotPlayer1");
                System.out.println("---------");

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
                System.out.println("");
                System.out.println("BotPlayer2");
                System.out.println("---------");
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
                System.out.println("");
                System.out.println("BotPlayer3");
                System.out.println("---------");
                throwedCard = botPlayer3.play(flag,initialcard,valuablecard);
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

    /**
     * BOT 1 variant for game which is started by BOT1 player
     * when a card throwed the play method runs and throws a card on table
     * @param player
     * @param botPlayer1
     * @param botPlayer2
     * @param botPlayer3
     * @param flag
     */

    public void bot1starts(Player player, BotPlayer botPlayer1,BotPlayer botPlayer2,BotPlayer botPlayer3,boolean flag){

        for(int el = 1 ; el <=13; el++){
            Node throwedCard ;
            String cardInTable ="";
            Node valuablecard = null;
            Node initialcard = null;
            for (int tur = 1; tur<=4; tur++){

                if(tur == 1){
                    System.out.println("");
                    System.out.println("BotPlayer1");
                    System.out.println("---------");

                    throwedCard = botPlayer1.play(flag,initialcard,valuablecard);
                    cardInTable = throwedCard.getCard().getECard();


                    System.out.println("ThrowedCard :"+cardInTable);
                    if(initialcard==null){
                        initialcard = throwedCard;

                    }


                    if(valuablecard == null){
                        valuablecard = throwedCard;
                    }else if(throwedCard.getCard().getValue() > valuablecard.getCard().getValue()){
                        valuablecard = throwedCard;
                    }
                    if (throwedCard.getCard().getSuit().equals("Spades")){
                        flag = true;
                    }

                } else if (tur == 2) {
                    System.out.println("Your turn");
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
                }else if (tur == 3){
                    System.out.println("");
                    System.out.println("BotPlayer2");
                    System.out.println("---------");
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
                    System.out.println("");
                    System.out.println("BotPlayer3");
                    System.out.println("---------");
                    throwedCard = botPlayer3.play(flag,initialcard,valuablecard);
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

    /**
     * BOT2 variant for game which is started by BOT2 player,
     * when a card throwed the play method runs and throws a card on table
     * @param player
     * @param botPlayer1
     * @param botPlayer2
     * @param botPlayer3
     * @param flag
     */

    public void bot2starts(Player player, BotPlayer botPlayer1,BotPlayer botPlayer2,BotPlayer botPlayer3,boolean flag){

        for(int el = 1 ; el <=13; el++){
            Node throwedCard ;
            String cardInTable ="";
            Node valuablecard = null;
            Node initialcard = null;
            for (int tur = 1; tur<=4; tur++){

                if(tur == 1){
                    System.out.println("");
                    System.out.println("BotPlayer2");
                    System.out.println("---------");
                    throwedCard = botPlayer2.play(flag,initialcard,valuablecard);
                    cardInTable = throwedCard.getCard().getECard();
                    System.out.println("ThrowedCard :"+cardInTable);
                    if(initialcard==null){
                        initialcard = throwedCard;

                    }


                    if(valuablecard == null){
                        valuablecard = throwedCard;
                    }else if(throwedCard.getCard().getValue() > valuablecard.getCard().getValue()){
                        valuablecard = throwedCard;
                    }

                    if (throwedCard.getCard().getSuit().equals("Spades")){
                        flag = true;
                    }

                } else if (tur == 2) {
                    System.out.println("");
                    System.out.println("BotPlayer3");
                    System.out.println("---------");
                    throwedCard = botPlayer3.play(flag,initialcard,valuablecard);
                    cardInTable = throwedCard.getCard().getECard();

                    System.out.println("ThrowedCard :"+cardInTable);
                     if(throwedCard.getCard().getValue() > valuablecard.getCard().getValue()){
                        valuablecard = throwedCard;
                    }
                    if (throwedCard.getCard().getSuit().equals("Spades")){
                        flag = true;
                    }
                }else if (tur == 3){
                    System.out.println("");
                    System.out.println("BotPlayer1");
                    System.out.println("---------");

                    throwedCard = botPlayer1.play(flag,initialcard,valuablecard);
                    cardInTable = throwedCard.getCard().getECard();


                    System.out.println("ThrowedCard :"+cardInTable);
                     if(throwedCard.getCard().getValue() > valuablecard.getCard().getValue()){
                        valuablecard = throwedCard;
                    }
                    if (throwedCard.getCard().getSuit().equals("Spades")){
                        flag = true;
                    }
                } else if (tur == 4) {
                    System.out.println("Your turn");
                    System.out.println("");
                    player.hand.printList();

                    throwedCard = player.play(flag,initialcard);

                    cardInTable = throwedCard.getCard().getECard();
                    System.out.println("ThrowedCard :"+cardInTable);

                    if (throwedCard.getCard().getSuit().equals("Spades")){
                        flag = true;
                    }

                    if(throwedCard.getCard().getValue() > valuablecard.getCard().getValue()){
                        valuablecard = throwedCard;
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
    /**
     * BOT3 variant for game which is started by BOT3 player, when a card throwed the play method runs and throws a card on table
     * @param player
     * @param botPlayer1
     * @param botPlayer2
     * @param botPlayer3
     * @param flag
     */

    public void bot3starts(Player player, BotPlayer botPlayer1,BotPlayer botPlayer2,BotPlayer botPlayer3,boolean flag){

        for(int el = 1 ; el <=13; el++){
            Node throwedCard ;
            String cardInTable ="";
            Node valuablecard = null;
            Node initialcard = null;
            for (int tur = 1; tur<=4; tur++){

                if(tur == 1){
                    System.out.println("");
                    System.out.println("BotPlayer3");
                    System.out.println("---------");
                    throwedCard = botPlayer3.play(flag,initialcard,valuablecard);
                    cardInTable = throwedCard.getCard().getECard();

                    System.out.println("ThrowedCard :"+cardInTable);

                    if(initialcard==null){
                        initialcard = throwedCard;

                    }
                    if(valuablecard == null){
                        valuablecard = throwedCard;
                    }else if(throwedCard.getCard().getValue() > valuablecard.getCard().getValue()){
                        valuablecard = throwedCard;
                    }
                    if (throwedCard.getCard().getSuit().equals("Spades")){
                        flag = true;
                    }

                } else if (tur == 2) {
                    System.out.println("");
                    System.out.println("BotPlayer2");
                    System.out.println("---------");
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
                }else if (tur == 3){
                    System.out.println("");
                    System.out.println("BotPlayer1");
                    System.out.println("---------");

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
                } else if (tur == 4) {
                    System.out.println("Your turn");
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