package hw2;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    @Test
    public void isEmptyTest() {
	ListStack<Integer> s = new ListStack();
	assertTrue(s.isEmpty());
	s.push(1);
	assertFalse(s.isEmpty());
    }

    @Test
    public void sizeTest() {
	ListStack<Integer> s = new ListStack();
	assertTrue(s.size() == 0);
	for (int i = 0; i < 10; i++) {
	    s.push(i);
	    assertTrue(s.size() == i+1);
	}
	for (int i = 0; i < 10; i++) {
	    int prePopSize = s.size();
	    s.pop();
	    int postPopSize = s.size();
	    assertTrue(prePopSize == postPopSize+1);
	}
    }

    @Test
    public void pushTest() {
	ListStack<Integer> s = new ListStack();
	for (int i = 0; i < 10; i++) {
	    int prePushSize = s.size();
	    s.push(i);
	    int postPushSize = s.size();
	    assertTrue(prePushSize == postPushSize-1);
	}
    }

    @Test
    public void popTest() {
	ListStack<Integer> s = new ListStack();
	for (int i = 0; i < 10; i++) {
	    s.push(i);
	}

	for (int i = 9; i >= 0; i--) {
	    assertTrue(s.pop() == i);
	}
    }
}
