package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		DepartmentDao departmentDao = new DaoFactory().createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ===");
		Department department = departmentDao.findById(1);
		
		System.out.println(department);
		
		
		System.out.println("=== TEST 2: department findAll ===");
		List<Department> departmentList = departmentDao.findAll();
		
		for (Department department2 : departmentList) {
			System.out.println(department2);
		}
		
		System.out.println("=== TEST 3: departmet insert ===");
		Department newDepartment = new Department(null, "Test");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Id = " + newDepartment.getId());
		
		System.out.println("=== TEST 4: department update ===");
		department = departmentDao.findById(2);
		department.setName("Bruce Waine");
		departmentDao.update(department);
		System.out.println("Update Completed");
		
		System.out.println("=== TEST 5: department delete ===");
		System.out.println("Enter id for delete test: ");
		int id = input.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Dellete Completed");
		
		input.close();

	}

}
