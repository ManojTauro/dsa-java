public class Runner {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.println("START");

        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1,2);
        list.deleteAtIndex(1);

        System.out.println("END");
    }
}
