public class Runner {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.println("START");

        list.addAtHead(2);
        list.deleteAtIndex(1);
        list.addAtHead(2);
        list.addAtHead(7);
        list.addAtHead(3);
        list.addAtHead(2);
        list.addAtHead(5);
        list.addAtTail(5);
        System.out.println(list.get(5));
        list.deleteAtIndex(6);
        list.deleteAtIndex(4);

        System.out.println("END");
    }
}
