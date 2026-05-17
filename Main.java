import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Address, Integer> costPerAddress = new HashMap<>();
        costPerAddress.put(new Address("Россия", "Москва"), 150);
        costPerAddress.put(new Address("Россия", "Казань"), 200);
        costPerAddress.put(new Address("США", "Нью-Йорк"), 350);
        costPerAddress.put(new Address("Германия", "Берлин"), 280);
        costPerAddress.put(new Address("Франция", "Париж"), 310);
        costPerAddress.put(new Address("Россия", "Санкт-Петербург"), 180);
        costPerAddress.put(new Address("Великобритания", "Лондон"), 400);
        int totalCost = 0;
        System.out.println("Сервис доставки товаров запущен. Для выхода введите 'end'.");
        while (true) {
            System.out.println("\n--- Заполнение нового заказа ---");
            System.out.print("Введите страну: ");
            String country = scanner.nextLine();
            if (country.equalsIgnoreCase("end")) {
                break;
            }
            System.out.print("Введите город: ");
            String city = scanner.nextLine();
            if (city.equalsIgnoreCase("end")) {
                break;
            }
            System.out.print("Введите вес (кг): ");
            String weightStr = scanner.nextLine();
            if (weightStr.equalsIgnoreCase("end")) {
                break;
            }
            int weight;
            try {
                weight = Integer.parseInt(weightStr);
                if (weight <= 0) {
                    System.out.println("Вес должен быть положительным числом. Заказ не принят.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: нужно ввести число. Заказ не принят.");
                continue;
            }
            Address searchAddress = new Address(country, city);
            if (costPerAddress.containsKey(searchAddress)) {
                int pricePerKg = costPerAddress.get(searchAddress);
                int deliveryCost = pricePerKg * weight;
                totalCost += deliveryCost;
                System.out.printf("Стоимость доставки составит: %d руб.\n", deliveryCost);
                System.out.printf("Общая стоимость всех доставок: %d руб.\n", totalCost);
            } else {
                System.out.println("Доставки по этому адресу нет");
            }
        }
        System.out.println("Работа сервиса завершена. До свидания!");
        scanner.close();
    }
}