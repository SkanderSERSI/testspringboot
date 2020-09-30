package com.example.demo.tests;

import com.example.demo.controller.EmployeeRestController;
import com.example.demo.models.entities.Employee;
import com.example.demo.services.EmployeeService;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeRestController.class)
public class EmployeeRestControllerUnitaryTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeService service;

    private Employee  alex;

    @Before
    public void setUp(){
        alex = new Employee("alex");
        List<Employee> employees = Arrays.asList(alex);
        given(service.getAllEmployees()).willReturn(employees);
    }

    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray() throws Exception{
        mvc.perform(get("/api/employees")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").value(alex.getName()));
    }



}
