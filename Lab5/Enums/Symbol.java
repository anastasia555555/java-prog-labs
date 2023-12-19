package Enums;

public enum Symbol {
    A("A"), B("B"), C("C"), D("D"), E("E"), F("F"), 
    G("G"), H("H"), I("I"), J("J"), K("K"), L("L"),
    M("M"), N("N"), O("O"), P("P"), Q("Q"), R("R"), 
    S("S"), T("T"), U("U"), V("V"), W("W"), X("X"), 
    Y("Y"), Z("Z"), a("a"), b("b"), c("c"), d("d"), 
    e("e"), f("f"), g("g"), h("h"), i("i"), j("j"), 
    k("k"), l("l"), m("m"), n("n"), o("o"), p("p"), 
    q("q"), r("r"), s("s"), t("t"), u("u"), v("v"), 
    w("w"), x("x"), y("y"), z("z");

    private final String value;
    
    private Symbol(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }

    public static Symbol valueOfOrNull(String value) {
        for (Symbol e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        return null;
    }

    public static Symbol valueOfOrNull(char value) {
        for (Symbol e : values()) {
            if (e.value.equals(String.valueOf(value))) {
                return e;
            }
        }
        return null;
    }

    @Override public String toString() {
        return value;
    }
}
