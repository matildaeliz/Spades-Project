public class Game
{

    /**
     * Method starts the game
     */
    public void play(){
        Card card = new Card();
        CardLinkedList deck = new CardLinkedList();
        card.createCards(deck);
        deck.shuffle(deck);
        Player player = new Player();
        BotPlayer botPlayer1 = new BotPlayer();
        BotPlayer botPlayer2 = new BotPlayer();
        BotPlayer botPlayer3 = new BotPlayer();
        player.sharetheCards(deck,botPlayer1,botPlayer2,botPlayer3,player);





    }


}
