

public class Player {
    /**
     * Attribute hold the 13 Card
     */
    CardLinkedList hand;

    /**
     * The constructer assings the hand
     */
    public Player() {
        hand = new CardLinkedList();
    }


    /**
     * Share the cards which are included in CardLinkedlist Equally
     * @param deck
     * @param botPlayer1
     * @param botPlayer2
     * @param botPlayer3
     * @param player
     */
    public void sharetheCards(CardLinkedList deck, BotPlayer botPlayer1, BotPlayer botPlayer2, BotPlayer botPlayer3, Player player) {
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