package Queue;

public class Queue {
    int [] array;
    int size;
    int front;
    int rear;

    public Queue(int size) {
        this.size = size;
        array = new int[size];
        front = 0;
        rear = -1;
    }

    void enQueue(int x){
        if(isFull()){
            System.out.println("Queue is full..");
        }
        else{
        rear++;
        array[rear] = x;
            System.out.println("Added to queue : " + array[rear]);
        }
    }

    void deQueue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        else{
            int num = array[front];
            for( int i = 1; i <= rear; i++){
                array[i-1] = array[i];
            }
            rear--;
            System.out.println(num + " exlueded from queue");
        }
    }

    private boolean isEmpty() {
        return rear == -1;
    }

    private boolean isFull() {
        return (rear == size - 1);
    }


    void elementNumber(){
        System.out.println(rear + 1);
    }

    void print(){
        int i = rear;
        System.out.println("Tail ->");
        while (i >= 0){
            System.out.println(array[i] + " -> ");
            i--;
        }
        System.out.println("-> Head");
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enQueue(10);
        queue.enQueue(30);
        queue.enQueue(40);
        queue.enQueue(50);
        queue.enQueue(60);
        queue.enQueue(60);
        queue.print();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
    }
}