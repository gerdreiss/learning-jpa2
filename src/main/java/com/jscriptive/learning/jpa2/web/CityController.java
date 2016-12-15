package com.jscriptive.learning.jpa2.web;

import com.jscriptive.learning.jpa2.domain.City;
import com.jscriptive.learning.jpa2.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/")
    @ResponseBody
    @Transactional(readOnly = true)
    public String bathUk() {
        Optional<City> cityOptional = this.cityService.getCity("Bath", "UK");
        return cityOptional.isPresent() ? cityOptional.get().getName() : null;
    }
}