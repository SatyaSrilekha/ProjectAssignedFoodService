package com.foodservice.dao;

import com.foodservice.entity.UserDetail;

public interface UserDetailDAO 
{
   public boolean registerUser(UserDetail userdetail);
   public UserDetail getUser(String userName);
   public boolean updateUser(UserDetail userdetail);
}
