package simpleSpringMVC;

import org.springframework.stereotype.Controller;

@Controller
public class AddressBookController {
    private AddressBookRepository repository;

    public AddressBookController(AddressBookRepository repository){
        this.repository = repository;
    }


}
