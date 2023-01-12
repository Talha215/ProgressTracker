package connections;

import java.util.List;

// DAO interface --> list out and outline the functionality we want to have with our data
public interface DepartmentDao {

	public List<Department> getAllDepartments();
	
	public Department getDepartmentById(int id);
	
	public Department getDepartmentByName(String deptName);
	
    public boolean addDepartment(Department dept);
    
    public boolean deleteDepartment(int deptId);
    
    public boolean updateDepartment(Department dept);
	
}
