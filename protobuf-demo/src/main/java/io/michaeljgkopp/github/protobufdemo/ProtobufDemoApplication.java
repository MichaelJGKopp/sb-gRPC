package io.michaeljgkopp.github.protobufdemo;

import io.michaeljgkopp.github.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProtobufDemoApplication {

  public static void main(String[] args) {

/*    // Example of creating a protobuf object
    Employee.newBuilder()
        .setId(101)
        .setName("John Doe")
        .build();*/

    SpringApplication.run(ProtobufDemoApplication.class, args);
  }

}
