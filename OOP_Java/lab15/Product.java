import javafx.beans.property.SimpleStringProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Product {

    private SimpleStringProperty title;
    private SimpleStringProperty price;
    private SimpleStringProperty quantity;
    private SimpleStringProperty unit;
    private SimpleStringProperty time;

    public Product () {
    }

    public Product (String s1, String s2, String s3, String s4, String s5) {

        title = new SimpleStringProperty(s1);
        price = new SimpleStringProperty(s2);
        quantity = new SimpleStringProperty(s3);
        unit = new SimpleStringProperty(s4);
        time = new SimpleStringProperty(s5);
    }

    public String getTitle() {
        return title.get();
    }
    public void setTitle(String s) {
        if ((s.matches("^(?!\\s*$).+"))){
            title.set(s);
        } else {
            title.set("Введіть коректну назву!");
        }

    }

    public String getQuantity() {

        return quantity.get();
    }
    public void setQuantity(String s) {
        if (s.matches("^\\d+")) {
            quantity.set(s);
        } else {
            quantity.set("Введіть коректну кількість!");
        }
    }

    public String getPrice() {

        return price.get();
    }
    public void setPrice(String s) {
        if (s.matches("^\\d+(\\.\\d+)?")) {
            price.set(s + " UAH");
        } else {
            price.set("Введіть коректну ціну!");
        }

    }

    public String getUnit() {

        return unit.get();
    }
    public void setUnit(String s) {
        unit.set(s);
    }

    public String getTime() {
        return time.get();
    }
    public void setTime(String s) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        try {
            format.parse(s);
            time.set(s);
        }
        catch(ParseException e){
            time.set("Введіть коректну дату!");
        }


    }

    @Override
    public String toString() {
        if (getQuantity().equals("Введіть коректну кількість!")){
            return "Назва: " + getTitle() + "\n" +
                    "Ціна: " + getPrice() + "\n" +
                    "Кількість: " + getQuantity() + "\n" +
                    "Дата: " + getTime() + "\n";
        } else {
            return "Назва: " + getTitle() + "\n" +
                    "Ціна: " + getPrice() + "\n" +
                    "Кількість: " + getQuantity() + " " + getUnit() + "\n" +
                    "Дата: " + getTime() + "\n";
        }
    }
}