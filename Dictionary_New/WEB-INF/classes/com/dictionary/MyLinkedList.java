/**
 * FileName:    MyLinkedList.java
 * Copyright:   By sun, or by yourself.
 */

package com.dictionary;

/**
 * A realization of linkedlist using generic paradigm methods.
 * It can be used as a stack or a queue. But it does not override any interface.
 * @author      Sny
 * @since       2018-05-05
 * @see         (1)https://blog.csdn.net/gongchuangsu/article/details/51527042
 *              (2)https://www.cnblogs.com/zhengbin/p/6377994.html
 *              (3)http://www.runoob.com/java/java-generics.html
 * @version     1.00
 */
public class MyLinkedList<T> {
    /**
     * A realization of node in linkedlist, which used as a structure.
     * It is a private class used by MyLinkedList.
     * @author      Sny
     * @since       2018-05-05
     * @version     1.00
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node() {
            item = null;
            next = null;
            prev = null;
        }

        Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    // Private variables in MyLinkedList.
    private int size;
    private Node<T> first;
    private Node<T> last;

    // Constructor
    // first and last must be null at the beginning.
    MyLinkedList() {
        size = 0;
        first = null;
        last = null;
    }

    // Link
    void linkFirst(T item) {
        final Node<T> f = first;
        final Node<T> newNode = new Node<T>(item, null, first);
        first = newNode;
        if(f == null) {
            last = newNode;
        }
        else {
            f.prev = newNode;
        }
        size++;
    }

    void linkLast(T item) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<T>(item, last, null);
        last = newNode;
        if(l == null) {
            first = newNode;
        }
        else {
            l.next = newNode;
        }
        size++;
    }

    void linkBefore(T item, Node<T> node) {
        final Node<T> temp = node;
        final Node<T> newNode = new Node<T>(item, null, node);
        if(temp == null) {
            first = newNode;
            last = newNode;
        }
        else if(temp.prev == null){
            first = newNode;
            temp.prev = newNode;
        }
        else {
            temp.prev.next = newNode;
            newNode.prev = temp.prev;
            temp.prev = newNode;
        }
        size++;
    }

    // Special
    void checkIndex(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    Node<T> node(int index) {
        if(index < (size >> 1)) {
            Node<T> x = first;
            for(int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        }
        else {
            Node<T> x = last;
            for(int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    T unlink(Node<T> x) {
        final T item = x.item;
        final Node<T> prev = x.prev;
        final Node<T> next = x.next;

        if(prev == null) {
            first = next;
        }
        else {
            prev.next = next;
            x.prev = null;
        }

        if(next == null) {
            last = prev;
        }
        else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return item;
    }

    // Add
    public void addFirst(T item) {
        linkFirst(item);
    }
    
    public void addLast(T item) {
        linkLast(item);
    }

    public void add(int index, T item) {
        checkIndex(index);
        if(index == 0) {
            linkFirst(item);
        }
        else if(index == size)
        {
            linkLast(item);
        }
        else {
            linkBefore(item, node(index));
        }
    }

    // Get
    public T getFirst() {
        final Node<T> f = first;
        return (f == null) ? null : f.item;
    }

    public T getLast() {
        final Node<T> l = last;
        return (l == null) ? null : l.item;
    }

    public T get(int index) {
        checkIndex(index);
        final Node<T> temp = node(index);
        return (temp == null) ? null : temp.item;
    }

    // Remove
    public T removeFirst() {
        final Node<T> f = first;
        return (f == null) ? null : unlink(f);
    }

    public T removeLast() {
        final Node<T> l = last;
        return (l == null) ? null : unlink(l);
    }

    public T remove(int index) {
        checkIndex(index);
        final Node<T> temp = node(index);
        return (temp == null) ? null : unlink(temp);
    }

    // Stack
    public void push(T item) {
        addFirst(item);
    }

    public T pop() {
        return removeFirst();
    }

    // Queue
    public void offer(T item) {
        addLast(item);
    }

    public T poll() {
        final Node<T> f = first;
        return (f == null) ? null : unlink(f);
    }

    // Set
    public T set(int index, T item) {
        checkIndex(index);
        Node<T> x = node(index);
        T oldVal = x.item;
        x.item = item;
        return oldVal;
    }

    // Size
    public int size() {
        return this.size;
    }

    // Clear
    public void clear() {
        for(Node<T> x = first; x != null;) {
            Node<T> next = x.next;
            x.item = null;
            x.prev = null;
            x.next = null;
            x = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    // String
    public String toString() {
        String listStr = "";
        for(int i = 0; i < size; i++) {
            listStr += get(i).toString() + "\n";
        }
        return listStr;
    }
}