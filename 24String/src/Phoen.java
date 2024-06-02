public class Phoen {
    private String phoneBrand;
    private int phonePrice;

    public Phoen() {
    }


    public Phoen(String phoneBrand, int phonePrice) {
        this.phoneBrand = phoneBrand;
        this.phonePrice = phonePrice;
    }

    public String getPhoneBrand() {
        return phoneBrand;
    }

    public int getPhonePrice() {
        return phonePrice;
    }

    public void setPhoneBrand(String phoneBrand) {
        this.phoneBrand = phoneBrand;
    }

    public void setPhonePrice(int phonePrice) {
        this.phonePrice = phonePrice;
    }
}
