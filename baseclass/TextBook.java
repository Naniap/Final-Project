package baseclass;

import java.io.Serializable;

public class TextBook implements Serializable {
	private static final long serialVersionUID = 1721474050182922274L;
	private String bookName, author, year, volume;
	/**
	 * 
	 * @param bookName name of textbook
	 * @param author author's name
	 * @param year year of when the book was released
	 * @param volume the volume
	 */
	public TextBook(String bookName, String author, String year, String volume) {
		this.bookName = bookName;
		this.author = author;
		this.year = year;
		this.volume = volume;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	@Override
	public String toString() {
		return bookName;
	}
}
