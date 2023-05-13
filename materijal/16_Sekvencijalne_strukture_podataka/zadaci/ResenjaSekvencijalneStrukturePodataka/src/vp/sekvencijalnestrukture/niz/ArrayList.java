package vp.sekvencijalnestrukture.niz;

import java.util.Arrays;

public class ArrayList<E> {
	private Object[] elementData;

	private int size;

	public ArrayList() {
		this.elementData = new Object[10];
	}

	private void grow(int minCapacity) {
		int oldCapacity = elementData.length;
		int newCapacity = oldCapacity + (oldCapacity / 2);
		if (newCapacity - minCapacity < 0)
			newCapacity = minCapacity;
		elementData = Arrays.copyOf(elementData, newCapacity);
	}

	private void ensureCapacityInternal(int minCapacity) {
		if (minCapacity - elementData.length > 0)
			grow(minCapacity);
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++)
				if (elementData[i] == null)
					return i;
		} else {
			for (int i = 0; i < size; i++)
				if (o.equals(elementData[i]))
					return i;
		}
		return -1;
	}

	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	E elementData(int index) {
		return (E) elementData[index];
	}

	public E get(int index) {
		return elementData(index);
	}

	public E set(int index, E element) {
		E oldValue = elementData(index);
		elementData[index] = element;
		return oldValue;
	}

	public boolean add(E e) {
		ensureCapacityInternal(size + 1);
		elementData[size++] = e;
		return true;
	}

	public void add(int index, E element) {
		ensureCapacityInternal(size + 1);
		System.arraycopy(elementData, index, elementData, index + 1, size
				- index);
		elementData[index] = element;
		size++;
	}

	public E remove(int index) {
		E oldValue = elementData(index);
		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(elementData, index + 1, elementData, index,
					numMoved);
		elementData[--size] = null;
		return oldValue;
	}

	public boolean remove(Object o) {
		if (o == null) {
			for (int index = 0; index < size; index++)
				if (elementData[index] == null) {
					remove(index);
					return true;
				}
		} else {
			for (int index = 0; index < size; index++)
				if (o.equals(elementData[index])) {
					remove(index);
					return true;
				}
		}
		return false;
	}

	public void clear() {
		for (int i = 0; i < size; i++)
			elementData[i] = null;
		size = 0;
	}
}
