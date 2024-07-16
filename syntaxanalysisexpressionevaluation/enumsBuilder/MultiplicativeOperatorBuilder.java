package syntaxanalysisexpressionevaluation.enumsBuilder;

import syntaxanalysisexpressionevaluation.enums.MultiplicativeOperator;
import syntaxanalysisexpressionevaluation.exceptions.MultiplicativeOperatorNotExist;

public class MultiplicativeOperatorBuilder {
    public static MultiplicativeOperator create (char value) throws MultiplicativeOperatorNotExist {
        for (MultiplicativeOperator multiplicativeOperator : MultiplicativeOperator.values()) {
            if (multiplicativeOperator.value == value)
                return multiplicativeOperator;

        }
        throw new MultiplicativeOperatorNotExist("multiplicative operator not exist");
    }
}
