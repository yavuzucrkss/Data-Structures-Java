public class LinkedListBidirectional {

    NodeBiDirectional head = null;
    NodeBiDirectional tail = null;

    void addHead(int x) {
        NodeBiDirectional element = new NodeBiDirectional(x);

        if (head == null) {
            head = element;
            tail = element;
        } else {
            element.next = head;
            head.prev = element;
            head = element;
        }
    }

    void addTail(int x) {
        NodeBiDirectional element = new NodeBiDirectional(x);

        if (head == null) {
            head = element;
            tail = element;
        } else {
            tail.next = element;
            element.prev = tail;
            tail = element;
        }
    }

    void insertBetween(int index, int x) {

        if (index == 0) {
            addHead(x);
        } else if (findListLength() == index) {
            addTail(x);
        } else if (findListLength() < index) {
            System.out.println("Index is too high!");
        } else {
            NodeBiDirectional element = new NodeBiDirectional(x);
            NodeBiDirectional temp = head;
            int count = 0;
            while (count != index) {
                temp = temp.next;
                count++;
            }
            element.prev = temp.prev;
            temp.prev.next = element;
            element.next = temp;
            temp.prev = element;

        }


    }

    void deleteHead() {
        if (head != null) {
            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        }
    }

    void deleteLast() {
        if(head != null){
            if(head.next == null){
                head = null;
                tail = null;
            }
            else{
                tail = tail.prev;
                tail.next = null;
            }
        }
    }

    void deleteByIndex(int index){
        if(index == 0){
            deleteHead();
        }
        else if(index == findListLength()){
            deleteLast();
        }
        else{
            int count = 0;
            NodeBiDirectional temp = head;
            while(count != index){
                temp = temp.next;
                count++;
            }
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;

        }
    }


    int findListLength(){
        int count = 0;
        NodeBiDirectional temp = head;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return  count;
    }

    void printForward() {
        NodeBiDirectional temp = head;
        System.out.println("Head -> ");
        while (temp != null) {
            System.out.println(temp.number + " -> ");
            temp = temp.next;
        }
        System.out.println(" -> Tail");
    }

    void printBackward() {
        NodeBiDirectional temp = tail;
        System.out.println("Tail -> ");
        while (temp != null) {
            System.out.println(temp.number + "-> ");
            temp = temp.prev;
        }
        System.out.println("Head -> ");

    }


    //-------------------------------- Main ----------------------------------
    public static void main(String[] args) {
        LinkedListBidirectional linkedListBidirectional = new LinkedListBidirectional();

        linkedListBidirectional.addHead(5);
        linkedListBidirectional.addHead(45);
        linkedListBidirectional.addTail(34);
        linkedListBidirectional.addTail(53);
        linkedListBidirectional.insertBetween(2, 32);


        linkedListBidirectional.printForward();
        linkedListBidirectional.printBackward();

    }
}
