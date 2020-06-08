import java.util.ArrayList;
import java.util.Scanner;

// Gianna
// Users Class for Library

public class Users {
	
	Scanner sc = new Scanner(System.in);
	
	// instance variables  
	private String firstName;
	private String password;
	private ArrayList<Book> booksOut = new ArrayList<Book> ();
	private ArrayList<Book> booksIn = new ArrayList<Book>() ;
	private boolean isBanned;
	private int phoneNumber;
	
	// constructors
	public Users() {
		this.booksOut = null;
		this.booksIn = null;
		this.isBanned = false; 
	}

	public Users(int phoneNumber, String firstName, String password) {
		super();
		this.phoneNumber = phoneNumber;
		this.firstName = firstName;
		this.password = password;
	}
	
	
	// getter setters

	public ArrayList<Book> getBooksOut() {
		return booksOut;
	}

	public void addBooksOut(Book boogrs) {
		this.booksOut.add(boogrs);
	}

	public ArrayList<Book> getBooksIn() {
		return booksIn;
	}

	public void addBooksIn(Book book) {
		this.booksIn.add(book);
	}

	public boolean isBanned() {
		return isBanned;
	}

	public void setBanned(boolean isBanned) {
		this.isBanned = isBanned;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getPassword() {
		return password;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	
	
	// toString
	@Override
	public String toString() {
		return "Users [firstName=" + firstName + ", password=" + password + ", booksOut=" + booksOut + ", booksIn="
				+ booksIn + ", isBanned=" + isBanned + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	// behavioural methods
	
	
	
	
	
}
