package leetCode;

import com.xiaoming.util.RandomArray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Xiaoming.
 * Created on 2019/07/29 16:05.
 */
public class ArraysAlg {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        int length = nums.length;
        Arrays.sort(nums); // 先排个队，最左边是最弱（小）的，最右边是最强(大)的
        if (nums[0] <= 0 && nums[length - 1] >= 0) { // 优化1: 整个数组同符号，则无解
            for (int i = 0; i < length - 2; ) {
                if (nums[i] > 0) break; // 优化2: 最左值为正数则一定无解
                int first = i + 1;
                int last = length - 1;
                do {
                    if (first >= last || nums[i] * nums[last] > 0) break; // 两人选相遇，或者三人同符号，则退出
                    int result = nums[i] + nums[first] + nums[last];
                    if (result == 0) { // 如果可以组队
                        res.add(List.of(nums[i], nums[first], nums[last]));
                    }
                    if (result <= 0) { // 实力太弱，把菜鸟那边右移一位
                        while (first < last && nums[first] == nums[++first]) ; // 如果相等就跳过
                    } else { // 实力太强，把大神那边右移一位
                        while (first < last && nums[last] == nums[--last]) ;
                    }
                } while (first < last);
                while (nums[i] == nums[++i]) ;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(threeSum(RandomArray.duplicateRandomArray(10, -5, 3)));

    }
}
