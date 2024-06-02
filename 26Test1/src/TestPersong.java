public class TestPersong {
    public static void main(String[] args) {
        Persong[] arr = new Persong[4];
        //    创建人类
        Persong persong1 = new Persong("wangfeng", 19, "girl");
        Persong persong2 = new Persong("Joon", 45, "man");
        Persong persong3 = new Persong("Sir", 30, "man");
        Persong persong4 = new Persong("xiaohu", 20, "girl");
//    统计四个人的评价年龄
        double PersongAgeAverage = 0.0;
        int PersongAgeSum = 0;
        arr[0] = persong1;
        arr[1] = persong2;
        arr[2] = persong3;
        arr[3] = persong4;
        for (int i = 0; i < arr.length; i++) {
            int age = arr[i].getAge();
            PersongAgeSum = PersongAgeSum + age;
        }
        PersongAgeAverage = PersongAgeSum / (double)arr.length;
        System.out.println(PersongAgeAverage);
        System.out.println(PersongAgeSum);
    }

}
