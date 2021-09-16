package homework;
import java.util.*;
public class homework42 {
    /*
    输出字符串最长公共字串的算法：
    **
    暴力 + 中心扩展 + Manacher算法
     */
    public static void main(String[] args) {
        /*
        这里展示的就是Manacher算法
         */
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        scan.close();
        char[] list = new char[str.length() * 2 + 1];
        Arrays.fill(list, '#');
        int k = 0;
        for(int i = 1; i < str.length() * 2 ; i += 2 ){
            list[i] = str.charAt(k ++ );
        }
        int max = 0;
        for(int i = 1; i < str.length() * 2; i ++ ){
            int start = i - 1;
            int end = i + 1;
            int temp = 0;
            while(start >= 0 && end <= str.length()* 2){
                if(list[start] == list[end]){
                    start -- ;
                    end ++ ;
                }
                else{
                    break;
                }
            }
            temp = (end - start - 1)/2;
            max = Math.max(temp , max);
        }
        System.out.println(max);
        int a = middleExpand(str);
        System.out.println(a);

    }
    public static int middleExpand(String a){
        int max = 0;
        char[] list = a.toCharArray();
        for(int i = 0 ; i < a.length(); i ++ ){
            int temp = 0;
            int front = i - 1;
            int post = i + 1;
            while(front >=0 && post < a.length()){
                if(list[front] == list[post]){
                    front --;
                    post ++ ;
                }
                else{
                    break;
                }
            }
            temp = (post - front - 1);
            max = Math.max(max, temp);
            int back = i + 1;
            int cur = i;
            while(cur >= 0 && back < a.length()){
                if(list[cur] == list[back]){
                    cur -- ;
                    back ++ ;
                }
                else{
                    break;
                }
            }
            max = Math.max((back - cur + 1)/2, max);
        }
        return max;
    }

}
