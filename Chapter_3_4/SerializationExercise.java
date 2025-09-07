package Chapter_3_4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializationExercise {

    public static void main(String[] args) {

        Student student1 = new Student(1L, "John", 20);
        Student student2 = new Student(2L, "Mary", 30);

        Course course1 = new Course("FX-1", "Machine Learning 1", "Jane Robot");
        Course course2 = new Course("OOP-1", "Object Oriented Progrmaming 1", "Jack Robot");

        ArrayList<Enrollment> enrollments = new ArrayList<>();
        enrollments.add(new Enrollment(student1, course1, "2025-09-01"));
        enrollments.add(new Enrollment(student2, course1, "2025-09-01"));
        enrollments.add(new Enrollment(student1, course2, "2025-09-01"));
        enrollments.add(new Enrollment(student2, course2, "2025-09-01"));

        String fileName = "Chapter_3_4/enrollments.ser";

        // Create the enrollment serialization file.
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(enrollments);
            System.out.println("Enrollment serialized to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // De-serialize the enrollments from the serialization file.
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            @SuppressWarnings("unchecked")
            ArrayList<Enrollment> deserializedEnrollments = (ArrayList<Enrollment>) ois.readObject();
            for (Enrollment enrollment : deserializedEnrollments) {
                System.out.println("Read: " + enrollment);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
