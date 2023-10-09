package Stack;

public class Stack {

    int array[];
    int size;
    int index;

    public Stack(int size) {
        this.size = size;
        array = new int[size];
        index = -1;
    }

    void push(int data){
        if(!isFull()){
            index++;
            array[index] = data;
            System.out.println("Push :" + array[index]);
        }else{
            System.out.println("Stack.Stack is full");
        }
    }

    int pop(){
        if(!isEmpty()){
            return array[index--];
        }
        else{
            System.out.println("Stack.Stack is empty!");
            return -1;
        }
    }

    boolean isFull(){
        return ( index == size-1);
    }

    boolean isEmpty(){
        return  ( index == -1);
    }

    void print(){
        int temp = index;
        while (temp > -1 ){
            System.out.println(array[temp] + " -> ");
            temp--;
        }


    }


    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(5);
        stack.push(2);
        stack.push(4);
        stack.push(6);

        System.out.println("Pop: " + stack.pop());


        stack.print();
    }
}
