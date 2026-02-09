// Diese Klasse repräsentiert das Spielfeld von Vier Gewinnt.
// Intern wird ein 2D-Array aus chars verwendet, z.B. '.' für leer, 'X' oder 'O' für Steine.
public class Spielfeld {

    // 2D-Array für das Spielfeld.
    // feld[zeile][spalte]
    private char[][] feld;

    // Anzahl der Zeilen (Standard: 6).
    private final int zeilen = 6;

    // Anzahl der Spalten (Standard: 7).
    private final int spalten = 7;

    // Konstruktor: Erzeugt das Spielfeld und initialisiert alle Felder mit '.' (leer).
    public Spielfeld() {
        // Erzeugt ein 2D-Array mit 6 Zeilen und 7 Spalten.
        feld = new char[zeilen][spalten];

        // Doppelte Schleife, um jedes Feld zu initialisieren.
        for (int i = 0; i < zeilen; i++) {          // Geht jede Zeile durch.
            for (int j = 0; j < spalten; j++) {     // Geht jede Spalte in der Zeile durch.
                // '.' bedeutet: Dieses Feld ist leer.
                feld[i][j] = '.';
            }
        }
    }

    // Versucht, einen Stein in die angegebene Spalte zu setzen.
    // Rückgabewert:
    // - true: Stein wurde erfolgreich gesetzt.
    // - false: Spalte existiert nicht oder ist voll.
    public boolean setzeStein(int spalte, char symbol) {
        // Zuerst prüfen wir, ob die Spalte überhaupt im gültigen Bereich liegt.
        // Gültige Spalten sind 0 bis spalten-1 (also 0 bis 6).
        if (spalte < 0 || spalte >= spalten) {
            return false;
        }

        // Wir gehen die Zeilen von unten nach oben durch (also von der letzten Zeile zur ersten).
        // Das simuliert das "Herunterfallen" des Steins.
        for (int i = zeilen - 1; i >= 0; i--) {
            // Wenn das Feld in dieser Zeile und Spalte noch leer ist ('.'),
            // können wir hier den Stein platzieren.
            if (feld[i][spalte] == '.') {
                feld[i][spalte] = symbol; // Stein setzen.
                return true;              // Zug war gültig.
            }
        }

        // Wenn wir keine freie Position in dieser Spalte gefunden haben,
        // ist die Spalte voll → ungültiger Zug.
        return false;
    }

    // Gibt das interne 2D-Array zurück.
    // Wird z.B. von der Regeln-Klasse verwendet, um das Feld zu prüfen.
    public char[][] getFeld() {
        return feld;
    }

    // Gibt das Spielfeld in der Konsole aus.
    public void anzeigen() {
        // Jede Zeile des Spielfelds ausgeben.
        for (int i = 0; i < zeilen; i++) {
            for (int j = 0; j < spalten; j++) {
                // Zwischen den Feldern ein Leerzeichen für bessere Lesbarkeit.
                System.out.print(feld[i][j] + " ");
            }
            // Nach jeder Zeile einen Zeilenumbruch.
            System.out.println();
        }

        // Unter dem Spielfeld die Spaltennummern anzeigen,
        // damit der Spieler weiß, welche Zahl zu welcher Spalte gehört.
        System.out.println("0 1 2 3 4 5 6");
    }
}
