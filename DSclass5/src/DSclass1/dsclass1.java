package DSclass1;

/**
 * 字符的切分
 */
public class dsclass1 {
    public static void main(String[] args){
        /*String a = "Hello world";
        String b = "\n";
        System.out.println(a.isEmpty());
        System.out.println(b.length());  //返回1//*/
        String str = "we are students";
        String str1 =  "   110 ";
        String[] str3 = str.split("v"); //不切割//
        for(int j = 0;  j < str3.length; j++){
            System.out.println(str3[j]);
        }
        int pos = str.indexOf("");  //返回字符串长度//
        int last = str.lastIndexOf("a");
        char[] chs = new char[str.length()];
        for(int i = 0 ; i < str.length(); i++){
            chs[i] = str.charAt(i);
        }
        System.out.println(str.substring(1));  //从第一位开始算//
        System.out.println(str.substring(0,str.length() - 1));
        int a = Integer.parseInt(str1.trim());
        System.out.println(a);
        System.out.println(str.replace("we","They"));
        System.out.println(str.startsWith("we "));
        System.out.println(str.endsWith("ts"));
        String str2 = "we are students";
        if(str == str2){
            System.out.println(true);
        }

    }
}
