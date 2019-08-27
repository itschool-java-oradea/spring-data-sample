package ro.itschool.springdatademo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.itschool.springdatademo.repository.DocumentRepository;
import ro.itschool.springdatademo.repository.model.Document;

@SpringBootApplication
public class SpringDataDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataDemoApplication.class, args);
    }


    @Bean
    CommandLineRunner atStartup(DocumentRepository repo) {
        return args -> {
            repo.save(new Document("name1", "content1", "Stefan"));
            repo.save(new Document("name2", "content2", "Steli"));
            repo.save(new Document("name2", "content2", "Maria"));
            repo.save(new Document("name2", "content2", "Maria"));
            repo.save(new Document("name2", "content2", "Maria"));
            repo.save(new Document("name2", "content2", "Maria"));
            repo.save(new Document("name2", "content2", "Steli"));
            repo.save(new Document("name2", "content2", "Steli"));
            repo.save(new Document("name2", "content2", "Cipri"));

            System.out.println("by owner");
            repo.findAllByOwner("Maria")
                    .forEach(System.out::println);
            repo.findFirstByOwnerOrderByDocumentIdDesc("Steli")
                    .ifPresent(System.out::println);
            System.out.println("crazy method:");
            repo.findAllByOwnerAndContentAndDocumentIdBetween("Maria", "content2", 4, 5)
                    .forEach(System.out::println);
            System.out.println("-----------------");
            System.out.println("all:");
            repo.findAll()
                    .forEach(System.out::println);
        };
    }
}
