package org.maochen.ws;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/rest")
public class RestWebService {

  /**
   * HTTP ServletRequest.
   *
   * @return String.
   */
  @RequestMapping(produces = MediaType.TEXT_HTML_VALUE, value = "/demo", method = RequestMethod.GET)
  public String index(HttpServletRequest request) {
    request.setAttribute("obj", "IT Works");
    System.out.println("/I called");
    return "DEMO";
  }
}
