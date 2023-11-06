public class CustomStack<E> {

    protected Object[] data;

    protected int index;
    private static final int DEFAULT_CAPACITY = 10;

    public CustomStack() {
        this(DEFAULT_CAPACITY);
    }

    public CustomStack(int capacity) {
        data = new Object[capacity];
    }

    public boolean push(E e){
        if(index == data.length)
            grow();

        data[index++] = e;
        return true;
    }

    public E pop(){
        if(index==0)
            throw new RuntimeException("Stack Is Empty.");
        E e = peek();
        data[--index] = null;
        return e;
    }

    public E peek(){
        if(index==0)
            throw new RuntimeException("Stack Is Empty.");
        return (E)data[index-1];
    }

    public void grow(){
        Object[] temp = new Object[data.length*2];

        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public void printStack(){
        for(int i=0; i<index; i++){
            System.out.print(data[i]+", ");
        }
    }
}

