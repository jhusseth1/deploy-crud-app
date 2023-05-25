package com.codingdojo.jhusseth.domain.mapper;

import com.codingdojo.jhusseth.domain.dto.UserDTO;
import com.codingdojo.jhusseth.domain.dto.UserRegisterDTO;
import com.codingdojo.jhusseth.domain.model.User;
import lombok.Generated;

import java.util.Objects;

import static com.codingdojo.jhusseth.utils.Utils.encodePassword;

@Generated
public class UserMapperImpl implements UserMapper {
    @Override
    public UserDTO userToUserDTO(User user) {
        if (Objects.isNull(user)) {
            return null;
        }
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }

    @Override
    public User userDtoToUser(UserRegisterDTO dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        return User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(encodePassword(dto.getPassword()))
                .confirmPassword(encodePassword(dto.getConfirmPassword()))
                .build();
    }
}
