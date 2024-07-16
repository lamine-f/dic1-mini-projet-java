package syntaxanalysisexpressionevaluation;

import syntaxanalysisexpressionevaluation.exceptions.*;

import java.util.Scanner;

/**
 * Classe représentant une session d'évaluation et d'analyse syntaxique des expressions.
 */
public class Session {
    private static boolean isStarting = true;
    private final SyntaxAnalysisEvaluationProcess syntaxAnalysisEvaluationProcess;

    /**
     * Constructeur de la classe Session. Initialise le processus d'analyse syntaxique et d'évaluation.
     */
    public Session() {
        this.syntaxAnalysisEvaluationProcess = new SyntaxAnalysisEvaluationProcess(this);
    }

    /**
     * Arrête la session en cours.
     */
    public void stop() {
        isStarting = false;
        System.out.println("Au revoir...");
    }

    /**
     * Démarre la session en continuant d'accepter les entrées de l'utilisateur jusqu'à ce que la session soit arrêtée.
     */
    public void start() {
        Scanner in = new Scanner(java.lang.System.in);
        while (isStarting) {
            Reader.init(in); // Initialise le lecteur avec l'entrée Scanner fournie
            try {
                System.out.print("À toi : ");
                syntaxAnalysisEvaluationProcess.parser(); // Analyse l'entrée de l'utilisateur
            } catch (StringBufferOverflowException | MultiplicativeOperatorNotExist | AdditiveOperatorNotExist e) {
                // Les exceptions spécifiques sont traitées ici (commenté pour le moment)
//                throw new RuntimeException(e);
            } catch (ArithmeticException | FactorParenthesisMissingException | SyntaxException e) {
                // Affiche l'erreur à l'utilisateur via l'écran de sortie
                Screen.printError(e);
            }
        }
        in.close();
    }
}
