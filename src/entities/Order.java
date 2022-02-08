package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
	private Date moment;
	private OrderStatus status;

	private List<OrdemItem> orders = new ArrayList<>();
	private Client client;

	// Constructor
	public Order() {

	}

	public Order(Date moment, OrderStatus status, Client client) {
		super();
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	// Getters e Setters
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrdemItem> getOrders() {
		return orders;
	}

	public void setOrders(List<OrdemItem> orders) {
		this.orders = orders;
	}

	// Functions

	public void addItem(OrdemItem item) {
		orders.add(item);
	}

	public void removeItem(OrdemItem item) {
		orders.remove(item);
	}

	public double total() {
		double sum = 0;
		for (OrdemItem x : orders) {
			sum += x.subTotal();
		}
		return sum;
	}

	// ToString
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append(client + "\n");
		for (OrdemItem x : orders) {
			sb.append(x + "\n");
		}
		sb.append("Total price: $" + String.format("%.2f", total()));
		return sb.toString();
	}
}
