package aux_ff;

public class Stack<T> implements interface_data_src<T> {
    private int pointer;
    private int size;
    private T[] stack;

    public Stack(int size){
        this.size = size;
        pointer = -1;
        stack = (T[]) new Object[size];
    }

    public void add(T data) throws Exception{

        if(data == null){
            throw new Exception("Data cannot be null");
        }

        if(isFull()){
            throw new Exception("Stack is full");
        }
        pointer++;
        stack[pointer] = data;
    }

    public T remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is empty");
        }

        T data = stack[pointer];
        pointer--;
        return data;
    }

    public boolean isEmpty(){
        return pointer == -1;
    }

    public boolean isFull(){
        return pointer == size - 1;
    }

    public void clear(){
        pointer = -1;
    }
}
