package tk.shenyifeng.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tk.shenyifeng.study.bean.DatabaseSelector;
import tk.shenyifeng.study.mapper.UserMaper;
import tk.shenyifeng.study.model.UserModel;

import javax.security.auth.callback.Callback;

import java.util.concurrent.*;

import static tk.shenyifeng.study.bean.ClusteEnum.MASTER;

@Component
public class UserService {

    @Autowired
    private UserMaper userMaper;

    @Transactional(rollbackFor = Exception.class)
    @DatabaseSelector(MASTER)
    public void insert(UserModel userModel){
        userMaper.insert(userModel);
    }

    public UserModel findOne(int id){
        return userMaper.findOne(id);
    }

    @DatabaseSelector(MASTER)
    public void updateOne(UserModel userModel){
        userMaper.updateOne(userModel);
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> c  = () -> {return "hello workd";};
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(c);
        String s = future.get();
        System.out.println("s1 =>" + s);
        String s1 = future.get();
        System.out.println("s1 =>" + s1);
        String s2 = future.get();
        System.out.println("s1 =>" + s2);
    }
}
