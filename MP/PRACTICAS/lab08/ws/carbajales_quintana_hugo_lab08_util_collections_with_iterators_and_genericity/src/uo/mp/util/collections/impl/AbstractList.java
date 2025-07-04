package uo.mp.util.collections.impl;

import uo.mp.util.collections.List;

public abstract class AbstractList<T> implements List<T> {

    protected int numberOfElements;

    public AbstractList() {
        super();
        numberOfElements = 0;
    }

    public abstract int size();

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            if (o.equals(get(i))) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean add(T element) {
        if (element != null) {
            numberOfElements++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size(); i++) {
                if (get(i) == null) {
                    remove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size(); i++) {
                if (o.equals(get(i))) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public abstract T get(int index);

    public abstract T remove(int index);
}
