import java.util.ArrayList;
import java.util.List;

class Kabinet {
    private List<Room> rooms;

    public Kabinet() {
        this.rooms = new ArrayList<>();
    }
        // cоздаем кабинет
    public void createRoom(int number) {
        rooms.add(new Room(number));
        System.out.println("Кабинет №" + number + " создан.");
    }

    public void addStudentToRoom(Pupil pupil, int roomNumber) {
        Room room = findRoomByNumber(roomNumber);
        if (room != null) {
            room.addStudent(pupil);
            System.out.println("Ученик добавлен в кабинет №" + roomNumber);
        } else {
            System.out.println("Кабинет не найден.");
        }
    }

    public void listRooms() {
        if (rooms.isEmpty()) {
            System.out.println("Нет созданных кабинетов.");
        } else {
            for (Room room : rooms) {
                System.out.println(room.getInfo());
            }
        }
    }
    // нахождения кабинетов (спижжено )
    private Room findRoomByNumber(int number) {
        return rooms.stream()
                .filter(room -> room.getNumber() == number)
                .findFirst()
                .orElse(null);
    }
}

