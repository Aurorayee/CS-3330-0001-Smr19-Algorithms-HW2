package hw2;

import java.util.function.Predicate;
import org.junit.Test;
import static org.junit.Assert.*;

public class ListTest {
    @Test
    public void testIsEmpty() {
	List<Integer> l = new List();
	assertTrue(l.isEmpty());
    }

    @Test
    public void testSize() {
	List<Integer> l = new List();
	assertTrue(l.size() == 0);
	for (int i = 0; i < 10; i++) {
	    l.insert(i);
	    assertTrue(l.size() == i+1);
	}
    }

    @Test
    public void testFind() {
	List<Integer> l = new List();
	assertTrue(l.isEmpty());
	for (int i = 0; i < 10; i++) {
	    l.insert(i);
	}
	assertTrue(l.size() == 10);

	for (int i = 0; i < 15; i++) {
	    final int k = i;
	    Integer found = l.find(new Predicate() {
		    @Override
		    public boolean test(Object v) {
			if (v instanceof Comparable) {
			    return ((Comparable) v).compareTo(k) == 0;
			}
			return false;
		    }
		});
	    if (i < 10) {
		assertTrue(found == i);
	    } else {
		assertTrue(found == null);
	    }
	}
	
    }

    @Test
    public void testInsert() {
	List<Integer> l = new List();
	assertTrue(l.isEmpty());
	for (int i = 0; i < 10; i++) {
	    l.insert(i);
	}
	for (int i = 9; i >= 0; i--) {
	    assertTrue(l.popFront() == i);
	}
    }

    @Test
    public void testAppend() {
	List<Integer> l = new List();
	assertTrue(l.isEmpty());
	for (int i = 0; i < 10; i++) {
	    l.append(i);
	}
	for (int i = 0; i < 10; i++) {
	    assertTrue(l.popFront() == i);
	}
	assertTrue(l.isEmpty());
    }

    @Test
    public void testDelete() {
	List<Integer> l = new List();
	assertTrue(l.isEmpty());
	Integer inserted = 3;
	l.insert(inserted);
	assertTrue(l.size() == 1);
	l.delete(inserted+1);
	assertTrue(l.size() == 1);
	l.delete(inserted);
	assertTrue(l.isEmpty());
    }

    @Test
    public void testPopBack() {
	List<Integer> l = new List();
	assertTrue(l.isEmpty());
        for (int i = 0; i < 10; i ++) {
	    l.insert(i);
	}
	for (int i = 0; i < 10; i++) {
	    assertTrue(l.popBack() == i);
	}
    }
}
