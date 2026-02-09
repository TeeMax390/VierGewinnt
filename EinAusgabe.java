import java.util.Scanner;

// Diese Klasse kapselt die Ein- und Ausgabe über die Konsole.
// So ist der Rest des Codes nicht direkt von System.in/System.out abhängig.
public class EinAusgabe {

    // Scanner-Objekt, um Eingaben von der Konsole zu lesen.
    private Scanner scanner = new Scanner(System.in);

    // Liest eine Spaltennummer vom Spieler ein.
    // Der Spieler wird übergeben, damit wir seinen Namen und sein Symbol anzeigen können.
    public int leseSpalte(Spieler spieler) {
        // Ausgabe einer Eingabeaufforderung.
        // Beispiel: "Spieler 1 (X), wähle eine Spalte: "
        System.out.print(spieler.getName() + " (" + spieler.getSymbol() + "), wähle eine Spalte: ");

        // Liest eine ganze Zahl von der Konsole.
        // Achtung: Wenn der Benutzer etwas Ungültiges eingibt (z.B. Buchstaben),
        // wirft nextInt() eine Exception. Das könnte man später noch abfangen.
        return scanner.nextInt();
    }

    // Gibt einen Text in der Konsole aus, gefolgt von einem Zeilenumbruch.
    public void ausgabe(String text) {
        System.out.println(text);
    }
}

