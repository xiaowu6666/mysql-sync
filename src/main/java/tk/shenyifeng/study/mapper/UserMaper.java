package tk.shenyifeng.study.mapper;

import org.apache.ibatis.annotations.Mapper;
import tk.shenyifeng.study.model.UserModel;

@Mapper
public interface UserMaper {

    UserModel findOne(int id);

    void updateOne(UserModel userModel);

    void insert(UserModel userModel);
}
