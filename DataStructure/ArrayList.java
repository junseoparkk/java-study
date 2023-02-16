package DataStructure;
import java.util.Arrays;

import interface_def.List;

public class ArrayList<E> implements List<E>{

	private static final int DEFAULT_CAPACITY = 10;	//기본 용량
	private static final Object[] EMPTY_ARRAY = {};
	
	private int size;	//현재 요소 개수
	
	Object[] array;
	
	public ArrayList(){
		this.array=EMPTY_ARRAY;
		this.size = 0;
	}
	
	public ArrayList(int capacity){
		this.array = new Object[capacity];
		this.size = 0;
	}
	
	// 크기 확장
	private void extendSize() {	
		int array_capacity=array.length;
		
		if(Arrays.equals(array, EMPTY_ARRAY)) {
			array=new Object[DEFAULT_CAPACITY];
			return;
		}
		
		if(size == array_capacity){
			int new_capacity=array_capacity*2;
			
			array = Arrays.copyOf(array, new_capacity);
			return;
		}
	}
	
	@Override
	public boolean add(E e) {
		addLast(e);
		return true;
	}
	
	public void addLast(E e) {
		if(size == array.length)
			extendSize();
		array[size++]=e;
	}

	@Override
	public void add(int index, E element) {
		
		if(index > size || index < 0)	// index 범위 검사
			throw new IndexOutOfBoundsException();
		
		
		if(index == size)	// 마지막에 요소 추가
			addLast(element);
		else {
			if(size == array.length)	// 공간 할당
				extendSize();
			
			for(int i=size;i>index;i--)	// 데이터 한 칸씩 뒤로 밀림
				array[i]=array[i-1];
			
			array[index]=element;
			size++;
		}
	}

	@Override
	public void set(int index, E element) {
		
		if(index > size || index <0)
			throw new IndexOutOfBoundsException();
		else array[index]=element;
	}

	@Override
	public boolean contains(Object o) {
		for(int i=0;i<size;i++) {
			if(array[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		if(index >= size || index < 0)
			throw new IndexOutOfBoundsException();
		
		return (E) array[index];
	}

	@Override
	public boolean isEmpty() {
		if(size == 0) return true;
		else return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		for(int i=0;i<size;i++)
			array[i]=null;
		array=EMPTY_ARRAY;
		size=0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		if(index >= size || index < 0)
			throw new IndexOutOfBoundsException();
		
		E element = (E)array[index];
		array[index]=null;
		
		for(int i=index;i<size-1;i++) { 
			array[i]=array[i+1];
			array[i+1]=null;
		}
		
		size--;
		
		return element; 
	}

	@Override
	public boolean remove(Object o) {
		int idx=-1;
		
		for(int i=0;i<size;i++) {
			if(array[i].equals(o))
				idx=i;
		}
		
		if(idx==-1) return false;
		
		remove(idx);
		return true;
	}
	
	public void show() {
		if(isEmpty())
			System.out.println("List is Empty!");
		else {
			System.out.print("[ ");
			for(int i=0;i<size-1;i++) {
				System.out.print(array[i]+",");
			}
			System.out.println(array[size-1]+" ]");
		}
	}
	
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		
		System.out.println("List is empty : "+list.isEmpty());
		System.out.println("Add 10 : "+list.add(10));
		System.out.println("Add 20 : "+list.add(20));
		System.out.println("Add 30 : "+list.add(30));
		list.show();
		System.out.println("Add 15 in index 2");
		list.add(2,15);
		list.show();
		System.out.println("Get index 3 : "+list.get(3));
		System.out.println("Current Size of List : "+list.size());
		System.out.println("List is empty : "+list.isEmpty());
		System.out.println("Change 30 to 5");
		list.set(3, 5);
		System.out.println("Add 100");
		list.add(100);
		list.show();
		System.out.println("10 is contained : "+list.contains(10));
		System.out.println("10 is remove : "+list.remove((Object)10));
		list.show();
		System.out.println("10 is contained : "+list.contains(10));
		System.out.println("Clear List");
		list.clear();
		list.show();
		System.out.println("List is empty : "+list.isEmpty());
		
	}
}
