package com.codingdojo.jhusseth.services.implementation;

import com.codingdojo.jhusseth.domain.dto.UserDTO;
import com.codingdojo.jhusseth.domain.dto.UserRegisterDTO;
import com.codingdojo.jhusseth.domain.mapper.UserMapper;
import com.codingdojo.jhusseth.domain.model.User;
import com.codingdojo.jhusseth.repository.UserRepository;
import com.codingdojo.jhusseth.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public boolean register(UserRegisterDTO dto) {
        User user = UserMapper.INSTANCE.userDtoToUser(dto);
        if (Objects.nonNull(user) && Objects.isNull(repository.findUserByEmail(user.getEmail()))) {
            repository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return repository.findAll().stream()
                .map(UserMapper.INSTANCE::userToUserDTO)
                .collect(Collectors.toList());
    }
}
