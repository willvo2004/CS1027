public class myTestSplit {

    public static void main(String[] args) {
        Integer[] x = new Integer[]{1,2,3,4,5,6,7};
        UniqueOrderedList<Integer> al = new UniqueOrderedList<Integer>();

        for (int i = 0; i < x.length; i++) {
            al.add(x[i]);
        }
        UniqueOrderedList<Integer> soln = BillSplitter.split(al,12);
        System.out.println(soln);
    }
}
