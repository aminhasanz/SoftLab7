package MiniJava.codeGenerator;

/**
 * Created by mohammad hosein on 6/28/2015.
 */

public abstract class Address {
    public int num;
    public TypeAddress Type;
    public varType varType;

    public Address(int num, varType varType, TypeAddress Type) {
        this.num = num;
        this.Type = Type;
        this.varType = varType;
    }

    public Address(int num, varType varType) {
        this.num = num;
        this.Type = TypeAddress.Direct;
        this.varType = varType;
    }

    public abstract String toString();
}

public class Direct extends Address {
    public String toString() {
        return num + "";
    }
}

public class Indirect extends Address {
    public String toString() {
        return "@" + num;
    }
}

public class Imidiate extends Address {
    public String toString() {
        return "#" + num;
    }
}