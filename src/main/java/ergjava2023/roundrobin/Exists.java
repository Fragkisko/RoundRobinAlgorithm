/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ergjava2023.roundrobin;

/**
 *
 * @author frag.pel
 */
class Exists {
    // check if an ID exists in the queue
 public static boolean doesIdExist(Queue queue, int targetId) {
        int front = 0;
        int rear = queue.getRear();

        for (int i = front; i < rear; i++) {
            if (queue.getQueue()[i] == targetId) {
                return true; // ID found in the queue
            }
        }

        return false; // ID not found in the queue
    }
}