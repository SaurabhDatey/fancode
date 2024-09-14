package services;

import Dtos.Todos;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.Endpoints;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TodoService {


    private final ObjectMapper objectMapper;

    public TodoService() {
        this.objectMapper = new ObjectMapper();
    }

    public double getTodoCompletedPercentByUserId(int userId) throws Exception {
        Response response = ApiClientService.getApiData(Endpoints.TODOS_API);
        Todos[] todos = objectMapper.readValue(response.getBody().asString(), Todos[].class);

        List<Todos> todosByUserId = Arrays.stream(todos).sequential()
                .filter(todo -> todo.getUserId() == userId)
                .collect(Collectors.toList());

        long completedTodoCount = todosByUserId.stream()
                .filter(Todos::isCompleted).count();

        return (double) completedTodoCount/todosByUserId.size()*100;
    }

}
