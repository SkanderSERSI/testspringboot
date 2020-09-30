package com.example.demo.tests;

import com.example.demo.models.entities.Employee;
import com.example.demo.models.repositories.EmployeeRepository;
import com.example.demo.services.EmployeeService;
import com.example.demo.services.EmployeeServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplIntegrationTest{
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public EmployeeService employeeService() {
            return new EmployeeServiceImpl();
        }
    }
    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp(){
        Employee alex = new Employee("alex");

        Mockito.when(employeeRepository.findByName("alex")).thenReturn(alex);
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound(){
        String name = "alex";
        Employee found = employeeService.getEmployeeByName(name);
        Assertions.assertThat(found.getName()).isEqualTo(name);
    }
}
