package com.jnunes.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.jnunes"})
@EntityScan(basePackages = {"com.jnunes"})
@EnableJpaRepositories(basePackages = {"com.jnunes"})
public class SpringCloudAzureFunctionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAzureFunctionApplication.class, args);
    }

//    @Autowired
//    CursoServiceImpl cursoService;
//
//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//            Curso curso = new Curso();
//            curso.setTitulo("Bosta");
//            curso.setDataInicio(LocalDate.now());
//            curso.setCargaHoraria(20);
//            cursoService.save(curso);
//            System.out.println("Curso salvo com sucesso!");
//        };
//    }
}
