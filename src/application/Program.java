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
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("--- Test 1: Seller FindById ---");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n--- Test 2: Seller FindByDepartment ---");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n--- Test 3: Seller FindAll ---");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
	}
		System.out.println("\n--- Test 4: Seller insert ---");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id =" + newSeller.getId());
		
		System.out.println("\n--- Test 5: Seller Update ---");
		seller = sellerDao.findById(1);
		seller.setName("Mario Green");
		sellerDao.update(seller);
		System.out.println("Update feito");
		
		System.out.println("\n--- Test 6: Delete Seller ---");
		System.out.println("Digite o ID para ser deletado: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Finalizado: ");
		
}
	
}
