package ase;

import java.util.*;

import ase.MutableList.*;

public class ImmutableList<T> {
    
    private final ListElement<T> rootElement;
    
    public ImmutableList(ListElement<T> rootElement) {
        super();
        this.rootElement = rootElement;
    }

    private static class ListElement<T> {
        private final T value;
        private final ListElement<T> nextElement;
        
        ListElement(T value, ListElement<T> element) {
            this.value = value;
            this.nextElement = element;
        }

        public static<T> ListElement<T> create(Collection<? extends T> c) {
            ListElement<T> current = null;
            for(T value : c) {
                current = new ListElement<T>(value, current);
            }
            return current;
        }

        public ListElement<T> addAll(Collection<? extends T> c) {
            
            if(nextElement == null) {
                return new ListElement<T>(this.value, ListElement.create(c));
            }
            
            return new ListElement<T>(this.value, this.nextElement.addAll(c));
        }
        
    }
    
    public int size() {
        ListElement<T> currentPointer = this.rootElement;
        int counter = 0;
        while(currentPointer != null) {
            currentPointer = currentPointer.nextElement;
            counter++;
        }
        return counter;
    }

    public ImmutableList<T> addAll(Collection<? extends T> c) {
        return new ImmutableList<T>(this.rootElement == null ? ListElement.create(c) : this.rootElement.addAll(c));
    }

    public T get(int index) {
        ListElement<T> currentPointer = this.rootElement;
        int counter = 0;
        while(counter < index) {
            currentPointer = currentPointer.nextElement;
            counter++;
        }
        return currentPointer.value;
    }

}
