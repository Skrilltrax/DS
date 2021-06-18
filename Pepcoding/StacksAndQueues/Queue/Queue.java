public class Queue {

    protected int arr[];
    protected int size;
    protected int front;
    protected int rear;

    public Queue() {
        this.size = 10;
        this.arr = new int[size];
        this.front = -1;
        this.size = -1;

    }

    public Queue(int size) {
        this.size = size;
        this.arr = new int[size];
        this.front = -1;
        this.size = -1;
    }

    private int getModulus(int rear) {
        return rear % size;
    }

    public void push(int data) throws Exception {
        if (getModulus(rear + 1) == front) {
            throw new Exception("Queue is full");
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        }
        arr[rear++] = data;
    }

    public void pop() throws Exception {
        if (getModulus(front) == rear) {
            throw new Exception("Queue is empty");
        }
        if (front + 1 == rear) {
            front = rear = -1;
        } else {
            front++;
        }
    }

    public int top() throws Exception {
        if (front == -1) {
            throw new Exception("Queue is empty");
        } else {
            return arr[front];
        }
    }
}