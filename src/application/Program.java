package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("=== TEST 2: seller findByDepartment ===");
		List<Seller> sellersList = sellerDao.findByDepartment(2);

		for (Seller seller2 : sellersList) {
			System.out.println(seller2);
		}
		
		System.out.println("=== TEST 3: seller findAll ===");
		sellersList = sellerDao.findAll();
		
		for (Seller seller2 : sellersList) {
			System.out.println(seller2);
		}
		
		System.out.println("=== TEST 4: seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, new Department(1, null));
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId());
		
		System.out.println("=== TEST 5: seller update ===");
		seller = sellerDao.findById(2);
		seller.setName("Bruce Waine");
		sellerDao.update(seller);
		System.out.println("Update Completed");
		
		System.out.println("=== TEST 6: seller delete ===");
		System.out.println("Enter id for delete test: ");
		int id = input.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Dellete Completed");
		
		input.close();
	}

}
