package by.bsu.car_catalog_client.utils;


import by.bsu.car_catalog_client.model.Car;
import by.bsu.car_catalog_client.model.SearchCriteria;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.util.Scanner;

public class RestClient {

    private static RestClient instance = new RestClient();

    private WebResource service;

    private static final String URI = "http://localhost:8080/car-catalog";

    private static final String DELIMITER = "\n================================================\n";

    private RestClient()
    {
        ClientConfig config = new DefaultClientConfig();
        config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(config);
        service = client.resource(UriBuilder.fromUri(URI).build());
    }

    public static RestClient getInstance()
    {
        return instance;
    }

    public void getById()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the id of car you want to receive: ");
        String carId = in.nextLine();

        System.out.println("Request for: GET " + URI + "/cars/" + carId);
        System.out.println(service.path("/cars").path("/" + carId).accept(MediaType.APPLICATION_JSON).get(String.class));
        System.out.println(DELIMITER);
    }

    public void getBySerachCriteria()
    {
        System.out.println("Now we will form a criteria for searching.");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter model of the car: ");
        String carModel = in.nextLine();

        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setModel(carModel);

        System.out.println("Request for: POST " + URI + "/cars/search");
        ClientResponse response = service.path("/cars").path("/search").type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, searchCriteria);
        System.out.println("Response " + response.getEntity(String.class));
        System.out.println(DELIMITER);
    }

    public void create()
    {
        System.out.println("Now we will create a new car in our catalog.");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the model of car: ");
        String newCarModel = in.nextLine();
        System.out.print("Enter the marka of car: ");
        String newCarMarka  = in.nextLine();
        System.out.print("Enter the price of car: ");
        String newCarPrice = in.nextLine();
        System.out.print("Enter the year of car: ");
        String newCarYear = in.nextLine();

        Car newCar = new Car(null, Double.valueOf(newCarPrice), newCarModel, newCarMarka, newCarYear);

        System.out.println("Request for: POST " + URI + "/cars");
        ClientResponse response = service.path("/cars").type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, newCar);
        System.out.println("Response " + response.getEntity(String.class));
        System.out.println(DELIMITER);
    }

    public void getList()
    {
        System.out.println("There is a catalog:");
        System.out.println("Request for: GET " + URI + "/cars");
        System.out.println(service.path("/cars").accept(MediaType.APPLICATION_JSON).get(String.class));
        System.out.println(DELIMITER);
    }

    public void update()
    {
        System.out.println("Now we will update info about car.");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter id of the car: ");
        String carId = in.nextLine();
        System.out.print("Enter new model of the car: ");
        String newCarModel = in.nextLine();
        System.out.print("Enter new marka of the car: ");
        String newCarMarka  = in.nextLine();
        System.out.print("Enter new price of the car: ");
        String newCarPrice = in.nextLine();
        System.out.print("Enter new year of the car: ");
        String newCarYear = in.nextLine();

        Car newCar = new Car(Long.valueOf(carId), Double.valueOf(newCarPrice), newCarModel, newCarMarka, newCarYear);

        System.out.println("Request for: PUT " + URI + "/cars/" + carId);
        ClientResponse response = service.path("/cars").path("/" + carId).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .put(ClientResponse.class, newCar);
        System.out.println(response.getEntity(String.class));

        System.out.println(DELIMITER);
    }

    public void delete()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the id of car to delete: ");
        String carId = in.nextLine();

        System.out.println("Request for: DELETE " + URI + "/cars/" + carId);
        ClientResponse response = service.path("/cars").path("/" + carId).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .delete(ClientResponse.class);
        System.out.println(response.getEntity(String.class));

        System.out.println(DELIMITER);
    }

    public void modelsInfo()
    {
        System.out.println("Call to info Model service");
        System.out.println("Request for: GET " + URI + "/info/models");
        System.out.println(service.path("/info").path("/models").accept(MediaType.APPLICATION_JSON).get(String.class));
        System.out.println(DELIMITER);
    }

    public void marksInfo()
    {
        System.out.println("Call to info Mark service");
        System.out.println("Request for: GET " + URI + "/info/marks");
        System.out.println(service.path("/info").path("/marks").accept(MediaType.APPLICATION_JSON).get(String.class));
        System.out.println(DELIMITER);
    }

    public void options()
    {
        System.out.println("Request for: OPTIONS " + URI + "/cars/");
        ClientResponse response = service.path("/cars").type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .options(ClientResponse.class);
        System.out.println(response.getHeaders());
        System.out.println(DELIMITER);
    }
}
