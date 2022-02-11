package simpleSpringMVC;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "BuddyInfo")
public class BuddyInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "buddy_id", nullable = false)
    private Long id;
    private String name;
    private long phoneNumber;

    protected BuddyInfo(){}

    public BuddyInfo(String name, long phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString(){
        return String.format("BuddyInfo[id=%d, name='%s, phone number=%d]",id, name, phoneNumber);
    }
}

