package LinkedListUniDirectional;

import java.util.Scanner;

public class ListStructureOneDirection {
    Node head = null;
    Node tail = null;

    void add(int x) {
        Node element = new Node();
        element.number = x;
        element.next = null;
        if (head == null) {
            head = element;
            tail = element;
            System.out.println("List created!");
        } else {
            tail.next = element;
            tail = element;
            System.out.println("New element added to tail of list: " + x);
        }
    }

    void prepend(int x) {
        Node element = new Node();
        element.number = x;

        if (head == null) {
            element.next = null;
            head = element;
            tail = element;
            System.out.println("List created and head assigned");
        } else {
            element.next = head;
            head = element;
            System.out.println("Added element to head");
        }
    }

    void addLast(int x) {
        Node element = new Node();
        element.number = x;

        if (head == null) {
            element.next = null;
            head = element;
            tail = element;
            System.out.println("List created and head assigned");
        } else {
            tail.next = element;
            tail = element;
            System.out.println("Element added to last");
        }
    }

    void insert(int index, int x) {

        if (index == 0) {
            prepend(x);
        } else {
            int n = 0;
            Node temp = head;
            Node temp2 = head;
            while (temp.next != null) {
                n++;
                temp2 = temp;
                temp = temp.next;
            }

            if (n == index) {
                addLast(x);
            } else {
                Node element = new Node();
                element.number = x;
                temp = head;
                temp2 = head;
                int i = 0;
                while (i < index) {
                    temp2 = temp;
                    temp = temp.next;
                    i++;
                }

                temp2.next = element;
                element.next = temp;
                System.out.println("Element added to index of " + index);
            }
        }

    }


    void deleteHead() {
        if (head == null) {
            System.out.println("List empty");
        } else if (head.next == null) {
            head = null;
            tail = null;
            System.out.println("List deleted!");
        } else {
            head = head.next;
            System.out.println("First element is deleted new first is " + head.number);
        }
    }

    void deleteTail() {
        if (head == null) {
            System.out.println("List empty");
        } else if (head.next == null) {
            head = null;
            tail = null;
            System.out.println("List deleted!");
        } else {
            Node temp = head;
            Node temp2 = head;
            while (temp.next != null) {
                temp2 = temp;
                temp = temp.next;
            }
            temp2.next = null;
            tail = temp2;

            System.out.println("Last element is deleted new last is " + head.number);
        }
    }


    void delete(int index) {
        int n = 0;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            n++;
        }
        if (index == 0) {
            deleteHead();
        } else if (index == n) {
            deleteTail();
        } else {
            n = 0;
            temp = head;
            Node temp2 = head;
            while (n != index) {
                temp2 = temp;
                temp = temp.next;
                n++;
            }
            temp2.next = temp.next;
            System.out.println("The element in between deleted!");
        }
    }

    void print() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            System.out.println("Head -> ");
            while (temp != null) {
                System.out.println(temp.number + " -> ");
                temp = temp.next;
            }
            System.out.println("-> Tail");
        }
    }


    //-------------------------------- Main ----------------------------------
    public static void main(String[] args) {
        ListStructureOneDirection listStructure = new ListStructureOneDirection();

        int choose = 99;
        int x, index;

        Scanner scanner = new Scanner(System.in);

        while (choose != 0) {

            System.out.println("Add head 1");
            System.out.println("Add last 2");
            System.out.println("Add between 3");
            System.out.println("Delete head 4");
            System.out.println("Delete last 5");
            System.out.println("Delete with index 6");
            System.out.println("0 exit..");
            System.out.println("Choose ?");

            choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("Enter will added number ...");
                    x = scanner.nextInt();
                    listStructure.add(x);
                    break;
                case 2:
                    System.out.println("Enter will added number(last) ...");
                    x = scanner.nextInt();
                    listStructure.addLast(x);
                    break;
                case 3:
                    System.out.println("Index and x please..");
                    index = scanner.nextInt();
                    x = scanner.nextInt();
                    listStructure.insert(index,x);
                    break;
                case 4:
                    System.out.println("Deleting head..");
                    listStructure.deleteHead();
                    break;
                case 5:
                    System.out.println("Deleting last..");
                    listStructure.deleteTail();
                    break;
                case 6:
                    System.out.println("Index for deleting element..");
                    index = scanner.nextInt();
                    listStructure.delete(index);
                    break;
                default:
                    break;
            }
            listStructure.print();
        }
    }
}


