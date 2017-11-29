package entity;

@SuppressWarnings("serial")
public class Ordersbook implements java.io.Serializable {

	private Integer ordersBookId;
	private Orders orders;
	private Book book;
	private Integer bookAmount;

	public Ordersbook() {
	}

	public Ordersbook(Orders orders, Book book, Integer bookAmount) {
		this.orders = orders;
		this.book = book;
		this.bookAmount = bookAmount;
	}

	public Integer getOrdersBookId() {
		return this.ordersBookId;
	}

	public void setOrdersBookId(Integer ordersBookId) {
		this.ordersBookId = ordersBookId;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getBookAmount() {
		return this.bookAmount;
	}

	public void setBookAmount(Integer bookAmount) {
		this.bookAmount = bookAmount;
	}

}