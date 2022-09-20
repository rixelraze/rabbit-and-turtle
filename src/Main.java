public class Main {
    public static void main(String[] args) {

        // Создание объектов потока для кроликов и черепах
        Animal rabbit = new Animal(" Кролик ");
        Animal turtle = new Animal(" Черепаха ");

        System.out.println("Старт!");
        rabbit.start();
        turtle.start();
    }
}

class Animal extends Thread {

    // Статус соревнования
    public static boolean flag = true;
    int distance;

    // Конструктор : Используются для передачи имени потока
    public Animal(String name) {
        super(name);
    }

    @Override
    public void run() {


        while (flag) {

            // Получаем случайное число
            double random = Math.random();
            if (random < 0.5 && " Кролик ".equals(this.getName())) {

                distance += 50;
                System.out.println(" Кролик пробежал " + distance + " метров ");
            }
            if (random >= 0.5 && " Черепаха ".equals(this.getName())) {

                distance += 50;
                System.out.println(" Черепаха пробежала " + distance + " метров ");
            }

            if (distance == 1000) {
                flag = false;
                System.out.println(this.getName() + " побеждает в соревновании！");
            }
        }
    }


}