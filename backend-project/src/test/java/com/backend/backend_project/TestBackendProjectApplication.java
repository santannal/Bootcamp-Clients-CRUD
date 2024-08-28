package com.backend.backend_project;

import org.springframework.boot.SpringApplication;

public class TestBackendProjectApplication {

	public static void main(String[] args) {
		SpringApplication.from(BackendProjectApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
