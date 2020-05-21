package org.ysp.webservice2020.service.impl;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.stereotype.Service;
import org.ysp.webservice2020.service.WeatherService;

import javax.jws.WebService;

/**
 * @author pai
 * @date 2020/5/4
 */
@Service
@WebService(serviceName = "weatherService" //wsdl命名空间
        ,name="WeatherService" //porType名称 客户端生成代码时为接口名称
        ,targetNamespace = "http://service.webservice2020.ysp.org"
        ,endpointInterface = "org.ysp.webservice2020.service.WeatherService")
public class WeatherServiceImpl implements WeatherService {

    public final static String[] WEATHER_DESC = new String[]{"晴天", "多云", "暴雨", "大雨", "中雨", "小雨"};


    @Override
    public String queryWeather(String city) {
        StringBuilder builder = new StringBuilder(city);
        builder.append("天气:");
        builder.append(WEATHER_DESC[getRandomNumber(5)]);
        return builder.toString();
    }


    private static int getRandomNumber(int num) {
        return (int) (Math.random() * num);
    }
}
