package web.clinic.config;

import org.testcontainers.containers.MySQLContainer;

public class DockerDatabase {

	@SuppressWarnings("rawtypes")
	public static MySQLContainer mysql = new MySQLContainer("mysql:5.6");
	
}
