package com.cegeka.school.domain.employees;

import com.cegeka.school.domain.credentials.Credential;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    private Credential testCredential;
    private Employee testEmployee;

    @Before
    public void setUp() throws Exception {
    testCredential = new Credential(0, "test.example@cegeka.com","123",10);
    testEmployee = new Employee();
    testEmployee.setCredential(testCredential);
    }

    @Test
    public void getFirstNameFromEmail_shouldReturnStringFirstName() throws Exception {
        Assertions.assertThat(testEmployee.getFirstNameFromEmail()).isEqualTo("Test");
    }

    @Test
    public void getLastNameFromEmail_shouldReturnStringLastName() throws Exception {
        Assertions.assertThat(testEmployee.getLastNameFromEmail()).isEqualTo("Example");
    }


}