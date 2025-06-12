package src.dao;

public interface Dao_interface<T> {
    public int insert (T t);

    public int update (T t);

    public int delete (T t);

    public Arraylist<T> selectAll();

    public T selectById(T t);

    public Arraylist<T> selectByCondition(String condition);
}
