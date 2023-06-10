package id.co.indivara.jdt12.h2.repository;

import id.co.indivara.jdt12.h2.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
