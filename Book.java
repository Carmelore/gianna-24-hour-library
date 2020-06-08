import java.util.Scanner;

// Gianna
// Book class assignment
public class Book {
	
	Scanner sc = new Scanner(System.in); 
	
	// instance variables  
	private String genre;
	private String language;
	private String series;
	private String author;
	private String location;
	private String publisher;
	private String title;
	private int readingLevel; 
	private int numPages;
	private int damage; //0 is perfect, 3 is needs to be replaced
	private int lastPageRead;
	private boolean isBought;
	private boolean ageRestricted;
	private boolean isOut;
	private double price;
	

	// constructors
	public Book() {
		this.location = null;
		this.damage = 0;
		this.lastPageRead = 0;
		this.isBought = false; 
		this.isOut = false;
		  
	}
      
	public Book(String genre, String language, String series, String author, String publisher, String title,
			int readingLevel, int numPages, boolean ageRestricted, double price) {
		super();
		this.genre = genre;
		this.language = language;
		this.series = series;
		this.author = author;
		this.publisher = publisher;
		this.title = title;
		this.readingLevel = readingLevel;
		this.numPages = numPages;
		this.ageRestricted = ageRestricted;
		this.price = price;
	}

	// getter and setter methods
      
    public String getLocation() {
    	return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public boolean isBought() {
		return isBought;
	}

	public void setBought(boolean isBought) {
		this.isBought = isBought;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getGenre() {
		return genre;
	}

	public String getLanguage() {
		return language;
	}

	public String getSeries() {
		return series;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getTitle() {
		return title;
	}

	public int getReadingLevel() {
		return readingLevel;
	}

	public int getNumPages() {
		return numPages;
	}

	public boolean isAgeRestricted() {
		return ageRestricted;
	}

	public int getLastPageRead() {
		return lastPageRead;
	}

	public void setLastPageRead(int lastPageRead) {
		this.lastPageRead = lastPageRead;
	}

	public boolean isOut() {
		return isOut;
	}

	public void setOut(boolean isOut) {
		this.isOut = isOut;
	}

	// static methods
    public static double cadToUsd(){
		return 0;
    }
    
    //toString
    
    
    // behavioural methods
    public void move(String newLocation){
    	// code to move the book
    	newLocation = null; 
    	location = newLocation; 
    	System.out.println("You have moved the book. It is now in " + location + ".");
    }


	@Override
	public String toString() {
		return "Book [sc=" + sc + ", genre=" + genre + ", language=" + language + ", series=" + series + ", author="
				+ author + ", location=" + location + ", publisher=" + publisher + ", title=" + title
				+ ", readingLevel=" + readingLevel + ", numPages=" + numPages + ", damage=" + damage + ", lastPageRead="
				+ lastPageRead + ", isBought=" + isBought + ", ageRestricted=" + ageRestricted + ", isOut=" + isOut
				+ ", price=" + price + "]";
	}

	public void readPage(int numPagesRead){
    	// code to read the book
    	if (lastPageRead < numPages) {
    		lastPageRead = lastPageRead + numPagesRead;
    		System.out.println("You have read " + numPagesRead + " pages. You are now on page " + lastPageRead + ".");
    	}
    	
    	if (lastPageRead >= numPages) {
    		System.out.println("Congrats! You have finished reading this book.");
    	}
		
    }

	public void rip(){
	    // code to rip the book
		if (damage < 3) {
			damage = damage + 1;
			System.out.println("You have damaged the book. It is now at level " + damage + " of damage.");
		}
		
		if (damage ==3) {
			System.out.println("This book is too damaged and needs to be replaced.");
		}
	}

    public void buy(){
        // code to buy the book
//    	if (isBought == false) {
//    		isBought = true;
//    		System.out.println("You have bought " + bookTitle + ".");
//    	}
//    	else {
//    		System.out.println("Sorry! " + bookTitle + " has already been bought."); 
//    	}
    	
    	
//    	if(this.isBought() == false && this.getDamage() > 100) {
//			System.out.println("This book is" + this.getPrice() + ". Would you like to continue?\n a)yes\n b)no\n");
//			String buy = sc.nextLine();
//			if (buy.toLowerCase().equals("a") || buy.toLowerCase().equals("yes")) {
//				this.isBought = true;
//				System.out.println("You have bought" + title);
//			}
//			else if (buy.toLowerCase().equals("b") || buy.toLowerCase().equals("no")) {
//				System.out.println("Have a nice day.");
//			}
//		}
//		else {
//			System.out.println("This book is not yet available for purchase. :3");
//		}
    }
}
