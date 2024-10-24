package factory.computershop;

public class Custom {
    public  static void main(String[] args) {
        Shoppers shopper = new Shoppers();
        Computer c =   shopper.ideaByComputerShop("服务");
        System.out.println(c.description());
    }

}
