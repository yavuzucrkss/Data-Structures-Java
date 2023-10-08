package LinkListCycleBi;

public class LinkListCycleBi {
    Node head = null;
    Node tail = null;

    void insertHead(int x){
        Node element = new Node(x);
        if(head == null){
            head = element;
            tail = element;
            head.next = tail;
            head.prev = tail;
            tail.next = head;
            tail.prev = head;
        }
        else{
            element.next = head;
            head.prev = element;
            head = element;
            tail.next = head;
            head.prev = tail;
        }
    }

    void insertTail(int x){
        Node element = new Node(x);
        if(head == null){
            head = element;
            tail = element;
            head.next = tail;
            head.prev = tail;
            tail.next = head;
            tail.prev = head;
        }
        else{
            tail.next = element;
            element.prev = tail;
            tail = element;
            tail.next = head;
            head.prev = tail;
        }
    }

    void insertByIndex(int index, int x){
        if(index == 0){
            insertHead(x);
        }
        else if(index >= findLength()){
            insertTail(x);
        }
        else {
            Node element = new Node(x);
            int n = 0;
            Node temp = head;
            while(n != index){
                temp = temp.next;
                n++;
            }
            element.prev = temp.prev;
            temp.prev.next = element;
            element.next = temp;
            temp.prev = element;

        }
    }

    int findLength(){
        int count = 0;
        Node temp = head;
        while(temp != tail){
            temp = temp.next;
            count++;
        }
        return  count;
    }


    void deleteHead(){
        if(head == null){
            System.out.println("List is empty");
        }
        else if(head == tail){
            head = null;
            tail = null;
        }
        else{
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
    }

    void deleteTail(){
        if(head == null){
            System.out.println("List is empty");
        }
        else if(head == tail){
            head = null;
            tail = null;
        }
        else{
            tail = tail.prev;
            tail.next =head;
            head.prev = tail;
        }
    }

    void deleteByIndex(int index){
        if(index == 0){
            deleteHead();
        }
        else if(index >= findLength()){
            deleteTail();
        }
        else{
            Node temp = head;
            int i = 0;
            while( i != index){
                temp=temp.next;
                i++;
            }
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;

        }
    }

    void printForward(){
        if(head == null){
            System.out.println("List is empty");
        }
        else {
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

    void printBackward(){
        if(head == null){
            System.out.println("List is empty");
        }
        else {
            Node temp = tail;
            System.out.println("Head -> ");
            while(temp != head){
                System.out.println(temp.number + " -> ");
                temp = temp.prev;
            }
            System.out.println(temp.number + " -> ");
            System.out.println(" -> Tail");
        }
    }


    public static void main(String[] args) {
        LinkListCycleBi linkListCycleBi = new LinkListCycleBi();

        linkListCycleBi.insertHead(2);
        linkListCycleBi.insertHead(1);
        linkListCycleBi.insertTail(3);
        linkListCycleBi.insertTail(4);
        linkListCycleBi.insertByIndex(4,6);
        linkListCycleBi.deleteByIndex(6);

        linkListCycleBi.printBackward();
        linkListCycleBi.printForward();

    }
}
