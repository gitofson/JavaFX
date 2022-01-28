package cz.spsmb.w21;

import javafx.beans.property.ReadOnlyProperty;

public class BookPropertyTest {
    public static void main(String[] args) {
        Book book = new Book("Moje Superkniha", 9.99, "0123456789");
        System.out.println("Po vytvoření objektu Book...");
        //Výpis vlastností
        printDetails(book.titleProperty());
        printDetails(book.priceProperty());
        printDetails(book.ISBNProperty());

        //změna vlastností
        book.setTitle("Moje Superkniha 1.0");
        book.setPrice(9.49);
        System.out.println("Po změně vlastností objektu book...");
        //Výpis vlastností
        printDetails(book.titleProperty());
        printDetails(book.priceProperty());
        printDetails(book.ISBNProperty());

    }
    public static void printDetails(ReadOnlyProperty<?> p) {
        String name = p.getName();
        Object value = p.getValue();
        Object bean = p.getBean();
        String beanClassName = (bean == null)? "null":bean.getClass().getSimpleName();
        String propClassName = p.getClass().getSimpleName();
        System.out.print(propClassName);
        System.out.print("[Name:"+name);
        System.out.print(", Bean Class:" + beanClassName);
        System.out.println(", Value:" + value + "]");
    }
}
