package hw2;

import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleHashMapTest {
    @Test
    public void isEmptyTest() {
	SimpleHashMap<String, Integer> m = new SimpleHashMap();
	assertTrue(m.isEmpty());
	m.put("one", 1);
	assertFalse(m.isEmpty());
    }

    @Test
    public void putTest() {
	SimpleHashMap<String, Integer> m = new SimpleHashMap();
	assertTrue(m.isEmpty());
	for (Integer i = 0; i < 10; i++) {
	    int prePutSize = m.size();
	    m.put(i.toString(), i);
	    int postPutSize = m.size();
	    assertTrue(prePutSize == postPutSize-1);
	}
    }

    @Test
    public void getTest() {
	SimpleHashMap<String, Integer> m = new SimpleHashMap();
	assertTrue(m.isEmpty());
	for (Integer i = 0; i < 10; i++) {
	    m.put(i.toString(), i);
	}
	assertTrue(m.size() == 10);
	for (Integer i = 0; i < 15; i++) {
	    Integer v = m.get(i.toString());
	    if (i < m.size()) {
		assertTrue(v != null);
		assertTrue(i == v);
	    } else {
		assertTrue(v == null);
	    }
	}
    }

    @Test
    public void allocateCapacityTest() {
	SimpleHashMap<String, Integer> m = new SimpleHashMap();
	assertTrue(m.isEmpty());
	m.allocateCapacity(10);
	assertTrue(m.capacity() == 10);
    }

    @Test
    public void capacityTest() {
	SimpleHashMap<String, Integer> m = new SimpleHashMap();
	assertTrue(m.capacity() == 0);
	m.put("1", 1);
	assertTrue(m.capacity() == 2);
	m.put("2", 2);
	assertTrue(m.capacity() == 2);
	m.put("3", 3);
	assertTrue(m.capacity() == 4);
    }
}
