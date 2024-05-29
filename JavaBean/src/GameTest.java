public class GameTest {
    public static void main(String[] args) {
        Role R1=new Role("汪枫","男",10);
        Role R2=new Role("汪峰","女",101);
        String face=R1.getFace();
        String name=R1.getName();
        String faceR2=R2.getFace();
        String nameR2=R2.getName();
        String genderR1=R1.getGender();
        String genderR2=R2.getGender();
        int bloodR1=R1.getBlood();
        int bloodR2=R2.getBlood();
        System.out.println("====格斗游戏开始====");
        System.out.println("====人物介绍====");
        System.out.println("人物一："+name+"面容"+face+"性别"+genderR1+"血量"+bloodR1);
        System.out.println("人物二："+nameR2+"面容"+faceR2+"性别"+genderR2+"血量"+bloodR2);
        while (true){
            R1.attack(R2);
            if (R2.getBlood()==0){
                System.out.println(R1.getName()+"ko"+R2.getName());
                break;
            }
            R2.attack(R1);
            if (R1.getBlood()==0){
                System.out.println(R2.getName()+"ko"+R1.getName());
                break;
            }
        }
    }
}
