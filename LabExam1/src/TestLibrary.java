import java.util.*;
public class TestLibrary {
Scanner s = new Scanner(System.in);
static int isbn;
static int option;
static String author,title,genre,refCode;
public static void main(String[] args) {
	Library l = new Library();
	Scanner s = new Scanner(System.in);
	do {
	System.out.println("*********************************************************************");
	System.out.println();
	System.out.println("* \t Welcome to KSU Library :)");
	System.out.println("* \t -------------------");
	System.out.println("* \t Please enter one of the following options: ");
	System.out.println("* \t 1) Add a book");
	System.out.println("* \t 2) Delete a book");
	System.out.println("* \t 3) Find a book");
	System.out.println("* \t 4 List all books");
	System.out.println("* \t 5) List books for a given genre");
	System.out.println("* \t 6) Number of books for a given author");
	System.out.println("* \t 7) Total number of books");
	System.out.println("* \t 8) Exit");
	System.out.println("* ");
	System.out.println("*********************************************************************");
	System.out.println();
	System.out.print("Enter your option : ");
	option = s.nextInt();
	switch(option){
		case 1: System.out.print("Please, enter the book details #ISBN, author, title, and genre: ");
				isbn = s.nextInt();
				author = s.next();
				title = s.next();
				genre = s.next();
				if(l.addBook(isbn, author, title, genre))
					System.out.println("The book is added successfully");
				else
						System.out.println("The book is either added before or wrong #ISBN is entered");
				break;
				
		case 2: System.out.print("Please, enter the #ISBN of the book you want to delete: ");
				isbn = s.nextInt();
		 		l.deleteBook(isbn);
		 		System.out.println("Deleted.");
		 		break;
		 		
		case 3: System.out.print("Please, enter the #ISBN of the book you want to find: ");
				isbn = s.nextInt();
				if(l.findBook(isbn)==-1)
		    		System.out.println("Book was not found");
		    	else
		    		System.out.println("Book number "+isbn+" was found in index "+l.findBook(isbn));
		 		break;
		 		
		case 4: l.printAll();
				break;
		
		case 5: System.out.print("Please, enter the Genre you want: ");
				genre = s.next();
				l.printGenre(genre);
				break;
				
				
		case 6: System.out.println("Please, enter the Author's name: ");
				author = s.next();
				System.out.println("The author: "+author+" has "+ l.getNumberOfBooksByAuthor(author)+" books");
				break;
				
		case 7: System.out.println("The total number of books is: "+l.getNumberOfBooks());
				break;
	}
	} while(option != 8);
	System.out.println("Thanks. Goodbye!");
}
}
