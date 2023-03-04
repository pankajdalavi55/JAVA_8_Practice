package dataStructure.linkedList;

import java.util.List;

public class LinkedListImpl {
    private ListNode head;
    private int length = 0;

    // adding element into the list
    // insert the element at first
    ListNode addElementToFirst(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
        return head;
    }

    // insert the element at last

    ListNode addElementAtLast(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            length++;
            return head;
        }

        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;

        length++;
        return curr;
    }

    // insert element at some position
    void addElementAtPosition(int data, int pos) {
        ListNode newNode = new ListNode(data);
        if (pos > length) {
            throw new ArrayIndexOutOfBoundsException("Linked list dont have that index");
        }
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            int count = 1;
            ListNode previous = head;
            while (count < pos - 1) { // <-- imp 1<2
                previous = previous.next;
                count++;
            }

            newNode.next = previous.next;
            previous.next = newNode;
        }

        length++;
    }

    // Remove
    //1. remove element from Linked List
    void removeElementFromFirst() {
        if (head == null) {
            System.out.println("Linked list Is Empty..!");
            return;
        }
        head = head.next;
        length--;
    }

    //2. remove element from last
    void removeElementFromLast() {
        if (head == null) {
            System.out.println("Linked List is Empty");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            ListNode last = head;
            while (last.next.next != null) {
                last = last.next;
            }
            last.next = null;
        }
        length--;
    }

    // 3. remove element at position
    void removeElementAtPosition(int pos) {
        if (head == null) {
            System.out.println("Linked List is empty..");
        }
        if (pos > length) {
            System.out.println("Linked list having length " + length + " cant access position :" + pos);
        }
        if (pos == 1) {
            head = head.next;
        } else {
            ListNode previous = head;
            int count = 1;
            if (count < pos - 1) {
                previous = previous.next;
            }
            ListNode current = previous.next;
            previous.next = current.next;
            current.next = null;
        }
        length--;
    }

    // find middle element in linked list

    ListNode getMiddleElement() {
        //TODO
        if (head == null) {
            System.out.println("Linked List is Empty..!");
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // reverse the linked list
    void reverseLinkedList() {
        if (head == null) {
            System.out.println("List is Empty..!");
            return;
        }
        if (head.next != null) {
            ListNode current = head;
            ListNode previous = null;
            ListNode next = null;
            while (current != null) {
                //first set next
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            head = previous;
        }

    }


    void printLinkedList() {
        if (head == null) {
            System.out.println("Empty Linked List ..!");
            return;
        }
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListImpl ll = new LinkedListImpl();
        ll.addElementAtLast(1);
        ll.addElementToFirst(5);
        ll.addElementAtLast(89);
        ll.addElementAtPosition(22, 3);
        ll.printLinkedList();

        ll.removeElementFromFirst();
        ll.printLinkedList();
        ll.addElementToFirst(36);

        ll.removeElementFromLast();
        ll.printLinkedList();

        ll.removeElementAtPosition(2);
        ll.printLinkedList();

        ll.removeElementAtPosition(1);
        ll.printLinkedList();

        ll.removeElementFromLast();
        ll.removeElementFromLast();
        ll.printLinkedList();

        System.out.println("Find middle poc");
        ll.getMiddleElement();
        ll.addElementToFirst(1);
        ll.printLinkedList();
        System.out.println(ll.getMiddleElement().toString());

        ll.addElementAtLast(34);
        System.out.println(ll.getMiddleElement().toString());

        ll.addElementAtLast(3);
        System.out.println(ll.getMiddleElement().toString());

        ll.addElementAtLast(90);
        System.out.println(ll.getMiddleElement().toString());

        ll.addElementAtLast(55);
        System.out.println(ll.getMiddleElement().toString());

        System.out.println("before reverse: ");
        ll.printLinkedList();
        ll.reverseLinkedList();
        System.out.println("after reverse: ");
        ll.printLinkedList();


        ll.removeAllElement();
        ll.printLinkedList();

    }

    private void removeAllElement() {
        if (head == null) {
            System.out.println("Linked List is already empty..!");
        }
        head = null;
        length = 0;
    }
}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
