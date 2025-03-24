package JavaStreams;

import java.io.*;

public class StudentData {
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        storeStudentData(101, "Alice", 8.5);
        storeStudentData(102, "Bob", 7.8);
        retrieveStudentData();
    }

    public static void storeStudentData(int rollNumber, String name, double gpa) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME, true))) {
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            System.out.println("Student data stored successfully.");
        } catch (IOException e) {
            System.err.println("Error storing student data: " + e.getMessage());
        }
    }

    public static void retrieveStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("Retrieving student data:");
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.err.println("Error retrieving student data: " + e.getMessage());
        }
    }
}
