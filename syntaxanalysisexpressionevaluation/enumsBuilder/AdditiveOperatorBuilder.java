package syntaxanalysisexpressionevaluation.enumsBuilder;

import syntaxanalysisexpressionevaluation.enums.AdditiveOperator;
import syntaxanalysisexpressionevaluation.exceptions.AdditiveOperatorNotExist;

public class AdditiveOperatorBuilder {
    public static AdditiveOperator create (char value) throws AdditiveOperatorNotExist {
        for (AdditiveOperator additiveOperator : AdditiveOperator.values()) {
            if (additiveOperator.value == value)
                return additiveOperator;

        }
        throw new AdditiveOperatorNotExist("additive operator not exist");
    }
}
