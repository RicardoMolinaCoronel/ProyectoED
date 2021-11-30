/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Iterator;

/**
 *
 * @author rdavi
 */
public class ArrayList<E> implements List<E>{
    private E[] elements = null;
    private int capacity;
    private int effectiveSize;
    
    public ArrayList(int capacity) {
        elements = (E[])(new Object[capacity]);
        effectiveSize = 0;
        this.capacity = capacity;
    }
    
    public ArrayList() {
        capacity = 100;
        elements = (E[])(new Object[capacity]);
        effectiveSize = 0;
    }
    
    private void addCapacity() {
        E[] tmp = (E[]) new Object[capacity * 2];
        for (int i = 0; i < capacity; i++) {
            tmp[i] = elements[i];
        }
        elements = tmp;
        capacity = capacity * 2;
    }
    
    public void addCapacity(int extraSpaces) {
        E[] tmp = (E[]) new Object[capacity + extraSpaces];
        for (int i = 0; i < capacity; i++) {
            tmp[i] = elements[i];
        }
        elements = tmp;
        capacity = capacity + extraSpaces;
    }
    
    private void lessCapacity(){
        capacity--;
        E[] tmp = (E[]) new Object[capacity];
        for (int i = 0; i < capacity; i++) {
            tmp[i] = elements[i];
        }
        elements = tmp;
    }
    
    @Override
    public int size() {
        return effectiveSize;
    }

    @Override
    public boolean isEmpty() {
        return effectiveSize == 0;
    }

    @Override
    public void add(int index, E element) {
        if (element != null){
            if(index <= capacity-1){
                addCapacity(1);
                System.arraycopy(elements, index, elements, index+1, capacity-index);
                effectiveSize++;
            }else{
                System.out.println();//aqui debe arrojar excepcion
            }    
        }
    }

    public void add(E element){
        if (element != null){
            if(effectiveSize <= capacity-1){
                elements[effectiveSize] = element;
                effectiveSize++;
            }
        }
    }
    
    @Override
    public E remove(int index) {
        E elementQuit = null;
        if ( (index+1) == elements.length ){
            elementQuit = elements[index];
            lessCapacity();
            effectiveSize--;
        }else if(index > elements.length){
            System.out.println();//aqui debe arrojar excepcion
        }else{
            elementQuit = elements[index];
            System.arraycopy(elements, index+1, elements, index, elements.length-index-1);
            lessCapacity();
            effectiveSize--;
        }
        return elementQuit;
    }

    @Override
    public E get(int index) {
        E element = null;
        if ( (capacity-1) >= index){
            element = elements[index];
        }
        return element;
    }

    @Override
    public void clear() {
        for(int i = 0; i < elements.length; i++){
            elements[i] = null;
        }
    }
    
    public Iterator<E> iterator(){
        Iterator<E> it = new Iterator<E>() {
            int cursor = 0;
            @Override
            public boolean hasNext() {
                return cursor < effectiveSize;
            }

            @Override
            public E next() {
                E e =elements[cursor];
                cursor++;
                return e;
            }
        };
        return it;
    }
    
    public void set(int index, E element){
        if (element!=null) {
            if(index <= capacity-1){
                elements[index]=element;
            }
        }
    }
    
    public static void main(String args[]){
        ArrayList<Integer> al = new ArrayList(3);
        al.add(1);
        al.add(2);
        al.add(3);        
    }
}
