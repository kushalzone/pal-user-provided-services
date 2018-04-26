package io.pivotal.pal.paluserprovidedservices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

@SpringBootApplication
@ComponentScan("io.pivotal")
public class PalUserProvidedServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PalUserProvidedServicesApplication.class, args);
	}

	@Bean
	ServiceCredentials serviceCredentials(@Value("${vcap.services}") String vcapServices) {
		return new ServiceCredentials(vcapServices);
	}

	@Bean(name = "dataSource")
	public DataSource dataSource(ServiceCredentials serviceCredentials) {

		String url = serviceCredentials.getCredential("external-db","user-provided", "url");
		String username = serviceCredentials.getCredential("external-db","user-provided", "username");
		String password = serviceCredentials.getCredential("external-db","user-provided", "password");

		return DataSourceBuilder.create().url(url).driverClassName("com.mysql.jdbc.Driver").username(username).password(password).build();
	}
}
