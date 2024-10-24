package example.i18n;

public class Custom {
    public static void main(String[] args) {
        Language language = Middleware.language("中文");
        System.out.println(language.GetTitle());
    }
}
