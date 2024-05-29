public class Student {
    private String studyName;
    private String studyNumber;
    private String studyAge;

    public Student() {
    }

    public Student(String studyName, String studyNumber, String studyAge) {
        this.studyName = studyName;
        this.studyNumber = studyNumber;
        this.studyAge = studyAge;
    }

    public String getStudyName() {
        return studyName;
    }

    public String getStudyNumber() {
        return studyNumber;
    }

    public String getStudyAge() {
        return studyAge;
    }


    public void setStudyName(String studyName) {
        this.studyName = studyName;
    }

    public void setStudyNumber(String studyNumber) {
        this.studyNumber = studyNumber;
    }

    public void setStudyAge(String studyAge) {
        this.studyAge = studyAge;
    }
}
