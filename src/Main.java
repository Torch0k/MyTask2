import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Kabinet kabinet = new Kabinet();

    public static void main(String[] args) throws IOException {





        System.out.println("Привет введи строку. Exit выход . add - добавка. list - все ученики. allB-все мальчики. allG-все девочки. Kabinet- кабинет");
        typo();
    }

    public static void typo() throws IOException {
        //создаем ридер команд пользователя
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
            //выыодим список учеников
            System.out.println("\nСписок учеников:");
            // циклом выводим всех учеников
            for (Pupil pupil : Pupil.getStudents()) {
                System.out.println(pupil.getInfo());

            }
             typo();
             // вывод телочек
        } if(start.startsWith("allG")){
            for (Pupil pupil : Pupil.getStudents()) {
                if (pupil.getGender() != true) {
                    System.out.println(pupil.getInfo());
                }
                typo();
            }
        }
         //вывод мальчиков
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
             System.out.println("Не не то ввел вводи вот это --->. Exit выход . add - добавка. list - все ученики allB-все мальчики. allG-все девочки");
             typo();
         }
    }

    public static void pupilAdder() throws IOException {
        //создаем ридер команд пользователя
        BufferedReader vvodstroki = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("имя");
        //ввод сруки имени
        String name = vvodstroki.readLine();

        for (Pupil pupil : Pupil.getStudents()) {
            if (pupil.getName().equals(name)){
                System.out.println("занято нахуй");
                System.out.println("Exit выход . add - добавка. list - все ученики allB-все мальчики. allG-все девочки");
                typo();

            }
        }




        System.out.println("Пол М или Ж?");

        String pregender = vvodstroki.readLine();
        Boolean gender = false;
        if (pregender.equalsIgnoreCase("м")) {
             gender = true;
        }else if (pregender.equalsIgnoreCase("ж")){
             gender = false;
        }

        //создаем строку возраста
        String age;
        while (true) {
            System.out.println("Возраст:");
            // принимаем  возраст от пользователя
            age = vvodstroki.readLine();

            // Проверка, что возраст является числом
            try {
                // Пробуем конвертировать в число
                Integer.parseInt(age);
                // Если успешно, выходим из цикла
                break;
                //если нет то ловим ошибку
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите возраст цифрами.");
            }
        }
        //добавляем ученика в лист

        Pupil.addStudent(name, Integer.parseInt(age),gender);
        //текст о том что добавили
        System.out.println("Ученик добавлен: " + name + ", возраст: " + age + "пол - лава" +pregender);
    }

    public static void kabinetManager(Kabinet kabinet) throws IOException {
        BufferedReader vvodstroki = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Команды: create - создать кабинет, add - добавить ученика, list - список кабинетов, back - назад.");

        while (true) {
            String command = vvodstroki.readLine().toLowerCase();
            // создаем кабинеьт
            if (command.equals("create")) {
                System.out.print("Введите номер кабинета: ");
                //прием номера кабинета от юзера
                int number = Integer.parseInt(vvodstroki.readLine());
                //создаем кабиент
                kabinet.createRoom(number);

                //команда на добовление
            } else if (command.equals("add")) {
                //если пусто то добавь пупилов
                if (Pupil.getStudents().isEmpty()) {
                    System.out.println("Нет учеников. Сначала добавьте учеников.");
                    continue;
                }
                // пишем всех учеников чтобы выбрать кого добавить
                System.out.println("\nСписок учеников:");
                for (int i = 0; i < Pupil.getStudents().size(); i++) {
                    System.out.println(i + ": " + Pupil.getStudents().get(i).getInfo());
                }
                // пишем всех учеников и кабинеты чтобы добвить
                System.out.print("Введите индекс ученика: ");
                int studentIndex = Integer.parseInt(vvodstroki.readLine());
                Pupil selectedPupil = Pupil.getStudents().get(studentIndex);

                System.out.println("Список кабинетов:");
                kabinet.listRooms();

                System.out.print("Введите номер кабинета: ");
                int kabinetNumber = Integer.parseInt(vvodstroki.readLine());
                // добавляем ученика в кабинет.
                kabinet.addStudentToRoom(selectedPupil, kabinetNumber);
                // вызываем метод из kabinet чтобы показать список кабинетов
            } else if (command.equals("list")) {
                kabinet.listRooms();
            } else if (command.equals("back")) {
                System.out.println("Exit выход . add - добавка. list - все ученики allB-все мальчики. allG-все девочки");
               typo(); // Возвращаемся в основное меню
                
            } else {
                System.out.println("Неизвестная команда. Введите: create, add, list, back.");
            }
        }
    }
}

