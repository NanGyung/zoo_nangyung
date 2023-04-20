package com.project.zoopiter.domain.bbscReply.dao;

import com.project.zoopiter.domain.entity.BbscReply;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class BbscReplyDAOImplTest {

  @Autowired
  private BbscReplyDAO bbscReplyDAO;


  @Test
  @DisplayName("댓글저장")
  void save() {
    BbscReply bbscReply = new BbscReply();
    bbscReply.setBbscId(1L);
    bbscReply.setCcContent("고양이 짱 귀여워요 지구뿌셔~");
    bbscReply.setUserNick("감튀");
    Long rNum = bbscReplyDAO.save(bbscReply);

    Assertions.assertThat(rNum).isEqualTo(1L);
    log.info("bbscReply={}",bbscReply);
  }

  @Test
  @DisplayName("댓글목록")
  void findAll() {
  }

  @Test
  @DisplayName("댓글수정")
  void updateByRnum() {
  }

  @Test
  @DisplayName("댓글삭제")
  void deleteByRnum() {
  }
}