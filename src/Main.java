import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


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
            for (Pupil pupil : Pupil.students) {
                System.out.println(pupil.getInfo());

            }
             typo();
             // ����� �������
        } if(start.startsWith("allG")){
            for (Pupil pupil : Pupil.students) {
                if (pupil.isMale != true) {
                    System.out.println(pupil.getInfo());
                }
                typo();
            }
        }
         //����� ���������
        if(start.startsWith("allB")){
            for (Pupil pupil : Pupil.students) {
                if (pupil.isMale) {
                    System.out.println(pupil.getInfo());

                }
                typo();
            }
        }
        if (start.startsWith("Kabinet")){

            kabinetAdder();
           // �������� �������� ������� �������.

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

        for (Pupil pupil : Pupil.students) {
            if (pupil.name.equals(name)){
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

    public static void kabinetAdder() throws IOException {
        BufferedReader vvodstroki = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("������� �������. create");
        String name = vvodstroki.readLine();

        if(name.equals("create")){
            System.out.println("������ ����� ��������");
            int num = Integer.parseInt(vvodstroki.readLine());
            Kabinet.kabinets.add(new Kabinet(num));
        }
            else if (name.equals("add")){
            System.out.println("������� ����� �������");
            for (int i = 0; i < Pupil.students.size(); i++) {
                System.out.println(i+": " + Pupil.students.get(i).getInfo());
            }
                int num = Integer.parseInt(vvodstroki.readLine());
                Pupil student = Pupil.students.get(num);
            System.out.println("��� ��������");
            for (int i = 0; i < Kabinet.kabinets.size(); i++) {
                System.out.println(i+";"+Kabinet.kabinets.get(i).KabinetID);
            }
            System.out.println("������ �������");
            int num2 = Integer.parseInt(vvodstroki.readLine());
            Kabinet.kabinets.get(num2).pupils.add(student);
        }
            else if (name.equals("list")){
                for ( Kabinet kabinet : Kabinet.kabinets) {
                    System.out.println("���"+ kabinet.KabinetID);
                    for (Pupil pupil : Pupil.students) {
                        System.out.println(pupil.getInfo());
                    }
                }
        }
        kabinetAdder();

    }
}

