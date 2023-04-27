package RegularExpressions;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        String a = "Hello.there.hey";
        String[] words = a.split("\\.");
        System.out.println(Arrays.toString(words));

        String b = "Hello676968there789866hey";
        String[] words2 = b.split("\\d+");
        System.out.println(Arrays.toString(words2));

        String c = "Hello.there.hey";
        String q =  c.replace("."," ");
        System.out.println(q);
    }
}
