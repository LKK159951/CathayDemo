package com.example.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.entity.Currency;
import com.example.demo.repository.CurrencyRespository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RestCommandLine implements CommandLineRunner {

	@Resource
	private RestTemplate restTemplate;
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private CurrencyRespository currencyRespository;

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Override
	public void run(String... args) throws Exception {
		String url = "https://api.coindesk.com/v1/bpi/currentprice.json";

		ResponseEntity<String> postForEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);

		String body = postForEntity.getBody();
		Map<String, Object> map = mapper.readValue(body, Map.class);
		Map<String, Object> bpiMap = (Map) map.get("bpi");
		Currency currency = new Currency();
		currency.setDisclaimer(String.valueOf(map.get("disclaimer")));
		currency.setChartName(String.valueOf(map.get("chartName")));
		Map<String, String> timeMap = (Map) map.get("time");

//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date updated = new Date(timeMap.get("updated"));
//		Date updatedISO = dateFormat.parse(timeMap.get("updatedISO"));
//		Date updateduk = dateFormat.parse(timeMap.get("updateduk"));

		bpiMap.keySet().forEach(mapKey -> {
			Map<String, String> bpi = (Map) bpiMap.get(mapKey);
			currency.setCode(bpi.get("code"));
			currency.setSymbol(bpi.get("symbol"));
			currency.setRate(bpi.get("rate"));
			currency.setDescription(bpi.get("description"));
			currency.setRateFloat(String.valueOf(bpi.get("rate_float")));
			currency.setId(null);
			currencyRespository.save(currency);
		});
		List<Currency> currencyList = currencyRespository.findAll();
		System.out.println(currencyList);
	}

	public static String dateTransformBetweenTimeZone(Date sourceDate, DateFormat formatter, TimeZone sourceTimeZone,
			TimeZone targetTimeZone) {
		Long targetTime = sourceDate.getTime() - sourceTimeZone.getRawOffset() + targetTimeZone.getRawOffset();
		return formatter.format(new Date(targetTime));

	}

}
