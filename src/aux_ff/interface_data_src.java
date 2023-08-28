package aux_ff;

public interface interface_data_src<T> {
    public void add(T data) throws Exception;
    public T remove() throws Exception;
    public void clear();
    public boolean isEmpty();
    public boolean isFull();
}