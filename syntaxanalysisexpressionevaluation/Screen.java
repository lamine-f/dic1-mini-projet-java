package syntaxanalysisexpressionevaluation;

/**
 * Classe utilitaire pour l'affichage des résultats et des erreurs liées à l'évaluation d'expressions.
 */
public class Screen {

    /**
     * Affiche le résultat de l'évaluation de l'expression.
     *
     * @param value La valeur résultante de l'expression
     */
    public static void printResult(int value) {
        System.out.printf("La syntaxe de l'expression est correcte.\nSa valeur est %d\n", value);
    }

    /**
     * Affiche un message d'erreur avec un préfixe spécifié.
     *
     * @param prefix  Le préfixe du message d'erreur
     * @param message Le message d'erreur à afficher
     */
    private static void printErrorMessage(String prefix, String message) {
        System.out.println(prefix + ": " + message);
    }

    /**
     * Affiche une erreur spécifique en fonction du type d'exception.
     *
     * @param exception L'exception à afficher
     */
    public static void printError(Exception exception) {
        if (exception instanceof ArithmeticException) {
            Screen.printErrorMessage("La valeur de l'expression est indéfinie", exception.getMessage());
        } else {
            Screen.printErrorMessage("La syntaxe de l'expression est erronée", exception.getMessage());
        }
    }
}
