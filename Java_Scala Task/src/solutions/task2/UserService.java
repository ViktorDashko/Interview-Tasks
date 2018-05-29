package task2;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UserService {

    public static void midnightOperation(){
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        long delay = Duration.between(LocalTime.now(), LocalTime.of(23, 59, 59)).getSeconds();
        long period = ChronoUnit.DAYS.getDuration().getSeconds();
        scheduler.scheduleAtFixedRate(()->{
            //here must be something like:

//                    List<User> users = userDao.getAllUsers();
//                    users.forEach(User::refreshUser);
//                    for (User user : users){
//                        userDao.updateUser(user);
                    },
                delay,
                period,
                TimeUnit.SECONDS);

        }
}
