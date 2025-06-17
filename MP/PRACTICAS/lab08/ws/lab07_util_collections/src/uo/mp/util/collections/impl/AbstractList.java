package uo.mp.util.collections.impl;

import uo.mp.util.collections.List;

public abstract class AbstractList implements List {

	protected int numberOfElements;

	public AbstractList() {
		super();
	}

	public abstract int size();

	@Override
	public boolean isEmpty() {
		return this.size()==0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

}