package Queue;

public class QueueLinkList {
    Node front;
    Node rear;
    int count;
    int size;

    public QueueLinkList(int size) {
        this.size = size;
        count = 0;
        front = null;
        rear = null;
    }

    void enQueue(int x){
        if( isFull()){
            System.out.println("Queue is full..");
        }
        else{
            Node element = new Node(x);
            if(isEmpty()){
                front = element;
                rear = element;
                System.out.println("Queue created -> " + x);
                count++;
            }
            else{
                 rear.next = element;
                 rear = rear.next;
                System.out.println(x + " added to Queue");
                count++;
            }
        }
    }

    void deQueue(){
        if(isEmpty()){
            System.out.println("Queue is empty!");
        }else{
            System.out.println(front.num + "deleted!");
            front = front.next;
            count--;
        }
    }

    private boolean isEmpty() {
        return  count == 0;
    }

    private boolean isFull() {
        return count == size;
    }

    void print(){
        if(isEmpty()) System.out.println("Queue is empty!");
        else{
            Node temp = front;
            System.out.println("Front <-");
            while (temp != null){
                System.out.println(temp.num + " <-");
                temp = temp.next;
            }
            System.out.println("<- Rear");
        }
    }


    public static void main(String[] args) {
        QueueLinkList queueLinkList = new QueueLinkList(5);
        queueLinkList.enQueue(10);
        queueLinkList.enQueue(20);
        queueLinkList.enQueue(30);
        queueLinkList.enQueue(40);
        queueLinkList.enQueue(50);

        queueLinkList.deQueue();
        queueLinkList.deQueue();
        queueLinkList.deQueue();
        queueLinkList.print();
    }
}
