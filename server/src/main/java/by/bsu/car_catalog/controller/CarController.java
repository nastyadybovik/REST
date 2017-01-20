package by.bsu.car_catalog.controller;

import by.bsu.car_catalog.dao.CarDAO;
import by.bsu.car_catalog.domain.Car;
import by.bsu.car_catalog.domain.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class CarController {

	
	@Autowired
	private CarDAO carDAO;

	
	@GetMapping("/cars")
	public List getCars() {
		return carDAO.list();
	}

	@GetMapping("/cars/{id}")
	 public ResponseEntity getCarById(@PathVariable("id") Long id) {

		Car car = carDAO.get(id);
		if (car == null) {
			return new ResponseEntity("No Car found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(car, HttpStatus.OK);
	}

	@PostMapping("/cars/search")
	public ResponseEntity getCarByCriteria(@RequestBody SearchCriteria criteria) {

		List<Car> carList = carDAO.get(criteria);
		if (carList.isEmpty()) {
			return new ResponseEntity("No Car found for Criteria " + criteria.getModel(), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(carList, HttpStatus.OK);
	}

	@PostMapping("/cars")
	public ResponseEntity createCar(@RequestBody Car car) {

		carDAO.create(car);

		return new ResponseEntity(car, HttpStatus.OK);
	}

	@DeleteMapping("/cars/{id}")
	public ResponseEntity deleteCar(@PathVariable Long id) {

		if (null == carDAO.delete(id)) {
			return new ResponseEntity("No Car found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}

	@PutMapping("/cars/{id}")
	public ResponseEntity updateCar(@PathVariable Long id, @RequestBody Car car) {

		car = carDAO.update(id, car);

		if (null == car) {
			return new ResponseEntity("No Cars found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(car, HttpStatus.OK);
	}

	@RequestMapping(value = "/cars", method = RequestMethod.OPTIONS)
	public ResponseEntity options(HttpServletResponse response) {
		response.setHeader("Allow", "GET, PUT, POST, DELETE, OPTIONS");
		return new ResponseEntity(HttpStatus.OK);
	}

}