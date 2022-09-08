package com.nchu.ptas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nchu.ptas.mapper")
public class PersonalTrainerAppointmentSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalTrainerAppointmentSystemApplication.class, args);
    }

}
