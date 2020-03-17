package com.jsonprocessor;

import com.jsonprocessor.io.provider.JSONProvider;
import com.jsonprocessor.io.writer.JSONWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static java.util.Optional.ofNullable;

@SpringBootApplication
public class JsonprocessorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JsonprocessorApplication.class, args);
		JSONProvider jsonProvider = context.getBean(JSONProvider.class);
		JSONWriter jsonWriter = context.getBean(JSONWriter.class);

		ofNullable(jsonProvider.getPosts()).ifPresent(jsonWriter::writePostsToFiles);
	}
}
