package com.accenture.lineProcessor;

import com.accenture.lineProcessor.model.Line;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

import java.util.Arrays;
import java.util.List;

@EnableBinding(Processor.class)
@SpringBootApplication
public class LineProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LineProcessorApplication.class, args);
	}

	@Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
	public Object getLine(String message){

		List<String> list = Arrays.asList(message.split(","));
		if(list.size() > 1){
			String fecha = list.get(0);
			String tipoReporte = list.get(1);
			String tipoDato = list.get(2);
			String subtipo = list.get(3);
			String valor = list.get(4);
			String fechaProceso = list.get(5);
			String idCarga = list.get(6);

			if(!valor.equals("VALOR")){
				float valorNum = Float.parseFloat(valor);

				if(valorNum >= 30000){
					valorNum = valorNum*2;
				} else {
					valorNum = valorNum / 2;
				}
				valor = Float.toString(valorNum);
			}

			return new Line(
					fecha,
					tipoReporte,
					tipoDato,
					subtipo,
					valor,
					fechaProceso,
					idCarga
			);
		} else {
			return new Line();
		}
	}
}
