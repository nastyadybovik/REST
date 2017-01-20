package by.bsu.car_catalog.dao;

import by.bsu.car_catalog.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InfoDAO {

    @Autowired
    private CarDAO carDAO;

    public List<String> getModels()
    {
        List<String> modelList = new ArrayList<String>();
        for(Car c : carDAO.list())
        {
            if(!modelList.contains(c.getModel()))
            {
                modelList.add(c.getModel());
            }
        }
        return modelList;
    }

    public List<String> getMarks()
    {
        List<String> markList = new ArrayList<String>();
        for(Car c : carDAO.list())
        {
            if(!markList.contains(c.getMarka().toUpperCase()))
            {
                markList.add(c.getMarka());
            }
        }
        return markList;
    }
}
