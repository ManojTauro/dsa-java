import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxHeap {
    private int capacity;
    private int[] heap;
    private int size;

    public MaxHeap(int capacity, int[] heap) {
        this.capacity = capacity;
        this.heap = heap;
        this.size = this.heap.length;

        this.buildHeap();
    }

    // Consider entire array as a complete BT
    // Start from the last element and call heapifyUp
    // O(N)
    private void buildHeap() {
        for (int i = this.size - 1; i >= 0; i--) {
            this.heapifyUp(i);
        }
    }

    private void heapifyUp(int i) {
        int parent = getParent(i);

        if (this.heap[i] > this.heap[parent]) {
            swap(i, parent);
            heapifyUp(parent);
        }
    }

    private void swap(int i, int parent) {
        int temp = this.heap[i];
        this.heap[i] = this.heap[parent];
        this.heap[parent] = temp;
    }

    private int getParent(int i) {
        return Math.abs(i - 1) / 2;
    }

    private int getLeft(int i) {
        return (2 * i) + 1;
    }

    private int getRight(int i) {
        return (2 * i) + 2;
    }

    private List<int[]> getChildren(int i) {
        List<int[]> children = new ArrayList<>();

        int l = getLeft(i);
        int r = getRight(i);

        int[] leftChild = new int[2];

        if (l != 0 && l < this.size) {
            leftChild[0] = this.heap[l];
            leftChild[1] = l;
            children.add(leftChild);
        }

        int[] rightChild = new int[2];
        if (r != 0 && r < this.size) {
            rightChild[0] = this.heap[r];
            rightChild[1] = r;
            children.add(rightChild);
        }

        return children;
    }

    private int[] getLargest(List<int[]> children) {
        if (children.size() == 1) return children.get(0);

        int leftValue = children.get(0)[0];
        int rightValue = children.get(1)[0];

        if (leftValue > rightValue) return children.get(0);
        else return children.get(1);
    }

    private void heapifyDown(int i) {
        List<int[]> children = getChildren(i);

        if (!children.isEmpty()) {
            int[] largest = getLargest(children);

            if (largest[0] > this.heap[i]) {
                swap(i, largest[1]);
                heapifyDown(largest[1]);
            }
        }
    }

    public void insert(int key) throws Exception {
        if (this.size + 1 > this.capacity) throw new Exception("Heap Overflow");

        this.size++;
        this.heap[this.size - 1] = key;

        this.heapifyUp(this.size - 1);
    }

    public int deleteMax() throws Exception {
        int max = this.heap[0];

        if (this.size == 0) throw new Exception("Heap Underflow");

        if (this.size == 1) {
            this.size--;
            return max;
        }

        this.heap[0] = this.heap[this.size - 1];
        this.heap[this.size - 1] = 0; // 0 represents no element
        this.size--;

        this.heapifyDown(0);

        return max;
    }

    public void printHeap() {
        System.out.println(Arrays.toString(this.heap));
    }
}