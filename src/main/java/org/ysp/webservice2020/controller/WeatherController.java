package org.ysp.webservice2020.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.ysp.webservice2020.entity.ResponseResult;
import org.ysp.webservice2020.service.WeatherService;

/**
 * @author pai
 * @date 2020/5/4
 */
@RestController
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = "/weather",method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult<String> queryWeather(String city) {
        return new ResponseResult<String>().setCode(0).setMsg("success").setObj(weatherService.queryWeather(city));
    }
}
