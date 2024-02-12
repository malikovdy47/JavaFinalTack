import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();
        PhoneBook.addData(phoneBook, "Sidorov", 123456);
        PhoneBook.addData(phoneBook, "Sidorov", 654321);
        PhoneBook.addData(phoneBook, "Ivanov", 123456);
        PhoneBook.addData(phoneBook, "Ivanov", 678910);
        PhoneBook.addData(phoneBook, "Ivanov", 372813);
        PhoneBook.addData(phoneBook, "Petrov", 123456);
        PhoneBook.addData(phoneBook, "Petrov", 423456);
        PhoneBook.addData(phoneBook, "Petrov", 523456);
        PhoneBook.addData(phoneBook, "Petrov", 623456);
        PhoneBook.addData(phoneBook, "Malikov", 1234567);
        System.out.println(phoneBook);
        PhoneBook.printPhoneNumber(phoneBook);
    }
}

class PhoneBook {
    /**
     * @param phoneBook телефонная книга
     * @param name      имя добавляемого абонента
     * @param number    телефонный номер добавляемого абонента
     * @apiNote Добавление абонента с номером телефона в телефонную книгу.
     */
    public static void addData(HashMap<String, ArrayList<Integer>> phoneBook, String name, int number) {
        if (phoneBook.containsKey(name)) {
            if (!phoneBook.get(name).contains(number)) {
                ArrayList<Integer> updateUsersNumbers;
                updateUsersNumbers = phoneBook.get(name);
                updateUsersNumbers.add(number);
                phoneBook.put(name, updateUsersNumbers);
            }
        } else {
            ArrayList<Integer> userNumbersList = new ArrayList<>();
            userNumbersList.add(number);
            phoneBook.put(name, userNumbersList);
        }
    }

    /**
     * @param phoneBook телефонная книга для сортировки
     * @apiNote метод для печати контактов в телефонной книге по убыванию количества номеров телефонов
     */
    public static void printPhoneNumber(HashMap<String, ArrayList<Integer>> phoneBook) {
        List<Map.Entry<String, ArrayList<Integer>>> list = new LinkedList<>(phoneBook.entrySet());

        // Сортировка списка по убыванию количества номеров
        list.sort(Comparator.comparingInt(entry -> -entry.getValue().size()));

        // Создание нового списка для сохранения порядка сортировки
        Map<String, List<Integer>> sortedPhoneBook = new LinkedHashMap<>();
        for (Map.Entry<String, ArrayList<Integer>> entry : list) {
            sortedPhoneBook.put(entry.getKey(), entry.getValue());
        }
        System.out.println("\nТелефонная книга после сортировки: ");
        System.out.println(sortedPhoneBook);
    }
}
