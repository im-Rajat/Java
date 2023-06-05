package leetcode;

class Node {
    int data;
    Node next;

    Node() {}
    Node(int data) {
        this.data = data;
        this.next = null;
    }
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class LinkedList {

    public static void main(String[] args) {
        Node n5 = new Node(5);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);

        printLinkedList(n1);
    }


    public static void printLinkedList(Node head) {
        while(head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
    }

}
