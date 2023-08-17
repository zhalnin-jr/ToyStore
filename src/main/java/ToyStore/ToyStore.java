package ToyStore;

import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class ToyStore {
    public static void main(String[] args) {
        Toy[] toys = new Toy[3];
        toys[0] = new Toy(1, "робот", 2);
        toys[1] = new Toy(2, "конструктор", 2);
        toys[2] = new Toy(3, "кукла", 6);

        PriorityQueue<Toy> queue = new PriorityQueue<>(toys.length, (t1, t2) -> t2.getWeight() - t1.getWeight());
        for (Toy toy : toys) {
            queue.add(toy);
        }

        try (FileWriter writer = new FileWriter("output.txt")) {
            for (int i = 0; i < 10; i++) {
                Toy toy = queue.poll();
                if (toy != null) {
                    double randomNumber = Math.random();
                    double FirstWeight=toys[0].getWeight();
                    double SecondWeight=toys[1].getWeight()+FirstWeight;
                    if (randomNumber < FirstWeight/10) {
                        writer.write("1 " + toys[0].getName() + "\n");
                    } else if (randomNumber < SecondWeight/10) {
                        writer.write("2 " + toys[1].getName() + "\n");
                    } else {
                        writer.write(toy.toString() + "\n");
                    }
                    queue.add(toy);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}