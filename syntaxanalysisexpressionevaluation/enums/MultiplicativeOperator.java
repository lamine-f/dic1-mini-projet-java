package syntaxanalysisexpressionevaluation.enums;

public enum MultiplicativeOperator {
    MULTIPLICATION('*'),
    DIVISION('/');
    public final char value;
    MultiplicativeOperator(char value){
        this.value = value;
    }
}
