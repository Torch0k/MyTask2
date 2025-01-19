import java.util.ArrayList;
import java.util.List;

class Kabinet {
    private List<Room> rooms;

    public Kabinet() {
        this.rooms = new ArrayList<>();
    }
        // c������ �������
    public void createRoom(int number) {
        rooms.add(new Room(number));
        System.out.println("������� �" + number + " ������.");
    }

    public void addStudentToRoom(Pupil pupil, int roomNumber) {
        Room room = findRoomByNumber(roomNumber);
        if (room != null) {
            room.addStudent(pupil);
            System.out.println("������ �������� � ������� �" + roomNumber);
        } else {
            System.out.println("������� �� ������.");
        }
    }

    public void listRooms() {
        if (rooms.isEmpty()) {
            System.out.println("��� ��������� ���������.");
        } else {
            for (Room room : rooms) {
                System.out.println(room.getInfo());
            }
        }
    }
    // ���������� ��������� (�������� )
    private Room findRoomByNumber(int number) {
        return rooms.stream()
                .filter(room -> room.getNumber() == number)
                .findFirst()
                .orElse(null);
    }
}

