package Stack;

public class StackLinkList {

    Node top;
    int size;
    int count;

    public StackLinkList(int size) {
        this.size = size;
        count = 0;
        top = null;
    }

    void push(int x){
        Node element = new Node(x);
        if(isFull()){
            System.out.println("Stack is full!");
        }
        else{
            count++;
            if(isEmpty()){
                top = element;
                System.out.println("First element added:");
            }
            else{
                element.next = top;
                top = element;
                System.out.println("Element added: " + element.number);
            }
        }
    }

    void pop(){
        if(isEmpty()){
            System.out.println("Stack is empty!");
        }
        else{
            count--;
            top = top.next;
            System.out.println("Top changed and pop op. success.");
        }
    }

    boolean isFull(){
        return (count == size);
    }

    boolean isEmpty(){
        return count == 0;
    }

    void print(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        else{
            Node temp = top;

            while(temp != null){
                System.out.println(temp.number + " -> ");
                temp = temp.next;
            }
        }
    }


    public static void main(String[] args) {
        StackLinkList stackLinkList = new StackLinkList(10);

        stackLinkList.push(5);
        stackLinkList.push(6);
        stackLinkList.push(7);
        stackLinkList.push(9);

        stackLinkList.print();
    }
}
