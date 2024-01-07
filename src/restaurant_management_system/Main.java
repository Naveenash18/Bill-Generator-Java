package restaurant_management_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {

		String id = null;
		String productName = null;
		int quantity = 0;
		double price = 0.0;
		double totalPrice = 0.0;
		double overAllPrice = 0.0;
		double cgst, subtotal = 0.0, discount = 0.0;
		String choice;
		System.out.println("\t\t\t\t--------------------Invoice-----------------");

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Customer Name: ");
		String customername = scan.nextLine();

		List<Product> product = new ArrayList<Product>();
		do {

			System.out.println("Enter the product details: ");
			System.out.print("Product ID: ");
			id = scan.nextLine();
			System.out.print("Product Name: ");
			productName = scan.nextLine();
			System.out.print("Quantity: ");
			quantity = scan.nextInt();
			System.out.print("Price (per unit): ");
			price = scan.nextDouble();

			totalPrice = price * quantity;

			overAllPrice = overAllPrice + totalPrice;

			product.add(new Product(id, productName, quantity, price, totalPrice));

			System.out.print("Want to add more items? (y or n): ");

			choice = scan.next();

			scan.nextLine();
		} while (choice!="N" || choice !="n");

		Product.displayFormat();

		for (Product p : product) {
			p.display();
		}

		System.out.println("\n\t\t\t\t\t\t\t\t\t\tTotal Amount (Rs.) " + overAllPrice);

		discount = overAllPrice * 2 / 100;
		System.out.println("\n\t\t\t\t\t\t\t\t\t\t    Discount (Rs.) " + discount);

		subtotal = overAllPrice - discount;
		System.out.println("\n\t\t\t\t\t\t\t\t\t\t          Subtotal " + subtotal);

		cgst = overAllPrice * 12 / 100;
		System.out.println("\n\t\t\t\t\t\t\t\t\t\t          GST      " + cgst + "(%)");

		System.out.println("\n\t\t\t\t\t\t\t\t\t\t     Invoice Total " + (subtotal + cgst));
		System.out.println("\t\t\t\t----------------Thank You for Shopping!!-----------------");
		System.out.println("\t\t\t\t                     " + customername);
		System.out.println("\t\t\t\t                     Visit Again");

		scan.close();
	}
}
