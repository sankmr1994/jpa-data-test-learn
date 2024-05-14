package com.learn.jpaDataTest.jpadatatest.repository;

import com.learn.jpaDataTest.jpadatatest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);

    @Query("SELECT e FROM Employee e WHERE e.firstName = ?1 AND e.lastName = ?2")
    Employee findBYFirstNameAndLastName(String firstName, String lastName);


    @Query("SELECT e FROM Employee e WHERE e.firstName = :firstName AND e.lastName = :lastName")
    Employee findBYFirstNameAndLastNameUsingNamed(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query(value = "SELECT * FROM employees e WHERE e.first_name = ?1 AND e.last_name = ?2", nativeQuery = true)
    Employee findBYFirstNameAndLastNativeSQL(String firstName, String lastName);

    @Query(value = "SELECT * FROM employees e WHERE e.first_name = :firstName AND e.last_name = :lastName", nativeQuery = true)
    Employee findBYFirstNameAndLastNativeSQLNamedParam(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
