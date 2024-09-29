package config;

import org.apache.http.HttpHost;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
@Configuration
public class ElasticsearchConfig {

    @Value("${elasticsearch.hostname}")
    private String hostname;
    @Value("${elasticsearch.port}")
    private int port;
    @Value("${elasticsearch.scheme}")
    private String scheme;

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost(hostname, port, scheme)));
        return client;
    }
}
