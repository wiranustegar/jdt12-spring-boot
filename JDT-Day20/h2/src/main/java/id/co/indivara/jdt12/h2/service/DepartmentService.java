package id.co.indivara.jdt12.h2.service;

import id.co.indivara.jdt12.h2.entity.Department;

import java.util.List;

public interface DepartmentService {

    //POST "/departments"
    Department createDepartment(Department department);

    //GET "/departments"
    List<Department> fetchDepartmentList();

    //PUT "/departments/{id}"
    Department updateDepartment(Department department, Long departmentId);

    //DELETE "/departments/{id}"
    void deleteDepartment(Long departmentId);
}
