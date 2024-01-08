/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ergjava2023.roundrobin;

/**
 *
 * @author frag.pel
 */class Queue {   
      
    public int front, rear, capacity;   
    public int queue[];   
     
    Queue(int size) {   
        front = rear = 0;   
        capacity = size;   
        queue = new int[capacity];   
    }   
     
    // insert an element into the queue  
     void queueEnqueue(int item)  {   
        // check if the queue is full  
        if (capacity == rear) {   
            System.out.printf("\nQueue is full\n");   
            return;   
        }   
     
        // insert element at the rear   
        else {   
            queue[rear] = item;   
            rear++;   
        }   
        return;   
    }   
     
    //remove an element from the queue  
     int queueDequeue()  {   
        // check if queue is empty   
        if (front == rear) {   
            System.out.printf("\nQueue is empty\n");   
            return -1;   
        }   
     
        // shift elements to the right by one place uptil rear   
        else {   
            for (int i = 0; i < rear - 1; i++) {   
                queue[i] = queue[i + 1];   
            }   
     
         
      // set queue[rear] to 0  
            if (rear < capacity)   
                queue[rear] = 0;   
     
            // decrement rear   
            rear--;   
        }   
        return queue[rear];   
    }   
     
    // print queue elements   
     void queueDisplay()   
    {   
        int i;   
        if (front == rear) {   
            System.out.printf("Queue is Empty\n");   
            return;   
        }   
     
        // traverse front to rear and print elements   
        for (i = front; i < rear; i++) {   
            System.out.printf(" %d , ", queue[i]);   
        }   
        return;   
    }   
     
    // print front of queue   
     void queueFront()   
    {   
        if (front == rear) {   
            System.out.printf("Queue is Empty\n");   
            return;   
        }   
        System.out.printf("\nFront Element of the queue: %d", queue[front]);   
        return;   
    }   

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }

    public int getCapacity() {
        return capacity;
    }

    public int[] getQueue() {
        return queue;
    }

    Queue() {
    }

     boolean isEmpty() {
        return front == rear;
    }
     
     void deleteX(int x) {
        int indexToDelete = -1;

        // Find the index of the element to delete
        for (int i = front; i < rear; i++) {
            if (queue[i] == x) {
                indexToDelete = i;
                break;
            }
        }

        // If the element is found, delete it
        if (indexToDelete != -1) {
            // Shift elements to the left to fill the gap
            for (int i = indexToDelete; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }

            // Set the last element to 0 and decrement rear
            queue[rear - 1] = 0;
            rear--;
        }
    }

    

}   
