# Task 2 Analysis

## 1. What is the exact cause of ConcurrentModificationException in Java?

ConcurrentModificationException occurs when a collection is modified while it is being iterated using an Iterator or enhanced for loop.

## 2. What code pattern at line 142 most likely triggered this error?

Most likely the code was removing elements from a collection during iteration.

Example:

```java
for(Transaction txn : transactions) {
    transactions.remove(txn);
}
```

## 3. Provide the minimal code change that resolves this safely.

Use Iterator.remove() instead of modifying the collection directly.

```java
Iterator<Transaction> itr = transactions.iterator();

while (itr.hasNext()) {
    Transaction txn = itr.next();

    if (txn.isInvalid()) {
        itr.remove();
    }
}
```
