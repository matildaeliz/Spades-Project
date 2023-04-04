
import java.util.Random;


public class BotPlayer extends Player {

    public BotPlayer() {

        super();
    }



        public void bidsForEnter () {
            Random rand = new Random();

            forcestedbid = rand.nextInt(7);
        }



        public Node play(boolean breaking,Node initialcard, Node valuablecard) {


            int calculatininitialcards = calculateInitialcard(initialcard);
            Node playedcard ;
            boolean flag =false;
             if(breaking == true) {
                 if(valuablecard == null){
                     Random rnd = new Random();
                     int  random = rnd.nextInt(hand.getSizeofHand())+1;
                     playedcard =hand.getNode(random);
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

                 else if (calculateInitialcard(initialcard)>0 ){
                      for(int i =1; i<=this.hand.getSizeofHand(); i++){
                          if((hand.getNode(i).getCard().getValue()> valuablecard.getCard().getValue() && hand.getNode(i).getCard().getSuit().equals(initialcard.getCard().getSuit())) || hand.getNode(i).getCard().getSuit().equals("Spades")){
                              flag =true;
                          }
                      }if(flag == true){
                          for(int i =1; i<=this.hand.getSizeofHand(); i++){
                              if((hand.getNode(i).getCard().getValue()> valuablecard.getCard().getValue() && hand.getNode(i).getCard().getSuit().equals(initialcard.getCard().getSuit())) || hand.getNode(i).getCard().getSuit().equals("Spades")){
                                  playedcard =hand.getNode(i);
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
                      }else {
                          for(int i =1; i<=this.hand.getSizeofHand(); i++){
                              if (hand.getNode(i).getCard().getSuit().equals(initialcard.getCard().getSuit()) || hand.getNode(i).getCard().getSuit().equals("Spades")){
                                  playedcard =hand.getNode(i);
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






                  }
                  else if (calculateInitialcard(initialcard)==0) {
                      Random rnd = new Random();
                      int  random = rnd.nextInt(hand.getSizeofHand())+1;


                      playedcard = hand.getNode(random);
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
          else if(!breaking){

                 if(valuablecard == null){

                         for(int i =1; i<=hand.getSizeofHand(); i++){
                             if(hand.getNode(i).getCard().getSuit().equals("Spades")){

                             }else{
                                 playedcard = hand.getNode(i);
                                 if (playedcard == hand.getHead()) {
                                     hand.setHead(playedcard.getNext());
                                     playedcard.setNext(null);
                                     return playedcard;
                                 } else {
                                     Node previous = hand.getPrevious(playedcard);
                                     Node currentnext = playedcard.getNext();
                                     previous.setNext(currentnext);
                                     playedcard.setNext(null);

                                     return playedcard;
                                 }
                             }


                     }

                 }
               else if(calculatininitialcards>0){
                   //checks if there are any initialbid and highervalue
                   for(int i =1; i<=this.hand.getSizeofHand(); i++){
                       if(hand.getNode(i).getCard().getValue() >= valuablecard.getCard().getValue() && hand.getNode(i).getCard().getSuit().equals(initialcard.getCard().getSuit())){
                          flag =true;
                       }
                   }
                   if(flag==true){
                       for(int i =1; i<=this.hand.getSizeofHand(); i++){
                           if (hand.getNode(i).getCard().getValue() >= valuablecard.getCard().getValue() && hand.getNode(i).getCard().getSuit().equals(initialcard.getCard().getSuit())){
                                     playedcard =hand.getNode(i);
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
                   } else {
                       for(int i =1; i<=this.hand.getSizeofHand(); i++){
                           if (hand.getNode(i).getCard().getSuit().equals(initialcard.getCard().getSuit())){
                               playedcard =hand.getNode(i);
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

               } else if (calculateInitialcard(initialcard)==0) {
                            Random rnd = new Random();
                           int  random = rnd.nextInt(hand.getSizeofHand()-1)+1;


                              playedcard = hand.getNode(random);
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


return  null;


        }






public boolean existValuebleCard(Node valuablecard){
        boolean flag = false;
        for(int i =1; i<=this.hand.getSizeofHand(); i++){
            if(this.hand.getNode(i).getCard().getValue() > valuablecard.getCard().getValue()){
                return true;
            }
        }

        return flag;
}


    }


