package org.example.fourthLab;

/**
 * This class represents a piece of furniture with various attributes such as ID, name, description, color, price, and weight.
 */
public class Furniture {
    private Integer id;
    private String name;
    private String description;
    private String color;
    private Float price;
    private Float weight;

    /**
     * Default constructor for Furniture.
     */
    public Furniture() {
    }

    /**
     * Parameterized constructor for Furniture with all attributes.
     *
     * @param id          The ID of the furniture.
     * @param name        The name of the furniture.
     * @param description The description of the furniture.
     * @param color       The color of the furniture.
     * @param price       The price of the furniture.
     * @param weight      The weight of the furniture.
     * @throws IllegalArgumentException if price or weight is negative.
     */
    public Furniture(Integer id, String name, String description, String color, Float price, Float weight) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.color = color;

        if (price >= 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price cannot be negative.");
        }

        if (weight >= 0) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Weight cannot be negative.");
        }
    }

    /**
     * Parameterized constructor for Furniture without ID.
     *
     * @param name        The name of the furniture.
     * @param description The description of the furniture.
     * @param color       The color of the furniture.
     * @param price       The price of the furniture.
     * @param weight      The weight of the furniture.
     * @throws IllegalArgumentException if price or weight is negative.
     */
    public Furniture(String name, String description, String color, Float price, Float weight) {
        this.name = name;
        this.description = description;
        this.color = color;

        if (price >= 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price cannot be negative.");
        }

        if (weight >= 0) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Weight cannot be negative.");
        }
    }

    /**
     * Get the ID of the furniture.
     *
     * @return The ID of the furniture.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the ID of the furniture.
     *
     * @param id The ID of the furniture.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get the name of the furniture.
     *
     * @return The name of the furniture.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the furniture.
     *
     * @param name The name of the furniture.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the description of the furniture.
     *
     * @return The description of the furniture.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the furniture.
     *
     * @param description The description of the furniture.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the color of the furniture.
     *
     * @return The color of the furniture.
     */
    public String getColor() {
        return color;
    }

    /**
     * Set the color of the furniture.
     *
     * @param color The color of the furniture.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Get the price of the furniture.
     *
     * @return The price of the furniture.
     */
    public Float getPrice() {
        return price;
    }

    /**
     * Set the price of the furniture.
     *
     * @param price The price of the furniture.
     * @throws IllegalArgumentException if price is negative.
     */
    public void setPrice(Float price) {
        if (price >= 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
    }

    /**
     * Get the weight of the furniture.
     *
     * @return The weight of the furniture.
     */
    public Float getWeight() {
        return weight;
    }

    /**
     * Set the weight of the furniture.
     *
     * @param weight The weight of the furniture.
     * @throws IllegalArgumentException if weight is negative.
     */
    public void setWeight(Float weight) {
        if (weight >= 0) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Weight cannot be negative.");
        }
    }

    /**
     * Generate a string representation of the furniture.
     *
     * @return A string representing the furniture's attributes.
     */
    @Override
    public String toString() {
        return "Furniture ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Description: " + description + "\n" +
                "Color: " + color + "\n" +
                "Price: $" + price + "\n" +
                "Weight: " + weight + " kg\n";
    }
}
