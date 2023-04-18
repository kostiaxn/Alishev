package SerializationSecond;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ReadObject {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("peopleSecond.bin")))){ //try with resources
//            FileInputStream fis = new FileInputStream("peopleSecond.bin");
//            ObjectInputStream ois = new ObjectInputStream(fis);
            Person[] people = (Person[]) ois.readObject();


//            int personCount = ois.readInt();
//            Person[] people = new Person[personCount];
//
//            for (int i = 0; i < personCount; i++) {
//                people[i] = (Person) ois.readObject();
//            }
            System.out.println(Arrays.toString(people));

//            ois.close(); не нужен с try with resources

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
