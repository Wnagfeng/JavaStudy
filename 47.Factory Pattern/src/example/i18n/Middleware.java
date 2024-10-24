package example.i18n;

public class Middleware {
    static Language language(String lang){
        if (lang.equals("中文")) {
            return new China();
        } else if (lang.equals("英文")) {
            return new Usa();
        } else {
            return new Canada();
        }
    }
}
