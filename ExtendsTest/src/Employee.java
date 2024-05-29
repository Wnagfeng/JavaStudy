public class Employee {
    private String id;
    private String name;
    private String work;

    public Employee(String id, String name, String work) {
        this.id = id;
        this.name = name;
        this.work = work;
    }

    public void work() {
        System.out.println(name + " is working on " + work);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWork() {
        return work;
    }
}