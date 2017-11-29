package entity;

@SuppressWarnings("serial")
public class Bargain implements java.io.Serializable {

	private Integer bargainId;
	private Book book;
	private Double bookNewPrice;

	public Bargain() {
	}

	public Bargain(Book book, Double bookNewPrice) {
		this.book = book;
		this.bookNewPrice = bookNewPrice;
	}

	public Integer getBargainId() {
		return this.bargainId;
	}

	public void setBargainId(Integer bargainId) {
		this.bargainId = bargainId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Double getBookNewPrice() {
		return this.bookNewPrice;
	}

	public void setBookNewPrice(Double bookNewPrice) {
		this.bookNewPrice = bookNewPrice;
	}

}