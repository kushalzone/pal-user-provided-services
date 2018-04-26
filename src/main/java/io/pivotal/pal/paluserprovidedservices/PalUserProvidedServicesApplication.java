package io.pivotal.pal.paluserprovidedservices;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
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

//	@Bean
//	ServiceCredentials serviceCredentials(@Value("${vcap.services}") String vcapServices) {
//		return new ServiceCredentials(vcapServices);
//	}

//	@Bean
//	DatabaseServiceCredentials databaseServiceCredentials(@Value("${vcap.services}") String vcapServices) {
//		return new DatabaseServiceCredentials(vcapServices);
//	}

//	@Bean(name = "dataSource")
//	public DataSource dataSource(ServiceCredentials serviceCredentials) {
//
//		String url = serviceCredentials.getCredential("external-db","user-provided", "url");
//		String username = serviceCredentials.getCredential("external-db","user-provided", "username");
//		String password = serviceCredentials.getCredential("external-db","user-provided", "password");
//
//		return DataSourceBuilder.create().url(url).driverClassName("com.mysql.jdbc.Driver").username(username).password(password).build();
//	}

//	@Bean
//	public DataSource albumsDataSource(DatabaseServiceCredentials serviceCredentials) {
//		MysqlDataSource dataSource = new MysqlDataSource();
//		dataSource.setURL(serviceCredentials.jdbcUrl("external-db", "user-provided"));
//		return dataSource;
//	}
}
