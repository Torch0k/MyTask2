import java.util.ArrayList;
import java.util.List;



// класс помогающий упрпавлять учениками в кабинетах непосркдственнол
class Room {
    private int number;
    private List<Pupil> students;

    public Room(int number) {
        this.number = number;
        this.students = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public void addStudent(Pupil pupil) {
        students.add(pupil);
    }
    // информация об кабинетах
    public String getInfo() {
        StringBuilder info = new StringBuilder("Кабинет №" + number + ":\n");
        if (students.isEmpty()) {
            info.append("Пусто");
        } else {
            for (Pupil pupil : students) {
                info.append(pupil.getInfo()).append("\n");
            }
        }
        return info.toString();
    }
}