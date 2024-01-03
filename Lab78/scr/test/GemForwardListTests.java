package scr.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;
import scr.main.GemForwardList;
import scr.main.Gemstone;

public class GemForwardListTests {

    private GemForwardList gemList;
    private Gemstone diamond;
    private Gemstone ruby;
    private Gemstone sapphire;
        
    
    @Before
    public void newGemList() {
        gemList = new GemForwardList();
        diamond = new Gemstone("Diamond", 1.2, 4.0, 0.9);
        ruby = new Gemstone("Ruby", 1.2, 4.0, 0.9);
        sapphire = new Gemstone("Sapphire", 1.2, 4.0, 0.9);
    }

    @Test
    public void testImplementsListInterface() {
        assertTrue(gemList instanceof List);
    }
    
    @Test
    public void testConstructorWithGemstone() {
        var gemList = new GemForwardList(diamond);

        assertEquals(1, gemList.size());
        assertTrue(gemList.contains(diamond));
        assertEquals(diamond, gemList.get(0));
        assertEquals(diamond, gemList.first.Gem);
        assertEquals(diamond, gemList.head.Gem);
    }

    @Test
    public void testConstructorWithGemstoneCollection() {
       
        Collection<Gemstone> gemCollection = Arrays.asList(diamond, ruby, sapphire);

        GemForwardList gemList = new GemForwardList(gemCollection);

        assertEquals(gemCollection.size(), gemList.size());
        assertTrue(gemList.containsAll(gemCollection));
        assertEquals(diamond, gemList.get(0));
        assertEquals(ruby, gemList.get(1));
        assertEquals(sapphire, gemList.get(2));
    }

    @Test
    public void testSize() {
        assertEquals(0, gemList.size());
        var diamond = new Gemstone("Diamond", 1.2, 4.0, 0.9);
        gemList.add(diamond);
        assertEquals(1, gemList.size());
        gemList.remove(diamond);
        assertEquals(0, gemList.size());
    }

    @Test
    public void testIsEmpty() {
        Gemstone diamond = new Gemstone("Diamond", 1.2, 4.0, 0.9);

        assertTrue(gemList.isEmpty());
        gemList.add(diamond);
        assertFalse(gemList.isEmpty());
        gemList.remove(diamond);
        assertTrue(gemList.isEmpty());
    }

    @Test
    public void testContains() {
        gemList.add(diamond);
        gemList.add(ruby);

        assertTrue(gemList.contains(diamond));
        assertTrue(gemList.contains(ruby));
        assertFalse(gemList.contains(sapphire));
        assertFalse(gemList.contains(null));
    }

    @Test
    public void testIterator() {
        gemList.add(diamond);
        gemList.add(ruby);
        gemList.add(sapphire);

        Iterator<Gemstone> iterator = gemList.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(diamond, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(ruby, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(sapphire, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testToArray() {
        gemList.add(diamond);
        gemList.add(ruby);
        gemList.add(sapphire);

        Object[] array = gemList.toArray();
        assertEquals(gemList.size(), array.length);
        assertEquals(diamond, array[0]);
        assertEquals(ruby, array[1]);
        assertEquals(sapphire, array[2]);
    }

     @Test
    public void testToArrayWithGivenArray() {
        gemList.add(diamond);
        gemList.add(ruby);
        gemList.add(sapphire);

        Gemstone[] gemArray = new Gemstone[gemList.size()];

        gemList.toArray(gemArray);
        assertArrayEquals(new Gemstone[]{diamond, ruby, sapphire}, gemArray);

        Gemstone[] largerArray = new Gemstone[gemList.size() + 2];
        gemList.toArray(largerArray);
        assertArrayEquals(new Gemstone[]{diamond, ruby, sapphire, null, null}, largerArray);

        Gemstone[] smallerArray = new Gemstone[gemList.size() - 1];
        Gemstone[] resultArray = gemList.toArray(smallerArray);
        assertNotSame(smallerArray, resultArray);
        assertArrayEquals(new Gemstone[]{diamond, ruby, sapphire}, resultArray);
    }

    @Test
    public void testAdd() {
        assertTrue(gemList.add(diamond));
        assertEquals(1, gemList.size());
        assertTrue(gemList.contains(diamond));

        assertTrue(gemList.add(ruby));
        assertEquals(2, gemList.size());
        assertTrue(gemList.contains(ruby));

        assertTrue(gemList.add(sapphire));
        assertEquals(3, gemList.size());
        assertTrue(gemList.contains(sapphire));
        assertEquals(sapphire, gemList.get(2));
    }

    @Test
    public void testRemove() {
        gemList.add(diamond);
        gemList.add(ruby);
        gemList.add(sapphire);

        assertTrue(gemList.remove(ruby));
        assertEquals(2, gemList.size());
        assertFalse(gemList.contains(ruby));

        assertTrue(gemList.remove(diamond));
        assertEquals(1, gemList.size());
        assertFalse(gemList.contains(diamond));
        assertEquals(sapphire, gemList.get(0));

        assertTrue(gemList.remove(sapphire));
        assertEquals(0, gemList.size());
        assertFalse(gemList.contains(sapphire));
        assertNull(gemList.head);
        assertNull(gemList.first);
    }

    @Test
    public void testContainsAll() {
        gemList.add(diamond);
        gemList.add(ruby);
        gemList.add(sapphire);

        assertTrue(gemList.containsAll(Arrays.asList(diamond, ruby)));
        assertTrue(gemList.containsAll(Arrays.asList(diamond, sapphire)));
        assertTrue(gemList.containsAll(Arrays.asList(ruby, sapphire)));
        assertFalse(gemList.containsAll(Arrays.asList(diamond, ruby, sapphire, new Gemstone("Emerald", 1.9, 2.0, 0.5))));
    }

    @Test
    public void testAddAll() {
        assertTrue(gemList.addAll(Arrays.asList(diamond, ruby, sapphire)));
        assertEquals(3, gemList.size());
        assertTrue(gemList.contains(diamond));
        assertTrue(gemList.contains(ruby));
        assertTrue(gemList.contains(sapphire));

        assertFalse(gemList.addAll(Arrays.asList()));
        assertEquals(3, gemList.size());

        assertTrue(gemList.addAll(Arrays.asList(ruby, sapphire)));
        assertEquals(5, gemList.size());
        assertTrue(gemList.contains(ruby));
        assertTrue(gemList.contains(sapphire));
    }

    @Test
    public void testAddAllAtIndex() {
        gemList.add(diamond);
        gemList.add(sapphire);

        assertTrue(gemList.addAll(1, Arrays.asList(ruby, sapphire)));
        assertEquals(4, gemList.size());
        assertTrue(gemList.contains(ruby));
        assertTrue(gemList.contains(sapphire));
        assertEquals(ruby, gemList.get(1));

        assertFalse(gemList.addAll(2, Arrays.asList()));
        assertEquals(4, gemList.size()); // Size should not change

        assertTrue(gemList.addAll(2, Arrays.asList(ruby, sapphire)));
        assertEquals(6, gemList.size());
        assertTrue(gemList.contains(ruby));
        assertTrue(gemList.contains(sapphire));
        assertEquals(ruby, gemList.get(2));
    }

    @Test
    public void testRemoveAll() {
        Gemstone emerald = new Gemstone("Emerald", 0.9, 10.3, 0.98);

        gemList.addAll(Arrays.asList(diamond, ruby, sapphire, emerald));

        assertTrue(gemList.removeAll(Arrays.asList(ruby, sapphire)));
        assertEquals(2, gemList.size());
        assertTrue(gemList.contains(diamond));
        assertTrue(gemList.contains(emerald));
        assertFalse(gemList.contains(ruby));
        assertFalse(gemList.contains(sapphire));

        assertFalse(gemList.removeAll(Arrays.asList()));
        assertEquals(2, gemList.size()); // Size should not change

        assertFalse(gemList.removeAll(Arrays.asList(ruby, sapphire)));
        assertEquals(2, gemList.size()); // Size should not change
    }

    @Test
    public void testRetainAll() {
        Gemstone emerald = new Gemstone("Emerald", 0.9, 10.3, 0.98);

        gemList.addAll(Arrays.asList(diamond, ruby, sapphire, emerald));

        assertTrue(gemList.retainAll(Arrays.asList(ruby, sapphire)));
        assertEquals(2, gemList.size());
        assertFalse(gemList.contains(diamond));
        assertFalse(gemList.contains(emerald));
        assertTrue(gemList.contains(ruby));
        assertTrue(gemList.contains(sapphire));

        assertFalse(gemList.retainAll(Arrays.asList()));
        assertEquals(2, gemList.size()); // Size should not change

        assertFalse(gemList.retainAll(Arrays.asList(ruby, sapphire)));
        assertEquals(2, gemList.size()); // Size should not change
    }

    @Test
    public void testClear() {
        gemList.addAll(java.util.Arrays.asList(diamond, ruby, sapphire));

        gemList.clear();
        assertEquals(0, gemList.size());
        assertNull(gemList.first);
        assertNull(gemList.head);
        assertFalse(gemList.contains(diamond));
        assertFalse(gemList.contains(ruby));
        assertFalse(gemList.contains(sapphire));

        gemList.clear();
        assertEquals(0, gemList.size());
        assertNull(gemList.first);
        assertNull(gemList.head);
    }

    
    @Test
    public void testGet() {
        gemList.addAll(java.util.Arrays.asList(diamond, ruby, sapphire));

        assertEquals(diamond, gemList.get(0));
        assertEquals(ruby, gemList.get(1));
        assertEquals(sapphire, gemList.get(2));

        try {
            gemList.get(3);
            fail("Expected IndexOutOfBoundsException was not thrown");
        } catch (IndexOutOfBoundsException e) { }

        try {
            gemList.get(-1);
            fail("Expected IndexOutOfBoundsException was not thrown");
        } catch (IndexOutOfBoundsException e) { }
    }

    @Test
    public void testSet() {
        gemList.addAll(java.util.Arrays.asList(diamond, ruby, sapphire));

        Gemstone newRuby = new Gemstone("NewRuby", 1.4, 28.3, 0.87);
        assertEquals(ruby, gemList.set(1, newRuby));
        assertEquals(newRuby, gemList.get(1));
        assertFalse(gemList.contains(ruby));

        try {
            gemList.set(3, newRuby);
            fail("Expected IndexOutOfBoundsException was not thrown");
        } catch (IndexOutOfBoundsException e) { }

        try {
            gemList.set(-1, newRuby);
            fail("Expected IndexOutOfBoundsException was not thrown");
        } catch (IndexOutOfBoundsException e) { }
    }

    @Test
    public void testAddAtIndex() {
        gemList.add(diamond);
        gemList.add(sapphire);

        gemList.add(1, ruby);
        assertEquals(3, gemList.size());
        assertTrue(gemList.contains(ruby));
        assertEquals(ruby, gemList.get(1));

        Gemstone amethyst = new Gemstone("Amethyst", 2.4, 8.6, 0.56);
        gemList.add(0, amethyst);
        assertEquals(4, gemList.size());
        assertTrue(gemList.contains(amethyst));
        assertEquals(amethyst, gemList.get(0));

        try {
            gemList.add(6, amethyst);
            fail("Expected IndexOutOfBoundsException was not thrown");
        } catch (IndexOutOfBoundsException e) {}

        try {
            gemList.add(-1, amethyst);
            fail("Expected IndexOutOfBoundsException was not thrown");
        } catch (IndexOutOfBoundsException e) {}
    }

    @Test
    public void testGetNodeAtIndex() {
        gemList.addAll(java.util.Arrays.asList(diamond, ruby, sapphire));

        assertEquals(diamond, gemList.getNodeAtIndex(0).Gem);
        assertEquals(ruby, gemList.getNodeAtIndex(1).Gem);
        assertEquals(sapphire, gemList.getNodeAtIndex(2).Gem);

        try {
            gemList.getNodeAtIndex(3);
            fail("Expected IndexOutOfBoundsException was not thrown");
        } catch (IndexOutOfBoundsException e) { }

        try {
            gemList.getNodeAtIndex(-1);
            fail("Expected IndexOutOfBoundsException was not thrown");
        } catch (IndexOutOfBoundsException e) { }
    }

    @Test
    public void testRemoveAtIndex() {
        gemList.addAll(java.util.Arrays.asList(diamond, ruby, sapphire));

        assertEquals(ruby, gemList.remove(1));
        assertEquals(2, gemList.size());
        assertFalse(gemList.contains(ruby));
        assertEquals(sapphire, gemList.get(1));

        assertEquals(diamond, gemList.remove(0));
        assertEquals(1, gemList.size());
        assertFalse(gemList.contains(diamond));
        assertEquals(sapphire, gemList.get(0));

        assertEquals(sapphire, gemList.remove(0));
        assertEquals(0, gemList.size());
        assertFalse(gemList.contains(sapphire));
        assertNull(gemList.first);
        assertNull(gemList.head);

        try {
            gemList.remove(1);
            fail("Expected IndexOutOfBoundsException was not thrown");
        } catch (IndexOutOfBoundsException e) { }

        try {
            gemList.remove(-1);
            fail("Expected IndexOutOfBoundsException was not thrown");
        } catch (IndexOutOfBoundsException e) { }
    }

    @Test
    public void testIndexOf() {
        gemList.addAll(java.util.Arrays.asList(diamond, ruby, sapphire));

        assertEquals(0, gemList.indexOf(diamond));
        assertEquals(1, gemList.indexOf(ruby));
        assertEquals(2, gemList.indexOf(sapphire));

        assertEquals(-1, gemList.indexOf(new Gemstone("Amethyst", 2.4, 8.6, 0.56)));

        assertEquals(-1, gemList.indexOf(null));
    }

    @Test
    public void testLastIndexOf() {
        gemList.addAll(java.util.Arrays.asList(diamond, ruby, sapphire, ruby));

        assertEquals(0, gemList.lastIndexOf(diamond));
        assertEquals(3, gemList.lastIndexOf(ruby));
        assertEquals(2, gemList.lastIndexOf(sapphire));

        assertEquals(-1, gemList.lastIndexOf(new Gemstone("Amethyst", 2.4, 8.6, 0.56)));

        assertEquals(-1, gemList.lastIndexOf(null));
    }

    @Test
    public void testListIterator() {
        gemList.addAll(java.util.Arrays.asList(diamond, ruby, sapphire));

        ListIterator<Gemstone> iterator = gemList.listIterator();
        assertTrue(iterator.hasNext());
        assertEquals(diamond, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(ruby, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(sapphire, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testListIteratorWithIndex() {
        gemList.addAll(java.util.Arrays.asList(diamond, ruby, sapphire));

        ListIterator<Gemstone> iterator = gemList.listIterator(1);
        assertTrue(iterator.hasNext());
        assertEquals(ruby, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(sapphire, iterator.next());
        assertFalse(iterator.hasNext());

        try {
            gemList.listIterator(4);
            fail("Expected IndexOutOfBoundsException was not thrown");
        } catch (IndexOutOfBoundsException e) { }

        try {
            gemList.listIterator(-1);
            fail("Expected IndexOutOfBoundsException was not thrown");
        } catch (IndexOutOfBoundsException e) { }
    }

    @Test
    public void testSubList() {
        gemList.addAll(java.util.Arrays.asList(diamond, ruby, sapphire));

        List<Gemstone> subList = gemList.subList(1, 3);
        assertEquals(2, subList.size());
        assertEquals(ruby, subList.get(0));
        assertEquals(sapphire, subList.get(1));

        try {
            gemList.subList(2, 1);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) { }

        try {
            gemList.subList(-1, 2);
            fail("Expected IndexOutOfBoundsException was not thrown");
        } catch (IndexOutOfBoundsException e) { }

        try {
            gemList.subList(0, 4);
            fail("Expected IndexOutOfBoundsException was not thrown");
        } catch (IndexOutOfBoundsException e) { }
    }

}