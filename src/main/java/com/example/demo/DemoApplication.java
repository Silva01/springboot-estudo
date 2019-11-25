package com.example.demo;

import com.example.demo.domain.Playlist;
import com.example.demo.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import sun.tools.jar.CommandLine;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private PlaylistService s;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
