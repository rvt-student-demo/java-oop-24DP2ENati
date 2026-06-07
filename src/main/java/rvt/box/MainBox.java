package rvt.box;

public class MainBox {
    public static void main(String[] args) {
        Box box = new Box(10);
        Box anotherBox = new Box(5);

        box.add(new Book("J.K. Rowling", "Harry Potter and the Philosopher's Stone", 1.2));
        box.add(new Book("George Orwell", "1984", 0.8));
        box.add(new Book("J.R.R. Tolkien", "The Hobbit", 1.1));

        box.add(new cd("Queen", "A Night at the Opera", 1975));
        box.add(new cd("Michael Jackson", "Thriller", 1982));
        box.add(new cd("Adele", "21", 2011));

        anotherBox.add(new cd("Ed Sheeran", "Divide", 2017));
        anotherBox.add(new cd("Imagine Dragons", "Night Visions", 2012));
        anotherBox.add(new cd("Coldplay", "Parachutes", 2000));
        anotherBox.add(new cd("Linkin Park", "Meteora", 2003));

        box.add(anotherBox);

        System.out.println(box);
    }
}