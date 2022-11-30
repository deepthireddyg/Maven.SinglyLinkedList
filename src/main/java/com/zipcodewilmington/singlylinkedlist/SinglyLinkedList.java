package com.zipcodewilmington.singlylinkedlist;

import javax.xml.soap.Node;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T> {
    Node head;

    public class Node {

        public T data;
        public Node next;

        public Node(T data) {
            this.data = data;
            next = null;

        }

    }
       public SinglyLinkedList appendNode(SinglyLinkedList list,T data) {
            Node newnode = new Node(data);
            if (list.head == null) {
                list.head = new Node(data);
            } else {
                Node lastNode = head;

                while (lastNode.next != null)
                    lastNode = lastNode.next;
                lastNode.next = newnode;

            }
            return list;
        }
       public SinglyLinkedList removeNode(SinglyLinkedList list,T data){
           Node currentNode=head;
           Node previousNode=null;
           if(currentNode!=null && currentNode.data.equals(data)){
               list.head=currentNode.next;
               return list;
           }
           while (currentNode!=null && !currentNode.data.equals(data)){
               previousNode=currentNode;
               currentNode=currentNode.next;
           }
           if(currentNode!=null && currentNode.data.equals(data))
               previousNode.next=currentNode.next;

           return list;
       }
    public boolean containsNode(SinglyLinkedList list,T data){

        Node currentNode=head;
        int count = 0;
        while(currentNode!=null){
            count++;
            currentNode=currentNode.next;
        }
        return false;
    }
    public int findNodeIndex(SinglyLinkedList list,T data) {
        int index = -1;
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                index++;
                return index;
            }
            index++;
            currentNode = currentNode.next;

        }
        return -1;
    }
    public int sizeList(SinglyLinkedList list){

        Node currentNode = head;
        int count = 0;
        while(currentNode!= null){
            count++;
            currentNode=currentNode.next;
        }
        return count;
    }
    public Object getNode(SinglyLinkedList lst,int index){
        Node currentNode = head;
        int counter=0;
        while(currentNode!=null){
            if(counter==index)
                return currentNode.next;
        }
        return null;
    }
    public SinglyLinkedList copyList(SinglyLinkedList lstSource){
        SinglyLinkedList lst = new SinglyLinkedList();
        Node temp = lstSource.head;
        while(temp.next!=null){
            lst.appendNode(lst,temp.data);
            temp=temp.next;
        }
        return lst;
    }
    public SinglyLinkedList sortList(SinglyLinkedList lst){
        int size = lst.sizeList(lst);
        Node current=lst.head;
        Node index = null;
        while(current!=null){
            index=current.next;
            while(index!=null){
                if((Integer) current.data>(Integer) index.data){
                    T temp = current.data;
                    current.data = index.data;
                    index.data=temp;

                }
                index = index.next;
            }
            current = current.next;
        }
       return lst;
    }
    public String print(SinglyLinkedList list){
        StringBuilder sb=new StringBuilder();
        Node currentNode=head;
        while(currentNode!=null){
            sb.append(currentNode.data+" ");
            currentNode=currentNode.next;
        }
        return sb.toString();
    }
    }
