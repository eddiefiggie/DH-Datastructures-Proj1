package edu.csudh.figueroa.datastructures.project;

public interface SLLInterface<E> {
    public void add(int index, E item);
    public E remove(int index);
    public E get(int index);
    public E set(int index, E newValue);
    public int size();
}
