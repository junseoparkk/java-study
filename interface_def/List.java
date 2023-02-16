/*
 * Plan : List - ArrayList, Vector, LinkedList
 * 
 * @author Junseo Park
 * @param <E> the type of elements in the list
 * 
 */

 package interface_def;

 public interface List<E>{
   
   // 객체 추가
   
   boolean add(E e);
   
   void add(int index, E element);
   
   void set(int index,E element);
   
   
   // 객체 검색
   
   boolean contains(Object o);
   
   E get(int index);
   
   boolean isEmpty();
   
   int size();
   
   
   // 객체 삭제
   
   void clear();
   
   E remove(int index);
   
   boolean remove(Object o);
 
   
   // 조회
   
   void show();
 }
 