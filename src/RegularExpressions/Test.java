package RegularExpressions;

public class Test {
    public static void main(String[] args) {
        /*
            \\d - одна цифра
            \\w - одна буква
            \\w = [a-zA-Z]
            + - 1 или более
            * - 0 или более
            ? - 0 или 1 символов до
            (x|y|z) - одна строка из множества строк
            [a-zA-Z] - все английские буквы
            [0-9] - \\d
            [abc]=(a|b|c)
            [^abc] - мы хотимвсе символы кроме [abc]
            . - любой символ

            точное количество предыдущих символов
            {2} - 2 символа до (\\d{2})
            {2,} - 2 или более символов (\\d{2,})
            {2,4} - от 2 до 4 символов (\\d{2,4})

         */
        String a = "1";
        System.out.println(a.matches("\\d"));
        String b = "91";
        System.out.println(b.matches("\\d+"));
        String c = "";
        System.out.println(c.matches("\\d*"));
        String d = "-54353";
        System.out.println(d.matches("-\\d*"));
        String e = "54353";
        System.out.println(e.matches("-?\\d*"));
        String f = "+54353";
        System.out.println(f.matches("(-|\\+)?\\d*"));


        String g = "ggfdg1325423";
        System.out.println(g.matches("[a-zA-Z]+\\d+"));

        String h = "hello";
        System.out.println(h.matches("[^abc]*"));

        String url = "http://www.google.com";
        System.out.println(url.matches("http://www\\..+\\.(com|ru)")); //.+ говорит что на месте названия может быть любой набор символов

        String url2 = "http://www.yandex.com";
        System.out.println(url2.matches("http://www\\..+\\.(com|ru)")); //.+ говорит что на месте названия может быть любой набор символов

        String q = "1234";
        System.out.println(q.matches("\\d{2,}"));

    }
}
