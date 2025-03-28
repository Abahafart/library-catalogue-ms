package com.arch.library.application.ports.output;

import com.arch.library.domain.BookDO;

public interface BookStreamManagement {

  void notificationNewBook(BookDO bookDO);

}
