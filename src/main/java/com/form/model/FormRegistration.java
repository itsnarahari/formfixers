package com.form.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class FormRegistration {
	
	private int id;
	private String name;
	private String email_or_mobile;

}
