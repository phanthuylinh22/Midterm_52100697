package org.example.midterm.ServiceTest;

import org.example.midterm.DTO.UserDTO;
import org.example.midterm.model.Role;
import org.example.midterm.model.User;
import org.example.midterm.repository.RoleRepository;
import org.example.midterm.repository.UserRepository;
import org.example.midterm.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository, roleRepository, passwordEncoder);
    }

    @Test
    public void testSaveUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("John");
        userDTO.setLastName("Doe");
        userDTO.setEmail("john@example.com");
        userDTO.setPassword("password");

        Role role = new Role();
        role.setName("ROLE_USER");
        when(roleRepository.findByName("ROLE_USER")).thenReturn(role);

        // Create ArgumentCaptor for User class
        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);

        userService.saveUser(userDTO);

        verify(passwordEncoder, times(1)).encode("password");

        // Verify that userRepository.save() is called with the expected User object
        verify(userRepository, times(1)).save(userCaptor.capture());
        User capturedUser = userCaptor.getValue();
        assertEquals("John Doe", capturedUser.getName());
        assertEquals("john@example.com", capturedUser.getEmail());
    }

    @Test
    public void testFindByEmail() {
        String email = "john@example.com";
        User user = new User();
        user.setEmail(email);
        when(userRepository.findByEmail(email)).thenReturn(user);

        User foundUser = userService.findByEmail(email);
        assertEquals(email, foundUser.getEmail());
    }

    @Test
    public void testFindAllUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setName("Alice Smith");
        user1.setEmail("alice@example.com");

        User user2 = new User();
        user2.setName("Bob Johnson");
        user2.setEmail("bob@example.com");

        // Thêm user1 và user2 vào danh sách
        users.add(user1);
        users.add(user2);

        // Stub phương thức findAll() của userRepository để trả về danh sách users
        when(userRepository.findAll()).thenReturn(users);

        // Gọi phương thức findAllUsers() của service
        List<UserDTO> userDTOs = userService.findAllUsers();

        // Kiểm tra số lượng UserDTO trả về có đúng là 2 hay không
        assertEquals(2, userDTOs.size());
    }
}

