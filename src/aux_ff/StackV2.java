package aux_ff;

public class StackV2<T>{
    private MyDll<T> stack = new MyDll<T>();
    int pointer = -1;

    public StackV2(){};

    public void add(T data) throws Exception{
        if(data == null){
            throw new Exception("Data cannot be null");
        }

        stack.append(data);
        pointer++;
    }

    public T remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is empty");
        }

        T data = stack.get(pointer);
        stack.pop(pointer);
        pointer--;
        return data;
    }

    public void clear(){
        stack.clear();
        pointer = -1;
    }

    public boolean isEmpty(){
        if(pointer == -1){
            return true;
        }
        return false;
    }

    private void print(){
        MyDll<T> aux = stack;
        aux.reverse();
        aux.print();
    }

    public static void main(String[] args){
        StackV2<Integer> stack = new StackV2<Integer>();
        try{
            stack.add(1);
            stack.add(2);
            stack.add(3);
            stack.add(4);
            stack.add(5);
            stack.remove();
            stack.remove();
            stack.remove();
            stack.remove();
            stack.remove();
            stack.add(6);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        stack.print();
    }


}
