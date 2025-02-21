package com.koerber.journalapp;

import com.koerber.journalapp.entities.JournalEntry;
import com.koerber.journalapp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
public class BookappApplication implements CommandLineRunner {

	@Autowired
	private MongoTemplate mongoTemplate;
	public static void main(String[] args) {

		SpringApplication.run(BookappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		JournalEntry journalEntry4 = new JournalEntry("Koerber", "I am a koerber employeee",
//				LocalDateTime.now());
//		JournalEntry journalEntry5 = new JournalEntry("UST", "I am a UST Employee", LocalDateTime.now());
//		JournalEntry journalEntry6 = new JournalEntry("Accenture", "Accenture Employee", LocalDateTime.now());
//
//		User user = new User("Merin", "Merin@gmail.com");
//		User user1 = new User("Tony", "Tony@gmail.com");
//
//		user.getJournalEntries().add(journalEntry4);
//		user.getJournalEntries().add(journalEntry5);
//		user.getJournalEntries().add(journalEntry6);
//
//		user1.getJournalEntries().add(journalEntry4);
//		user1.getJournalEntries().add(journalEntry5);
//		user1.getJournalEntries().add(journalEntry6);
//		mongoTemplate.save(journalEntry4);
//		mongoTemplate.save(journalEntry5);
//		mongoTemplate.save(journalEntry6);
//
//		// Save User objects
//		mongoTemplate.save(user);
//		mongoTemplate.save(user1);

	}
}
