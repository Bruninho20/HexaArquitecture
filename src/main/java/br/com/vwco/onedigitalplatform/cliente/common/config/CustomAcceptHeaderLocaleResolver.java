package br.com.vwco.onedigitalplatform.cliente.common.config;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import jakarta.servlet.http.HttpServletRequest;

public class CustomAcceptHeaderLocaleResolver extends AcceptHeaderLocaleResolver {

	private static final List<Locale> SUPPORTED_LOCALES = Arrays.asList(Locale.US, new Locale("en", "US"),
			new Locale("pt", "BR"),
			new Locale("es", "ES")

	);

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String acceptLanguageHeader = request.getHeader("Accept-Language");
		if (acceptLanguageHeader == null || acceptLanguageHeader.isEmpty()) {
			return getDefaultLocale();
		}

		List<Locale.LanguageRange> list = Locale.LanguageRange.parse(acceptLanguageHeader);
		Locale locale = Locale.lookup(list, SUPPORTED_LOCALES);

		return locale != null ? locale : getDefaultLocale();
	}
}
