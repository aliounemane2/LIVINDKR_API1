package qualshore.livindkr.main;

import org.springframework.boot.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Executor;

/*@SpringBootApplication
public class LivindkrApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivindkrApplication.class, args);
	}
}

*/


@SpringBootApplication
@EnableAsync
public class LivindkrApplication extends SpringBootServletInitializer implements CommandLineRunner{


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LivindkrApplication.class);
    }

    @Bean
    public Executor asyncExecutor() {
      ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
      executor.setCorePoolSize(2);
      executor.setMaxPoolSize(2);
      executor.setQueueCapacity(500);
      executor.setThreadNamePrefix("EmailHtmlSender");
      executor.initialize();
      return executor;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(LivindkrApplication.class, args);
    }
    /*
    public static void main(String[] args) {
        SpringApplication.run(ApiEtreasuryApplication.class, args);
    }
*/
    @Override
    public void run(String... arg0) throws Exception {
        /*fileStorageService.deleteAll();
        fileStorageService.init();*/
    }

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    CharacterEncodingFilter characterEncodingFilter() {
      CharacterEncodingFilter filter = new CharacterEncodingFilter();
      filter.setEncoding("UTF-8");
      filter.setForceEncoding(true);
      return filter;
    }


}

