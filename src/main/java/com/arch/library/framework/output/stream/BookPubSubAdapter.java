package com.arch.library.framework.output.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.arch.library.application.ports.output.BookStreamManagement;
import com.arch.library.domain.BookDO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BookPubSubAdapter implements BookStreamManagement {

  private static final Logger log = LoggerFactory.getLogger(BookPubSubAdapter.class);
  private final StreamBridge streamBridge;
  private static final String NEW_BOOK = "book-library-store";

  @Override
  public void notificationNewBook(BookDO bookDO) {
    Message<BookDO> message = MessageBuilder.withPayload(bookDO).build();
    log.info("Information to send : {}", NEW_BOOK);
    streamBridge.send(NEW_BOOK, message);
    log.info("New Book sent : {}", NEW_BOOK);
  }
}
