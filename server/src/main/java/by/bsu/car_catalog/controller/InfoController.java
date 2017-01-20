package by.bsu.car_catalog.controller;

import by.bsu.car_catalog.dao.InfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/info")
public class InfoController {

    @Autowired
    private InfoDAO infoDAO;

    @GetMapping(value = "/models")
    public ResponseEntity getModels()
    {
        return new ResponseEntity(infoDAO.getModels(), HttpStatus.OK);
    }

    @GetMapping(value = "/marks")
    public ResponseEntity getMarks()
    {
        return new ResponseEntity(infoDAO.getMarks(), HttpStatus.OK);
    }
}
