public class Spieler { // Klasse repräsentiert einen Spieler im Spiel
    private String name; // Name des Spielers
    private char symbol; // Symbol des Spielers

    public Spieler(String name, char symbol) { // erzeugt einen Spiele mit Name und Symbolr
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() { // Methode um den Namen von außen zu lesen
        return name;
    }

    public char getSymbol() { // Methode um das Symbol von außen zu lesen
        return symbol;
    }
}
