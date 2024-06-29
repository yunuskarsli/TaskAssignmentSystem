package com.DataBase.Sorgu.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        UserDto userDto=new UserDto();
        userDto.setName(user.getName());
        userDto.setId(user.getId());
        return userDto;
    }
    public static User mapToUser(UserDto userDto){
        User user=new User();
        user.setName(userDto.getName());
        user.setId(userDto.getId());
        return user;

        }

}
