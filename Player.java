

public class Player {

    CardLinkedList hand;

    public Player() {
        hand = new CardLinkedList();
    }
    public void sharetheCards(CardLinkedList  deck, BotPlayer botPlayer1, BotPlayer botPlayer2, BotPlayer botPlayer3, Player player) {
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
}

