package leetCode;

import java.util.*;

/**
 * @author Xiaoming.
 * Created on 2019/07/20 14:52.
 */
public class IntegerSum {
    public int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int v2 = target - nums[i];
            if (map.containsValue(v2)) {
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == v2) {
                        return new int[]{entry.getKey(), i};
                    }
                }
            }
            map.put(i, nums[i]);
        }
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum_0(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[][] threeSum(int[] nums, int target) {
        List<Integer[]> res = new LinkedList<>();
        final int length = nums.length;
        Arrays.sort(nums); // 先排个队，最左边是最弱（小）的，最右边是最强(大)的
        if (nums[0] <= 0 && nums[length - 1] >= 0) { // 优化1: 整个数组同符号，则无解
            for (int i = 0; i < length - 2; ) {
                if (nums[i] > 0) break; // 优化2: 最左值为正数则一定无解
                int first = i + 1;
                int last = length - 1;
                do {
                    if (first >= last || nums[i] * nums[last] > 0) break; // 两人选相遇，或者三人同符号，则退出

                    int result = nums[i] + nums[first] + nums[last];
                    if (result == target) { // 如果可以组队
                        res.add(new Integer[]{nums[i], nums[first], nums[last]});
                    }
                    if (result <= target) { // 实力太弱，把菜鸟那边右移一位
                        while (first < last && nums[first] == nums[++first]) {
                        } // 如果相等就跳过
                    } else { // 实力太强，把大神那边右移一位
                        while (first < last && nums[last] == nums[--last]) {
                        }
                    }
                } while (first < last);
                while (nums[i] == nums[++i]) {
                }
            }
        }
        int[][] ans = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = new int[3];
            Integer[] t = res.get(i);
            for (int j = 0; j < 3; j++) {
                ans[i][j] = t[j];
            }
        }
        return ans;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j - i > 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if (nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) continue;

                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    int tmp = nums[i] + nums[j] + nums[left] + nums[right];
                    if (tmp == target) {
                        List<Integer> tmpList = new LinkedList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        res.add(tmpList);
                        while (left < right && nums[left] == nums[left + 1]) left += 1;
                        while (left < right && nums[right] == nums[right - 1]) right -= 1;
                        left += 1;
                        right -= 1;
                    } else if (tmp > target) right -= 1;
                    else left += 1;
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int[] e : threeSum(new int[]{-1, 0, 1, 2, -1, -4}, 0)) {
            sb.append(Arrays.toString(e));
        }
        System.out.println(sb.toString());
    }
}
