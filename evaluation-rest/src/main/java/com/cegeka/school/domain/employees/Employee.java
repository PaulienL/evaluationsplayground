package com.cegeka.school.domain.employees;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "JOB_DESCRIPTION")
    private String jobDescription;
    @Id
    @Column(name = "EVALUATOR_ID")
    private int evaluatorID;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
    private int employeeID;

   private Employee(){}

    public Employee(String lastName, String firstName, String jobDescription, int evaluatorID, int employeeID) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.jobDescription = jobDescription;
        this.evaluatorID = evaluatorID;
        this.employeeID = employeeID;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public int getEvaluatorID() {
        return evaluatorID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (evaluatorID != employee.evaluatorID) return false;
        if (employeeID != employee.employeeID) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        return jobDescription != null ? jobDescription.equals(employee.jobDescription) : employee.jobDescription == null;
    }

    @Override
    public int hashCode() {
        int result = lastName != null ? lastName.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (jobDescription != null ? jobDescription.hashCode() : 0);
        result = 31 * result + evaluatorID;
        result = 31 * result + employeeID;
        return result;
    }
}
