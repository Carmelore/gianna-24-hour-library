// Gianna Leung
// Library- Book Class Assignment Extended

import java.util.*;

public class Main {
  static ArrayList<Book>books = new ArrayList<Book>();
	static ArrayList<Users>users = new ArrayList<Users>();
  static Scanner sc = new Scanner(System.in);

	// user array list creation
			// User : first name, phone number, password, books signed out
	
	public static void main(String[] args) {


//public Book(String genre, String language, String series, String author, String publisher, String title,			int readingLevel, int numPages, boolean ageRestricted, double price)
  Book howToDrinkWater = new Book("nonfiction", "english", "na", "Bob Joe", "smallhouseInc", "how to drink water", 3, 25, false, 5.99);
	Book spaghettiNoodles = new Book("nonfiction", "english", "Noodle Series", "Joe Bob", "GoodBooks", "spaghetti noodles", 5, 500, false, 20.99);
	Book thumbelina = new Book("fairy tale", "english", "na", "Hans Christian Andersen", "Book People" , "thumbelina" , 1, 10, false, 3.99); 
	Book ibSLHaeseMath = new Book("textbook", "english", "Haese Textbooks", "Michael Haese", "Haese Mathematics", "mathematics 10e myp 5 extended", 10, 616, false, 100.0);
	
	books.add(howToDrinkWater);
	books.add(spaghettiNoodles);
	books.add(thumbelina);
	books.add(ibSLHaeseMath);
	


		System.out.println("Press any key to start, or type exit to exit");
		String start = sc.nextLine();
		
		if (start.toLowerCase().equals("exit")) {
			System.out.println("Bye! Have a nice day\n --------------------------------------------");
		}
		
		while (!start.toLowerCase().equals("exit")) {
			// main page with choices
			
			System.out.println("-------------------------------------------------------------------\n");
			System.out.println("Welcome to Book Library! What would you like to do today? (please enter the letter)\n a)borrow/return a book\n b)find user info\n c)find book info\n d)purchase a book\n e)create a library account"); 
			String mainChoice = sc.nextLine();
			
			switch(mainChoice.toLowerCase()) {
				case "a":
					borrowReturn();
					break;
				case "b":
					findUserInfo();
					break;
				case "c":
					findBookInfo(); 
					break;
				case "d":
					
//					System.out.println("Which book would you like to buy? Enter the title below.");
//					String title = sc.nextLine();
//					
//					buyBook(title);
//					System.out.println("Would you like to purchase another book?\n a)yes\n b)no\n");
//					String buyAnother = sc.nextLine();
//					if (buyAnother.toLowerCase().equals("a") || buyAnother.toLowerCase().equals("yes")) {
//						System.out.println("Which book would you like to buy? Enter the title below.");
//						title = sc.nextLine();
//						buyBook(title);
//					}
					
					buyBook();
					
					break;
					
				case "e":
					createAccount(); 
					System.out.println("Thank you for visiting, have a nice day!");
					break;
					
					default:
						System.out.println("Please enter a recognizable letter from the list provided");
			}
			
		}
		
	}
	private static void userEntersB(int i) {
    System.out.println("Please enter the title of the book");
							String title = sc.nextLine();
							for (int j = 0; j < books.size(); j ++) {
								if(title.equals(books.get(j).getTitle())) {

                  System.out.println("This is j" + j);
                        System.out.println("This is i" + i);
                  System.out.println("user get i " + users.get(i));

                  System.out.println("book get j " + books.get(j));
									users.get(i).addBooksIn(books.get(j));
									books.get(j).setOut(false);
									
									Calendar calendar = Calendar.getInstance();
									
									System.out.println("You have returned " + books.get(j).getTitle() + " on " + calendar.getTime());
									
							        Date today = calendar.getTime();
							        calendar.add(Calendar.DAY_OF_YEAR, 1);
							        Date tomorrow = calendar.getTime();
							         
							        if(tomorrow.after(today) == true){
							        	long diff = today.getTime() - tomorrow.getTime();
							        	System.out.println("This book was returned " + diff + " days late. Your account will be disabled until the fine is paid.");
							        	users.get(j).setBanned(true);

                        System.out.println("Would you like to pay now?\n a)yes\n b)no\n");
                        String pay = sc.nextLine();
                        if(pay.toLowerCase().equals("a")) {
                            System.out.println("The late fee is" + diff*0.1);
                            users.get(j).setBanned(false);
                            System.out.println("Thank you! Your account is no longer disabled.");
                            }  else if(pay.toLowerCase().equals("b")) {
                              System.out.println("Your account will remain disabled.");
                            } else {
                              System.out.println("Please enter a valid response from the list above.");
                            }
							        } else {
							        	System.out.println("Have a nice day!");
							        }
								}
								
							}
}

	

private static void userEntersA (int i) {
 if  (users.get(i).isBanned() == false) {
								System.out.println("Please enter the title of the book");
								String title = sc.nextLine();
                boolean theBookIsFound = false;


                      for (int j = 0; j < books.size(); j ++) {
                        if (title.equals(books.get(j).getTitle())) {
                          System.out.println("This book has been found: " + books.get(j).getTitle()); 
                          theBookIsFound = true;


                          int foundBookIndex = j;
                  
                            if (books.get(j).isOut() == true) {
                            System.out.println("Sorry! This book has already been taken out!");
                             }	
                             else {
                              System.out.println("user i is " + users.get(i));

                              users.get(i).addBooksOut(books.get (foundBookIndex));
                                      
                              books.get(j).setOut(true);
                              System.out.println("You have signed out " + books.get(j).getTitle());

                                      
                                        
                                        Calendar cal  = Calendar.getInstance();
                                        int currentDay = cal.get(Calendar.DAY_OF_WEEK);
                                        int leftDays= Calendar.SUNDAY - currentDay;
                                        cal.add(Calendar.DATE, leftDays);
                                        
                                        System.out.println("This book must be returned by " + cal.getTime() + ". There is a $o.1 fine for every day late and your account will be disabled.");
                                        System.out.println("Enjoy your book!");
                                      }

                    
									}}
									if(theBookIsFound == false) {
										System.out.println("It seems this book is not from our library! Make sure to return it to the library it was borrowed from.");
									}
								
                }
                else {
								System.out.println("Your account is currently disabled due to unpaid fees. To pay the late fees, access your account through returning books");
							  }
}

private static void borrowReturn() {
		
    System.out.println("Hello! Do you have an existing account with our library?\n a)yes\n b)no\n");
		String yesno = sc.nextLine();


		if (yesno.toLowerCase().equals("a") || yesno.toLowerCase().equals("yes")) {
			System.out.println("Please enter your phone number");
			int number = Integer.parseInt(sc.nextLine());

      for (int i = 0; i < users.size(); i ++) {
				if (number == users.get(i).getPhoneNumber()) {
					System.out.println("Enter your password");
					String pass = sc.nextLine();
					if (pass.equals(users.get(i).getPassword())) {
						
						System.out.println("Welcome! Are you...\n a)borrowing books\n b)returning books\n");
						String userDoing = sc.nextLine(); 
						if (userDoing.toLowerCase().equals("a")) {
							userEntersA(i);  
              System.out.println("Would call userEntersA");
							
						}
						else if(userDoing.toLowerCase().equals("b")) {
              userEntersB(i);
                System.out.println("Would call userEntersB");
										}
						else {
							System.out.println("Please enter a valid response from the list above.");
						}
					}
					else {
						System.out.println("The password you entered is incorrect. Please try again.");
					}
				
        }
				else {
					System.out.println("This number is not registered in the system. Please try again.");
				}
			}
      
    }
      else {
        System.out.println("You need to create an account to borrow books. Create an account through choice e on the main menu.");
      }
  }
		
	private static void findUserInfo() {
		System.out.println("Do you have an existing Book Library account?\n a)yes\n b)no\n");
		String accountExist = sc.nextLine();
		if (accountExist.toLowerCase().equals("a") || accountExist.toLowerCase().equals("yes")) {
			System.out.println("Please enter your phone number");
			int number = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < users.size(); i ++) {
				if (number == users.get(i).getPhoneNumber()) {
					System.out.println("Enter your password");
					String pass = sc.nextLine();
					if (pass.equals(users.get(i).getPassword())) {
						System.out.println(users.get(i));
					}
					else {
						System.out.println("The password you entered is incorrect. Please try again.");
					}
				}
				else {
					System.out.println("This number is not registered in the system. Please try again.");
				}
			}
		}
		else if (accountExist.toLowerCase().equals("b") || accountExist.toLowerCase().equals("no")){
			createAccount();
		}
		else {
			System.out.println("Please enter a valid response from the list above.");
		}
	}
		
		private static void printAllBooks() {
      System.out.println("Here are all the books you have blahblahb:");
  for (Book eachBook: books) {
    System.out.println(eachBook.getTitle());
  }
    }
		
		
	private static void findBookInfo() {

    printAllBooks();
		System.out.println("Which book would you like to find?"); 
		String book = sc.nextLine();
    book = book.toLowerCase();
    boolean isFound = false;

		for (int i = 0; i < books.size(); i ++) {

			if(book.equals(books.get(i).getTitle())) {

				System.out.println("The title is "+ books.get(i).getTitle());
				System.out.println("The genre is " + books.get(i).getGenre());
				System.out.println("The Author is " + books.get(i).getAuthor());
        isFound = true;
			}
		}
    if (isFound == false) {
      System.out.println("This book is not in our library.");
    }
	}
	
	private static void buyBook() {
		
		System.out.println("Which book would you like to buy? Enter the title below.");
		String title = sc.nextLine();
		
		for (int i = 0; i < books.size(); i++) {
			if (title.toLowerCase().equals(books.get(i).getTitle())) {
				if (books.get(i).isBought() == false && books.get(i).getDamage() >= 100) {
					System.out.println("This book is" + books.get(i).getPrice() + ". Would you like to continue?\n a)yes\n b)no\n");
					String buy = sc.nextLine();
					if (buy.toLowerCase().equals("a") || buy.toLowerCase().equals("yes")) {
						books.get(i).setBought(true);
						System.out.println("You have bought" + title);
						books.remove(i);
					}
					else if (buy.toLowerCase().equals("b") || buy.toLowerCase().equals("no")) {
						System.out.println("Have a nice day.");
					}
					else {
						System.out.println("Please enter a valid response based on the list above.");
					}
				}
				else {
					System.out.println("This book is not yt available for purchase.");
				}
			}
			else {
				System.out.println("This book does not exist in our library. Try again, and pay attention to spelling!");
			}
		}

	}
	
	private static void createAccount(){
		System.out.println("Please follow the instructions given in order to create your account.\n Enter your phone number");
		int userPhone = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < users.size(); i ++) {
			if(userPhone == users.get(i).getPhoneNumber());{
				System.out.println("This number has already been used to create another account. Please enter another number.");
			}
		}
		System.out.println("Enter your first name");
		String userName = sc.nextLine();
		System.out.println("Please create a password for this account. Make sure it is strong as well as memorable!");
		String userPass = sc.nextLine();
		users.add(new Users(userPhone, userName, userPass));
		System.out.println("Your account has been created. You can now borrow books");
		
	}
		     
}
