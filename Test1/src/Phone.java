public class Phone {
    private String phoenbrand;
    private int phoenprce;
    private String phoencolor;

    public Phone() {
    }

    public Phone(String phoenbrand, int phoenprce, String phoencolor) {
        this.phoenbrand = phoenbrand;
        this.phoenprce = phoenprce;
        this.phoencolor = phoencolor;
    }

    public String getPhoenbrand() {
        return phoenbrand;
    }

    public int getPhoenprce() {
        return phoenprce;
    }

    public String getPhoencolor() {
        return phoencolor;
    }

    public void setPhoenbrand(String phoenbrand) {
        this.phoenbrand = phoenbrand;
    }

    public void setPhoenprce(int phoenprce) {
        this.phoenprce = phoenprce;
    }

    public void setPhoencolor(String phoencolor) {
        this.phoencolor = phoencolor;
    }
}
