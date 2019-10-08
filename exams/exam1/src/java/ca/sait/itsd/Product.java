package ca.sait.itsd;

import java.io.Serializable;

/**
 *
 * @author Carlos J. Garcia Carmona
 */
public class Product implements Serializable {

    // Attributes
    private String name;
    private float productUnitCost;
    private int productNumberInStock;

    // Constructors
    public Product() {
        name = "";
        productUnitCost = 0f;
        productNumberInStock = 0;
    }

    public Product(String name, float productUnitCost, int productNumberInStock) {
        this.name = name;
        this.productUnitCost = productUnitCost;
        this.productNumberInStock = productNumberInStock;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getProductUnitCost() {
        return productUnitCost;
    }

    public void setProductUnitCost(float productUnitCost) {
        this.productUnitCost = productUnitCost;
    }

    public int getProductNumberInStock() {
        return productNumberInStock;
    }

    public void setProductNumberInStock(int productNumberInStock) {
        this.productNumberInStock = productNumberInStock;
    }

    // Operational methods
    public float calcTotalValueInStock(int stock, float cost) {
        return stock * cost;
    }
}
