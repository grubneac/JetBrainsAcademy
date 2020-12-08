package collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*Write a program that implements a simple load balancer.

The program must read tasks from the standard input and distribute them between two queues. Tasks will be processed by
a system (in the future). Each task has a unique identifier and a number indicating the load on the system (in parrots).
The balancer should distribute tasks between queues by the following rule: the task is added to the lower-load queue
(by the total load). If both queues have the same total load indicator, the task must be added to the first queue.
It's guaranteed, the input data contain at least two tasks.

Input data format
The first line contains the number of tasks. Other lines consist of task description: an identifier and a load
indicator (separated by a space).

Output data form
The first line should contain identifiers of tasks in the first queue, the second line should contain the
identifiers in the second queue.
*/
public class GreedyLoadBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currTask;
        int currWeight;
        List<Integer> query1 = new LinkedList<>();
        List<Integer> query2 = new LinkedList<>();
        int weigh1 = 0;
        int weigh2 = 0;

        int numTask = scanner.nextInt();
        for (int i = 0; i < numTask; i++) {
            currTask = scanner.nextInt();
            currWeight = scanner.nextInt();
            if (weigh1 <= weigh2) {
                query1.add(currTask);
                weigh1 += currWeight;
            } else {
                query2.add(currTask);
                weigh2 += currWeight;
            }
        }
        query1.forEach(x -> System.out.print(x + " "));
        System.out.println();
        query2.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }
}
