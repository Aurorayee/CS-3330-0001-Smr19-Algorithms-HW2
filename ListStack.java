package hw2;


public class ListStack<T> implements Stack<T> {
    private List<T> root;
    private int size=0;

    public ListStack() {
	// TODO: implement
    }
    public void push(T v) {
	// TODO: implement
        List<T> a=new List<>();
        a.insert(v);
        if (size==0){
            root=a;
            size++;
        }
        else{
            root.insert(v);
            size++;
        }
    }
    public T pop() {
        // TODO: implement
        if (size == 0) {
            return null;
        } else {
            size--;
            return root.popFront();
        }
    }
    public boolean isEmpty() {
	// TODO: implement
	return size==0;
    }
    public int size() {
	// TODO: implement
	return size;
    }
}
