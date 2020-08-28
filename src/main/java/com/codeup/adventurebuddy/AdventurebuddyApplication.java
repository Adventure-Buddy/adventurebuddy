package com.codeup.adventurebuddy;

import com.codeup.adventurebuddy.services.TrailService;
import com.codeup.adventurebuddy.models.Trail;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class AdventurebuddyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdventurebuddyApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner (TrailService trailService) {
//        return args -> {
//            // read json and write to db
//          ObjectMapper mapper = new ObjectMapper();
//          TypeReference<List<Trail>> typeReference = new TypeReference<List<Trail>>(){};
//            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/trails.json");
//            try{
//                List<Trail> trails = mapper.readValue(inputStream, typeReference);
//                trailService.save(trails);
//                System.out.println("Trails saved!");
//            } catch (IOException e) {
//               System.out.println("Unable to save trails: " + e.getMessage());
//            }
//        };
//   }
////   comment

}
