package SerializationSecond;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {

        Person[] people = {new Person(1,"Bob"),
                new Person(2,"Mike"),new Person(3,"Tom")};

        try {
            FileOutputStream fos = new FileOutputStream("peopleSecond.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(people);

//            oos.writeInt(people.length);
//            for(Person person : people) {
//                oos.writeObject(person);
//            }

            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
