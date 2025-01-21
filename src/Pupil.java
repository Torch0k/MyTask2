import java.util.ArrayList;
import java.util.List;

class Pupil {
    public String name;
    public int age;
    public static List<Pupil> students = new ArrayList<>();
    public boolean isMale;    // ������ private �������� �

    public Pupil(String name, int age,boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

    public static void addStudent(String name, int age,boolean gender) {students.add(new Pupil(name, age,gender));
    }

    public String isMaleToString() {
        if (isMale) {
            return "���! �����";

        } else return "��� ����� �����";
        }

    public String getInfo() {
        return "��� " + name + " ������� " + age + " "+ isMaleToString() +" "+ "���";
    }
}