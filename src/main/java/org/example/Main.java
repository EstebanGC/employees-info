package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        DbManager dbManager = new DbManager();

        int totalDepartments = dbManager.callCountDepartments();
        System.out.println("Total de departamentos: " + totalDepartments);

        int totalEmployees = dbManager.callCountEmployees();
        System.out.println("Total de empleados: " + totalEmployees);

        int departmentId = 1;
        int employeesInDepartment = dbManager.callCountEmployeesByDepartmentId(departmentId);
        System.out.println("Empleados en el departamento " + departmentId + ": " + employeesInDepartment);

        }
}