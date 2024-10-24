package factory.computershop;

public class Shoppers {
    public  Computer ideaByComputerShop(String purpose){
        switch (purpose) {
            case "学习":
                return new NoteBook();
            case "服务":
                return new Server();
            case "游戏":
            default:
                return new Desktop();
        }
    };
}
