import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Kabinet {
    public List<Integer> roomNumbers; // Номера кабинетов
    public List<List<Pupil>> roomStudents; // Список учеников для каждого кабинета

    public Kabinet() {
        roomNumbers = new ArrayList<>();
        roomStudents = new ArrayList<>();
    }

    // делаем кабинет
    public void createRoom(int number) {
        if (roomNumbers.contains(number)) {
            System.out.println("Кабинет №" + number + " уже существует.");
            return;
        }
        roomNumbers.add(number);
        roomStudents.add(new ArrayList<>()); // добавляем пустой список учеников для нового кабинета
        System.out.println("Кабинет №" + number + " создан.");
    }

    // добавка ученика в кабинет
    public void addStudentToRoom(Pupil pupil, int roomNumber) {
        int index = roomNumbers.indexOf(roomNumber);
        if (index == -1) {
            System.out.println("Кабинет №" + roomNumber + " не найден.");
            return;
        }
        roomStudents.get(index).add(pupil); // добавляем ученика в список для кабинета
        System.out.println("Ученик добавлен в кабинет №" + roomNumber);
    }

    // список учеников и кабинетов
    public void listRooms() {
        if (roomNumbers.isEmpty()) {
            System.out.println("Нет созданных кабинетов.");
            return;
        }
        for (int i = 0; i < roomNumbers.size(); i++) {
            System.out.println("Кабинет №" + roomNumbers.get(i) + ":");
            List<Pupil> students = roomStudents.get(i);
            if (students.isEmpty()) {
                System.out.println("  Пусто");
            } else {
                for (Pupil pupil : students) {
                    System.out.println("  " + pupil.getInfo());
                }
            }
        }
    }
}
