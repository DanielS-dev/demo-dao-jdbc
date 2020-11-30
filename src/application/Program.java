package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
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

	}

}
