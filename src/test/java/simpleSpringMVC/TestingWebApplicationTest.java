package simpleSpringMVC;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TestingWebApplicationTest {

    @Autowired
    private AddressBookRepository addressBookRepository;
    private AddressBookController controller = new AddressBookController(addressBookRepository);

    @Test
    public void contextLoads(){
        assertThat(controller).isNotNull();
    }
}
