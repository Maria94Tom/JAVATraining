package com.koerber.journalapp.services;

import com.koerber.journalapp.entities.JournalEntry;
import com.koerber.journalapp.entities.User;
import com.koerber.journalapp.exception.ResurceNotFoundException;
import com.koerber.journalapp.repo.JournalEntryRepo;
import com.koerber.journalapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JournalServiceImpl implements JournalService{

    private JournalEntryRepo journalRepo;
    private UserRepo userRepo;

    @Autowired
    public JournalServiceImpl(JournalEntryRepo journalRepo, UserRepo userRepo) {
        this.journalRepo = journalRepo;
        this.userRepo = userRepo;
    }



    @Override
    public List<JournalEntry> getAll() {
        return journalRepo.findAll();
    }

    @Override
    public JournalEntry save(JournalEntry journalEntry) {
        return journalRepo.save(journalEntry);
    }


    @Override
    public JournalEntry update(String id, JournalEntry journalEntry) {
        journalEntry.setId(id);
        journalRepo.save(journalEntry);
        return journalEntry;
    }

    @Override
    public void delete(String id) {
        journalRepo.deleteById(id);

    }

    @Override
    public JournalEntry getById(String id) {
        return journalRepo.findById(id).orElseThrow(()->new ResurceNotFoundException("ResourceNotFound"));
    }

    @Override
    public List<JournalEntry> getByUserId(String id) {
        User user=userRepo.findById(id).orElseThrow(()->new ResurceNotFoundException("ResourceNotFound"));
        return user.getJournalEntries();
    }
}
