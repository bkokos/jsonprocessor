package com.jsonprocessor.io.writer;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class JSONWriter {

	public void writePostsToFiles(List<JSONObject> posts) {
		log.info("Saving posts to files...");
		posts.forEach(post -> {
			try (FileWriter file = new FileWriter(((Integer) post.get("id")).toString() + ".json")) {
				file.write(post.toJSONString());
			} catch (IOException e) {
				log.error("Cannot write post to file", e);
			}
		});
		log.info("Saving posts to files is done.");
	}
}
