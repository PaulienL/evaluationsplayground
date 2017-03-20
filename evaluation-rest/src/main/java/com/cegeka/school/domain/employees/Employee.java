package com.cegeka.school.domain.employees;

import com.cegeka.school.domain.credentials.Credential;
import com.cegeka.school.domain.meetings.Meeting;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {

    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "JOB_DESCRIPTION")
    private String jobDescription;
    @Column(name = "EVALUATOR_ID")
    private int evaluatorID;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "EMPLOYEE_ID")
    private Credential credential;
    @Id
    @Column(name = "EMPLOYEE_ID")
    private int employeeID;
    @OneToMany
    @JoinColumn( referencedColumnName = "EMPLOYEE_ID")
    private List<Meeting> meetings;

   public Employee(){}

    public String getFirstNameFromEmail(){
       String input = credential.getEmail();
       String firstName = input.replace("@cegeka.com","")
                               .substring(0,input.indexOf("."));
        String output = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
        return output;

    }

    public String getLastNameFromEmail(){
        String input = credential.getEmail();
        String lastName = input.replace("@cegeka.com","")
                .substring(input.indexOf(".")+1, input.indexOf("@"));

        String output = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
        return output;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

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

    public Credential getCredential() {
        return credential;
    }

    public List<Meeting> getMeetings() {
        return meetings;
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
