package de.netpioneer.socialmedia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocialMediaAnalysisApplication implements CommandLineRunner {
	
    public static void main(String[] args) {
        SpringApplication.run(SocialMediaAnalysisApplication.class, args);
    }

	@Override
	public void run(String... arg0) throws Exception {}
    
}
