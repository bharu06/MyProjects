package LRUcache;

import java.util.HashMap;

public class DLL {
    private Node head;
    private Node tail;
    private int size;

    DLL() {
        this.size = 0;
        this.head = null; //by default all refs are null.check safe side later
        this.tail = null;
    }

    public int getSize() {
        return size;
    }

    public Node getHead() {
        return head;
    }

    /**
     * Change 1-2-3-4-5 , to 3-1-2-4-5. if node is 3.
     * @param newNode
     */
    void putAtHead(Node newNode){
        Node temp = this.head;
        if (temp == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        size++;
    }

    Node removeNodeAtLast() {
        Node removedNode = this.tail;
        this.tail.prev.next = null;
        this.tail = this.tail.prev;
        size--;
        return removedNode;
    }

    void removeNodeAtRandom(Node nodeToRemove) {
        nodeToRemove.prev.next = nodeToRemove.next;
    }

    void printDLL() {
        Node temp = this.head;
        System.out.println("printing from head");
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
