package com.project.zoopiter.web;

import com.project.zoopiter.domain.bbscReply.svc.BbscReplySVC;
import com.project.zoopiter.domain.entity.BbscReply;
import com.project.zoopiter.web.common.LoginMember;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bbscReply")
public class BbscReplyController {

  private final BbscReplySVC bbscReplySVC;

  // 댓글 작성
  @ResponseBody
  @PostMapping("/save")
  public RestResponse<Object> save(
      @RequestBody BbscReply bbscReply,
      HttpServletRequest request
  ){
    log.info("bbscReply={}",bbscReply);
    RestResponse<Object> res = null;

    HttpSession session = request.getSession(false);
    if(session != null) {
      LoginMember loginMember = (LoginMember)session.getAttribute(SessionConst.LOGIN_MEMBER);
      String userNick = loginMember.getUserNick();
      bbscReply.setUserNick(userNick);
    }

    // 댓글번호
    Long ccId = bbscReplySVC.save(bbscReply);
    res = RestResponse.createRestResponse("00","성공",ccId);

    return res;
  }

  // 댓글 목록


  // 댓글 삭제
}
