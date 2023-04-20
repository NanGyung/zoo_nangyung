package com.project.zoopiter.domain.bbscReply.dao;

import com.project.zoopiter.domain.entity.BbscReply;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@ToString
@Slf4j
@Repository
@RequiredArgsConstructor
public class BbscReplyDAOImpl implements BbscReplyDAO {

  private final NamedParameterJdbcTemplate template;

  /**
   * 댓글작성
   *
   * @param bbscReply
   * @return 댓글번호
   */
  @Override
  public Long save(BbscReply bbscReply) {
    StringBuffer sql = new StringBuffer();
    sql.append("insert into C_BBSC (CC_ID, BBSC_ID, CC_CONTENT, USER_NICK) ");
    sql.append("values(C_BBSC_CC_ID_SEQ.nextval, :bbscId, :ccContent, :userNick) ");

    KeyHolder keyHolder = new GeneratedKeyHolder();
    SqlParameterSource param = new BeanPropertySqlParameterSource(bbscReply);

    template.update(sql.toString(),param, keyHolder, new String[]{"cc_id"});  //댓글번호
    long ccId = keyHolder.getKey().longValue();

    return ccId;
  }

  /**
   * 댓글목록
   *
   * @return
   */
  @Override
  public List<BbscReply> findAll() {
    String sql = "select * from c_bbsc";

    List<BbscReply> list = template.query(sql, new BeanPropertyRowMapper<>(BbscReply.class));

    return list;
  }

  /**
   * 댓글 수정
   *
   * @param rnum      댓글번호
   * @param bbscReply
   * @return 수정건수
   */
  @Override
  public int updateByRnum(Long rnum, BbscReply bbscReply) {
    StringBuffer sql = new StringBuffer();
    sql.append("update bbscReply ");
    sql.append("set cc_content = :ccContent, cc_udate = systimestamp ");
    sql.append("where cc_id = :ccId ");

    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("ccContent",bbscReply.getCcContent())
        .addValue("ccId",rnum);

    return template.update(sql.toString(),param);
  }

  /**
   * 삭제
   *
   * @param rnum      댓글번호
   * @return 삭제건수
   */
  @Override
  public int deleteByRnum(Long rnum) {
    String sql = "delete from c_bbsc where cc_id = :ccId";
    return template.update(sql, Map.of("ccId",rnum));
  }

}
