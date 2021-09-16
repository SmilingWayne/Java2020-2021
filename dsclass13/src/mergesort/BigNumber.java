//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package mergesort;
//有问题啊！！！
import java.util.ArrayList;

public class BigNumber {
    public BigNumber() {
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> c = new ArrayList();
        int i = a.size() - 1;
        int j = b.size() - 1;

        int d;
        int ret;
        for(d = 0; i >= 0 && j >= 0; --j) {
            ret = (Integer)a.get(i) + (Integer)b.get(j) + d;
            c.add(0, ret % 10);
            d = ret / 10;
            --i;
        }

        while(i >= 0) {
            ret = (Integer)a.get(i) + d;
            c.add(0, ret % 10);
            d = ret / 10;
            --i;
        }

        while(j >= 0) {
            ret = (Integer)b.get(j) + d;
            c.add(0, ret % 10);
            d = ret / 10;
            --j;
        }

        if (d > 0) {
            c.add(0, d);
        }

        return c;
    }

    public static int array2int(ArrayList<Integer> a) {
        int ret = 0;
        int d = 1;

        for(int i = a.size() - 1; i >= 0; --i) {
            ret += (Integer)a.get(i) * d;
            d *= 10;
        }

        return ret;
    }

    public static ArrayList<Integer> int2array(int a) {
        ArrayList ret;
        for(ret = new ArrayList(); a > 0; a /= 10) {
            ret.add(0, a % 10);
        }

        return ret;
    }

    public static ArrayList[] divide(ArrayList<Integer> a) {
        ArrayList[] b = new ArrayList[]{new ArrayList(), null};

        int i;
        for(i = 0; i < a.size() - 5; ++i) {
            b[0].add(a.get(i));
        }

        b[1] = new ArrayList();

        for(i = a.size() - 5; i < a.size(); ++i) {
            b[1].add(a.get(i));
        }

        return b;
    }

    public static ArrayList<Integer> partition(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a.size() <= 5 && b.size() <= 5) {
            int aint = array2int(a);
            int bint = array2int(b);
            return int2array(aint * bint);
        } else {
            ArrayList[] c;
            ArrayList d;
            ArrayList e;
            if (a.size() > 5 && b.size() > 5) {
                c = divide(a);
                c = divide(b);
                d = partition(c[0], c[0]);
                e = partition(c[0], c[1]);
                ArrayList<Integer> ret3 = partition(c[1], c[0]);
                ArrayList<Integer> ret4 = partition(c[1], c[1]);

                int i;
                for(i = 0; i < 10; ++i) {
                    d.add(0);
                }

                for(i = 0; i < 5; ++i) {
                    e.add(0);
                    ret3.add(0);
                }

                return merge(d, merge(e, merge(ret3, ret4)));
            } else {
                ArrayList<Integer> temp = null;
                if (a.size() <= 5) {
                    temp = a;
                    a = b;
                    b = temp;
                }

                c = divide(a);
                d = partition(c[0], b);
                e = partition(c[1], b);

                for(int i = 0; i < 5; ++i) {
                    d.add(0);
                }

                return merge(d, e);
            }
        }
    }

    public static ArrayList<Integer> string2array(String a) {
        ArrayList<Integer> b = new ArrayList();

        for(int i = 0; i < a.length(); ++i) {
            b.add(Integer.parseInt(a.substring(i, i + 1)));
        }

        return b;
    }

    public static String array2string(ArrayList<Integer> a) {
        String b = "";

        for(int i = 0; i < a.size(); ++i) {
            b = b + a.get(i);
        }

        return b;
    }

    public static void main(String[] args) {
        String a = "123456";
        String b = "987654";
        ArrayList<Integer> c = string2array(a);
        ArrayList<Integer> d = string2array(b);
        ArrayList<Integer> e = partition(c, d);
        System.out.println(array2string(e));
    }
}
