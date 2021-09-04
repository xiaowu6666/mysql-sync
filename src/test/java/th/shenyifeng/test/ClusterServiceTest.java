package th.shenyifeng.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tk.shenyifeng.study.RunApp;
import tk.shenyifeng.study.model.UserModel;
import tk.shenyifeng.study.service.UserService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RunApp.class)
@Slf4j
public class ClusterServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void insertTest(){
        UserModel userModel = new UserModel();
        userModel.setName("神易风");
        userModel.setAge(8848);
        userService.insert(userModel);
    }

    @Test
    public void findOne(){
        UserModel one = userService.findOne(1);
        log.info("user data {}",one);
    }

    @Test
    public void integrationTest(){
        UserModel userModel = userService.findOne(1);
        userModel.setName("神易风02");
        userModel.setAge(18);
        userService.updateOne(userModel);
    }
}
