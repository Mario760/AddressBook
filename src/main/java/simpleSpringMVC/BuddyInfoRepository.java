package simpleSpringMVC;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
    List<BuddyInfo> findByName(String name);
    List<BuddyInfo> findByPhoneNumber(long phoneNumber);
    BuddyInfo findById(long id);
}
