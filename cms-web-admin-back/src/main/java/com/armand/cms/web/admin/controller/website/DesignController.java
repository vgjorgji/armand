package com.armand.cms.web.admin.controller.website;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.armand.cms.web.admin.model.Controller;
import com.armand.cms.web.admin.model.PageConst;
import com.armand.cms.web.admin.model.response.Response;

@RestController(value = Controller.WebsiteDesign)
@RequestMapping(value = PageConst.WebsiteDesign)
public class DesignController {

  @RequestMapping(value = "/load", method = RequestMethod.GET)
  public Response load() {
    Response response = new Response();
    return response;
  }

}
