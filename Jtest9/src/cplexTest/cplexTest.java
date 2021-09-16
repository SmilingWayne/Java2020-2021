package cplexTest;


import java.util.Arrays;

import ilog.concert.*;
import ilog.cplex.IloCplex;


public class cplexTest {

    public static void main(String[] args) throws IloException {
        IloCplex cplex = new IloCplex();

        // define variables x0 x1 x2
        IloIntVar[][][] x = new IloIntVar[9][9][9];
        //System.out.println(x[0][0].length);

        for(int i = 0 ; i < 9 ; i ++ ){
            for(int j = 0 ; j < 9 ; j ++ ){
                for(int k = 0 ; k < 9 ; k ++ ){
                    x[i][j][k] = cplex.intVar(0,1,"x"+(i + 1) + (j+1) +(k + 1));
                }
            }
        }
        // objective
//		IloLinearNumExpr obj = cplex.linearNumExpr();
//		obj.addTerm(1, x[0]);
//		obj.addTerm(2, x[1]);
//		obj.addTerm(3, x[2]);
//		cplex.addMaximize(obj);

        cplex.addMinimize();
        // 这里怎么设置成可行解！！！

        for(int k = 0; k < 9; k ++ ){
            for(int i = 0; i < 9; i ++  ){
                IloLinearIntExpr r1 = cplex.linearIntExpr();
                for(int j = 0; j < 9; j ++ ){
                    r1.addTerm(1 , x[i][j][k]);
                }
                cplex.addEq(r1, 1, "r" + (i + 1));
            }
        }
        for(int k = 0; k < 9; k ++ ){
            for(int j = 0; j < 9; j ++ ){
                IloLinearIntExpr  c1 = cplex.linearIntExpr();
                for(int i = 0 ; i < 9 ; i ++ ){
                    c1.addTerm(1,x[i][j][k]);
                }
                cplex.addEq(c1, 1, "c" + (j + 1));
            }
        }
        for(int m = 0; m < 9; m ++ ) {
            for (int k = 0; k < 9; k++) {
                IloLinearIntExpr solo = cplex.linearIntExpr();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        solo.addTerm(1, x[i + (m/3) * 3][j + (m % 3) * 3][k]);
                    }
                }
                cplex.addEq(solo, 1, "z" + (m + 1) + (k + 1));
            }
        }
        for(int i = 0; i < 9; i ++ ){
            for(int j = 0; j < 9; j ++ ){
                IloLinearIntExpr b = cplex.linearIntExpr();
                for(int k = 0; k < 9; k ++ ){
                    b.addTerm(1,x[i][j][k]);
                }
                cplex.addEq(b, 1, "add" + (i+ 1) + "" + (j + 1));
            }
        }
        IloLinearIntExpr firstLine = cplex.linearIntExpr();
        firstLine.addTerm(1, x[0][0][0]);
        cplex.addEq(firstLine, 1, "F");
        // constraints
//        IloLinearNumExpr c1 = cplex.linearNumExpr();
//        c1.addTerm(-1, x[0]);
//        c1.addTerm(1, x[1]);
//        c1.addTerm(1, x[2]);
//        cplex.addLe(c1, 20, "c1");
//
//        IloLinearNumExpr c2 = cplex.linearNumExpr();
//        double[] a2 = {1, -3, 1};
//        c2.addTerms(a2, x);
//        cplex.addLe(c2, 30, "c2");

        // output model
        cplex.exportModel("example_2.lp");

        if (cplex.solve()) {
            System.out.println("Status: " + cplex.getStatus());
            // get optimal objective value
//            int[][][] ans = new int[9][9][9];
            //double[][][] ans = cplex.getValues(x);
            double [][][] ans = new double[9][9][9];
            for(int i = 0; i < 9; i ++ ){
                for(int j = 0; j < 9; j ++ ){
                    for(int k = 0 ;k < 9; k ++ ){
                        ans[i][j][k] = cplex.getValue(x[i][j][k]);
                    }
                }
            }
//            int count = 0;
//            for(int i = 0; i < 9; i ++ ){
//                for(int j = 0; j < 9; j ++ ){
//                    for(int k = 0; k < 9; k ++ ){
//                        if(ans[i][j][k] == 0){
//                            //System.out.print("Yes" + " ");
//                        }
//                        else{
//                            System.out.print(k + " ");
//                            count ++ ;
//                        }
//                    }
//                }
//                System.out.println("");
//            }
//            System.out.println("_____");
//            System.out.println(count);
//            int count1 = 0;
            System.out.println("\tFinal Matrix as Followed:");
            int[][] grid = new int[9][9];
            for(int i = 0; i < 9; i ++ ){
                for(int j = 0; j < 9; j ++ ){
                    for(int k = 0; k < 9; k ++ ){
                        if(ans[i][j][k] != 0){
                            grid[i][j] = k + 1;
                            //count1 ++ ;
                        }
                    }
                }
            }
            for(int i = 0 ; i < 9; i ++ ){
                System.out.print("\t\t");
                for(int j = 0 ; j < 9; j ++ ){
                    System.out.print(grid[i][j] + ",");
                }
                System.out.println("");
            }

            // get optimal solution value
            //double[] _x = cplex.getValues(x);
            //System.out.println("x = " + Arrays.toString(_x));

            // write solution to file
            cplex.writeSolution("example_2.xml");
        } else {
            System.err.println("Infeasible");
        }
    }
}


