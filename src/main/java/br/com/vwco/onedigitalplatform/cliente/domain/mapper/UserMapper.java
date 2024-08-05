package br.com.vwco.onedigitalplatform.cliente.domain.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.response.UserDto;
import br.com.vwco.onedigitalplatform.cliente.domain.model.User;

@Component
public class UserMapper {

	public List<UserDto> toDtoList(List<User> users) {
		return users.stream().map(this::toDto).toList();
	}

	public UserDto toDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setFirstName(user.getFirstName());
		userDto.setSurName(user.getSurName());
		userDto.setEmail(user.getEmail());
		userDto.setCpf(user.getCpf());
		userDto.setTelephone(user.getTelephone());
		userDto.setId(user.getId());
		return userDto;
	}

}
