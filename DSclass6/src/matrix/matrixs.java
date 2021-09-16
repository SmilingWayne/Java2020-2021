package matrix;


public class matrixs{

    public final int MAX_SIZE = 1000;

    public triple[] base;

    /** number of non-zero elements */
    public int tot;

    /** number of rows */
    public int n;

    /** number of columns */
    public int m;

    /** rpos[i]: the position of the first element in array base whose row index is equal to i */
    public int[] rpos;

    public matrixs(){
        base = new triple[MAX_SIZE];
        m = 0;
        n = 0;
        tot = 0;
        rpos = null;
    }

    public void initialize_rpos(){
        rpos = new int[m + 1];
        for(int i = 0; i < rpos.length; i++){
            rpos[i] = -1;
        }
        for(int i = 0; i < tot; i++){
            triple triple = base[i];
            if(rpos[triple.i] < 0){
                rpos[triple.i] = i;
            }
        }
        rpos[n] = tot;
        for(int i = rpos.length - 2; i >= 0; i--){
            if(rpos[i] < 0){
                rpos[i] = rpos[i + 1];
            }
        }
    }
    public matrixs(int[][] a){
        base = new triple[MAX_SIZE];
        n = a.length;
        m = a[0].length;
        tot = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                if(a[i][j] != 0){
                    base[tot ++] = new triple(i, j, a[i][j]);
                }
            }
        }
        initialize_rpos();
    }


    public matrixs inverse(){
        matrixs mt = new matrixs();
        int[] row_number = new int[m];
        for(int i = 0; i < tot; i++){
            row_number[base[i].j] ++;
        }
        int[] pos = new int[m + 1];
        for(int i = 1; i < m + 1; i++){
            pos[i] = pos[i - 1] + row_number[i - 1];
        }
        for(int i = 0; i < tot; i++){
            mt.base[pos[base[i].j]] = new triple(base[i].j, base[i].i, base[i].v);
            pos[base[i].j] ++;
        }
        mt.m = n;
        mt.n = m;
        mt.tot = tot;
        mt.initialize_rpos();
        return mt;
    }


    /**
     * b = this * a
     * @param a
     * @return
     */
    public matrixs multiply(matrixs a){
        matrixs b = new matrixs();
        b.m = m;
        b.n = a.n;
        b.tot = 0;
        for(int i = 0; i < m; i++){
            int[] temp = new int[a.n];
            for(int j = 0; j < tot; j++){
                if(base[j].i == i){
                    for(int k = 0; k < a.tot; k++){
                        if(a.base[k].i == base[j].j){
                            temp[a.base[k].j] += base[j].v * a.base[k].v;
                        }
                    }
                }
            }
            for(int j = 0; j < a.n; j++){
                if(temp[j] != 0){
                    b.base[b.tot ++] = new triple(i, j, temp[j]);
                }
            }
        }
        return b;
    }


    public matrixs fast_multiply(matrixs a){
        matrixs b = new matrixs();
        b.m = m;
        b.n = a.n;
        b.tot = 0;
        for(int i = 0; i < m; i++){
            int[] temp = new int[a.n];
            for(int j = rpos[i]; j < rpos[i + 1]; j++){
                for(int k = a.rpos[base[j].j]; k < a.rpos[base[j].j + 1]; k++){
                    temp[a.base[k].j] += base[j].v * a.base[k].v;
                }
            }
            for(int j = 0; j < a.n; j++){
                if(temp[j] != 0){
                    b.base[b.tot ++] = new triple(i, j, temp[j]);
                }
            }
        }
        b.initialize_rpos();
        return b;
    }


    public String toString(){
        String str = "";
        for(int i = 0; i < tot; i++){
            str += "(" + base[i].i + ", " + base[i].j + ", " + base[i].v + ")\n";
        }
        return str;
    }

}