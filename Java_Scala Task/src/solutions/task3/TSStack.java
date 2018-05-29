package task3;


import java.util.ArrayList;
import java.util.EmptyStackException;

public class TSStack <E> implements StackOperations<E> {

    private volatile ArrayList<E> elements = new ArrayList<>();

    @Override
    public synchronized boolean push(E element) {
        return elements.add(element);
    }

    @Override
    public synchronized E peek() {
        if(elements.size() == 0){
            throw new EmptyStackException();
        }
        return elements.get(elements.size() - 1);
    }

    @Override
    public synchronized E pop() {
        E result = peek();
        elements.remove(elements.size() - 1);
        return result;
    }

    public synchronized boolean isEmpty(){
        return elements.isEmpty();
    }

    public synchronized int size(){
        return elements.size();
    }

    @Override
    public String toString() {
        return "TSStack{" +
                "elements=" + elements +
                '}';
    }
}
