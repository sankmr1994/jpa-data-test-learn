package com.learn.jpaDataTest.jpadatatest.repository;

import com.learn.jpaDataTest.jpadatatest.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    public void setUp() {
        employee = Employee.builder()
                .firstName("sandy")
                .lastName("kmr")
                .email("san.kmr@gmail.com")
                .build();
    }

    @DisplayName("Junit test for save employee")
    @Test
    public void givenEmployeeObject_whenSaveEmployee_thenReturnSavedEmployee() {
        //Given - setup
        /*Employee employee = Employee.builder()
                .firstName("sandy")
                .lastName("kmr")
                .email("san.kmr@gmail.com")
                .build();*/

        //When - behaviour that we are going to do
        Employee savedEmployee = employeeRepository.save(employee);

        //Then - verify the output
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }

    @DisplayName("Junit test for get all employee")
    @Test
    public void givenEmployeeList_whenFindAllEmployee_thenReturnEmployeeList() {
        //Given - setup
        Employee employee1 = Employee.builder()
                .firstName("sandy")
                .lastName("kmr")
                .email("san.kmr@gmail.com")
                .build();

        Employee employee2 = Employee.builder()
                .firstName("Mano")
                .lastName("kmr")
                .email("mano.don@gmail.com")
                .build();

        employeeRepository.saveAll(List.of(employee1, employee2));

        //When - behaviour that we are going to do
        List<Employee> employeeList = employeeRepository.findAll();

        //Then - verify the output
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);
    }

    @DisplayName("Junit test for get employee by id")
    @Test
    public void givenEmployeeId_whenFindEmployeeById_returnEmployeeObject() {
        //Given - setup
       /* Employee employee = Employee.builder()
                .firstName("sandy")
                .lastName("kmr")
                .email("san.kmr@gmail.com")
                .build();*/

        employeeRepository.save(employee);

        //When - behaviour that we are going to do
        Employee savedEmployee = employeeRepository.findById(employee.getId()).get();


        //Then - verify the output
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }

    @DisplayName("Junit test for get employee by email")
    @Test
    public void givenEmployeeEmail_whenFindByEmail_thenReturnEmployeeObject() {
        //Given - setup
       /* Employee employee = Employee.builder()
                .firstName("sandy")
                .lastName("kmr")
                .email("san.kmr@gmail.com")
                .build();*/
        employeeRepository.save(employee);

        //When - behaviour that we are going to do
        Employee savedEmployee = employeeRepository.findByEmail(employee.getEmail()).get();

        //Then - verify the output
        assertThat(savedEmployee).isNotNull();
    }

    @DisplayName("Junit test for update employee")
    @Test
    public void givenEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployee() {
        //Given - setup
       /* Employee employee = Employee.builder()
                .firstName("sandy")
                .lastName("kmr")
                .email("san.kmr@gmail.com")
                .build();*/
        employeeRepository.save(employee);

        //When - behaviour that we are going to do
        Employee savedEmployee = employeeRepository.findById(employee.getId()).get();
        savedEmployee.setFirstName("mano");
        savedEmployee.setEmail("mano.don@gmail.com");

        Employee updatedEmployee = employeeRepository.save(savedEmployee);

        //Then - verify the output
        assertThat(updatedEmployee).isNotNull();
        assertThat(updatedEmployee.getFirstName()).isEqualTo("mano");
        assertThat(updatedEmployee.getEmail()).isEqualTo("mano.don@gmail.com");
    }

    @DisplayName("Junit test for delete employee")
    @Test
    public void givenEmployeeObject_whenDeleteEmployee_thenRemoveEmployee() {
        //Given - setup
      /*  Employee employee = Employee.builder()
                .firstName("sandy")
                .lastName("kmr")
                .email("san.kmr@gmail.com")
                .build();*/
        employeeRepository.save(employee);

        //When - behaviour that we are going to do
        employeeRepository.deleteById(employee.getId());

        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());

        //Then - verify the output
        assertThat(optionalEmployee).isEmpty();
    }

    @DisplayName("Junit test for get employee using JPQL query")
    @Test
    public void givenEmployeeFirstNameAndLastName_whenFindByFirstNameAndLastName_thenReturnEmployee() {
        //Given - setup
        /*Employee employee = Employee.builder()
                .firstName("sandy")
                .lastName("kmr")
                .email("san.kmr@gmail.com")
                .build();*/
        employeeRepository.save(employee);

        //When - behaviour that we are going to do
        Employee savedEmployee = employeeRepository.findBYFirstNameAndLastName(employee.getFirstName(), employee.getLastName());

        //Then - verify the output
        assertThat(savedEmployee).isNotNull();
    }

    @DisplayName("Junit test for get employee using JPQL named param query")
    @Test
    public void givenEmployeeFirstNameAndLastName_whenFindByFirstNameAndLastNameUsingNamedParam_thenReturnEmployee() {
        //Given - setup
        /*Employee employee = Employee.builder()
                .firstName("sandy")
                .lastName("kmr")
                .email("san.kmr@gmail.com")
                .build();*/
        employeeRepository.save(employee);

        //When - behaviour that we are going to do
        Employee savedEmployee = employeeRepository.findBYFirstNameAndLastName(employee.getFirstName(), employee.getLastName());

        //Then - verify the output
        assertThat(savedEmployee).isNotNull();
    }

    @DisplayName("Junit test for get employee using Native SQL query")
    @Test
    public void givenEmployeeFirstNameAndLastName_whenFindByFirstNameAndLastNameUsingNativeSQL_thenReturnEmployee() {
        //Given - setup
       /* Employee employee = Employee.builder()
                .firstName("sandy")
                .lastName("kmr")
                .email("san.kmr@gmail.com")
                .build();*/
        employeeRepository.save(employee);

        //When - behaviour that we are going to do
        Employee savedEmployee = employeeRepository.findBYFirstNameAndLastNativeSQL(employee.getFirstName(), employee.getLastName());

        //Then - verify the output
        assertThat(savedEmployee).isNotNull();
    }

    @DisplayName("Junit test for get employee using Native SQL named param query")
    @Test
    public void givenEmployeeFirstNameAndLastName_whenFindByFirstNameAndLastNameUsingNativeSQLNamedParam_thenReturnEmployee() {
        //Given - setup
        /*Employee employee = Employee.builder()
                .firstName("sandy")
                .lastName("kmr")
                .email("san.kmr@gmail.com")
                .build();*/
        employeeRepository.save(employee);

        //When - behaviour that we are going to do
        Employee savedEmployee = employeeRepository.findBYFirstNameAndLastNativeSQLNamedParam(employee.getFirstName(), employee.getLastName());

        //Then - verify the output
        assertThat(savedEmployee).isNotNull();
    }


}