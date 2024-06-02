class Animal {
    public String publicName;
    protected String protectedName;
    String defaultName;
    private String privateName;

    public Animal() {
        publicName = "Public Animal";
        protectedName = "Protected Animal";
        defaultName = "Default Animal";
        privateName = "Private Animal";
    }
    public String getPrivateName() {  // 定义公共方法访问私有成员变量
        return privateName;
    }
}