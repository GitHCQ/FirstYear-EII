package uo.mp.util.collections.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> extends AbstractList<T>{
    T[] elements;
    private static final int DEFAULT_CAPACITY = 20;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        super();
        numberOfElements = 0;
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size(); i++) {
            elements[i] = null;
        }
        numberOfElements = 0;
    }


    @Override
    public T get(int index) {
        checkIndex(index);
        return elements[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

	@Override
    public T set(int index, T element) {
        checkIndex(index);
        T oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

	@Override
	public void add(int index, T element) {
	    if (index < 0 || index > size()) {
	        throw new IndexOutOfBoundsException("Index out of bounds: " + index);
	    }
	    if (element == null) {
	        throw new IllegalArgumentException("Cannot add null elements to the list");
	    }
	    if (size() == elements.length) {
	        resize();
	    }
	    for (int i = size(); i > index; i--) {
	        elements[i] = elements[i - 1];
	    }
	    elements[index] = element;
	    numberOfElements++;
	}

	@Override
    public T remove(int index) {
        T removedElement = elements[index];
        for (int i = index; i < size() - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size() - 1] = null; // Remove reference to the last element
        numberOfElements--;
        return removedElement;
    }


    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size(); i++) {
            if (o == null && elements[i] == null) {
                return i;
            }
            if (o != null && o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size(); i++) {
            sb.append(elements[i]);
            if (i < size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size(); i++) {
                if (elements[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size(); i++) {
                if (o.equals(elements[i])) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public int size() {
        return numberOfElements;
    }

    public class ArrayListIterator implements Iterator<T> {
        int index;
        int lastReturnedIndex;
        T lastReturned;

        private ArrayListIterator() {
            index = 0;
            lastReturnedIndex = -1;
            lastReturned = null;
        }

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay elemento siguiente");
            }
            lastReturned = elements[index];
            lastReturnedIndex = index;
            index++;
            return lastReturned;
        }

        @Override
        public void remove() {
            if (lastReturnedIndex == -1) {
                throw new IllegalStateException("No se puede eliminar el elemento actual");
            }
            ArrayList.this.remove(lastReturnedIndex);
            index = lastReturnedIndex; // Actualizamos el índice después de eliminar el elemento
            lastReturnedIndex = -1;
            lastReturned = null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }
 // Método auxiliar para redimensionar el arreglo si es necesario
    @SuppressWarnings("unchecked")
	private void resize() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = (T[]) newElements;
    }
 
}

