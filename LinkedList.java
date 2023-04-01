import org.w3c.dom.Node;

import java.util.Random;

public class CardLinkedList {


    private CardNode head;
    private CardNode tail;


    public CardLinkedList() {
        this.head = null;
        this.tail = tail;
    }

    public void insertLast(CardNode newNode) {
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
    }

    public void printList() {

        CardNode tmp = head;

        while (tmp != null) {
            System.out.print(tmp.getCard().getECard()+ " ");
            tmp = tmp.getNext();
        }

    }
public CardNode getHead(){
        return head;
}

public void setHead(CardNode node){
        this.head = node;
}

    public CardNode getPrevious(CardNode node) {
        CardNode tmp = head;
        CardNode previous = null;
        while (tmp != node) {
            previous = tmp;
            tmp = tmp.getNext();
        }
        return previous;
    }

    public void deleteLast() {
        tail = getPrevious(tail);
        if (tail != null) {
            tail.setNext(null);
        } else {
            head = null;
        }
    }

    public CardNode getNode(int i) {
        CardNode tmp = head;
        int index = 1;
        while (tmp != null) {
            if (index == i){
                return tmp;
            }
            index++;
            tmp = tmp.getNext();
        }
        return null;
    }
  public int getSizeofHand(){
        int i = 0;
        CardNode tmp = head;
        while (tmp != null){
            i++;
            tmp = tmp.getNext();
        }
        return i;
  }

    public CardNode getFirst(){
       CardNode tmp =head;

       head = head.getNext();

        return tmp;
    }


    /**
     * Method takes nodes from the existed cardlinkedlist and puts in the new linkedlist but If the node has adrress, the adress changes.
     * @param newNode
     */
    public void newLinkedListinsert(CardNode newNode){
        if(tail !=null){
            newNode.setNext(null);
            tail.setNext(newNode);
            tail = newNode;
        } else if (head == null) {
            head=newNode;
            head.setNext(null);
        } else if (head != null && tail == null) {
            newNode.setNext(null);
            head.setNext(newNode);
            tail= newNode;
        }



    }

    /**
     * Method takaes the current node with mathRandom method and puts in the head of the cardlinkedlist
     *
     * @param deck
     */

    public void shuffle(CardLinkedList deck){
        Random rand = new Random();
        CardNode current;
        CardNode previusofcurrent;
        CardNode nextofcurrent;
        CardNode headnext;
        int i=0;
while (i<143) {
    int randomNum = rand.nextInt(50) + 2;
    current = getNode(randomNum);
    previusofcurrent = getPrevious(current);
    nextofcurrent = current.getNext();
    headnext = head.getNext();

    previusofcurrent.setNext(nextofcurrent);
    current.setNext(head);
    head = current;



i++;
}



    }


}

