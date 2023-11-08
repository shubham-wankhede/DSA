package com.example.queue;

public class CustomArrayQueue<E> {

    protected Object[] data;
    private static final int DEFAULT_CAPACITY = 5;
    private int size;
    private int front = 0;
    private int end = 0;

    public CustomArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CustomArrayQueue(int capacity) {
        data = new Object[capacity];
    }

    public boolean add(E e){
        if(size == data.length)
            grow();
        data[end% data.length] = e;
        end++;
        size++;
        return true;
    }

    public E remove(){
        if(size==0){
            throw new RuntimeException("Queue is Empty.");
        }
        E e = (E) data[front];
        front = (front+1)%data.length;
        size--;
        return e;
    }

    public E peek(){
        if(size==0){
            throw new RuntimeException("Queue is Empty.");
        }
        return (E) data[front];
    }

    private void grow() {
        Object[] temp = new Object[data.length*2];
        for(int i = 0; i< data.length; i++){
            temp[i] = data[(front+i)% data.length];
        }
        data = temp;
    }


    public void printQueue() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[(front+i)%data.length]+" <-");
        }
        System.out.println("END");
    }
}

