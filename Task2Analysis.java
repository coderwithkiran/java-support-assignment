public class Task2Analysis {

    /*
     * 1. ConcurrentModificationException occurs when a collection
     * is modified while it is being iterated.
     *
     * 2. Most likely caused by removing elements from an ArrayList
     * inside a for-each loop.
     *
     * Example:
     *
     * for(Transaction t : transactions){
     *     transactions.remove(t);
     * }
     *
     * 3. Minimal Fix:
     *
     * Iterator<Transaction> itr = transactions.iterator();
     *
     * while(itr.hasNext()){
     *     Transaction txn = itr.next();
     *     if(txn.isInvalid()){
     *         itr.remove();
     *     }
     * }
     */
}
