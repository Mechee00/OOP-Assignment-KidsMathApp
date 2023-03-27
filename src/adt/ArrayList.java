package adt;

/**
 * ArrayList.java is an implementation of List interface
 *
 * @author Cheah Pin Chee
 * @version 1.0
 */

public class ArrayList<T> implements ListInterface<T> {

	private T[] array;
	private int numberOfEntries;
	private static final int INITIAL_CAPACITY = 5;

	public ArrayList() {
		this(INITIAL_CAPACITY);
	}

	public ArrayList(int initialCapacity) {
		numberOfEntries = 0;
		array = (T[]) new Object[initialCapacity];
	}

	@Override
	public boolean add(T newItem) {
		if (isFull()) {
			doubleArray();
		}

		array[numberOfEntries] = newItem;
		numberOfEntries++;
		return true;
	}

	@Override
	public boolean add(int position, T newItem) {
		boolean isSuccessful = true;

		if ((position >= 1) && (position <= numberOfEntries + 1)) {
			if (isFull()) {
				doubleArray();
			}
			makeRoom(position);
			array[position - 1] = newItem;
			numberOfEntries++;
		} else {
			isSuccessful = false;
		}

		return isSuccessful;
	}

	@Override
	public void clear() {
		numberOfEntries = 0;
	}

	@Override
	public boolean contains(T item) {
		if (!isEmpty()) {
			return getPositionOf(item) != -1;
		}
		return false;
	}

	@Override
	public T getItemOf(int position) {
		T result = null;
		if ((position >= 1) && (position <= numberOfEntries)) {
			result = array[position - 1];
		}
		return result;
	}

	@Override
	public int getNumberOfEntries() {
		return numberOfEntries;
	}

	@Override
	public int getPositionOf(T item) {
		for (int position = 0; (position < numberOfEntries); position++) {
			if (item.equals(array[position])) {
				return position + 1;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	@Override
	public boolean isFull() {
		return numberOfEntries == array.length;
	}

	@Override
	public T remove(int position) {
		T result = null;

		if ((position >= 1) && (position <= numberOfEntries)) {
			result = array[position - 1];
			if (position < numberOfEntries) {
				removeGap(position);
			}
			numberOfEntries--;
		}
		return result;
	}

	@Override
	public void removeItem(T item) {
		int position = getPositionOf(item);
		if (position != -1) {
			removeGap(position);
			numberOfEntries--;
		}
	}

	@Override
	public boolean replace(int position, T newItem) {
		boolean isSuccessful = true;

		if ((position >= 1) && (position <= numberOfEntries)) {
			array[position - 1] = newItem;
		} else {
			isSuccessful = false;
		}

		return isSuccessful;
	}

	private void doubleArray() {
		T[] oldArr = array;
		array = (T[]) new Object[array.length * 2];
		for (int i = 0; i < numberOfEntries; i++) {
			array[i] = oldArr[i];
		}
	}

	private void makeRoom(int newPosition) {
		int newIndex = newPosition - 1;
		int lastIndex = numberOfEntries - 1;
		for (int index = lastIndex; index >= newIndex; index--) {
			array[index + 1] = array[index];
		}
	}

	private void removeGap(int position) {
		int removedIndex = position - 1;
		int lastIndex = numberOfEntries - 1;

		for (int index = removedIndex; index < lastIndex; index++) {
			array[index] = array[index + 1];
		}
	}

	@Override
	public String toString() {
		String outputStr = "";
		for (int index = 0; index < numberOfEntries; ++index) {
			outputStr += array[index] + "\n";
		}

		return outputStr;
	}

}