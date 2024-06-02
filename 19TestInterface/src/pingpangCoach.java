public class pingpangCoach extends Coach implements English {
    public pingpangCoach(String name, String age) {
        super(name, age);
    }

    public pingpangCoach() {
    }

    @Override
    public void speakenglish() {
        System.out.println("乒乓球教练说英语");
    }


    @Override
    public void teacher() {
        System.out.println("乒乓球教练教乒乓球");
    }
}
