package by.bsu.car_catalog_client.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {

	@JsonProperty("id")
	private Long id;
	@JsonProperty("price")
	private Double price;
	@JsonProperty("model")
	private String model;
	@JsonProperty("marka")
	private String marka;
	@JsonProperty("year")
	private String year;

	public Car(Long id, Double price, String model, String marka, String year) {
		this.id = id;
		this.price = price;
		this.model = model;
		this.marka = marka;
		this.year = year;
	}

	public Car() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}
}