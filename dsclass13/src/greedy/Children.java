//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package greedy;

import java.util.Arrays;

public class Children {
    public Children() {
    }
    /*
    分发糖果：先排序再分发。
     */
    public static void main(String[] args) {
        int[] s = new int[]{4, 3, 3};
        int[] g = new int[]{2, 3, 4};
        Arrays.sort(s);
        Arrays.sort(g);
        int i = 0;
        int j = 0;
        int count = 0;

        while(i < s.length && j < g.length) {
            if (s[i] <= g[j]) {
                ++count;
                ++i;
                ++j;
            } else {
                ++j;
            }
        }

        System.out.println(count);
    }
}
