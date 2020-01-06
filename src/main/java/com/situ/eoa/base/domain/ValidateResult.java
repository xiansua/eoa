package com.situ.eoa.base.domain;

import java.io.Serializable;

public class ValidateResult implements Serializable {
	private static final long serialVersionUID = 1L;
	private String validate;
	private Boolean result;

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}
}
