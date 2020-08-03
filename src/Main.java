public class Main {


    public static void main(String[] args) {
        XmlParser xmlParser = new XmlParser("http://www.cbr.ru/scripts/XML_daily.asp");

        System.out.println(xmlParser.getValuteValues().toString());
    }
}
