public class KSubsetsRecursiveLoop {
    public static void main(String[] args) {
        new KSubsetsRecursiveLoop();
    }

    KSubsetsRecursiveLoop() {
        //--- Initialize the data we're using.
        set = new String[]{"Anna", "Bob", "Carla"};
        n = set.length;
        k = 2;

        //--- Now let's have some fun!
        buildSubsets(0, 0, "");
        System.out.println();
    }

    int n, k;
    String[] set;

    void buildSubsets(int i, int j, String subset) {
        //--- Is the subset complete?
        // Instead of j, we can use subset.length
        if (j == k) {
            System.out.print(subset + " ");
            return;
        }
        //--- Ok, let's add more.
        for (; i < n; ++i)
            buildSubsets(i + 1, j + 1, subset + set[i].charAt(0));
    }
}
