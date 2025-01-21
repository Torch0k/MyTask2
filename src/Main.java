import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


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
            for (Pupil pupil : Pupil.students) {
                System.out.println(pupil.getInfo());

            }
             typo();
             // вывод телочек
        } if(start.startsWith("allG")){
            for (Pupil pupil : Pupil.students) {
                if (pupil.isMale != true) {
                    System.out.println(pupil.getInfo());
                }
                typo();
            }
        }
         //вывод мальчиков
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
           // вызываем екабинет манагер раньшше.

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

        for (Pupil pupil : Pupil.students) {
            if (pupil.name.equals(name)){
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

    public static void kabinetAdder() throws IOException {
        BufferedReader vvodstroki = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Создать кабинет. create");
        String name = vvodstroki.readLine();

        if(name.equals("create")){
            System.out.println("ведите номер кабинета");
            int num = Integer.parseInt(vvodstroki.readLine());
            Kabinet.kabinets.add(new Kabinet(num));
        }
            else if (name.equals("add")){
            System.out.println("введите номер ученика");
            for (int i = 0; i < Pupil.students.size(); i++) {
                System.out.println(i+": " + Pupil.students.get(i).getInfo());
            }
                int num = Integer.parseInt(vvodstroki.readLine());
                Pupil student = Pupil.students.get(num);
            System.out.println("все кабинеты");
            for (int i = 0; i < Kabinet.kabinets.size(); i++) {
                System.out.println(i+";"+Kabinet.kabinets.get(i).KabinetID);
            }
            System.out.println("выбери кабинет");
            int num2 = Integer.parseInt(vvodstroki.readLine());
            Kabinet.kabinets.get(num2).pupils.add(student);
        }
            else if (name.equals("list")){
                for ( Kabinet kabinet : Kabinet.kabinets) {
                    System.out.println("каб"+ kabinet.KabinetID);
                    for (Pupil pupil : Pupil.students) {
                        System.out.println(pupil.getInfo());
                    }
                }
        }
        kabinetAdder();

    }
}

