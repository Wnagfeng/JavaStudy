public class pingpangSport extends Persong implements  English{
    public pingpangSport(String name, String age) {
        super(name, age);
    }

    public pingpangSport() {
    }
    public void action(){
        System.out.println("乒乓球运动员学打乒乓球");
    }

    @Override
    public void speakenglish() {
        System.out.println("乒乓球运动员学说英语");
    }
}
