package syntaxanalysisexpressionevaluation;

import syntaxanalysisexpressionevaluation.enums.AdditiveOperator;
import syntaxanalysisexpressionevaluation.enums.MultiplicativeOperator;
import syntaxanalysisexpressionevaluation.enumsBuilder.AdditiveOperatorBuilder;
import syntaxanalysisexpressionevaluation.enumsBuilder.MultiplicativeOperatorBuilder;
import syntaxanalysisexpressionevaluation.exceptions.*;

/**
 * Classe responsable de l'analyse et de l'évaluation syntaxique des expressions.
 */
public class SyntaxAnalysisEvaluationProcess {
    private final Session session;

    /**
     * Constructeur de la classe SyntaxAnalysisEvaluationProcess.
     *
     * @param session La session associée à ce processus d'analyse
     */
    public SyntaxAnalysisEvaluationProcess(Session session) {
        this.session = session;
    }

    /**
     * Méthode principale pour l'analyse syntaxique et l'évaluation de l'expression.
     *
     * @throws StringBufferOverflowException si la capacité de la chaîne tampon est dépassée
     * @throws FactorParenthesisMissingException si une parenthèse est manquante
     * @throws SyntaxException si une erreur de syntaxe est détectée
     * @throws AdditiveOperatorNotExist si un opérateur additif n'est pas reconnu
     * @throws MultiplicativeOperatorNotExist si un opérateur multiplicatif n'est pas reconnu
     */
    void parser() throws StringBufferOverflowException, FactorParenthesisMissingException, SyntaxException, AdditiveOperatorNotExist, MultiplicativeOperatorNotExist {
        Reader.readNext(); // Lit le prochain caractère de l'entrée
        if (Grammar.isStopSessionCharacter(Reader.getCurrentCharacter())) {
            this.session.stop(); // Arrête la session si le caractère est un arrêt de session
        } else {
            int expressionResult = expression(); // Évalue l'expression
            if (Grammar.isExpressionTerminationCharacter(Reader.getCurrentCharacter())) {
                if (Reader.nextCharacterExist()) {
                    throw new SyntaxException("Pas de caractère après le symbole =");
                }
                Screen.printResult(expressionResult); // Affiche le résultat de l'expression
            } else if (Grammar.isEndFactor(Reader.getCurrentCharacter())) {
                throw new FactorParenthesisMissingException("Parenthèse non ouverte");
            } else {
                throw new SyntaxException("Symbole terminal non reconnu");
            }
        }
    }

    /**
     * Méthode pour l'évaluation d'une expression.
     *
     * @return Le résultat de l'expression évaluée
     * @throws StringBufferOverflowException si la capacité de la chaîne tampon est dépassée
     * @throws SyntaxException si une erreur de syntaxe est détectée
     * @throws FactorParenthesisMissingException si une parenthèse est manquante
     * @throws AdditiveOperatorNotExist si un opérateur additif n'est pas reconnu
     * @throws MultiplicativeOperatorNotExist si un opérateur multiplicatif n'est pas reconnu
     */
    int expression() throws StringBufferOverflowException, SyntaxException, FactorParenthesisMissingException, AdditiveOperatorNotExist, MultiplicativeOperatorNotExist {
        int result = term(); // Évalue le terme initial
        if (Grammar.isAdditiveOperator(Reader.getCurrentCharacter())) {
            AdditiveOperator operator = AdditiveOperatorBuilder.create(Reader.getCurrentCharacter());
            Reader.readNext();
            switch (operator) {
                case PLUS:
                    result += expression(); // Additionne le résultat du terme suivant
                    break;
                case MINUS:
                    result -= expression(); // Soustrait le résultat du terme suivant
                    break;
            }
        }
        return result;
    }

    /**
     * Méthode pour l'évaluation d'un terme.
     *
     * @return Le résultat du terme évalué
     * @throws StringBufferOverflowException si la capacité de la chaîne tampon est dépassée
     * @throws SyntaxException si une erreur de syntaxe est détectée
     * @throws FactorParenthesisMissingException si une parenthèse est manquante
     * @throws AdditiveOperatorNotExist si un opérateur additif n'est pas reconnu
     * @throws MultiplicativeOperatorNotExist si un opérateur multiplicatif n'est pas reconnu
     */
    int term() throws StringBufferOverflowException, SyntaxException, FactorParenthesisMissingException, AdditiveOperatorNotExist, MultiplicativeOperatorNotExist {
        int result = factor(); // Évalue le facteur initial
        if (Grammar.isMultiplicativeOperator(Reader.getCurrentCharacter())) {
            MultiplicativeOperator operator = MultiplicativeOperatorBuilder.create(Reader.getCurrentCharacter());
            Reader.readNext();
            switch (operator) {
                case MULTIPLICATION:
                    result *= term(); // Multiplie par le résultat du terme suivant
                    break;
                case DIVISION:
                    result /= term(); // Divise par le résultat du terme suivant
                    break;
            }
        }
        return result;
    }

    /**
     * Méthode pour l'évaluation d'un facteur.
     *
     * @return Le résultat du facteur évalué
     * @throws StringBufferOverflowException si la capacité de la chaîne tampon est dépassée
     * @throws FactorParenthesisMissingException si une parenthèse est manquante
     * @throws SyntaxException si une erreur de syntaxe est détectée
     * @throws AdditiveOperatorNotExist si un opérateur additif n'est pas reconnu
     * @throws MultiplicativeOperatorNotExist si un opérateur multiplicatif n'est pas reconnu
     */
    int factor() throws StringBufferOverflowException, FactorParenthesisMissingException, SyntaxException, AdditiveOperatorNotExist, MultiplicativeOperatorNotExist {
        int result;
        if (Grammar.isDigit(Reader.getCurrentCharacter())) {
            result = number(); // Évalue un nombre
        } else if (Grammar.isStartFactor(Reader.getCurrentCharacter())) {
            Reader.readNext();
            result = expression(); // Évalue une expression entre parenthèses
            if (Grammar.isEndFactor(Reader.getCurrentCharacter())) {
                Reader.readNext();
            } else {
                throw new FactorParenthesisMissingException("Parenthèse non fermée");
            }
        } else {
            throw new SyntaxException("Facteur non reconnu");
        }
        return result;
    }

    /**
     * Méthode pour l'évaluation d'un nombre.
     *
     * @return La valeur numérique du nombre lu
     */
    int number() {
        boolean isFirst = true;
        int result = 0;
        try {
            while (Grammar.isDigit(Reader.getCurrentCharacter())) {
                if (isFirst) {
                    result = Reader.getCurrentCharacter() - '0';
                    isFirst = false;
                } else {
                    result = result * 10 + (Reader.getCurrentCharacter() - '0');
                }
                Reader.readNext();
            }
            return result;
        } catch (StringBufferOverflowException e) {
            return result;
        }
    }

}