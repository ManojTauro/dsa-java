public class SubsetsLexicographic {
    public static void main(String[] args) {
        new SubsetsLexicographic();
    }

    SubsetsLexicographic() {
        //--- Initialize the data we're using.
        set = new String[]{"Anna", "Bob", "Carla", "Dennis"};
        n = set.length;

        //--- Now let's have some fun!
        foo(0, "");
    }

    String[] set;
    int n;

    void foo(int i, String subset) {
        System.out.println('"' + subset + '"');
        for (; i < n; ++i)
            foo(i + 1, subset + set[i].charAt(0));
    }
}
