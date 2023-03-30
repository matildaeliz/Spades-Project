import java.util.Random;

public class LinkedList {


    private Node head;
    private Node tail;


    public LinkedList() {
        this.head = null;
        this.tail = tail;
    }

    public void insertLast(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
    }

    public void printList() {

        Node tmp = head;

        while (tmp != null) {
            System.out.print(tmp.getCard().getECard()+ " ");
            tmp = tmp.getNext();
        }

    }


    public Node getPrevious(Node node) {
        Node tmp = head;
        Node previous = null;
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


    public Node getFirst(){
       Node tmp =head;

       head = head.getNext();

        return tmp;
    }

    public void newLinkedListinsert(Node newNode){
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

