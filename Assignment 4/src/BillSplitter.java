/**
 * This class implements a recursive algorithm for splitting a UniqueOrderedList of integers into
 * a subsequence whose elements sum up to a target value.
 */
public class BillSplitter {

    /**
     * This method will call the next recursive method.
     * @param in the list containing the price and number of items purchased
     * @param target the dollar amount that the elements in the returned list must add up to
     * @return a UniqueOrderedList object whose elements sum up to the value of target
     */
    public static UniqueOrderedList<Integer> split(UniqueOrderedList<Integer> in, int target) {
        return yourSplit(in.iterator(), target);
    }

    /**
     * Uses a recursive algorithm to find a subsequence of the iterator elements that sums up to the target value.
     * @param it the iterator that to represent the elements that are in the unique ordered list
     * @param target the dollar amount that the elements in the returned list must add up to
     * @return a UniqueOrderedList object whose elements sum up to the value of target
     */
    private static UniqueOrderedList<Integer> yourSplit(CopyableIterator<Integer> it, int target) {
        // Base case: if iterator has no more elements
        if (!it.hasNext()) {
            // If the target is 0, an empty list is a valid solution; otherwise, no solution is possible.
            if (target == 0) {
                return new UniqueOrderedList<>();
            } else {
                return null;
            }
            // Recursive case: if our iterator has unvisited nodes
        } else {
            Integer curr = it.next();
            if (curr <= target) { // if curr is equal to or less than the target
                UniqueOrderedList<Integer> sol = yourSplit(it.copy(), target - curr);

                // if sol is a possible solution (if sol is not null), then add curr to the list
                if (sol != null) {
                    sol.add(curr);
                    return sol;
                }
            }
            UniqueOrderedList<Integer> sol = yourSplit(it.copy(), target);
            return sol;
        }
    }
}
