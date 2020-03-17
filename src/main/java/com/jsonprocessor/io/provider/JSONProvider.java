package com.jsonprocessor.io.provider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class JSONProvider {

	@Value("${posts.url}")
	private String postsUrl;

	private final RestTemplate restTemplate;

	public List<JSONObject> getPosts() {
		log.info("Getting posts from {}...", postsUrl);
		ResponseEntity<List<JSONObject>> listResponseEntity = restTemplate.exchange(postsUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<JSONObject>>() {
		});
		log.info("Getting posts from {} is done.", postsUrl);
		return listResponseEntity.getBody();
	}
}
