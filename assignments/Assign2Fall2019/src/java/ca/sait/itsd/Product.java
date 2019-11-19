package ca.sait.itsd;

import java.io.Serializable;

/**
 *
 * @author Carlos J. Garcia Carmona <carlos.garciacarmona@edu.sait.ca>
 */
public class Product implements Serializable {

	private int productID;
	private String productDescription;
	private float productUnitPrice;
	private int productStockLevel;

	public Product() {
	}

	public Product(int productID, String productDescription, float productUnitPrice, int productStockLevel) {
		this.productID = productID;
		this.productDescription = productDescription;
		this.productUnitPrice = productUnitPrice;
		this.productStockLevel = productStockLevel;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public float getProductUnitPrice() {
		return productUnitPrice;
	}

	public void setProductUnitPrice(float productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}

	public int getProductStockLevel() {
		return productStockLevel;
	}

	public void setProductStockLevel(int productStockLevel) {
		this.productStockLevel = productStockLevel;
	}
}
