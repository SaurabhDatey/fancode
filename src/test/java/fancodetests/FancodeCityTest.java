package fancodetests;

import Dtos.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.TodoService;
import services.UserService;
import java.util.List;

public class FancodeCityTest {

    private final UserService userService = new UserService();
    private final TodoService todoService = new TodoService();

    @Test
    public void todoCompletionPercentTest() throws Exception{
        List<User> fancodeUsers = userService.getFancodeCityUsers();

        for(User user : fancodeUsers){
            double todoCompletionPercentage = todoService.getTodoCompletedPercentByUserId(user.getId());
            Assert.assertTrue(todoCompletionPercentage > 50, "User " + user.getUsername() + " has less then 50% task completd.");
        }
    }
}
