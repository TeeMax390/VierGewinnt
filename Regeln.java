public class Regeln { // Klasse enthält Logik von den Spielregeln

    public boolean pruefeSieg(char[][] feld, char symbol) { // Prüft, ob der Spieler mit dem gegebenen Symbol gewonnen hat
        int zeilen = feld.length;
        int spalten = feld[0].length;

        // Horizontal prüfen
        for (int i = 0; i < zeilen; i++) {
            for (int j = 0; j < spalten - 3; j++) {
                if (feld[i][j] == symbol && feld[i][j+1] == symbol &&
                    feld[i][j+2] == symbol && feld[i][j+3] == symbol) {
                    return true;
                }
            }
        }

        // Vertikal prüfen
        for (int i = 0; i < zeilen - 3; i++) {
            for (int j = 0; j < spalten; j++) {
                if (feld[i][j] == symbol && feld[i+1][j] == symbol &&
                    feld[i+2][j] == symbol && feld[i+3][j] == symbol) {
                    return true;
                }
            }
        }

        // Diagonal ↘ prüfen
        for (int i = 0; i < zeilen - 3; i++) {
            for (int j = 0; j < spalten - 3; j++) {
                if (feld[i][j] == symbol && feld[i+1][j+1] == symbol &&
                    feld[i+2][j+2] == symbol && feld[i+3][j+3] == symbol) {
                    return true;
                }
            }
        }

        // Diagonal ↗ prüfen
        for (int i = 3; i < zeilen; i++) {
            for (int j = 0; j < spalten - 3; j++) {
                if (feld[i][j] == symbol && feld[i-1][j+1] == symbol &&
                    feld[i-2][j+2] == symbol && feld[i-3][j+3] == symbol) {
                    return true;
                }
            }
        }

        return false; // Wenn keine vier gleiche Symbole in einer Reihe gefunden wurden gibt es keinen Sieg
    }

    public boolean pruefeUnentschieden(char[][] feld) { // prüft ob es ein Unentschieden gibt
        for (int j = 0; j < feld[0].length; j++) {
            if (feld[0][j] == '.') return false;
        }
        return true; // Wenn kein leeres Feld in der obersten Reihe dann Unentschieden
    }
}
