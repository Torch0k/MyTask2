import java.util.ArrayList;
import java.util.List;

class Pupil {
    private String name;
    private int age;
    private static List<Pupil> students = new ArrayList<>();
    private boolean gender;

    public Pupil(String name, int age,boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public static void addStudent(String name, int age,boolean gender) {students.add(new Pupil(name, age,gender));
    }

    public static List<Pupil> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean getGender() {return gender;}

    public boolean setGender(boolean gender) {
        return gender;
    }
    public String knowGender(){
        if (gender) { return "���! �����"; }

        if(gender != true) { return "��� ����� �����"; }
        else return "������";
    }


    public String getInfo() {
        return "��� " + name + " ������� " + age + " "+ knowGender() +" "+ "���";
    }
}