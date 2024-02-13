package com.tistory.jaimemin.internationalizationmessageyml.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ApiController {

	private final MessageSource messageSource;

	/**
	 * map의 value를 받아오기
	 */
	@GetMapping("/fruits")
	public List<String> getFruits() {
		log.info("{}", LocaleContextHolder.getLocale());

		return Collections.unmodifiableList(Arrays.asList(
			getMessage("fruits.apple"),
			getMessage("fruits.orange"),
			getMessage("fruits.grape")
		));
	}

	/**
	 * list 형식으로 받아오기
	 */
	@GetMapping("/colors")
	public List<String> getColors() {
		return Collections.unmodifiableList(Arrays.asList(
			getMessage("colors[0]"),
			getMessage("colors[1]"),
			getMessage("colors[2]")
		));
	}

	private String getMessage(String code) {
		return getMessage(code, null);
	}

	private String getMessage(String code, Object[] args) {
		return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
	}
}
