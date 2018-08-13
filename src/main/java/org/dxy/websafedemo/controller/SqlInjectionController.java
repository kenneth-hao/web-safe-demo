package org.dxy.websafedemo.controller;

import org.dxy.websafedemo.domain.BusinessCustomer;
import org.dxy.websafedemo.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/sql_injection")
public class SqlInjectionController {

    @Autowired
    private EntityManager em;

    @RequestMapping("/my_business_customer")
    public String viewMyBusinessCustomer(@RequestParam(required = false) String city, Model model, HttpServletRequest request) {
        String username = SessionUtil.getUsername(request);

        String sql = "select * from demo_business_customer where username='" + username + "'";
        if (!StringUtils.isEmpty(city)) {
            sql = sql + " AND city='" + city + "'";
        }
        List<BusinessCustomer> customers = em.createNativeQuery(sql, BusinessCustomer.class).getResultList();
        model.addAttribute("customers", customers);
        model.addAttribute("city", city);

        return "sql_injection/my_business_customer";
    }

}
