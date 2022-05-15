import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;

public class UserServiceImplTest {
    User user = Mockito.mock(User.class); // mock User
    UserDAO userDAO = Mockito.mock(UserDAO.class); // mock UserDAO
    SecurityService securityService = Mockito.mock(SecurityService.class); // mock SecurityService
    UserServiceImpl sut = new UserServiceImpl(userDAO, securityService);

    @Test
    public void testGetPassword() throws Exception {
        sut.assignPassword(user);
        verify(user).getPassword(); // verifikasi jika object user berhasil mendapatkan password barunya
    }

    @Test
    public void testUpdateUser() throws Exception {
        sut.assignPassword(user);
        verify(userDAO).updateUser(user); // verifikasi method updateUser() pada userDAO dipanggil dengan benar/tidak
    }
}
