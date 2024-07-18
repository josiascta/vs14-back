package br.com.dbc.vemser.pessoaapi;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class PropertieReader {

    @Value("${ambiente}")
    private String ambiente;

    @Value("${spring.application.name}")
    private String app;
}
