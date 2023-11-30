package com.umc.study.domain.book.facade;

import com.umc.study.domain.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookFacade {

    private final BookService bookService;
}
