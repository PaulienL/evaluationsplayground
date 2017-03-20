package com.cegeka.school.domain.credentials;

import javax.persistence.*;

@Entity
@Table(name = "CREDENTIALS")
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "CREDENTIAL_ID")
    private int credentialID;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMPLOYEE_ID")
    private int employeeID;

    public Credential(){}

    public Credential(int meetingID, String email, String password, int employeeID) {
        this.credentialID = meetingID;
        this.email = email;
        this.password = password;
        this.employeeID = employeeID;
    }

    public int getCredentialID() {
        return credentialID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Credential that = (Credential) o;

        if (credentialID != that.credentialID) return false;
        if (employeeID != that.employeeID) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        return password != null ? password.equals(that.password) : that.password == null;
    }

    @Override
    public int hashCode() {
        int result = credentialID;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + employeeID;
        return result;
    }
}
