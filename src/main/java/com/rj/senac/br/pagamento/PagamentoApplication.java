package com.rj.senac.br.pagamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PagamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagamentoApplication.class, args);
	}

}
