import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();

        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(2);
        linkedList.insert(4);
        linkedList.insert(5);
        linkedList.insert(8);
        linkedList.insert(9);
        linkedList.insert(12);
        linkedList.insert(15);

        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNextInt()) {
                linkedList.insert(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        System.out.print("List contents: ");
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        linkedList.delete(1);
        linkedList.delete(2);

        System.out.print("After deletion: ");
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
