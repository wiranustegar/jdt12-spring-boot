package id.co.indivara.jdt12.h2.controller;

import id.co.indivara.jdt12.h2.entity.Department;
import id.co.indivara.jdt12.h2.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/departments")
    public Department createDepartment(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Long departmentId){
        return departmentService.updateDepartment(department, departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return "d";
    }
}
