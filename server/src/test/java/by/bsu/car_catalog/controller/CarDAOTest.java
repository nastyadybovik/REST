package by.bsu.car_catalog.controller;

import by.bsu.car_catalog.dao.CarDAO;
import by.bsu.car_catalog.domain.Car;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class CarDAOTest {

    private CarDAO carDAO = new CarDAO();

    /**
     * Test with valid date
     */
    @Test
    public void testGetById()
    {
        List<Car> carList = carDAO.list();
        Car carExpected = carList.get(0);
        Car car = carDAO.get(carExpected.getId());
        Assert.assertNotNull(car);
        Assert.assertEquals(car.getMarka(), carExpected.getMarka());
        Assert.assertEquals(car.getModel(), carExpected.getModel());
        Assert.assertEquals(car.getPrice(), carExpected.getPrice());
        Assert.assertEquals(car.getYear(), carExpected.getYear());
    }

    /**
     * Test with id = null
     */
    @Test
    public void testGetByNullId()
    {
        Long id = null;
        Car car = carDAO.get(id);
        Assert.assertNull(car);
    }

    /**
     * Test list
     */
    @Test
    public void testList()
    {
        List<Car> carList = carDAO.list();
        Assert.assertNotNull(carList);
        Assert.assertFalse(carList.isEmpty());
        Assert.assertEquals(carList.size(), 4);
    }
}
