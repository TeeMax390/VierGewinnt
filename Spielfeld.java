public class Spielfeld {
    private char[][] feld;
    private final int zeilen = 6;
    private final int spalten = 7;

    public Spielfeld() {
        feld = new char[zeilen][spalten];
        for (int i = 0; i < zeilen; i++) {
            for (int j = 0; j < spalten; j++) {
                feld[i][j] = '.';
            }
        }
    }

    public boolean setzeStein(int spalte, char symbol) {
        if (spalte < 0 || spalte >= spalten) return false;

        for (int i = zeilen - 1; i >= 0; i--) {
            if (feld[i][spalte] == '.') {
                feld[i][spalte] = symbol;
                return true;
            }
        }
        return false;
    }

    public char[][] getFeld() {
        return feld;
    }

    public void anzeigen() {
        for (int i = 0; i < zeilen; i++) {
            for (int j = 0; j < spalten; j++) {
                System.out.print(feld[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("0 1 2 3 4 5 6");
    }
}
