public class Spiel {
    private Spielfeld spielfeld;
    private Regeln regeln;
    private EinAusgabe io;
    private Spieler spieler1;
    private Spieler spieler2;

    public Spiel() {
        spielfeld = new Spielfeld();
        regeln = new Regeln();
        io = new EinAusgabe();
        spieler1 = new Spieler("Spieler 1", 'X');
        spieler2 = new Spieler("Spieler 2", 'O');
    }

    public void starten() {
        Spieler aktueller = spieler1;
        boolean spielLaeuft = true;

        while (spielLaeuft) {
            spielfeld.anzeigen();
            int spalte = io.leseSpalte(aktueller);

            if (!spielfeld.setzeStein(spalte, aktueller.getSymbol())) {
                io.ausgabe("Ungültiger Zug! Spalte voll oder nicht existent.");
                continue;
            }

            if (regeln.pruefeSieg(spielfeld.getFeld(), aktueller.getSymbol())) {
                spielfeld.anzeigen();
                io.ausgabe(aktueller.getName() + " hat gewonnen!");
                spielLaeuft = false;
            } else if (regeln.pruefeUnentschieden(spielfeld.getFeld())) {
                spielfeld.anzeigen();
                io.ausgabe("Unentschieden!");
                spielLaeuft = false;
            } else {
                aktueller = (aktueller == spieler1) ? spieler2 : spieler1;
            }
        }
    }

    public static void main(String[] args) {
        new Spiel().starten();
    }
}
