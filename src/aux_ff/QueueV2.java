package aux_ff;

public class QueueV2<T>{
    private MyDll<T> queue = new MyDll<T>();

    public QueueV2(){};

    public void add(T data) throws Exception{
        if(data == null){
            throw new Exception("Data cannot be null");
        }

        queue.append(data);
    }

    public T remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }

        T data = queue.get(0);
        queue.pop(0);
        return data;
    }

    public void clear(){
        queue.clear();
    }

    public boolean isEmpty(){
        if(queue.count() == 0){
            return true;
        }
        return false;
    }

    private void print(){
        queue.print();
    }

    public static void main(String[] args){
        QueueV2<Integer> queue = new QueueV2<Integer>();
        try{
            queue.add(1);
            queue.add(2);
            queue.add(3);
            queue.add(4);
            queue.add(5);
            queue.remove();
            queue.remove();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        queue.print();
    }
}
