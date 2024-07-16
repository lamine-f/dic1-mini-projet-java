package syntaxanalysisexpressionevaluation;

import syntaxanalysisexpressionevaluation.exceptions.StringBufferOverflowException;

import java.util.Scanner;

/**
 * Classe utilitaire pour la lecture et la gestion des caractères à partir d'une entrée Scanner.
 */
public class Reader {
    private static Scanner in;
    private static String stringBuffer;
    private static int stringBufferLength;
    private static int index;
    private static char currentCharacter;

    /**
     * Initialise le Reader avec l'instance Scanner fournie.
     *
     * @param in L'instance Scanner à utiliser pour la lecture
     */
    public static void init(Scanner in) {
        Reader.in = in;
        stringBuffer = null;
        stringBufferLength = 0;
        index = 0;
        currentCharacter = 0;
    }

    /**
     * Récupère le caractère courant dans la chaîne en cours.
     *
     * @return Le caractère courant
     */
    public static char getCurrentCharacter() {
        return currentCharacter;
    }

    /**
     * Lit le prochain caractère de l'entrée Scanner et le stocke comme caractère courant.
     *
     * @throws StringBufferOverflowException Si la chaîne tampon est dépassée
     */
    public static void readNext() throws StringBufferOverflowException {
        if (stringBuffer == null) {
            stringBuffer = in.nextLine();
            stringBufferLength = stringBuffer.length();
            index = 0;
            currentCharacter = 0;
        }
        if (index >= stringBufferLength)
            throw new StringBufferOverflowException("Dépassement de la capacité de la chaîne tampon");
        currentCharacter = stringBuffer.charAt(index++);
        while (Character.isWhitespace(currentCharacter))
            readNext();
    }

    /**
     * Vérifie si un caractère suivant existe dans la chaîne tampon.
     *
     * @return true si un caractère suivant existe, false sinon
     */
    public static boolean nextCharacterExist() {
        try {
            stringBuffer.charAt(index);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
