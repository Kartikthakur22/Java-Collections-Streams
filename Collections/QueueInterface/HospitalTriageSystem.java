package Collections.QueueInterface;

import java.util.PriorityQueue;
import java.util.Scanner;

class Patient{
    String patientName;
    int severity;
    public Patient(String patientName,int severity){
        this.patientName=patientName;
        this.severity=severity;
    }
    public String getName(){
        return patientName;
    }
    public int getSeverity(){
        return severity;
    }
}
public class HospitalTriageSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Patient> pq=new PriorityQueue<>((p1,p2)->(Integer.compare(p2.getSeverity(),p1.getSeverity())));
        System.out.print("Enter the number of patients: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of patient " + (i + 1) + ": ");
            String name = scanner.next();
            
            System.out.print("Enter severity level for " + name + " (1-10): ");
            int severity = scanner.nextInt();
            scanner.nextLine();

            pq.add(new Patient(name, severity));
            System.out.println("\nTreatment Order (from highest to lowest severity):");
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll().getName());
        }
        scanner.close();
    }
}
