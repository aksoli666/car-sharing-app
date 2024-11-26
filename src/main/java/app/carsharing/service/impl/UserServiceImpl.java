package app.carsharing.service.impl;

import static app.carsharing.security.CustomUserDetailsService.getUserFromAuthentication;

import app.carsharing.dto.UserDto;
import app.carsharing.dto.request.UserUpdateProfileRequestDto;
import app.carsharing.exception.DuplicateRoleException;
import app.carsharing.exception.EntityNotFoundException;
import app.carsharing.mapper.UserMapper;
import app.carsharing.model.Role;
import app.carsharing.model.User;
import app.carsharing.repository.RoleRepository;
import app.carsharing.repository.UserRepository;
import app.carsharing.service.UserService;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    @Override
    public void updateRole(Authentication authentication, String roleName) {
        User user = getUserFromAuthentication(authentication);
        Role roleForUpdate = convertsToRole(roleName);
        Set<Role> roles = user.getRoles();
        ensureNoDuplicateRole(roles, roleForUpdate);
        roles.add(roleForUpdate);
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public UserDto getProfile(Authentication authentication) {
        return userMapper.toUserDto(
                getUserFromAuthentication(authentication)
        );
    }

    @Override
    public UserDto updateProfile(Authentication authentication,
                                 UserUpdateProfileRequestDto updateProfileRequestDto) {
        User user = getUserFromAuthentication(authentication);
        userMapper.updateUser(updateProfileRequestDto, user);
        return userMapper.toUserDto(userRepository.save(user));
    }

    private Role convertsToRole(String roleName) {
        Role.RoleName value = Role.RoleName.valueOf(roleName);
        return roleRepository.findByRole(value)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Role not found: " + roleName));
    }

    private void ensureNoDuplicateRole(Set<Role> roles, Role roleForUpdate) {
        if (roles.stream().anyMatch(role -> role.equals(roleForUpdate))) {
            throw new DuplicateRoleException("Role already exists: " + roleForUpdate.getRole());
        }
    }
}
