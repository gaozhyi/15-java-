package entity;

@SuppressWarnings("serial")
public class Recommended implements java.io.Serializable {

	private Integer recommendedId;
	private Book book;

	public Recommended() {
	}

	public Recommended(Book book) {
		this.book = book;
	}

	public Integer getRecommendedId() {
		return this.recommendedId;
	}

	public void setRecommendedId(Integer recommendedId) {
		this.recommendedId = recommendedId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}