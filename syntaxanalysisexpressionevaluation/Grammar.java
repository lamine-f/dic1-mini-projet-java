package syntaxanalysisexpressionevaluation;

/**
 * Classe utilitaire pour vérifier différents caractères en tant qu'opérateurs ou chiffres.
 */
public class Grammar {

    /**
     * Vérifie si le caractère donné est un opérateur multiplicatif (* ou /).
     *
     * @param c Le caractère à vérifier
     * @return true si c est '*' ou '/', false sinon
     */
    public static boolean isMultiplicativeOperator(char c) {
        return (c == '*') || (c == '/');
    }

    /**
     * Vérifie si le caractère donné est un opérateur additif (+ ou -).
     *
     * @param c Le caractère à vérifier
     * @return true si c est '+' ou '-', false sinon
     */
    public static boolean isAdditiveOperator(char c) {
        return (c == '+') || (c == '-');
    }

    /**
     * Vérifie si le caractère donné est un chiffre (0-9).
     *
     * @param c Le caractère à vérifier
     * @return true si c est un chiffre ('0'-'9'), false sinon
     */
    public static boolean isDigit(char c) {
        return (c >= '0') && (c <= '9');
    }

    /**
     * Vérifie si le caractère donné est le facteur de départ '('.
     *
     * @param c Le caractère à vérifier
     * @return true si c est '(', false sinon
     */
    public static boolean isStartFactor(char c) {
        return (c == '(');
    }

    /**
     * Vérifie si le caractère donné est le facteur de fin ')'.
     *
     * @param c Le caractère à vérifier
     * @return true si c est ')', false sinon
     */
    public static boolean isEndFactor(char c) {
        return (c == ')');
    }

    /**
     * Vérifie si le caractère donné est un caractère de terminaison d'expression '='.
     *
     * @param c Le caractère à vérifier
     * @return true si c est '=', false sinon
     */
    public static boolean isExpressionTerminationCharacter(char c) {
        return (c == '=');
    }

    /**
     * Vérifie si le caractère donné est un caractère d'arrêt de session '.'.
     *
     * @param c Le caractère à vérifier
     * @return true si c est '.', false sinon
     */
    public static boolean isStopSessionCharacter(char c) {
        return (c == '.');
    }
}
