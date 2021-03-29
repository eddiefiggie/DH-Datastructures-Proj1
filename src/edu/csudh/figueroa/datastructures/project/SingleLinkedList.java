package edu.csudh.figueroa.datastructures.project;

public class SingleLinkedList<E> implements SLLInterface<E> {

    private static class Node<F> {
        private F data;
        private Node<F> next;

        // creates a new node with a null next field
        private Node(F dataItem) {
            data = dataItem;
            next = null;  // pointer
        }

        // creates a new node that references another node
        private Node(F dataItem, Node<F> nodeRef) {
            data = dataItem;
            next = nodeRef;  // pointer
        }
    }

    private Node<E> head = null;
    private int size = -1;

    public SingleLinkedList() {
        this.head = new Node<E>(null);
        this.size = 0;
    }

    private void addFirst(E item) {
        Node<E> temp = new Node<E>(item, head.next);
        head.next= temp;
        size++;
    }

    private void addAfter(Node<E> node, E item) {
        Node<E> temp = new Node<E>(item, node.next);
        node.next = temp;
        size++;
    }

    private E removeAfter (Node<E> node) {
        Node<E> temp = node.next;
        if(temp != null) {
            node.next = temp.next;
            size--;
            return temp.data;
        }
        else {
            return null;
        }
    }

    private E removeFirst() {
        Node<E> temp = head;
        if (head != null) {
            head = head.next;
        }
        if(temp != null) {
            size--;
            return temp.data;
        }
        else {
            return null;
        }
    }

    private Node<E> getNode(int index) {
        Node<E> node = head;
        for(int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    public String toString() {
        String s = "[";
        Node<E> p = head;
        if(p != null) {
            while(p.next != null) {
                s += p.next.data + " -> ";
                p = p.next;
            }
        }
        s += "]";
        return s;
    }

    public void nukeLinkedList() {
        this.head = new Node<E>(null);
        this.size = 0;
    }

    @Override
    public void add(int index, E item) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if(index == 0) {
            addFirst(item);
        }
        else {
            Node<E> node = getNode(index-1);
            addAfter(node, item);
        }
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if(index == 0) {
            return removeFirst();
        }
        else {
            Node<E> node = getNode(index-1);
            return removeAfter(node);
        }

    }

    @Override
    public E get(int index) {
        index = index + 1;
        if(index < 0) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    @Override
    public E set(int index, E newValue) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        E result = node.data;
        node.data = newValue;
        return result;
    }

    @Override
    public int size() {
        return this.size;
    }
}
