public class Main {
    public static void main(String[] args) {

        // Создание объектов потока для кроликов и черепах
        Animal rabbit = new Animal(" Кролик ", 1);
        Animal turtle = new Animal(" Черепаха ", 10);

        System.out.println("Старт!");
        rabbit.start();
        turtle.start();
    }
}

class Animal extends Thread {
    String name;
    int priority;
    final int distance = 11;

    public Animal(String s, int i) {
        this.name = s;
        this.priority = i;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        Thread.currentThread().setName(name);
        int timeToStep = 1000 / (Thread.currentThread().getPriority());
        for (int i = 0; i < distance; i++) {
            try {
                Thread.sleep(timeToStep);
                System.out.println(getName() + (" - ") + (i * 100) + " метров ");
            } catch (Exception e) {

                e.printStackTrace();
            }
            if (i == distance / 5) {
                double random = Math.random();
                int rnd;
                if (random < 0.5) {
                    rnd = 1;

                } else {
                    rnd = 2;

                }
                if (Thread.currentThread().getPriority() == rnd) {
                    Thread.currentThread().setPriority(10);
                } else {
                    Thread.currentThread().setPriority(rnd);
                }


            }
            timeToStep = 1000 / (Thread.currentThread().getPriority());

        }

    }
}


