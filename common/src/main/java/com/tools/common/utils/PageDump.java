package com.tools.common.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;
import org.springframework.data.domain.Page;

/**
 * @Author jeff
 * @Date 2018/12/15 2:37 PM
 * @Description TODO
 * @Version 0.1
 */
@Data
public class PageDump<T> {

  private List<T> content;
  private int totalPages;
  private long total;
  private int page;
  private int size;
  @JsonProperty("first")
  private boolean isFirst;
  @JsonProperty("last")
  private boolean isLast;
  private boolean hasNext;
  private boolean hasPrevious;

  public PageDump<T>  pageDump(Page<T> page) {
    PageDump<T> chunk = new PageDump();
    if(page!=null){
      chunk.setContent(page.getContent());
      chunk.setTotalPages(page.getTotalPages());
      chunk.setTotal(page.getTotalElements());
      chunk.setPage(page.getPageable().getPageNumber() + 1);
      chunk.setSize(page.getPageable().getPageSize());
      chunk.setFirst(page.isFirst());
      chunk.setLast(page.isLast());
      chunk.setHasNext(page.hasNext());
      chunk.setHasPrevious(page.hasPrevious());
    }
    return chunk;
  }
}
