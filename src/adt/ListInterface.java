package adt;

/**
 * ListInterface.java An interface for the ADT list. Entries in the list have
 * positions that begin with 1.
 *
 * @author Cheah Pin Chee
 * @version 1.0
 */

public interface ListInterface<T> {
    boolean add(T newItem);

    boolean add(int position, T newItem);

    boolean replace(int position, T newItem);

    T remove(int position);

    void removeItem(T item);

    void clear();

    T getItemOf(int position);

    int getPositionOf(T item);

    boolean contains(T item);

    int getNumberOfEntries();

    boolean isEmpty();

    boolean isFull();

}
