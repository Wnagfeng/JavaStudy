import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
 public static void main(String[] args) {
  // 创建学生对象并存储在Map中
  Map<String, Students> studentsMap = new HashMap<>();
  studentsMap.put("张三", new Students("张三"));
  studentsMap.put("王五", new Students("王五"));
  studentsMap.put("李四", new Students("李四"));
  studentsMap.put("小红", new Students("小红"));
  studentsMap.put("小明", new Students("小明"));
  studentsMap.put("小李", new Students("小李"));
  studentsMap.put("小白", new Students("小白"));
  studentsMap.put("小黑", new Students("小黑"));
  studentsMap.put("小黄", new Students("小黄"));

  // 随机选择一个学生
  Random random = new Random();
  int randomIndex = random.nextInt(studentsMap.size());
  String[] studentNames = studentsMap.keySet().toArray(new String[0]);
  String selectedStudentName = studentNames[randomIndex];
  Students selectedStudent = studentsMap.get(selectedStudentName);
  System.out.println("随机点名结果：" + selectedStudent.getName());
 }
}