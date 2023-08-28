package aux_ff;

public class CircularQueue<T> implements interface_data_src<T>{
    private int top, bottom;
    private int size;
    private T[] queue;

    public CircularQueue(int size){
        this.size = size;
        top = bottom = -1;
        queue = (T[]) new Object[size];
    }

    public void add(T data) throws Exception{

        if(data == null){
            throw new Exception("Data cannot be null");
        }
        
        if(isFull()){
            throw new Exception("Queue is full");
        }
        
        //There is space in the queue

        //If the queue is empty, set top to 0
        if(isEmpty()){
            top = 0;
        }

        //Index of bottom is always the last element in the queue, could add without removing elements -> bottom changes -> bottom != size!
        bottom = (bottom + 1) % size;

        queue[bottom] = data;
    }

    public T remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }

        T data = queue[top];

        //If bottom reaches top, there is only one element in the queue
        if(top == bottom){
            top = bottom = -1;
        }else{
            //Increment top
            top = (top + 1) % size;
        }
        return data;
    }

    public void clear(){
        top = bottom = -1;
        queue = (T[]) new Object[size];
    }

    public boolean isEmpty(){
        //If top is not initialized, queue is empty
        return top == -1;
    }

    public boolean isFull(){
        //If top is 0 and bottom is size - 1, queue is full
        if(top == 0 && bottom == size - 1){
            return true;
        }
        //If top is 1 less than bottom, queue is full
        return top == bottom + 1;
    }

    private void print(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Queue: ");
        for(int i = top; i != bottom; i = (i + 1) % size){
            System.out.println(queue[i]);
        }
    }

    public static void main(String[] args){
        CircularQueue<Integer> queue = new CircularQueue<Integer>(5);
        try{
            queue.add(1);
            queue.add(2);
            queue.add(3);
            queue.add(4);
            queue.add(5);
            queue.remove();
            queue.add(6);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }queue.print();
    }
}