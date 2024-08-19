package br.com.fiap.products.cliente.common.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;

@Configuration
public class LocaleResolverFactory {

	@Bean
	public LocaleResolver localeResolver() {
		CustomAcceptHeaderLocaleResolver resolver = new CustomAcceptHeaderLocaleResolver();
		resolver.setDefaultLocale(new Locale("en", "US"));
		return resolver;
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages/messages");
		messageSource.setCacheSeconds(3600);
		return messageSource;
	}

}
