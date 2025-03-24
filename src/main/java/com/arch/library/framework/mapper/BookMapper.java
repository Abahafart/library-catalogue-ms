package com.arch.library.framework.mapper;

import org.mapstruct.Mapper;

import com.arch.library.domain.BookDO;
import com.arch.library.domain.rest.request.BookRequest;
import com.arch.library.framework.config.MappingConfig;
import com.arch.library.framework.output.persistence.data.BookData;

@Mapper(config = MappingConfig.class)
public interface BookMapper {

  BookData fromModel(BookDO model);
  BookDO toModel(BookData data);
  BookDO fromRequest(BookRequest request);

}
