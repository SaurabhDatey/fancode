package services;

import Dtos.User;
import io.restassured.response.Response;
import java.util.List;
import java.util.stream.Collectors;
import config.Endpoints;
import com.fasterxml.jackson.databind.ObjectMapper;


public class UserService {

    private final ObjectMapper objectMapper;
    private final double MIN_LAT = -40;
    private final double MAX_LAT = 5;
    private final double MIN_LNG = 5;
    private final double MAX_LNG = 100;



    public UserService() {
        this.objectMapper = new ObjectMapper();
    }

    public  List<User> getFancodeCityUsers() throws Exception {

        Response response = ApiClientService.getApiData(Endpoints.USERS_API);
        User[] users = objectMapper.readValue(response.getBody().asString(), User[].class);

        return List.of(users)
                .stream().filter(user ->{
            double lat = Double.parseDouble(user.getAddress().getGeo().getLat());
            double lng = Double.parseDouble(user.getAddress().getGeo().getLng());
            return lat > MIN_LAT && lat < MAX_LAT && lng > MIN_LNG && lng < MAX_LNG;
        }).collect(Collectors.toList());
    }
}
