package com.project.zoopiter.domain.bbscReply.dao;

import com.project.zoopiter.domain.entity.BbscReply;

import java.util.List;

public interface BbscReplyDAO {
  /**
   * 댓글작성
   * @param bbscReply
   * @return  댓글번호
   */
  Long save(BbscReply bbscReply);

  /**
   * 댓글목록
   * @return
   */
  List<BbscReply> findAll();


  /**
   * 댓글 수정
   * @param rnum 댓글번호
   * @param bbscReply
   * @return 수정건수
   */
  int updateByRnum(Long rnum, BbscReply bbscReply);


  /**
   * 삭제
   * @param rnum 댓글번호
   * @return 삭제건수
   */
  int deleteByRnum(Long rnum);


}
