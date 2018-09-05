/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

/**
 *
 * @author dospino17
 */
public class Cola<E> {

    private Nodo top, end;
    private int size;

    public Cola() {
        this.top = this.end = null;
        this.size = 0;
    }

    public void enqueue(E valor) { //en cola
        Nodo<E> nodo = new Nodo(valor);
        if (top == null) { // Cola vacia?
            this.top = this.end = nodo;
        } else {
            this.end.setLink(nodo);
            this.end = nodo;
        }
        this.size++;
    }

    public Nodo<E> dequeue() {//de cola
        if (top == null) // cola esta vacia?
        {
            return null;
        } else {
            Nodo<E> nodo = this.top;
            this.top = this.top.getLink();
            this.size--;
            return nodo;
        }
    }
public  E First() {
        if (isEmpty()) {
            
            return null;
        }

        return (E) top.getValor();
    }
    public Nodo<E> peek() {//ojeada
        return this.top;
    }

    public int getSize() { //tamaño
        return this.size;
    }

    public boolean isEmpty() {// vacio
        return top == null;
    }

    public Nodo<E> getEnd() {//final
        return this.end;
    }

    public void display() {//monitor
        Nodo<E> nodo = this.top;
        System.out.println("La Cola de tamaño " + this.getSize() + " es la siguiente:");
        while (nodo != null) {
            System.out.println(nodo.getValor().toString());
            nodo = nodo.getLink();
        }

    }
}
