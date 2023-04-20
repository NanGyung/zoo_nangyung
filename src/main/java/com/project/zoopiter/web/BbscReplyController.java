package com.project.zoopiter.web;

import com.project.zoopiter.domain.bbscReply.svc.BbscReplySVC;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bbscReply")
public class BbscReplyController {

  private final BbscReplySVC bbscReplySVC;

  
}
