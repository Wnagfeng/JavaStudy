public class TestStudent {
    public static void main(String[] args) {
        Student[] StudentArray = new Student[3];
        Student  study1=new Student("wanfeng","1","19");
        Student  study2=new Student("Joon","2","29");
        Student  study3=new Student("Kiss","3","39");
        StudentArray[0]=study1;
        StudentArray[1]=study2;
        StudentArray[2]=study3;
        StudentArray[2]=study3;
        Student  study4=new Student("Kisss","4","39");
        boolean flag =  costiance(StudentArray,study4.getStudyNumber());
        if (flag){
            System.out.println("不能添加Id重复了");
        }else {
          int count=   GetArrayLength(StudentArray);
            if (count==StudentArray.length){
                System.out.println("扩容成功");
                Student [] newArray= CreateArray(StudentArray);
                newArray[count]=study4;
                printArr(newArray);
            }else if (count!=StudentArray.length){
                System.out.println("添加成功！");
                StudentArray[count]=study4;
                printArr(StudentArray);
            }
        }
    }
    public static  boolean costiance(Student[] StudentArray,String StudentId){
        for (int i = 0; i < StudentArray.length; i++) {
            if (StudentArray[i]!=null){
                if(StudentId==StudentArray[i].getStudyNumber()){
                    return true;
                }
            }
        }
        return  false;
    }
    public static int GetArrayLength(Student[] StudentArray){
        int count=0;
        for (int i = 0; i < StudentArray.length; i++) {
            Student item=StudentArray[i];
            if(item!=null){
                count++;
            }
        }
        return  count;
    }
    public static void printArr(Student[] arr){
        for (int i = 0; i < arr.length; i++) {
            Student stu = arr[i];
            if(stu != null){
                System.out.println(stu.getStudyNumber() + ", " + stu.getStudyName() + ", " + stu.getStudyAge());
            }
        }
    }
    public static Student[] CreateArray(Student [] student){
        Student[] newArr = new Student[student.length + 1];
        for (int i = 0; i < student.length; i++) {
            newArr[i] = student[i];
        }
        return newArr;
    }

}
