package com.koerber.journalapp.services;

import com.koerber.journalapp.entities.JournalEntry;
import com.koerber.journalapp.entities.User;

import java.util.List;

public interface JournalService {
    public List<JournalEntry> getAll();
    public JournalEntry save(JournalEntry journalEntry);
    public JournalEntry update(String id, JournalEntry journalEntry);
    public void delete(String id);
    public JournalEntry getById(String id);
    public List<JournalEntry> getByUserId(String id); //we want rest endpoint to provide all the JournalEntry of an specific user>
}