
public class Book {
int isbn,count;
String author,title,genre,refCode;


public boolean equals(Book obj) {
	if(isbn==obj.getIsbn())
		return true;
	else
		return false;}

public Book() {
	
}

public String getRefCode() {
	return refCode;
}

public Book(int isbn, String author, String title, String genre) {
	this.isbn = isbn;
	this.author = author;
	this.title = title;
	this.genre = genre;
}
public int getIsbn() {
	return isbn;
}
public void setIsbn(int isbn) {
	this.isbn = isbn;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}

public void generateReference() {
	String a = author.substring(0,1).toUpperCase();
	String a1 = author.substring(1,2).toUpperCase();
	String a2 = genre.substring(0,1).toUpperCase();
	String a3 = genre.substring(1,2).toUpperCase();
	refCode = a + a1 + "-"+a2 +a3;
}

public boolean verifyISBN(int ISBN) {
int n1,n2,n3,n4;
	
	n4=ISBN%10;
	n3=ISBN/10%10;
	n2=ISBN/100%10;
	n1=ISBN/1000%10;
	
	if((n1 * 3 + n2 *2 + n3)%4 == n4)
		return true;
	return false;
}



public void printBookInfo() {
	generateReference();
	System.out.println("Title: "+title+"\n \n Author: "+author+"\n \n ISBN: "+isbn+" - Reference Code : "+refCode+"\n \n Genre: "+ genre);
}
}
