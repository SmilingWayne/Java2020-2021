package polynomial;

public class Main{

    public static void main(String[] args){
        double[] coef1 = {3, 2, 1};
        int[] exp1 = {0, 1, 2};

        double[] coef2 = {-1, 1, -1};
        int[] exp2 = {0, 1, 2};

        Poly poly1 = new Poly(coef1, exp1);
        Poly poly2 = new Poly(coef2, exp2);
        System.out.println("poly1: " + poly1);
        System.out.println("poly2: " + poly2);
        poly1.add(poly2);
        System.out.println("poly1: " + poly1);
    }
}