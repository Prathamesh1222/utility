package com.utility.util.transformers;


import com.utility.domain.User;
import com.utility.dto.UserDTO;
import com.utility.util.DtoTransformer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Harshal Patil
 */
@Component
public class UserTransformer implements DtoTransformer<User, UserDTO> {

    @Override
    public UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();

        if(null != user) {
            userDTO.setId(user.getId());
            userDTO.setFirst_name(user.getFirst_name());
            userDTO.setLast_name(user.getLast_name());
            userDTO.setAge(user.getAge());
            userDTO.setFavourite_colour(user.getFavourite_colour());
        }
        return userDTO;
    }

    @Override
    public User toEntity(UserDTO dto) {
        User user = new User();
        if(null != dto) {
            user.setFirst_name(dto.getFirst_name());
            user.setLast_name(dto.getLast_name());
            user.setAge(dto.getAge());
            user.setFavourite_colour(dto.getFavourite_colour());
        }
        return user;
    }

    @Override
    public Set<UserDTO> toDtoSet(Set<User> userList) {
        if(userList != null && !userList.isEmpty()) {
            return userList
                    .stream()
                    .map(this::toDto)
                    .collect(Collectors.toSet());
        }
        return Set.of();
    }

    @Override
    public Set<User> toEntitySet(Set<UserDTO> dtoList) {
        if(dtoList != null && !dtoList.isEmpty()) {
            return dtoList
                    .stream()
                    .map(this::toEntity)
                    .collect(Collectors.toSet());
        }
        return Set.of();
    }

    @Override
    public List<UserDTO> toDtoList(List<User> userList) {
        if(userList != null && !userList.isEmpty()) {
            return userList
                    .stream()
                    .map(this::toDto)
                    .collect(Collectors.toList());
        }
        return List.of();
    }

    @Override
    public List<User> toEntityList(List<UserDTO> dtoList) {
        if(dtoList != null && !dtoList.isEmpty()) {
            return dtoList
                    .stream()
                    .map(this::toEntity)
                    .collect(Collectors.toList());
        }
        return List.of();
    }
}
