package spicinemas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "spicinemas.api")
public class SpiCinemasApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpiCinemasApplication.class, args);
	}
}
