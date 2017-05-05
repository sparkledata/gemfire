package related;

import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.client.ClientRegionFactoryBean;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import related.gemfire.EnvParser;
import related.model.ProductCorrelation;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Properties;

@Configuration
@EnableGemfireRepositories
@SuppressWarnings("unused")
@SpringBootApplication
public class Application {
    private static final String SECURITY_CLIENT = "security-client-auth-init";

    @Bean
    public ClientCache gemfireCache() {
        Properties props = new Properties();
        props.setProperty(SECURITY_CLIENT, "related.gemfire.ClientAuthInitialize.create");
        ClientCacheFactory ccf = new ClientCacheFactory(props);

        try {
            List<URI> locatorList = EnvParser.getInstance().getLocators();

            for (URI locator : locatorList) {
                ccf.addPoolLocator(locator.getHost(), locator.getPort());
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Could not deploy Application", e);
        }

        return ccf.create();
    }

    @Bean(name = "correlation")
    public ClientRegionFactoryBean<String, ProductCorrelation> correlationRegion(@Autowired ClientCache gemfireCache) {
        ClientRegionFactoryBean<String, ProductCorrelation> pizzaRegion = new ClientRegionFactoryBean<>();

        pizzaRegion.setCache(gemfireCache);
        pizzaRegion.setClose(false);
        pizzaRegion.setShortcut(ClientRegionShortcut.PROXY);
        pizzaRegion.setLookupEnabled(true);
        return pizzaRegion;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}