package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.Book;
import service.BookServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceImpl_Test {
    private BookServiceImpl bookService;
    private Book book;


    @BeforeEach
    public void before(){
         bookService=new BookServiceImpl();
    }

    @Test
    public void testBook(){

assertNotNull(bookService.getAllBooks());

    }

}

