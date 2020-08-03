import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class XmlParser {

    private List<Valute> valuteValues = new ArrayList<>();
    private String date;

    XmlParser(String xml) {
        getValute(xml);
    }

    private void getValute(String xml) {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputStream stream = new URL(xml).openStream();
            Document document = builder.parse(stream);
            Element valCurs = document.getDocumentElement();
            date = valCurs.getAttribute("Date");
            NodeList valuteList = valCurs.getChildNodes();
            for (int i = 0; i < valuteList.getLength(); i++) {
                Node valute = valuteList.item(i);
                if (valute instanceof Element) {
                    Element valuteElement = (Element) valute;
                    getProperty(valuteElement);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getProperty(Element valuteElement) {
        Valute valuteObject = new Valute();
        NodeList valuteElementList = valuteElement.getChildNodes();
        for (int i = 0; i < valuteElementList.getLength(); i++) {
            Node valuteProperty = valuteElementList.item(i);
            if (valuteProperty instanceof Element) {
                Element property = (Element) valuteProperty;
                Text textNode = (Text) property.getFirstChild();
                String text = textNode.getData().trim();
                if (property.getTagName().equals("NumCode"))
                    valuteObject.setNumCode(text);
                else if (property.getTagName().equals("CharCode"))
                    valuteObject.setCharCode(text);
                else if (property.getTagName().equals("Nominal"))
                    valuteObject.setNominal(text);
                else if (property.getTagName().equals("Name"))
                    valuteObject.setName(text);
                else if (property.getTagName().equals("Value"))
                    valuteObject.setValue(text);

            }
        }
        valuteValues.add(valuteObject);
    }

    public List<Valute> getValuteValues() {
        return valuteValues;
    }

    public String getDate() {
        return date;
    }
}
