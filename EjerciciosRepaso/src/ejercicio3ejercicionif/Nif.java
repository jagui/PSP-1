package ejercicio3ejercicionif;

public class Nif {
    private static String LETTERS = "TRWAGMYFPDXBNJZSQVHLCKE";
    private static char NO_LETTER = ' ';
    private static int NO_NUMBER = 0;


    private int number;
    private char letter;

    public int getNumber() {
        return number;
    }

    public char getLetter() {
        return letter;
    }

    public Nif() {
        this(NO_NUMBER, NO_LETTER);
    }

    public Nif(int dni) {
        this(dni, calculateLetter(dni));
    }

    public Nif(int dni, char letter) {
        this.number = dni;
        this.letter = letter;
    }

    private static char calculateLetter(int dni) {
        int index = dni % LETTERS.length();
        return LETTERS.charAt(index);
    }

    public void read(int dni) {
        this.number = dni;
        this.letter = calculateLetter(number);
    }

    @Override
    public String toString() {
        return String.format("%08d-%c", this.number, this.letter);
    }
}
