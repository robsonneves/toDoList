package br.com.monitoramento;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@EnableAdminServer
@SpringBootApplication
public class MonitoramentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitoramentoApplication.class, args);
	}

}
