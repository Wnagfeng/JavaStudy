public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        backetBollCoch bc=new backetBollCoch("wangfeng","19");
        backetballSport bs=new backetballSport("joon","3");
        pingpangCoach pc=new pingpangCoach("liyinhe","4");
        pingpangSport ps =new pingpangSport("xiaohong","5");
        bc.teacher();
        bs.action();
        pc.speakenglish();
        pc.teacher();
        ps.action();
        ps.speakenglish();
    }
}