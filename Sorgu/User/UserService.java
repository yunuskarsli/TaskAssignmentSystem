package com.DataBase.Sorgu.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User find(Integer id){
        return userRepository.findById(id).get();
    }

    public User createUser5(User user){
        return userRepository.save(user);
    }


    public User  createUser(UserDto userDto) {
        User user=new User(33," Fahri ","Kayalı");
        user.setName(userDto.getName());
//        user.setSoyad(userDto.getSoyad());
        return userRepository.save(user);
    }

    public User updateUser(User user){
        return  userRepository.save(user);
    }



    private List<User> userList;
    public List<User> getUsersByName(String name){
        return userList.stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
}
