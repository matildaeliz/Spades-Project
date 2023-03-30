public class BidLinkedList {


    private BidNode head;
    private BidNode tail;


    public BidLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void insertLast(BidNode newNode) {
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
    }

    public BidNode getFirst(){
       BidNode tmp =head;

        head = head.getNext();

        return tmp;
    }
    public void printList() {

        BidNode tmp = head;

        while (tmp != null) {
            System.out.print(tmp.getData()+ " ");
            tmp = tmp.getNext();
        }

    }


}
