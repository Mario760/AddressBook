package simpleSpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddressBookController {
    private AddressBookRepository repository;

    public AddressBookController(AddressBookRepository repository){
        this.repository = repository;
    }

    @GetMapping("/addressBook/{id}")
    public String addressBookForm(@PathVariable("id") long id, Model model) {
        AddressBook addressbook = this.repository.findById(id);
        model.addAttribute("validId", !(addressbook == null));
        model.addAttribute("addressBook", addressbook);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "addressBook";
    }

    @PostMapping("/addressBook/{id}")
    public String addBuddyInfo(@PathVariable("id") long id,
                                    BuddyInfo buddy) {
        System.out.println("SUCCESS ENTER POST");
        AddressBook addressbook = this.repository.findById(id);
        if (addressbook == null){
            return null;
        }
        buddy.setId((long)(addressbook.getBuddyInfos().size()+1));
        addressbook.addBuddyInfo(buddy);
        this.repository.save(addressbook);
        return "redirect:/";
    }

    @GetMapping("/")
    public String mainPage(){
        return "index";
    }

    @GetMapping("/createBuddy/{id}")
    public String createBuddy(@PathVariable("id") Long id, Model model){
        AddressBook addressbook = this.repository.findById(id);
        model.addAttribute("validId", !(addressbook == null));
        model.addAttribute("id", id);
        return "createBuddy";
    }

    @PostMapping("/addressBook/{id}/{buddyID}")
    public AddressBook removeBuddyInfo(@PathVariable("id") long id,
                                       @PathVariable("buddyID") long buddyID) {
        AddressBook addressbook = this.repository.findById(id);
        if (addressbook == null){
            return null;
        }
        for(BuddyInfo buddy:addressbook.getBuddyInfos()){
            if(buddy.getId()==buddyID){
                addressbook.removeBuddy(buddy);
            }
        }
        this.repository.save(addressbook);
        return addressbook;
    }
}
