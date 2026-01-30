import java.util.Scanner;

public class EinAusgabe {
    private Scanner scanner = new Scanner(System.in);

    public int leseSpalte(Spieler spieler) {
        System.out.print(spieler.getName() + " (" + spieler.getSymbol() + "), wähle eine Spalte: ");
        return scanner.nextInt();
    }

    public void ausgabe(String text) {
        System.out.println(text);
    }
}
