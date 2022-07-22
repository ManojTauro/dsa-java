public class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {}

    public int get(int index) {
        int counter = 0;
        Node temp = head;

        while(counter != index) {
            temp = temp.getNext();
            counter++;
        }

        return temp.getValue();
    }

    public void addAtHead(int val) {
        System.out.println();
        Node newNode = getNode(val);

        if(head == null)
            head = newNode;

        newNode.setNext(head);
        head = newNode;

    }

    public void addAtTail(int val) {
        Node temp = head;

        while(temp.getNext() != null) {
            temp = temp.getNext()();
        }

        temp.setNext(getNode(val));
    }

    public void addAtIndex(int index, int val) {
        int counter = 0;
        Node newNode = getNode(val);
        Node temp = head;
        Node prev = null;

        while(counter != index && temp.getNext() != null) {
            prev = temp;
            temp = temp.getNext();
            counter++;
        }

        prev.setNext(newNode);
        newNode.setNext(temp);
    }

    public void deleteAtIndex(int index) {
        int counter = 0;
        Node temp = head;
        Node prev = null;

        while(counter != index && temp.getNext() != null) {
            prev = temp;
            temp = temp.getNext();
            counter++;
        }

        prev.setNext(temp.getNext());
    }

    private Node getNode(int val) {
        return new Node(val);
    }
}
