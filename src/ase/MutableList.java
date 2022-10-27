package ase;

import java.util.*;

public class MutableList<T> extends AbstractList<T> {

    private ListElement<T> rootElement;
    
    private static class ListElement<T> {
        private T value;
        private ListElement<T> nextElement;
        
        ListElement(T value) {
            this.value = value;
        }
        
    }
    
    @Override
    public int size() {
        ListElement<T> currentPointer = this.rootElement;
        int counter = 0;
        while(currentPointer != null) {
            currentPointer = currentPointer.nextElement;
            counter++;
        }
        return counter;
    }

    
    @Override
    public boolean addAll(Collection<? extends T> c) {
        if(c.isEmpty()) {
            return false;
        }
        ListElement<T> currentPointer = this.rootElement;
        Iterator<? extends T> iterator = c.iterator();
        if(currentPointer == null) {
            this.rootElement = new ListElement<>(iterator.next());
            currentPointer = this.rootElement;
        } else {
            while(currentPointer.nextElement != null) {
                currentPointer = currentPointer.nextElement;
            }
        }
        
        while(iterator.hasNext()) {
            ListElement<T> listElement = new ListElement<>(iterator.next());
            currentPointer.nextElement = listElement;
            currentPointer = listElement;
        }
               
        return true;
    }

    @Override
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
