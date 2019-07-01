package coder.models;

public class Product {
	private int id, cat_id, price;
	private String name, image, description, deleted_at, created_at, updated_at;

	public int getId() {
		return id;
	}

	public Product(int id, int cat_id, int price, String name, String image, String description, String deleted_at,
			String created_at, String updated_at) {
		super();
		this.id = id;
		this.cat_id = cat_id;
		this.price = price;
		this.name = name;
		this.image = image;
		this.description = description;
		this.deleted_at = deleted_at;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCat_id() {
		return cat_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

}
