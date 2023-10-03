package org.example.fourthLab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Text User Interface (TUI) for interacting with Furniture objects.
 */
@Component
public class TUI {
    private final FurnitureDao furnitureDao;

    /**
     * Constructor for TUI that injects a FurnitureDao.
     *
     * @param furnitureDao The data access object for Furniture objects.
     */
    @Autowired
    public TUI(FurnitureDao furnitureDao) {
        this.furnitureDao = furnitureDao;
    }

    /**
     * Start the TUI, displaying a menu and handling user actions.
     */
    public void start() {
        while (true) {
            printMenu();
            int choice = Input.getIntInput();
            switch (choice) {
                case 1:
                    addFurniture();
                    break;
                case 2:
                    viewAllFurniture();
                    break;
                case 3:
                    editFurniture();
                    break;
                case 4:
                    deleteFurniture();
                    break;
                case 5:
                    searchFurniture();
                    break;
                case 6:
                    System.out.println("Exiting the application.");
                    System.exit(0);
                default:
                    System.err.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Display the main menu to the user.
     */
    private void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add Furniture");
        System.out.println("2. View All Furniture");
        System.out.println("3. Edit Furniture");
        System.out.println("4. Delete Furniture");
        System.out.println("5. Search Furniture");
        System.out.println("6. Exit");
        System.out.print("Select an action: ");
    }

    /**
     * Allow the user to add a new Furniture object to the database.
     */
    private void addFurniture() {
        Furniture addingFurniture = new Furniture();
        try {
            System.out.println("Enter name:");
            addingFurniture.setName(Input.getUserInput());
            System.out.println("Enter description:");
            addingFurniture.setDescription(Input.getUserInput());
            System.out.println("Enter color:");
            addingFurniture.setColor(Input.getUserInput());
            System.out.println("Enter price:");
            addingFurniture.setPrice(Input.getFloatInput());
            System.out.println("Enter weight:");
            addingFurniture.setWeight(Input.getFloatInput());
            furnitureDao.insert(addingFurniture);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Display a list of all Furniture objects in the database.
     */
    private void viewAllFurniture() {
        List<Furniture> allFurniture = furnitureDao.findAll();
        System.out.println("Furniture list:\n");
        for (Furniture furniture : allFurniture) {
            System.out.println(furniture);
        }
    }

    /**
     * Allow the user to edit the information of an existing Furniture object in the database.
     */
    private void editFurniture() {
        System.out.println("Enter ID:");
        int id = Input.getIntInput();
        Furniture existingFurniture = furnitureDao.findById(id);
        int choose;
        if (existingFurniture == null) {
            System.err.println("Furniture with the given ID not found.");
            return;
        }
        do {
            System.out.println("Choose a field to edit:\n" +
                    "1 - Name\n" +
                    "2 - Description\n" +
                    "3 - Color\n" +
                    "4 - Price\n" +
                    "5 - Weight\n" +
                    "6 - Exit\n");
            choose = Input.getIntInput();
            switch (choose) {
                case 1:
                    System.out.println("Enter name:");
                    existingFurniture.setName(Input.getUserInput());
                    break;
                case 2:
                    System.out.println("Enter description:");
                    existingFurniture.setDescription(Input.getUserInput());
                    break;
                case 3:
                    System.out.println("Enter color:");
                    existingFurniture.setColor(Input.getUserInput());
                    break;
                case 4:
                    System.out.println("Enter price:");
                    try {
                        existingFurniture.setPrice(Input.getFloatInput());
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Enter weight:");
                    try {
                        existingFurniture.setWeight(Input.getFloatInput());
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 6:
                    furnitureDao.updateFurniture(existingFurniture);
                    break;
                default:
                    System.err.println("Invalid command entered");
            }
        } while (choose != 6);
    }

    /**
     * Allow the user to delete a Furniture object from the database by its ID.
     */
    private void deleteFurniture() {
        int result;
        System.out.println("Enter ID:");
        int id = Input.getIntInput();
        result = furnitureDao.delete(id);
        if (result == 0) {
            System.err.println("Furniture with the given ID not found.");
        }
    }

    /**
     * Allow the user to search for Furniture objects with a minimum price.
     */
    private void searchFurniture() {
        System.out.println("Enter minimum price:");
        float minPrice = Input.getFloatInput();
        List<Furniture> allFurniture = furnitureDao.findByMinPrice(minPrice);
        System.out.println("Furniture list:");
        for (Furniture furniture : allFurniture) {
            System.out.println(furniture);
        }
    }
}
