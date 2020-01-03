
public class Library {
	Book[] libraryBooks;
	int numOfBooks;
	static final int MAX_SIZE=100;
	Book b = new Book();
	public Library() {
		libraryBooks = new Book[MAX_SIZE];
		numOfBooks = 0;
	}
	
	public boolean addBook(int ISBN,String author,String title,String genre) {
		Book b=new Book(ISBN,author,title,genre);
		
		if(b.verifyISBN(ISBN)) {
			if(findBook(ISBN)==-1) {
				libraryBooks[numOfBooks++]=b;
				return true;
			}
				
			else 
				
				return false;
		}
			return false;
	}
	
	public boolean addbook(Book i) {
		if(i.verifyISBN(i.getIsbn())) {
				if(findBook(i.isbn)==-1) {
					libraryBooks[numOfBooks++]=i;
					return true;
				}else 
					return false;
			}
		else
			return false;
	}

	public int findBook(int a) {
		if(libraryBooks[0]!=null) {
		for(int i=0; i<numOfBooks;i++)
			if(a == libraryBooks[i].getIsbn())
				return i;
		}
		return -1;
		
	}

	public int findBook(Book b) {
		for(int i=0;i<libraryBooks.length;i++)
			if(libraryBooks[i].equals(b))
				return i;
		
		return -1;
	}
	
public void deleteBook(int isbn) {
	for(int i=0; i<numOfBooks;i++) {
		if(libraryBooks[i].getIsbn()==isbn)
			libraryBooks[i]= libraryBooks[numOfBooks];
			libraryBooks[numOfBooks--] = null;
	}
}

public void printAll() {
	if(libraryBooks != null)
	for(int i=0; i<numOfBooks;i++) {
		libraryBooks[i].printBookInfo();
		
	}
}

public void printGenre(String g) {
	if(libraryBooks != null)
	for(int i=0; i<numOfBooks;i++) {
		if(libraryBooks[i].getGenre().equalsIgnoreCase(g))
			libraryBooks[i].printBookInfo();
	}
}

public int getNumberOfBooksByAuthor(String Author) {
	int c=0;
	for(int i=0; i<numOfBooks;i++) {
		if(libraryBooks[i].author.equalsIgnoreCase(Author))
			c++;
	}
	return c;
}

public int getNumberOfBooks() {
	return numOfBooks;
}

public void setNumOfBooks(int numOfBooks) {
	this.numOfBooks = numOfBooks;
}

public Book[] getLibraryBooks() {
	return libraryBooks;
}
	
	
}
