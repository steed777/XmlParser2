

public class Valute {
    private String NumCode, CharCode, Nominal, Name, Value;

    public void setNumCode(String numCode) {
        NumCode = numCode;
    }

    public void setCharCode(String charCode) {
        CharCode = charCode;
    }

    public void setNominal(String nominal) {
        Nominal = nominal;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getNumCode() {
        return NumCode;
    }

    public String getCharCode() {
        return CharCode;
    }

    public String getNominal() {
        return Nominal;
    }

    public String getName() {
        return Name;
    }

    public String getValue() {
        return Value;
    }

    @Override
    public String toString() {
        return "Valute{" +
                "NumCode='" + NumCode + '\'' +
                ", CharCode='" + CharCode + '\'' +
                ", Nominal='" + Nominal + '\'' +
                ", Name='" + Name + '\'' +
                ", Value='" + Value + '\'' +
                '}';
    }
}
