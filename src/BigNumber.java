
public class BigNumber {
    public static void main(String[] args) {
        System.out.println(add("1211112121111111000011121211","22222222222222222200001111"));
    }
 
    public static String add(String a, String b) {
 
        String ret = "";
        int lenA = a.length();
        int lenB = b.length();
        int maxLen = lenA > lenB ? lenA : lenB;
        int minLen = lenA < lenB ? lenA : lenB;
        StringBuilder s = new StringBuilder();
        //要保证两个数位数相同，位数少的前面补0
        for (int i = 0; i < maxLen - minLen; i++) {
            s.append(0);
        }
        if (minLen == lenA) {
            s.append(a);
        } else {
            s.append(b);
        }
 
        s = new StringBuilder();
        int tempA, tempB, result;
        int sc = 0;//进位
        for (int i = maxLen - 1; i >= 0; i--) {
            tempA = Integer.valueOf(a.charAt(i));
            tempB = Integer.valueOf(b.charAt(i));
            result = tempA + tempB + sc;
            sc = result / 10;
            result = result % 10;
            s.append(result);
        }
        //如果加到最高为仍有进位，那么也要加上去
        if (sc == 1) {
            s.append(1);
        }
        //因为是从个位依次相加的，所以结果要倒过来
        ret = s.reverse().toString();
 
        return ret;
    }
 
}