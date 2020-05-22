package practice.dao;

public interface GenericDao<T> {
    T add(T t);
}
