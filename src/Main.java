import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Kabinet kabinet = new Kabinet();

    public static void main(String[] args) throws IOException {





        System.out.println("������ ����� ������. Exit ����� . add - �������. list - ��� �������. allB-��� ��������. allG-��� �������. Kabinet- �������");
        typo();
    }

    public static void typo() throws IOException {
        //������� ����� ������ ������������
        BufferedReader vvodstroki = new BufferedReader(new InputStreamReader(System.in));
        String start = vvodstroki.readLine();
        if(start.equalsIgnoreCase("exit")) {
            System.exit(0);
        }
         if (start.startsWith("add")) {
            pupilAdder();
             typo();
        }
         if(start.startsWith("list")){
            //������� ������ ��������
            System.out.println("\n������ ��������:");
            // ������ ������� ���� ��������
            for (Pupil pupil : Pupil.getStudents()) {
                System.out.println(pupil.getInfo());

            }
             typo();
             // ����� �������
        } if(start.startsWith("allG")){
            for (Pupil pupil : Pupil.getStudents()) {
                if (pupil.getGender() != true) {
                    System.out.println(pupil.getInfo());
                }
                typo();
            }
        }
         //����� ���������
        if(start.startsWith("allB")){
            for (Pupil pupil : Pupil.getStudents()) {
                if (pupil.getGender() == true) {
                    System.out.println(pupil.getInfo());

                }
                typo();
            }
        }
        if (start.startsWith("Kabinet")){

            kabinetManager(kabinet);

        }
         else {
             System.out.println("�� �� �� ���� ����� ��� ��� --->. Exit ����� . add - �������. list - ��� ������� allB-��� ��������. allG-��� �������");
             typo();
         }
    }

    public static void pupilAdder() throws IOException {
        //������� ����� ������ ������������
        BufferedReader vvodstroki = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("���");
        //���� ����� �����
        String name = vvodstroki.readLine();

        for (Pupil pupil : Pupil.getStudents()) {
            if (pupil.getName().equals(name)){
                System.out.println("������ �����");
                System.out.println("Exit ����� . add - �������. list - ��� ������� allB-��� ��������. allG-��� �������");
                typo();

            }
        }




        System.out.println("��� � ��� �?");

        String pregender = vvodstroki.readLine();
        Boolean gender = false;
        if (pregender.equalsIgnoreCase("�")) {
             gender = true;
        }else if (pregender.equalsIgnoreCase("�")){
             gender = false;
        }

        //������� ������ ��������
        String age;
        while (true) {
            System.out.println("�������:");
            // ���������  ������� �� ������������
            age = vvodstroki.readLine();

            // ��������, ��� ������� �������� ������
            try {
                // ������� �������������� � �����
                Integer.parseInt(age);
                // ���� �������, ������� �� �����
                break;
                //���� ��� �� ����� ������
            } catch (NumberFormatException e) {
                System.out.println("������! ������� ������� �������.");
            }
        }
        //��������� ������� � ����

        Pupil.addStudent(name, Integer.parseInt(age),gender);
        //����� � ��� ��� ��������
        System.out.println("������ ��������: " + name + ", �������: " + age + "��� - ����" +pregender);
    }

    public static void kabinetManager(Kabinet kabinet) throws IOException {
        BufferedReader vvodstroki = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("�������: create - ������� �������, add - �������� �������, list - ������ ���������, back - �����.");

        while (true) {
            String command = vvodstroki.readLine().toLowerCase();
            // ������� ��������
            if (command.equals("create")) {
                System.out.print("������� ����� ��������: ");
                //����� ������ �������� �� �����
                int number = Integer.parseInt(vvodstroki.readLine());
                //������� �������
                kabinet.createRoom(number);
                //������� �� ����������
            } else if (command.equals("add")) {
                //���� ����� �� ������ �������
                if (Pupil.getStudents().isEmpty()) {
                    System.out.println("��� ��������. ������� �������� ��������.");
                    continue;
                }
                // ����� ���� �������� ����� ������� ���� ��������
                System.out.println("\n������ ��������:");
                for (int i = 0; i < Pupil.getStudents().size(); i++) {
                    System.out.println(i + ": " + Pupil.getStudents().get(i).getInfo());
                }
                // ����� ���� �������� � �������� ����� �������
                System.out.print("������� ������ �������: ");
                int studentIndex = Integer.parseInt(vvodstroki.readLine());
                Pupil selectedPupil = Pupil.getStudents().get(studentIndex);

                System.out.println("������ ���������:");
                kabinet.listRooms();

                System.out.print("������� ����� ��������: ");
                int kabinetNumber = Integer.parseInt(vvodstroki.readLine());
                // ��������� ������� � �������.
                kabinet.addStudentToRoom(selectedPupil, kabinetNumber);
                // �������� ����� �� kabinet ����� �������� ������ ���������
            } else if (command.equals("list")) {
                kabinet.listRooms();
            } else if (command.equals("back")) {
                System.out.println("Exit ����� . add - �������. list - ��� ������� allB-��� ��������. allG-��� �������");
               typo(); // ������������ � �������� ����
                
            } else {
                System.out.println("����������� �������. �������: create, add, list, back.");
            }
        }
    }
}

