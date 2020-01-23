package interview.baidu;

/**
 * @author Xiaoming.
 * Created on 2019/09/17 18:53.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static class Task implements Comparable {
        int needTime;
        int limitTime;

        public Task(int needTime, int limitTime) {
            this.needTime = needTime;
            this.limitTime = limitTime;
        }

        @Override
        public int compareTo(Object o) {
            return this.limitTime - ((Task) o).limitTime;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int num = in.nextInt();
        int taskCount;

        Task[][] tasks = new Task[num][];

        int limit, need;
        for (int i = 0; i < num; i++) {
            taskCount = in.nextInt();
            tasks[i] = new Task[taskCount];
            for (int j = 0; j < taskCount; j++) {
                need = in.nextInt();
                limit = in.nextInt();
                tasks[i][j] = new Task(need, limit);
            }
        }

        boolean completed = true;
        for (int i = 0; i < num; i++) {
            completed = canCompleteTask(tasks[i]);
            System.out.println(completed ? "Yes" : "No");
        }
    }

    private static boolean canCompleteTask(Task[] tasks) {
        Arrays.sort(tasks);
        int sum = 0;
        for (Task t : tasks) {
            sum += t.needTime;
            if (sum > t.limitTime) {
                return false;
            }
        }

        return true;
    }
}
