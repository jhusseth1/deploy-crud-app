package com.codingdojo.jhusseth.services.interfaces;

import com.codingdojo.jhusseth.domain.dto.UserDTO;
import com.codingdojo.jhusseth.domain.dto.UserRegisterDTO;

import java.util.List;

public interface UserService {

    public boolean register(UserRegisterDTO dto);

    List<UserDTO> findAllUsers();

}
