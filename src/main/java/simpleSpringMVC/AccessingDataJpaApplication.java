package simpleSpringMVC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {
	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class);
	}

	@Bean
	public CommandLineRunner demo(simpleSpringMVC.AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository){
		AddressBook addressBook = new AddressBook();
		BuddyInfo buddyInfo1 = new BuddyInfo("Jason",123456);
		BuddyInfo buddyInfo2 = new BuddyInfo("Jack",7891011);
		BuddyInfo buddyInfo3 = new BuddyInfo("Mario",87945612);

		addressBook.addBuddyInfo(buddyInfo1);
		addressBook.addBuddyInfo(buddyInfo2);
		addressBook.addBuddyInfo(buddyInfo3);

		return (args) -> {
			addressBookRepository.save(addressBook);
			log.info("AddressBook found with findAll():");
			log.info("----------------------------------");
			for(AddressBook addressbook : addressBookRepository.findAll()){
				log.info(addressbook.toString());
			}
			log.info("");


			buddyInfoRepository.save(buddyInfo1);
			buddyInfoRepository.save(buddyInfo2);
			buddyInfoRepository.save(buddyInfo3);

			log.info("BuddyInfo found with findAll():");
			log.info("--------------------------------");
			for(BuddyInfo buddyInfo : buddyInfoRepository.findAll()){
				log.info(buddyInfo.toString());
			}
			log.info("");

		};
	}
}
