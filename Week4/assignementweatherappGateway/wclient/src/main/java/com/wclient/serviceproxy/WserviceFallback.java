package com.wclient.serviceproxy;

import com.wclient.dto.WeatherInfoDto;
import org.springframework.stereotype.Component;

@Component
public class WserviceFallback implements WeatherServiceProxy{


    @Override
    public String getWeatherInfo(int temp) {
        return "Weather is not found";
    }
}
