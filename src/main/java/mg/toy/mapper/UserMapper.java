package mg.toy.mapper;

import mg.toy.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    User selectUserId(String userId);

    User selectEmail(String email);

    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(String userId);
}
