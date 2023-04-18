package com.project.zoopiter.domain.bbsc.dao;

import com.project.zoopiter.domain.entity.Bbsc;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class BbscDAOImplTest {

  @Autowired
  private BbscDAO bbscDAO;

  @Test
  @DisplayName("게시글 전체 건수")
  void totalCount() {
    int size = bbscDAO.findAll().size();
    int i = bbscDAO.totalCount();
    Assertions.assertThat(i).isEqualTo(size);
  }

  @Test
  @DisplayName("게시글 건수-펫태그")
  void testTotalCount() {
    String[] arr= {"기타","소동물"};
    BbscFilterCondition filterCondition = new BbscFilterCondition(arr, 1, 5, "");
    List<Bbsc> byPetType = bbscDAO.findByPetType(filterCondition);
    log.info("byPetType={}",byPetType);
  }

  @Test
  void testTotalCount1() {
  }
}