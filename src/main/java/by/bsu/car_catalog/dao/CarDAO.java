package by.bsu.car_catalog.dao;

import by.bsu.car_catalog.domain.Car;
import by.bsu.car_catalog.domain.SearchCriteria;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAO {

	private static List<Car> cars;

	public CarDAO()
	{
		cars = new ArrayList();
		cars.add(new Car(101, 14709.5D, "Toyota", "Corolla", "2016"));
		cars.add(new Car(102, 21142D, "Toyota", "Camry", "2016"));
		cars.add(new Car(103, 20148D, "Toyota", "RAV4", "2016"));
		cars.add(new Car(104, 48964.5D, "Toyota", "HighLander", "2016"));
	}
	/**
	 * Get the list of cars
	 * @return list of cars
	 */
	public List<Car> list() {
		return cars;
	}

	/**
	 * Get car by Id if such exist, else retrieve null
	 * @param id
	 * @return car or null
	 */
	public Car get(Long id) {

		for (Car c : cars) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}

	/**
	 * Fet car by search criteria
	 * The conditions are not strictly
	 * @param searchCriteria
	 * @return List<Car>
	 */
	public List<Car> get(SearchCriteria searchCriteria) {
		List<Car> requiredCars = new ArrayList<Car>();
		for (Car c : cars) {
			if (c.getModel().equals(searchCriteria.getModel()))
			{
				requiredCars.add(c);
			}
		}
		return requiredCars;
	}

	/**
	 * Create car
	 * @param car
	 * @return created car
	 */
	public Car create(Car car) {
		car.setId(System.currentTimeMillis());
		cars.add(car);
		return car;
	}

	/**
	 * Delete car by Id if such exist and return the Id.
	 * If there is no car with such Id return null
	 * @param id
	 * @return id or null
	 */
	public Long delete(Long id) {

		for (Car c : cars) {
			if (c.getId().equals(id)) {
				cars.remove(c);
				return id;
			}
		}

		return null;
	}

	/**
	 * Update car by Id
	 * @param id
	 * @param car
	 * @return updated car or null
	 */
	public Car update(Long id, Car car) {

		for (Car c : cars) {
			if (c.getId().equals(id)) {
				car.setId(c.getId());
				cars.remove(c);
				cars.add(car);
				return car;
			}
		}

		return null;
	}

}