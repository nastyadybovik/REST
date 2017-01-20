package by.bsu.car_catalog.domain;


public class Car {

	private Long id;
	private Double price;
	private String model;
	private String marka;
	private String year;

	public Car(long id, Double price, String model, String marka, String year) {
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