class Dog extends Animal {
    public void printNames() {
        System.out.println(publicName);      // 直接访问父类的public成员变量
        System.out.println(protectedName);   // 直接访问父类的protected成员变量
        System.out.println(defaultName);     // 直接访问父类的default成员变量
        // System.out.println(privateName);  // 无法直接访问父类的private成员变量
        // 通过调用父类的公共方法来间接访问父类的private成员变量
        System.out.println(getPrivateName());
    }
}
