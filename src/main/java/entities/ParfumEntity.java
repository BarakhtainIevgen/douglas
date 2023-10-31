package entities;

public class ParfumEntity extends BaseEntity{
	private String topBrand;
	private String brandLine;
	private String name;
	private String category;
	private String price;
	private String basePrice;
	private String ratingInfo;

	public ParfumEntity() {
		topBrand = "";
		brandLine = "";
		name = "";
		category = "";
		price = "";
		basePrice = "";
		ratingInfo = "";
	}

	public void setTopBrand(String topBrand) {
		this.topBrand = topBrand;
	}

	public void setBrandLine(String brandLine) {
		this.brandLine = brandLine;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}

	public void setRatingInfo(String ratingInfo) {
		this.ratingInfo = ratingInfo;
	}

	public String getBrandLine() {
		return this.brandLine;
	}

	public String getTopBrand() {
		return this.topBrand;
	}

	public String getName() {
		return this.name;
	}

	public String getCategory() {
		return this.category;
	}

	public String getPrice() {
		return this.price;
	}

	public String getBasePrice() {
		return this.basePrice;
	}

	public String getRatingInfo() {
		return this.ratingInfo;
	}
}