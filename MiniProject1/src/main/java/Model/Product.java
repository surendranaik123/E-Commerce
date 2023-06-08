package Model;

import java.sql.Blob;

public class Product {
	//private String id;
	private int id;
	private String name;
	private String category;
	private Double price;
	private Blob image;
	

	public Product() {
	}
	
	public Product(int id, String name, String category, Double price, Blob image) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.image = image;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", image="
				+ image + "]";
	}
	
	
	
}