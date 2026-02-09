public class Spiel { // Klasse steuert den Ablauf des Vier-Gewinnt-Spiels.
    private Spielfeld spielfeld;
    private Regeln regeln;
    private EinAusgabe io;
    private Spieler spieler1; // erster Spieler
    private Spieler spieler2; // zweiter Spieler

    public Spiel() {
        spielfeld = new Spielfeld(); // neues Spielfeld
        regeln = new Regeln(); // neues Regel-Objekt das Gewinn oder Unentschieden erkennt
        io = new EinAusgabe(); // neues EinAusgabe-Objekt für Konsoleneingaben
        spieler1 = new Spieler("Spieler 1", 'X'); // Spieler 1 mit Namen und Symbol
        spieler2 = new Spieler("Spieler 2", 'O'); // Spieler 2 mit Namen und Symbol
    }

    public void starten() { // Methode startet den Spielablauf
        Spieler aktueller = spieler1; // der aktuelle Spieler
        boolean spielLaeuft = true; // Steuert, ob das Spiel weiterläuft

        while (spielLaeuft) { // Hauptschleife: läuft so lange, bis das Spiel beendet ist
            spielfeld.anzeigen(); // aktuellen Zustand des Spielfelds anzeigen
            int spalte = io.leseSpalte(aktueller); // Den aktuellen Spieler nach einer Spalte fragen

            if (!spielfeld.setzeStein(spalte, aktueller.getSymbol())) { // Versuchen, den Stein in der gewählten Spalte zu setzen. setzeStein gibt true zurück, wenn der Zug gültig war. false, wenn die Spalte voll ist oder nicht existiert..
                io.ausgabe("Ungültiger Zug! Spalte voll oder nicht existent."); // Ungültiger Zug: Spieler muss erneut wählen.
                continue; // überspringt den Rest der Schleife
            }

            if (regeln.pruefeSieg(spielfeld.getFeld(), aktueller.getSymbol())) { // prüfen ob der aktuelle Spieler durch diesen Zug gewonnen hat
                spielfeld.anzeigen(); // noch einmal das Finale Spielfeld anzeigen
                io.ausgabe(aktueller.getName() + " hat gewonnen!"); // Siegmeldung
                spielLaeuft = false; // Spiel Beenden
            } else if (regeln.pruefeUnentschieden(spielfeld.getFeld())) { //prüft ob das Spielfeld voll ist -> Unentschieden
                spielfeld.anzeigen(); // noch einmal das Finale Spielfeld anzeigen
                io.ausgabe("Unentschieden!");
                spielLaeuft = false; // Spiel beenden
            } else { // Wenn niemand Gewonnen hat oder es kein Unentschieden gibt wird der aktuelle Spieler gewechselt
                aktueller = (aktueller == spieler1) ? spieler2 : spieler1;
            }
        }
    }

    public static void main(String[] args) { // Einstiegspunkt des Programms
        new Spiel().starten(); // Neues Spiel erzeugen und starten
    }
}
