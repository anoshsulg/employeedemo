package com.anoshsulg.java.employee;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeMain {

    public static void main(String[] args){
        System.out.print("boo\n");
        System.out.print("boo\n");



        Employee emp1 = new Employee("Peter", "WA", 9, "Math", "Sc" );
        Employee emp2 = new Employee("Jon", "WA", 19, "Eng", "Sc");
        Employee emp3 = new Employee("Linda", "CA", 9, "Eng", "Math");
        Employee emp4 = new Employee("Mark", "AZ", 9, "Sc" , "Eng" ) ;

        System.out.print(" Empl 1 " + emp1.toString() );

        List<Employee> employeeList = new ArrayList<>();
        Employee[] employees = {emp1, emp2, emp3, emp4};
        employeeList = Arrays.asList(employees);

        System.out.println("Employees");

        int i = 0;
        for(Employee emp : employeeList){
            if("WA".equals( emp.getState()) ) {

                System.out.println(" Empl  " + i + " :  " + emp.toString());
                i = i + 1;
            }
        }
        System.out.println("Employees");
        employeeList.stream().filter(emp -> "WA".equals( emp.getState())).forEach(emp -> System.out.println(emp));

        List<List<String> > lists = employeeList.stream().map(Employee :: getAssignments).collect(Collectors.toList());

        System.out.println("assignments : " + lists.toString());



        Set<String> lists3 = employeeList.stream().flatMap(emp -> emp.getAssignments().stream()).collect(Collectors.toSet());

        System.out.println("assignments : "  + lists3.toString());

        List<String> lists2 = employeeList.stream().flatMap(emp -> emp.getAssignments().stream()).collect(Collectors.toList());

        System.out.println("assignments : "  + lists2.toString());

        List<String> distList = new ArrayList<>();
        String concat = employeeList.stream().flatMap(emp -> emp.getAssignments().stream()).collect(Collectors.joining());

        System.out.println("assignments  concat : "  + concat);

        String concat2 = employeeList.stream().flatMap(emp -> emp.getAssignments().stream()).reduce("" , (s, s1 ) -> s + s1 );

        System.out.println("assignments  concat2 : "  + concat2);

        Map<String, List<Employee>> stringListMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getState));
        System.out.println("assignments  stringListMap : "  + stringListMap);

        Map<String,Long> map2 = employeeList.stream().collect( Collectors.groupingBy(Employee::getState, Collectors.counting()) );
        System.out.println("assignments  stringListMap : "  + map2);

        Map<String, Employee> stringNameMap =  employeeList.stream().collect( Collectors.toMap(Employee::getName, Function.identity()) );
        System.out.println("assignments  stringListMap : " + stringNameMap);

        Map<String, String> stringNameStateMap =  employeeList.stream().collect( Collectors.toMap(Employee::getName, Employee :: getState ) );
        System.out.println("assignments  stringListMap : " + stringNameStateMap);


        Map<String, String> stringNameStateMap2 =  employeeList.stream().collect( Collectors.toMap(Employee::getState, Employee :: getName, (s, s1) -> s + ", " + s1 ) );
        System.out.println("assignments  stringListMap : " + stringNameStateMap2);

        System.out.println( employeeList.stream().reduce((s, s1) -> {
             System.out.println(s);
             return s1;
         })) ;

    }


}
