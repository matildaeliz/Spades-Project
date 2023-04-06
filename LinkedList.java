import java.util.Random;

public class LinkedList {
    /**
     * head of linkedlist
     */
    private Node head;

    /**
     * tail of linkedlist
     */
    private Node tail;


    public LinkedList() {
        this.head = null;
        this.tail = null;
    }


    /**
     * insert the node last
     */

    public void insertLast(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
    }

    /**
     * prinst the list
     */
    public void printList() {

        Node tmp = head;
              
        while (tmp != null) {
            System.out.print(tmp.getCard().getECard()+ ", ");
            tmp = tmp.getNext();

        }

    }
public Node getHead(){
        return head;
}

public void setHead(Node node){
        this.head = node;
}

    /**
     * gets previous node
     * @param node
     * @return
     */
    public Node getPrevious(Node node) {
        Node tmp = head;
        Node previous = null;
        while (tmp != node) {
            previous = tmp;
            tmp = tmp.getNext();
        }
        return previous;
    }

    /**
     *delete last node
     */
    public void deleteLast() {
        tail = getPrevious(tail);
        if (tail != null) {
            tail.setNext(null);
        } else {
            head = null;
        }
    }

    /**
     * gets the i ' th  node
     * @param i
     * @return
     */
    public Node getNode(int i) {
        Node tmp = head;
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

    /**
     * returns size of hand;
     *
     */
  public int getSizeofHand(){
        int i = 0;
        Node tmp = head;
        while (tmp != null){
            i++;
            tmp = tmp.getNext();
        }
        return i;
  }

    /**
     * gets first node
     * @return
     */
    public Node getFirst(){
       Node tmp =head;

       head = head.getNext();

        return tmp;
    }


    /**
     * Method takes nodes from the existed cardlinkedlist and puts in the new linkedlist but If the node has adrress, the adress changes.
     * @param newNode
     */
    public void newLinkedListinsert(Node newNode){
        if(tail !=null){
            newNode.setNext(null);
            tail.setNext(newNode);
            tail = newNode;
        } if (head == null) {
            head=newNode;
            head.setNext(null);
        }  if (head != null && tail == null) {
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

    public void shuffle(LinkedList deck){
        Random rand = new Random();
        Node current;
        Node previusofcurrent;
        Node nextofcurrent;
        Node headnext;
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

