package by.bsu.car_catalog_client;

import by.bsu.car_catalog_client.utils.RestClient;
import org.apache.http.client.ClientProtocolException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        RestClient restClient = RestClient.getInstance();
        restClient.getById();
        restClient.create();
        restClient.getList();
        restClient.delete();
        restClient.update();
        restClient.getList();
        restClient.getBySerachCriteria();
        restClient.marksInfo();
        restClient.modelsInfo();
        restClient.options();
    }


}
