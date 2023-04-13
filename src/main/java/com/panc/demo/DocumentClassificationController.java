package com.panc.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class DocumentClassificationController {
    
	@PostMapping("/classifydoc")
	public Map<String, Object> classifyDocument(@RequestParam("file") MultipartFile file,
	                                            @RequestParam(value = "options", required = false) Map<String, String> options) {
	    // Add your logic to classify the document here
	    String result = "Document classified successfully.";
	    int id = 1234; // Replace with the ID of the batch

	    Map<String, Object> response = new HashMap<String,Object>();
	    response.put("result", result);
	    response.put("id", id);

	    return response;
	}
	
	@GetMapping("/classifydoc/{id}")
	public Map<String, Object> getDocumentClassificationResult(@PathVariable int id) {
	    // Add your logic to fetch the classification result based on the ID
	    String result = "Document classified successfully.";
	    
	    Map<String, Object> response = new HashMap<>();
	    response.put("result", result);

	    return response;
	}




}

