package application;

import entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.next();

        System.out.print("Birthday (DD/MM/YYYY): ");
        Date birthDay = sdf.parse(sc.next());

        Client client = new Client(name, email, birthDay);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        Enums.OrderStatus status = Enums.OrderStatus.valueOf(sc.next());
        Order order = new Order(new Date(),status,client);

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();


        for (int i = 1; i <= n; i++) {
            System.out.printf("Enter #%d item data:\n", i);
            System.out.print("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            Product product = new Product(productName,productPrice);
            OrderItem orderItem = new OrderItem(quantity,productPrice,product);
            order.addItem(orderItem);
        }
        System.out.println();
        System.out.println("Order Summary: ");
        System.out.println(order);

        sc.close();
    }
}





















