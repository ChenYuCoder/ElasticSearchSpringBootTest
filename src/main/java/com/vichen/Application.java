package com.vichen;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author chenyu
 * @date 2021/2/1
 */
@SpringBootApplication
@EnableJpaRepositories("com.vichen.jpa")
@EnableElasticsearchRepositories("com.vichen.elasticsearch")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }


  @Bean
  RestHighLevelClient elasticsearchClient() {
    ClientConfiguration configuration = ClientConfiguration.builder()
      .connectedTo("192.168.17.55:9200")
      //.withConnectTimeout(Duration.ofSeconds(5))
      //.withSocketTimeout(Duration.ofSeconds(3))
      //.useSsl()
      //.withDefaultHeaders(defaultHeaders)
      //.withBasicAuth(username, password)
      // ... other options

      .build();
    return RestClients.create(configuration).rest();
  }

}
