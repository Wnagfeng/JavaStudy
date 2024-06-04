import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        /*
        * 定义数组并存储女友朋友对象 利用arrays中的sort方法进行排序
        * 要求1：属性有姓名 年龄 身高
        * 要求2：按照年龄的大小进行排序，年龄一样，按照身高排序，身高一样按照名字字母排序
        * */



        GirlFriends gf1=new GirlFriends("小红", 25, 160);
        GirlFriends gf2=new GirlFriends("小白", 25, 161);
        GirlFriends gf3=new GirlFriends("小蓝", 25, 162);
        GirlFriends gf4=new GirlFriends("小绿", 25, 163);


        GirlFriends[] arr ={gf1,gf2,gf3,gf4};

        Arrays.sort(arr,( o1,  o2)-> {
                if (o1.getAge()!=o2.getAge()){
                    return o1.getAge()-o2.getAge();
                }else if (o1.getHeight()!=o2.getHeight()){
                    return o1.getHeight()-o2.getHeight();
                }else {
                    return o1.getName().compareTo(o2.getName());
                }
            }

        );
        for (GirlFriends girlFriends : arr) {
            System.out.println(girlFriends.getName()+" "+girlFriends.getAge()+" "+girlFriends.getHeight());
        }
    }
}