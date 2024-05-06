public class Runner {
    public static void main(String[] args) throws Exception {
        int[] input1 = {10, 8, 5, 15, 6};

        MaxHeap maxHeap = new MaxHeap(5, input1);
        maxHeap.printHeap();

        System.out.println(maxHeap.deleteMax());
        maxHeap.printHeap();

        System.out.println(maxHeap.deleteMax());
        maxHeap.printHeap();

        maxHeap.insert(1);
        maxHeap.printHeap();

        maxHeap.insert(4);
        maxHeap.printHeap();

        System.out.println(maxHeap.deleteMax());
        maxHeap.printHeap();
        
        maxHeap.insert(15);
        maxHeap.printHeap();
    }
}
