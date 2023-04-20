package com.project.zoopiter.domain.bbsc.dao;

import com.project.zoopiter.domain.entity.Bbsc;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
    log.info("cnt={}",i);
  }

  @Test
  @DisplayName("펫태그 검색")
  void findbyPetTypes() {
    String[] arr= {"기타","소동물"};
    BbscFilterCondition filterCondition = new BbscFilterCondition(arr, 1, 11, "");
    List<Bbsc> byPetType = bbscDAO.findByPetType(filterCondition);
    log.info("byPetType={}",byPetType);
  }

  @Test
  @DisplayName("펫태그 게시글 건수")
  void totalCountByPetType() {
    String[] arr= {"기타","소동물"};
    BbscFilterCondition filterCondition = new BbscFilterCondition(arr, 1, 11, "");
    int cntOfFindedPetType = bbscDAO.totalCount(filterCondition);
    log.info("cntOfFindedPetType={}",cntOfFindedPetType);
  }

  @Test
  @DisplayName("필터 검색")
  void findByFilter(){
    String[] arr= {};
    String filter1 = "bcHit";
    String filter2 = "bcUdate";
    BbscFilterCondition bcHit = new BbscFilterCondition(arr, 1, 11, filter1);
    BbscFilterCondition bcUdate = new BbscFilterCondition(arr, 1, 11, filter2);

    List<Bbsc> findByBchit = bbscDAO.findByFilter(bcHit);
    List<Bbsc> findByBcudate = bbscDAO.findByFilter(bcUdate);

    log.info("findByBchit={}",findByBchit);
    log.info("findByBcudate={}",findByBcudate);
  }

  @Test
  @DisplayName("전체 검색(레코드번호)")
  void findAll(){
    List<Bbsc> findedAll = bbscDAO.findAll(1, 5);
    log.info("findedAll={}",findedAll);
  }

  @Test
  @DisplayName("전체 검색(펫필터,레코드번호)")
  void findAll2(){
    String[] arr= {"기타","소동물"};
    BbscFilterCondition filterCondition = new BbscFilterCondition(arr, 1, 12, "");
    List<Bbsc> findedAll = bbscDAO.findAll(filterCondition,1, 5);
    log.info("findedAll={}",findedAll);
  }
}