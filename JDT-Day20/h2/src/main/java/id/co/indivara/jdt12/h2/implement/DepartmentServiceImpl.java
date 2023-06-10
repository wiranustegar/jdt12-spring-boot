package id.co.indivara.jdt12.h2.implement;

import id.co.indivara.jdt12.h2.entity.Department;
import id.co.indivara.jdt12.h2.repository.DepartmentRepository;
import id.co.indivara.jdt12.h2.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Department department, Long departmentId) {
        Department dep = departmentRepository.findById(departmentId).get();
        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            dep.setDepartmentName(department.getDepartmentName());
        }if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            dep.setDepartmentAddress(department.getDepartmentAddress());
        }if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            dep.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(dep);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
