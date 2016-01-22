package mineproj.app.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.athena.config.server.WebConfig;
import org.springframework.context.annotation.Bean;


/**
 *
 *
 * @author Anant
 *
 */

@Configuration
@EnableTransactionManagement

public class WebConfigExtended extends WebConfig{

	
}