package hw2;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    @Test
    public void pushTest() {
	ListQueue<Integer> q = new ListQueue();
	assertTrue(q.isEmpty());
	q.push(1);
	assertFalse(q.isEmpty());
	assertTrue(q.size() == 1);
    }

    @Test
    public void popTest() {
	ListQueue<Integer> q = new ListQueue();
	assertTrue(q.isEmpty());
	for (int i = 0; i < 10; i++) {
	    q.push(i);
	}

	for (int i = 0; i < 10; i++) {
	    int prePopSize = q.size();
	    assertTrue(q.pop() == i);
	    int postPopSize = q.size();
	    assertTrue(prePopSize == postPopSize + 1);
	}
    }

    @Test
    public void isEmptyTest() {
	ListQueue<Integer> q = new ListQueue();
	assertTrue(q.isEmpty());
	q.push(1);
	assertFalse(q.isEmpty());
	q.pop();
	assertTrue(q.isEmpty());
    }

    @Test
    public void sizeTest() {
	ListQueue<Integer> q = new ListQueue();
	assertTrue(q.isEmpty());
	for (int i = 0; i < 10; i++) {
	    q.push(i);
	    assertTrue(q.size() == i+1);
	}
    }
	
}
