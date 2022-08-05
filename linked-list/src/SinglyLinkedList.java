public class SinglyLinkedList {
    private Node head = null;
    private int length = 0;

    public SinglyLinkedList() {}

    public int get(int index) {
        if(index < 0 || index >= this.length) return -1;
        else {
            int counter = 0;
            Node temp = head;

            while(counter != index) {
                temp = temp.getNext();
                counter++;
            }

            return temp.getValue();
        }
    }

    public void addAtHead(int val) {
        Node newNode = getNode(val);

        newNode.setNext(head);

        head = newNode;
        this.length++;
//        printList();
    }

    public void addAtTail(int val) {
        if(this.length == 0) {
            addAtHead(val);
            return;
        }
        Node newNode = getNode(val);
        Node temp = head;

        while(temp.getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(newNode);
        this.length++;
//        printList();
    }

    public void addAtIndex(int index, int val) {
        if(index == 0) {
            addAtHead(val);
            return;
        }

        if(index == this.length) {
            addAtTail(val);
            return;
        }

        if(index > this.length) return;

        int counter = 0;
        Node temp = head;
        Node newNode = getNode(val);

        while (counter != (index-1)) {
            temp = temp.getNext();
            counter++;
        }

        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        this.length++;

//        printList();
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= this.length) return;

        Node temp = head;

        if(index == 0) {
            head = temp.getNext();
        } else {
            Node prev = null;
            int counter = 0;

            while(counter != index) {
                prev = temp;
                temp = temp.getNext();
                counter++;
            }

            prev.setNext(temp.getNext());
            }

        this.length--;
//        printList();
    }

    private Node getNode(int val) {
        return new Node(val);
    }

    public void printList() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.getValue()+"->");
            temp = temp.getNext();
        }
        System.out.println();
    }
}
