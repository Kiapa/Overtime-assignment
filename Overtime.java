package net.javacode;
import java.util.Scanner;

public class Overtime {
    class Employee {
        String EmployeeName;
        double HourlySalary;

        public Employee(String name, double hsalary) {
            EmployeeName = name;
            HourlySalary = hsalary;
        }
    }

    class Week {
        double Monday;
        double Tuesday;
        double Wednesday;
        double Thursday;
        double Friday;
        double Saturday;
        double Sunday;

        public Week(double m, double t, double w, double th, double f, double s, double su) {
            Monday = m;
            Tuesday = t;
            Wednesday = w;
            Thursday = th;
            Friday = f;
            Saturday = s;
            Sunday = su;
        }
        
        public double calculateOvertimeHours() {
            double overtime = 0;
            for (double dayHours : new double[]{Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday}) {
                overtime += Math.max(dayHours - 8, 0); // Overtime is any time over 8 hours
            }
            return overtime;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the employee's name:");
        String name = input.nextLine();
        System.out.println("Enter the employee's hourly salary:");
        double hourlySalary = input.nextDouble();

        Overtime overtime = new Overtime();
        Employee employee = overtime.new Employee(name, hourlySalary);

        Week[] weeks = new Week[2];
        for (int week = 0; week < 2; week++) {
            System.out.println("Enter hours worked for Week " + (week + 1) + ":");
            double m = input.nextDouble();
            double t = input.nextDouble();
            double w = input.nextDouble();
            double th = input.nextDouble();
            double f = input.nextDouble();
            double s = input.nextDouble();
            double su = input.nextDouble();
            weeks[week] = overtime.new Week(m, t, w, th, f, s, su);
        }

        double Overtime = 0;
        double Regular = 0;

        for (Week week : weeks) {
            Overtime += week.calculateOvertimeHours();
            for (double dayHours : new double[]{week.Monday, week.Tuesday, week.Wednesday, week.Thursday, week.Friday}) {
                Regular += Math.min(dayHours, 8); 
            }
        }

        double regularAmount = Regular* employee.HourlySalary;
        double overtimeAmount = Overtime * (employee.HourlySalary * 1.5); 
        double NetPay = regularAmount + overtimeAmount;

        System.out.println("Employee Name: " + employee.EmployeeName);
        System.out.println("Total Regular Hours: " + Regular + " hours");
        System.out.println("Total Overtime Hours over Two Weeks: " + Overtime + " hours");
        System.out.println("Regular Pay: $" + regularAmount);
        System.out.println("Overtime Pay: $" + overtimeAmount);
        System.out.println("Total Net Pay: $" + NetPay);

        input.close();
    }
}