import java.util.ArrayList;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        int MAX_SIZE = 3;

        ArrayList<String> shoppingList = new ArrayList<>();

        System.out.println("Skapa en matlista:");
        String newItem = "";

        while (!newItem.equals("done")) {
            System.out.print("Lägg till: ");
            newItem = sc.nextLine();

            if (!newItem.equals("done")) {
                if (shoppingList.size() < MAX_SIZE) {
                    shoppingList.add(newItem);
                } else {
                    checkAndReplaceItem(shoppingList, newItem);
                }
            }
        }

        printList(shoppingList);
    }

// ask user to replace
    public static void checkAndReplaceItem(ArrayList<String> shoppingList, String newItem) {
        boolean replaced = false;
        while (!replaced) {
            System.out.println("Vilken vara ska ersättas?");
            printList(shoppingList);
            String itemToRemove = sc.nextLine();
            replaced = replace(itemToRemove, newItem, shoppingList);
        }
    }
// function to replace item in list
    public static boolean replace(String oldItem, String newItem, ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(oldItem)) {
                list.set(i, newItem);
                return true;
            }
        }
        return false;
    }

    public static void printList(ArrayList<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
    }


}