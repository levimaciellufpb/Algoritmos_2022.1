package org.ufpb.levi.codigos;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item>{
    //Primeiro item da fila
    private Node<Item> first;
    //Ultimo elemento da fila
    private Node<Item> last;
    //Tamanho da fila;
    private int N;


    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }

    public Queue(){
        first = null;
        last = null;
        N = 0;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    public Item peek(){
        if(isEmpty())
            throw new NoSuchElementException("Queue Underflow!");
        return first.item;
    }

    //Enfilera um elemento, o colocando no final da fila
    public void enqueue(Item item){
        //antigo último recebe o último
        Node<Item> oldLast = last;
        //O último elemento se torna agora o novo passado como parâmetro
        last = new Node<Item>();
        last.item = item;
        //O último elemento aponta para null, pois não existe mais nenhum elemento da fila
        last.next = null;
        //Se o item for o primeiro da fila, o primeiro também será o último
        if(isEmpty())
            first = last;
        //Se não, o antigo ultimo da fila vai apontar para o último.
        else{
            oldLast.next = last;
            N++;
        }
    }

    //Desenfilera um elemento, o removendo do início
    public Item dequeue(){
        if(isEmpty())
            throw new NoSuchElementException("Queue underflow");

        Item item = first.item;
        first = first.next;
        N--;

        if(isEmpty())
            last = null;

        return item;
    }

    @Override
    public String toString(){
        StringBuffer s = new StringBuffer();

    }
}
