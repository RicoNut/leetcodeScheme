package array;

/**
 * @author alis
 * @date 2019/10/17 1:09 AM
 * @description
 */
public class LC_70_ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new LC_70_ClimbingStairs().climbStairs_memory(4));
    }

    /**
     * @param n
     * @return int
     * @author Rico
     * @description 斐波那契数动态规划
     * @date 2019/10/17 1:14 AM
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int p1 = 1, p2 = 2, p3 = 3;
        for (int i = 3; i < n + 1; i++) {
            p3 = p1 + p2;
            p1 = p2;
            p2 = p3;
        }
        return p3;
    }

    /**
     * @param n 楼梯阶梯
     * @return int
     * @author Rico
     * @description 递归缓存法 O(n)
     * @date 2019/10/17 1:19 AM
     */
    public int climbStairs_memory(int n) {

        return climbingStairs(0, n, new int[n + 1]);
    }

    private int climbingStairs(int i, int n, int[] memory) {
        if (i > n) return 0;
        if (i == n) return 1;
        if (memory[i] > 0) {
            return memory[i];
        }

        memory[i] = climbingStairs(i + 1, n, memory) + climbingStairs(i + 2, n, memory);
        return memory[i];
    }


}
