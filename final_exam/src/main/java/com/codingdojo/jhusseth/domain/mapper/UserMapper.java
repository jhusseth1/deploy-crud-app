package com.codingdojo.jhusseth.domain.mapper;

import com.codingdojo.jhusseth.domain.dto.UserDTO;
import com.codingdojo.jhusseth.domain.dto.UserRegisterDTO;
import com.codingdojo.jhusseth.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);

    User userDtoToUser(UserRegisterDTO dto);

//    UserDetailsDTO userToUserDetailsDTO(User user);

}
