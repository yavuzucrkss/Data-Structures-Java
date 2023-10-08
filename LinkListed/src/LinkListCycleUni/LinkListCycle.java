package LinkListCycleUni;

public class LinkListCycle {
    Node head= null;
    Node tail =null;

    void insertHead(int x){
        Node element = new Node(x);
        if( head == null){
            head = element;
            tail = element;
            tail.next = head;
        }
        else{
            element.next = head;
            head = element;
            tail.next = head;
        }
    }

    void insertTail(int x){
        Node element = new Node(x);
        if( head == null){
            head = element;
            tail = element;
            tail.next = head;
        }
        else{
            tail.next = element;
            tail = element;
            tail.next = head;
        }
    }

    void insertByIndex(int index, int x){
        if(index == 0){
            insertHead(x);
        }
        else if(index == findLength() - 1){
            insertTail(x);
        }
        else{
            Node element = new Node(x);
            Node temp = head;
            Node temp2 = head;
            int count = 0;
            while(count != index){
                temp2 =temp;
                temp = temp.next;
                count++;
            }
            temp2.next = element;
            element.next = temp;

        }

    }

    void deleteHead(){
        if(head == null){
            System.out.println("List is empty!");
        }
        else if(head == tail){
            head = null;
            tail = null;
        }
        else{
            head = head.next;
            tail.next = head;
        }
    }


    void deleteTail(){
        if(head == null){
            System.out.println("List is empty!");
        }
        else if(head == tail){
            head = null;
            tail = null;
        }
        else{
            Node temp = head;
            while(temp.next != tail){
                temp = temp.next;
            }
            tail = temp;
            tail.next = head;
        }
    }

    void deleteByIndex(int index){
        if(index == 0){
            deleteHead();
        }
        else if(index == findLength()){
            deleteTail();
        }
        else{
            Node temp = head;
            Node temp2 = head;
            int count = 0;
            while(count != index){
                temp2 = temp;
                temp = temp.next;
                count++;
            }
            temp2.next = temp.next;
        }
    }


    int findLength(){
        int count = 0;
        Node temp = head;

        while(temp != tail){
            temp = temp.next;
            count++;
        }
        return count;
    }

    void print(){
        if(head == null){
            System.out.println("List is empty");
        }
        else{
            Node temp = head;
            System.out.println("Head -> ");
            while(temp != tail){
                System.out.println(temp.number + " -> ");
                temp = temp.next;
            }
            System.out.println(temp.number + " -> ");
            System.out.println(" -> Tail");
        }
    }

    public static void main(String[] args) {
        LinkListCycle linkListCycle = new LinkListCycle();

        linkListCycle.insertHead(2);
        linkListCycle.insertHead(1);
        linkListCycle.insertTail(3);
        linkListCycle.insertTail(4);
        linkListCycle.insertByIndex(3,5);

        linkListCycle.deleteByIndex(2);

        linkListCycle.print();
    }
}
