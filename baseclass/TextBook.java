package baseclass;

public class TextBook {
	private String bookName, author, year, volume;
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
