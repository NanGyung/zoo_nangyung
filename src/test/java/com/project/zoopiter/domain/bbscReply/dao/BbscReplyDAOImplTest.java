package com.project.zoopiter.domain.bbscReply.dao;

import com.project.zoopiter.domain.entity.BbscReply;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@Slf4j
@SpringBootTest
class BbscReplyDAOImplTest {

  @Autowired
  private BbscReplyDAO bbscReplyDAO;


  @Test
  @DisplayName("댓글저장")
  void save() {
    BbscReply bbscReply = new BbscReply();
    bbscReply.setBbscId(2L);
    bbscReply.setCcContent("동글동글 동그리 냥냥이다!");
    bbscReply.setUserNick("감튀");
    Long rNum = bbscReplyDAO.save(bbscReply);

    Assertions.assertThat(rNum).isEqualTo(3L);
  }

  @Test
  @DisplayName("댓글목록")
  void findByBbscId() {
    Optional<List<BbscReply>> byBbscId = bbscReplyDAO.findByBbscId(2L);
    log.info("byBbscId={}",byBbscId);
  }

  @Test
  @DisplayName("댓글수정")
  void updateByRnum() {
    BbscReply bbscReply = new BbscReply();
    bbscReply.setCcId(2L);
    bbscReply.setCcContent("수정수정 고양이 짱 귀여워요 지구뿌쎠!");
    int cntOfUpdate = bbscReplyDAO.updateByCcid(2L, bbscReply);
    Assertions.assertThat(cntOfUpdate).isEqualTo(1);
  }

  @Test
  @DisplayName("댓글삭제")
  void deleteByRnum() {
    int cntOfDelete = bbscReplyDAO.deleteByCcid(3L);
    Assertions.assertThat(cntOfDelete).isEqualTo(1);
  }
}