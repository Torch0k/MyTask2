import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Kabinet {
    public List<Integer> roomNumbers; // ������ ���������
    public List<List<Pupil>> roomStudents; // ������ �������� ��� ������� ��������

    public Kabinet() {
        roomNumbers = new ArrayList<>();
        roomStudents = new ArrayList<>();
    }

    // ������ �������
    public void createRoom(int number) {
        if (roomNumbers.contains(number)) {
            System.out.println("������� �" + number + " ��� ����������.");
            return;
        }
        roomNumbers.add(number);
        roomStudents.add(new ArrayList<>()); // ��������� ������ ������ �������� ��� ������ ��������
        System.out.println("������� �" + number + " ������.");
    }

    // ������� ������� � �������
    public void addStudentToRoom(Pupil pupil, int roomNumber) {
        int index = roomNumbers.indexOf(roomNumber);
        if (index == -1) {
            System.out.println("������� �" + roomNumber + " �� ������.");
            return;
        }
        roomStudents.get(index).add(pupil); // ��������� ������� � ������ ��� ��������
        System.out.println("������ �������� � ������� �" + roomNumber);
    }

    // ������ �������� � ���������
    public void listRooms() {
        if (roomNumbers.isEmpty()) {
            System.out.println("��� ��������� ���������.");
            return;
        }
        for (int i = 0; i < roomNumbers.size(); i++) {
            System.out.println("������� �" + roomNumbers.get(i) + ":");
            List<Pupil> students = roomStudents.get(i);
            if (students.isEmpty()) {
                System.out.println("  �����");
            } else {
                for (Pupil pupil : students) {
                    System.out.println("  " + pupil.getInfo());
                }
            }
        }
    }
}
