package logisticmanagement;

import ilog.concert.*;
import ilog.cplex.IloCplex;

public class logistic {
    public static void main(String[] args) throws IloException {
        IloCplex cplex = new IloCplex();
        IloIntVar[][] x = new IloIntVar[8][4];
//        IloIntVar[] c = new IloIntVar[4];
        IloNumExpr[] a = new IloNumExpr[4];
        for(int i = 0; i < 4; i ++ ){
            a[i] = cplex.numVar(0, 1, IloNumVarType.Int, "a" + (i+1));
        }
        for(int i = 0 ; i < 8 ; i ++ ){
            for(int j = 0 ; j < 4 ; j ++ ){
                x[i][j] = cplex.intVar(0,1,"x"+(i + 1) + (j + 1));
            }
        }
        int[][] c = {{4,12,20,6},{2,10,25,10},{3,4,16,14},{6,5,9,2},{18,12,7,3},{14,4,4,9},{20,30,2,11},{24,12,6,22}};
        int[] d = {100,50,120,80,200,70,60,60,100};
        IloLinearNumExpr obj = cplex.linearNumExpr();
//        for(int j = 0 ; j < 4; j ++ ){
//            for(int i = 0 ; i < 8 ; i ++ ){
//                obj.addTerm(c[i][j], a[j]*x[i][j]);
//            }
//        }
    }
}
