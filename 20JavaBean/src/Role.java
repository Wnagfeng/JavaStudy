import java.util.Random;

public class Role {
    private String name;
    private String gender;
    private int blood;
    private String face;//这是人物的面容

    String[] boyfaces = {"风流俊雅", "气宇轩昂", "相貌英俊", "五官端正", "相貌平平", "一塌糊涂", "面目狰狞"};
    String[] girlfaces = {"美奂绝伦", "沉鱼落雁", "婷婷玉立", "身材娇好", "相貌平平", "相貌简陋", "惨不忍睹"};
    String[] attacks_desc = {
            "%s使出了一招【背心钉】，转到对方的身后，一掌向%s背心的灵台穴拍去。",
            "%s使出了一招【游空探爪】，飞起身形自半空中变掌为抓锁向%s。",
            "%s大喝一声，身形下伏，一招【劈雷坠地】，捶向%s双腿。",
            "%s运气于掌，一瞬间掌心变得血红，一式【掌心雷】，推向%s。",
            "%s阴手翻起阳手跟进，一招【没遮拦】，结结实实的捶向%s。",
            "%s上步抢身，招中套招，一招【劈挂连环】，连环攻向%s。"
    };
    //    injured 受伤描述：
    String[] injureds_desc = {
            "结果%s退了半步，毫发无损",
            "结果给%s造成一处瘀伤",
            "结果一击命中，%s痛得弯下腰",
            "结果%s痛苦地闷哼了一声，显然受了点内伤",
            "结果%s摇摇晃晃，一跤摔倒在地",
            "结果%s脸色一下变得惨白，连退了好几步",
            "结果『轰』的一声，%s口中鲜血狂喷而出",
            "结果%s一声惨叫，像滩软泥般塌了下去"
    };

    Random FaceRandomIndex = new Random();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public void setFace(String gender) {
        int RandomIndex = FaceRandomIndex.nextInt(boyfaces.length);
        if (gender == "男") {
            this.face = boyfaces[RandomIndex];
        } else if (gender == "女") {
            this.face = girlfaces[RandomIndex];
        }
    }

    public String getGender() {
        return gender;
    }

    public int getBlood() {
        return blood;
    }

    public String getFace() {
        return face;
    }

    public Role() {
    }

    public Role(String name, String gender, int blood) {
        this.name = name;
        this.gender = gender;
        this.blood = blood;
        setFace(gender);
    }

    //    攻击的方法
//    Role表示类型
    public void attack(Role role) {
//        生成造成的血量
        Random R = new Random();
        int hurt = R.nextInt(20) + 1;
//        生成随机的功夫
        int index = FaceRandomIndex.nextInt(attacks_desc.length);

        String KungFu = attacks_desc[index];
//        输出攻击效果
        System.out.printf(KungFu, this.getName(), role.getName());
        System.out.println();
//        计算剩余血量
        int remainboold = role.getBlood() - hurt;
        remainboold = remainboold < 0 ? 0 : remainboold;
        role.setBlood(remainboold);
        if (remainboold > 90) {
            System.out.printf(injureds_desc[0], role.getName());
        } else if (remainboold > 80 && remainboold <= 90) {
            System.out.printf(injureds_desc[1], role.getName());
        } else if (remainboold > 70 && remainboold <= 80) {
            System.out.printf(injureds_desc[2], role.getName());
        } else if (remainboold > 60 && remainboold <= 70) {
            System.out.printf(injureds_desc[3], role.getName());
        } else if (remainboold > 40 && remainboold <= 60) {
            System.out.printf(injureds_desc[4], role.getName());
        } else if (remainboold > 20 && remainboold <= 40) {
            System.out.printf(injureds_desc[5], role.getName());
        } else if (remainboold > 10 && remainboold <= 20) {
            System.out.printf(injureds_desc[6], role.getName());
        } else {
            System.out.printf(injureds_desc[7], role.getName());
        }
        System.out.println();

    }

}
