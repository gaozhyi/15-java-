package entity;

import java.sql.*;


@SuppressWarnings("serial")
public class Book implements java.io.Serializable {


	private Integer bookId;
	private String bookNumber;
	private String bookName;
	private String bookAuthor;
	private String bookPress;
	private String bookPicture;
	private Integer bookAmount;
	private Type type;
	private Timestamp bookShelveTime;
	private Double bookPrice;
	private String bookRemark;
	private Integer bookSales;
	private Double bookNewPrice;

	public Book() {
	}

	public Book(String bookNumber, String bookName, String bookAuthor,
			String bookPress, String bookPicture, Integer bookAmount,
			Type type, Timestamp bookShelveTime, Double bookPrice,
			Integer bookSales) {
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPress = bookPress;
		this.bookPicture = bookPicture;
		this.bookAmount = bookAmount;
		this.type = type;
		this.bookShelveTime = bookShelveTime;
		this.bookPrice = bookPrice;
		this.bookSales = bookSales;
	}

	public Book(String bookNumber, String bookName, String bookAuthor,
			String bookPress, String bookPicture, Integer bookAmount,
			Type type, Timestamp bookShelveTime, Double bookPrice,
			String bookRemark, Integer bookSales,Double bookNewPrice) {
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPress = bookPress;
		this.bookPicture = bookPicture;
		this.bookAmount = bookAmount;
		this.type = type;
		this.bookShelveTime = bookShelveTime;
		this.bookPrice = bookPrice;
		this.bookRemark = bookRemark;
		this.bookSales = bookSales;
		this.bookNewPrice = bookNewPrice;
	}

	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookNumber() {
		return this.bookNumber;
	}

	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return this.bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPress() {
		return this.bookPress;
	}

	public void setBookPress(String bookPress) {
		this.bookPress = bookPress;
	}

	public String getBookPicture() {
		return this.bookPicture;
	}

	public void setBookPicture(String bookPicture) {
		this.bookPicture = bookPicture;
	}

	public Integer getBookAmount() {
		return this.bookAmount;
	}

	public void setBookAmount(Integer bookAmount) {
		this.bookAmount = bookAmount;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Timestamp getBookShelveTime() {
		return this.bookShelveTime;
	}

	public void setBookShelveTime(Timestamp bookShelveTime) {
		this.bookShelveTime = bookShelveTime;
	}

	public Double getBookPrice() {
		return this.bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookRemark() {
		return this.bookRemark;
	}

	public void setBookRemark(String bookRemark) {
		this.bookRemark = bookRemark;
	}

	public Integer getBookSales() {
		return this.bookSales;
	}

	public void setBookSales(Integer bookSales) {
		this.bookSales = bookSales;
	}

	public Double getBookNewPrice() {
		return bookNewPrice;
	}

	public void setBookNewPrice(Double bookNewPrice) {
		this.bookNewPrice = bookNewPrice;
	}

}