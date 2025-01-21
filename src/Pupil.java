import java.util.ArrayList;
import java.util.List;

class Pupil {
    public String name;
    public int age;
    public static List<Pupil> students = new ArrayList<>();
    public boolean isMale;    // убрать private отовсюду и

    public Pupil(String name, int age,boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

    public static void addStudent(String name, int age,boolean gender) {students.add(new Pupil(name, age,gender));
    }

    public String isMaleToString() {
        if (isMale) {
            return "НАщ! ПАцан";

        } else return "Фуу девка тупая";
        }

    public String getInfo() {
        return "Имя " + name + " Возраст " + age + " "+ isMaleToString() +" "+ "пол";
    }
}