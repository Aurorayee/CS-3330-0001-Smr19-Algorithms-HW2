package hw2;

import java.lang.StringBuilder;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class List<T> {
    private ListNode<T> root;
    private ListNode<T> tail;
    private int size;

    public List() {
		root = null;
		tail = null;
		size = 0;
    }

    public T find(Predicate<T> pred) {
	if (root == null) return null;
	ListNode<T> runner = root;
	while (runner != null) {
	    if (pred.test(runner.value())) {
		return runner.value();
	    }
	    runner = runner.next();
	}
	return null;
    }

    public void insert(T v) {
    	ListNode<T> a=new ListNode<>(v);
        // TODO: implement
		if (isEmpty()){
			root=a;
			tail=a;
			size++;
		}
		else {
			a.setNext(root);
			root.setPrev(a);
			root = root.prev();
			size++;
		}

    }

    public void append(T v) {
	// TODO: implement
		ListNode<T>a=new ListNode<>(v);
		if (isEmpty()){
			root=a;
			tail=a;
			size++;
		}
		else {
			a.setPrev(tail);
			tail.setNext(a);
			tail = tail.next();

			size++;
		}
    }
    
    public void delete(T v) {
	// TODO: implement
		ListNode<T>front=new ListNode<>(v);
		ListNode<T> a= root.next();
		if (size==0){
			return;
		}
		else if(root.value().equals(v)){
			popFront();
			return;
		}
		else if (size==2 && a.value().equals(v)){
			popBack();
			return ;
		}
		while (a!=null){
			if(a.value().equals(tail)){
				popBack();
				return;
			}
			else if(a.next()!=null && a.value().equals(v)){
				a.prev().setNext(a.next());
				a.next().setPrev(a.prev());
				size--;
				return ;
			}
			a=a.next();
		}


    }

    public T popFront() throws IllegalStateException {
	// TODO: implement
		T a=root.value();
		if(isEmpty()){
			return null;
		}
		if(size==1){
			root=null;
			tail=null;
			size--;
			return a;
		}
		else{
			root.setNext(root.next());
			root=root.next();
			root.setPrev(null);
			size--;
		}

	return a;
    }

    public T popBack() throws IllegalStateException {
	// TODO: implement
		T a= tail.value();
		if (isEmpty()){
			return null;
		}
		if(size==1){
			tail=null;
			root=null;
			size--;
			return a;
		}
		else{
			tail.setPrev(tail.prev());
			tail.setNext(null);
			tail=tail.prev();
			size--;
		}
	return  a;
    }

    public int size() {
	// TODO: implement
	return size;
    }
    public boolean isEmpty() {
	// TODO: implement
	return size==0;
    }

    public void forEach(Consumer<T> consumer) {
	var runner = root;
	while (runner != null) {
	    consumer.accept(runner.value());
	    runner = runner.next();
	}
    }

    @Override
    public String toString() {
	class StrConsumer implements Consumer<T> {
	    StringBuilder builder;

	    StrConsumer() {
		builder = new StringBuilder("[ ");
	    }

	    
	    public void accept(T t) {
		builder.append(t);
		builder.append(" ");
	    }

	    public String str() {
		builder.append("]");
		return builder.toString();
	    }
	}

	var strConsumer = new StrConsumer();
	forEach(strConsumer);
	return strConsumer.str();
    }
}
