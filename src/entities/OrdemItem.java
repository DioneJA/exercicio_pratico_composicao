package entities;

public class OrdemItem {
	private int quantity;
	private double price;

	private Product product;

	// Constructors
	public OrdemItem() {

	}

	public OrdemItem(int quantity, double price, Product product) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	// Getters e Setters
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	// Function
	public double subTotal() {
		return quantity * price;
	}

	// toString
	public String toString() {
		return product + ", $" + String.format("%.2f", price) + ", Quantity: " + quantity + ", Subtotal: $"
				+ String.format("%.2f",subTotal());
	}
}
