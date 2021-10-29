package fr.unilim.iut;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    @Test
    public void should_create_user_with_hashed_password() {

        HashProvider hashProvider = mock(HashProvider.class);
        when(hashProvider.hash("secret")).thenReturn("hash");
        UserService userService = new UserServiceImpl(hashProvider);

        User user = userService.createUser("Bob", "secret");

        assertEquals(user.firstName(), "Bob");
        assertEquals(user.hashedPassword(), "hash");
    }
}
