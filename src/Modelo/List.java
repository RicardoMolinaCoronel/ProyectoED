/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

/**
 *
 * @author rdavi
 * @param <E>
 */
public interface List<E> {
    public int size();
    
    public boolean isEmpty();
    
    public void add(int index, E element);
    
    public E remove(int index);
    
    public E get(int index);
    
    public void clear();
    
    public void set(int index, E element);
}
