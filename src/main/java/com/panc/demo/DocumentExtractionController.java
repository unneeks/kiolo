package com.panc.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class DocumentExtractionController{

   // @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/submitforextraction")
    public Map<String, Object> submitForExtraction(@RequestParam("file") MultipartFile file,
                                                   @RequestHeader("Authorization") String authorizationHeader) {

        // Validate the JWT token
        String jwt = authorizationHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(jwt);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        jwtTokenUtil.validateToken(jwt, userDetails);

        // Add your logic to submit the document for extraction here
        String status = "Document submitted for extraction successfully.";
        int jobId = 5678; // Replace with the ID of the job

        Map<String, Object> response = new HashMap<String, Object> ();
        response.put("status", status);
        response.put("jobId", jobId);

        return response;
    }

    @GetMapping("/getextractionresult/{jobId}")
    public Map<String, Object> getExtractionResult(@PathVariable int jobId,
                                                   @RequestHeader("Authorization") String authorizationHeader) {

        // Validate the JWT token
        String jwt = authorizationHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(jwt);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        jwtTokenUtil.validateToken(jwt, userDetails);

        // Add your logic to fetch the extraction result based on the job ID
        String result = "Extraction job completed successfully.";

        Map<String, Object> response = new HashMap<>();
        response.put("result", result);

        return response;
    }

    @GetMapping("/getextractionstatus/{jobId}")
    public Map<String, Object> getExtractionStatus(@PathVariable int jobId,
                                                   @RequestHeader("Authorization") String authorizationHeader) {

        // Validate the JWT token
        String jwt = authorizationHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(jwt);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        jwtTokenUtil.validateToken(jwt, userDetails);

        // Add your logic to fetch the status of the extraction job based on the job ID
        String status = "Extraction job in progress.";

        Map<String, Object> response = new HashMap<>();
        response.put("status", status);

        return response;
    }
}
