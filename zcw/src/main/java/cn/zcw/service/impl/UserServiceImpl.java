package cn.zcw.service.impl;

import cn.zcw.bean.User;
import cn.zcw.bean.UserExample;
import cn.zcw.mapper.UserMapper;
import cn.zcw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public int regist(User user) {

        return userMapper.insertSelective(user);
    }

    /**
     *
     * @param user
     * @return
     * -1登录失败，1登录成功
     */
    public int doLogin(User user){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginacctEqualTo(user.getLoginacct());
        List<User> list = userMapper.selectByExample(userExample);
        if(list==null){
            System.out.println("-1");
        return -1 ;
        }else{
            if(list.get(0).getUserpswd().equals(user.getUserpswd())){
                System.out.println("1");
                return 1;

            }
            System.out.println("-1");
            return -1;
        }
    }
}
