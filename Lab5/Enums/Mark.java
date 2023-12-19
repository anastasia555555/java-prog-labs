package Enums;
public enum Mark {
    EXCLAMATION_MARK("!"),
    QUOTATION_MARK("\""),
    NUMBER_SIGN("#"),
    DOLLAR_SIGN("$"),
    PERCENT_SIGN("%"),
    AMPERSAND("&"),
    APOSTROPHE("'"),
    LEFT_PARENTHESIS("("),
    RIGHT_PARENTHESIS(")"),
    ASTERISK("*"),
    PLUS_SIGN("+"),
    COMMA(","),
    HYPHEN_MINUS("-"),
    FULL_STOP("."),
    SOLIDUS("/"),
    COLON(":"),
    SEMICOLON(";"),
    LESS_THAN_SIGN("<"),
    EQUALS_SIGN("="),
    GREATER_THAN_SIGN(">"),
    QUESTION_MARK("?"),
    COMMERCIAL_AT("@"),
    EMPTY_SPACE(" ");

    private final String value;
    
    private Mark(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    public static Mark valueOfOrNull(String value) {
        for (Mark a : values()) {
            if (a.value.equals(value)) {
                return a;
            }
        }
        return null;
    }

    public static Mark valueOfOrNull(char value) {
        for (Mark e : values()) {
            if (e.value.equals(String.valueOf(value))) {
                return e;
            }
        }
        return null;
    }

    @Override public String toString() {
        return value;
    }

    public boolean equels(Object obj) {
        if (!(obj instanceof Mark)) {
            return false;
        }

        if (this.value != obj.toString()) {
            return false;
        }
        
        return true;
    }
}
