package scr.main;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class GemForwardList implements List<Gemstone> {

    private int size = 0;
    public GemstoneNode first = null;
    public GemstoneNode head = null;

    public GemForwardList() {}

    public GemForwardList(Gemstone gem) {
        first = new GemstoneNode(gem, null);
        head = first;
        size++;
    }

    public GemForwardList(Collection<Gemstone> gems) {
        this();
        addAll(gems);
    }

    public class GemstoneNode {

        public Gemstone Gem = null;
        public GemstoneNode NextNode = null;
    
        public GemstoneNode(Gemstone gemstone, GemstoneNode nextNode) {
            Gem = gemstone;
            NextNode = nextNode;
        }
    
        public GemstoneNode() {}
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return false;
        }
    
        GemstoneNode current = first;
    
        while (current != null) {
            if (o.equals(current.Gem)) {
                return true;
            }
            current = current.NextNode;
        }
    
        return false;
    }

    @Override
    public Iterator<Gemstone> iterator() {
        return new GemstoneNodeIterator();
    }

    private class GemstoneNodeIterator implements ListIterator<Gemstone> {
        
        private GemstoneNode current = first;
        private GemstoneNode lastReturned = null;
        private int currentIndex = 0;

        public GemstoneNodeIterator() {}
        
        public GemstoneNodeIterator(int index) {
            checkPositionIndex(index);
            current = getNodeAtIndex(index);
            currentIndex = index;
        }


        private GemstoneNode getNodeAtIndex(int index) {
            GemstoneNode node = first;
            for (int i = 0; i < index; i++) {
                node = node.NextNode;
            }
            return node;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Gemstone next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Gemstone gem = current.Gem;
            lastReturned = current;
            current = current.NextNode;
            currentIndex++;
            return gem;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public Gemstone previous() {
            throw new NoSuchElementException("GemForwardList is a forward list, no previous elements");
        }

        @Override
        public int nextIndex() {
            return currentIndex;
        }

        @Override
        public int previousIndex() {
            return -1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported");
        }

        @Override
        public void set(Gemstone e) {
            if (lastReturned == null) {
                throw new IllegalStateException("No element to set");
            }
            lastReturned.Gem = e;
        }

        @Override
        public void add(Gemstone e) {
            throw new UnsupportedOperationException("add() is not supported");
        }
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (GemstoneNode x = first; x != null; x = x.NextNode)
            result[i++] = x.Gem;
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            a = (T[])java.lang.reflect.Array.newInstance(
                                a.getClass().getComponentType(), size);
        int i = 0;
        Object[] result = a;
        for (GemstoneNode x = first; x != null; x = x.NextNode)
            result[i++] = x.Gem;

        if (a.length > size)
            a[size] = null;

        return a;
    }

    @Override
    public boolean add(Gemstone e) {
        
        GemstoneNode newNode = new GemstoneNode(e, null);

        if (isEmpty()) {
            first = newNode;
            head = newNode;
        } else {
            head.NextNode = newNode;
            head = newNode;
        }
    
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        
        if (o == null) {
            return false;
        }
    
        GemstoneNode current = first;
        GemstoneNode prev = null;

        while (current != null) {
            if (o.equals(current.Gem)) {
                // If remove the first node
                if (prev == null) {
                    first = current.NextNode;
                    if (first == null) {
                        head = null;
                    }
                } 
                else {
                    prev.NextNode = current.NextNode;
                    if (current.NextNode == null) {
                        head = prev;
                    }
                }
    
                size--;
                return true;
            }
    
            prev = current;
            current = current.NextNode;
        }
    
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Gemstone> c) {
        if (c.isEmpty()) {
            return false;
        }

        for (Gemstone element : c) {
            add(element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Gemstone> c) {
        checkPositionIndex(index);

        if (c.isEmpty()) {
            return false;
        }
        
        int i = index;
        for (Gemstone element : c) {
            add(i++, element);
        }
    
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;

        for (Object element : c) {
            while (remove(element)) {
                modified = true;
            }
        }
    
        return modified;
    }

    /*Removes elements of the list, that are not present in a collection. */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;

        if (c.isEmpty()) {
            return modified;
        }
        
        GemstoneNode current = first;
    
        while (current != null) {
            if (!c.contains(current.Gem)) {
                GemstoneNode nextNode = current.NextNode;
                remove(current.Gem);
                current = nextNode;
                modified = true;
            } else {
                current = current.NextNode;
            }
        }
    
        return modified;
    }

    /*Garbage collection?? */
    @Override
    public void clear() {
        first = null;
        head = null;
        size = 0;
    }

    @Override
    public Gemstone get(int index) {
        checkPositionIndex(index);

        GemstoneNode node = getNodeAtIndex(index);
        return node.Gem;
    }

    @Override
    public Gemstone set(int index, Gemstone element) {
        checkPositionIndex(index);

        GemstoneNode node = getNodeAtIndex(index);
        Gemstone oldElement = node.Gem;
    
        node.Gem = element;
    
        return oldElement;
    }

    @Override
    public void add(int index, Gemstone element) {
        checkPositionIndex(index);

        GemstoneNode newNode = new GemstoneNode(element, null);
    
        if (index == 0) {
            newNode.NextNode = first;
            first = newNode;
            if (isEmpty()) {
                head = newNode;
            }
        } 
        else {
            GemstoneNode prev = getNodeAtIndex(index - 1);
            newNode.NextNode = prev.NextNode;
            prev.NextNode = newNode;
            if (newNode.NextNode == null) {
                head = newNode;
            }
        }
    
        size++;
    }

    public GemstoneNode getNodeAtIndex(int index) {
        if (index == size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        
        checkPositionIndex(index);
    
        GemstoneNode node = first;
        for (int i = 0; i < index; i++) {
            node = node.NextNode;
        }
        return node;
    }

    @Override
    public Gemstone remove(int index) {
        checkPositionIndex(index);

        GemstoneNode removedNode;

        // If remove the first node
        if (index == 0) {
            removedNode = first;
            first = first.NextNode;
            if (first == null) {
                head = null;
            }
        } 
        else {
            GemstoneNode prev = getNodeAtIndex(index - 1);
            removedNode = prev.NextNode;
            prev.NextNode = removedNode.NextNode;
            if (removedNode.NextNode == null) {
                head = prev;
            }
        }
    
        size--;
        return removedNode.Gem;
    }

    @Override
    public int indexOf(Object o) {
        
        if (o == null) {
            return -1;
        }
    
        GemstoneNode current = first;
        int index = 0;
    
        while (current != null) {
            if (o.equals(current.Gem)) {
                return index;
            }
            current = current.NextNode;
            index++;
        }
        
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            return -1;
        }
    
        GemstoneNode current = first;
        int lastIndex = -1;
        int index = 0;
    
        while (current != null) {
            if (o.equals(current.Gem)) {
                lastIndex = index;
            }
            current = current.NextNode;
            index++;
        }
    
        return lastIndex;
    }

    @Override
    public ListIterator<Gemstone> listIterator() {
        return new GemstoneNodeIterator();
    }

    @Override
    public ListIterator<Gemstone> listIterator(int index) {
        checkPositionIndex(index);
        return new GemstoneNodeIterator(index);
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    @Override
    public List<Gemstone> subList(int fromIndex, int toIndex) {
        checkPositionIndex(fromIndex);
        checkPositionIndex(toIndex);

        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex must be less than or equal to toIndex");
        }

        List<Gemstone> subList = new ArrayList<>();

        GemstoneNode current = getNodeAtIndex(fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(current.Gem);
            current = current.NextNode;
        }

        return subList;

    }
    
}
