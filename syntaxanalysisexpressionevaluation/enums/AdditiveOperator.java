package syntaxanalysisexpressionevaluation.enums;

public enum AdditiveOperator {
    PLUS('+'),
    MINUS('-');
    public final char value;
    AdditiveOperator(char value){
        this.value = value;
    }
}
