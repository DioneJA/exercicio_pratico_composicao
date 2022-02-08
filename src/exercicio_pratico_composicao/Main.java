package exercicio_pratico_composicao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.OrdemItem;
import entities.Order;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date date = sdf.parse(sc.next());
		Client client = new Client(clientName, clientEmail, date);
		
		System.out.println("\nEnter order data: ");
		System.out.print("Status: ");
		String status = sc.next();
		OrderStatus os1 = OrderStatus.valueOf(status);
		
		Date dateOfMoment = new Date();
		Order orders = new Order(dateOfMoment, os1, client);
		System.out.print("\nHow many items to this order? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("\nEnter #" + (i + 1) + " item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			Product product = new Product(productName, productPrice);
			OrdemItem o = new OrdemItem(productQuantity, productPrice, product);
			orders.addItem(o);
		}
		System.out.println("\nORDER SUMMARY: ");
		System.out.println(orders);
		sc.close();
	}

}
