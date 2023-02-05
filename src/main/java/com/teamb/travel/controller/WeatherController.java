package com.teamb.travel.controller;

import com.teamb.travel.dto.weather.MapReqDTO;
import com.teamb.travel.dto.weather.WeatherResDTO;
import com.teamb.travel.service.weather.WeatherService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/tourlist/weather")
    public Result findWeather(@RequestBody MapReqDTO mapReqDto) throws IOException, ParseException {
        WeatherResDTO weatherResDTO = weatherService.findWeatherResDTOByMapXAndMapY(mapReqDto.getMapX(), mapReqDto.getMapY());
        return new Result(weatherResDTO);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }
}
