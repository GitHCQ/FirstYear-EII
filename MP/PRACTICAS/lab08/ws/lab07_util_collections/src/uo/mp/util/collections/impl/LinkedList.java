package uo.mp.util.collections.impl;

import uo.mp.util.collections.List;

public class LinkedList extends AbstractList {
	Node head;
	private class Node{
		Object element;
		Node next;
			Node(Object element,Node node){
				this.element=element;
				this.next=node;
			}
	}
	public LinkedList() {
		this.numberOfElements=0;
		this.head=null;
	}

	@Override
	public int size() {
		return numberOfElements;
	}
	private void checkIndex(int index) {
		if(index<0 || index>=this.size()) {
			//throw new IndexOutOfBoundsException()
			
		}
		
	}
	private void CheckIlegalArguement() {
		
	}

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
		add(size(),element);
		return true;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean equals(Object o) {
		if(o==null)return false;
		if(o==this)return true;
		if(!(o instanceof List))return false;
		List that=(List)o;
		if(this.size()!=that.size())return false;
		for(int i=0;i<size();i++) {
			Object o1=this.get(i);
			Object o2=that.get(i);
			if(!(o1.equals(o2))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	private Node getNode(int index) {
		checkIndex(index);
		int pos=0;
		Node node=head;
		while(pos<index) {
			node=node.next;
			pos+=1;
		}
		return node;
	}
	@Override
	public Object set(int index, Object element) {
		/*
		 * 1- obtener el nodo anterior para ese indice.Para ello hay que implementar 
		 * tambien el getNode(index)
		 * 2- Crear un nuevo nodo que enlace con el siguiente que habia 
		 * 3- Hacer que el anterior enlace con el nuevo
		 * 
		 * Cuidado!No funciona con la primera posicion ya que no tiene anterior.
		 * habria que modificar la cabeza 
		 */
		checkIndex(index);
		if(index==0) {
			head=new Node(element,head);
		}else {
			Node previus=getNode(index-1);
			previus.next=new Node(element,previus.next);
			
		}
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
