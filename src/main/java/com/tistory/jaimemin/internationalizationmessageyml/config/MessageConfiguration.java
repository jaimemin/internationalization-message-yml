package com.tistory.jaimemin.internationalizationmessageyml.config;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import dev.akkinoc.util.YamlResourceBundle;

/**
 * 참고: https://github.com/ttasjwi/trilo-be/blob/258463cdf208cfd28d47af242e2695dd5ef5db42/src/main/resources/exceptions/exception_en.yml
 */
@Configuration
public class MessageConfiguration {

	@Bean
	public MessageSource messageSource() {
		YamlMessageSource messageSource = new YamlMessageSource();
		messageSource.setBasename("resource"); // 메시지를 찾을 위치
		messageSource.setDefaultEncoding("UTF-8"); // 인코딩
		messageSource.setAlwaysUseMessageFormat(true); // 메시지 포맷 규칙 사용
		messageSource.setUseCodeAsDefaultMessage(true); // 메시지를 못 찾으면 코드 그 자체를 디폴트 메시지로 사용
		messageSource.setFallbackToSystemLocale(true); // 특정 로케일에 대한 파일을 발견하지 못 할 경우, 시스템 로케일로 폴백(resource.yml)

		return messageSource;
	}

	private static class YamlMessageSource extends ResourceBundleMessageSource {

		@NotNull
		@Override
		protected ResourceBundle doGetBundle(@NotNull String basename, @NotNull Locale locale) throws
			MissingResourceException {
			return ResourceBundle.getBundle(basename, locale, YamlResourceBundle.Control.INSTANCE);
		}
	}
}
