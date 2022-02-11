package simpleSpringMVC;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
public class AddressBook implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addressbook_id", nullable = false)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<BuddyInfo> buddyInfos = new LinkedList<>();

    public Long getId() {
        return id;
    }

    public AddressBook(){}

    @Transient
    public void addBuddyInfo(BuddyInfo buddyInfo){
        buddyInfos.add(buddyInfo);
    }

    public List<BuddyInfo> getBuddyInfos() {
        return buddyInfos;
    }

    @Transient
    public void removeBuddy(BuddyInfo buddyInfo){
        this.buddyInfos.remove(buddyInfo);
    }

    @Transient
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AddressBook temp_book = (AddressBook) obj;
        return temp_book.buddyInfos.equals(buddyInfos);
    }

    @Override
    public String toString(){
        String str = String.format("AddressBook : id=%d\n", id);
        str += buddyInfos;
        return str;
    }
}