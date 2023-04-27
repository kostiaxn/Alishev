package PatternAndMatcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String text = "Hello, Guys! i send you my email joe@gmail.com so we can\n" +
                "keep in touch. Thanks, Joe! That's cool. I am sending you\n" +
                "my address: tim@yandex.ru. Let's stay in touch...";
        Pattern email = Pattern.compile("(\\w+)@(gmail|yandex)\\.(com|ru)");
        Matcher matcher = email.matcher(text);

        while (matcher.find())
            System.out.println(matcher.group());
    }
}
