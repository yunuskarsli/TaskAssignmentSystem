package com.DataBase.Sorgu.User;

import com.DataBase.Sorgu.User.UserBulderDesign.UserBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private int id;
    private String name;
    private String soyad;

        //Builder fieldleri
        public static class Builder {
        private int id;
        private String name;
        private String soyad;


        public Builder id(int id) {
            this.id = id;
            return this;
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder soyad(String soyad) {
            this.soyad = soyad;
            return this;
        }
        //builder constructor
        public Builder(int id, String name, String soyad) {
            this.id = id;
            this.name = name;
            this.soyad = soyad;
        }
        //oluturma metodu
        public UserDto build(){
            UserDto userDto=new UserDto();
            userDto.setId(id);
            userDto.setName(name);
            userDto.setSoyad(soyad);
            return userDto;
        }
    }
}