package com.wagner.demo.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

@Component
public class SeekerConfig {
	@NotNull
	@Range(min = 1, max = 100000, message = "The size must be between {2} and {1}.")
	private Integer arrayASize;
	@NotNull
	@Range(min = 1, max = 100000, message = "The size must be between {2} and {1}.")
	private Integer arrayBSize;
	@NotNull
	private Boolean arrayAIntoHashSet;

	public SeekerConfig() {

	}

	public SeekerConfig(int arrayASize, int arrayBSize, boolean arrayAIntoHashSet) {
		this.arrayASize = arrayASize;
		this.arrayBSize = arrayBSize;
		this.arrayAIntoHashSet = arrayAIntoHashSet;
	}

	public Integer getArrayASize() {
		return arrayASize;
	}

	public void setArrayASize(Integer arrayASize) {
		this.arrayASize = arrayASize;
	}

	public Integer getArrayBSize() {
		return arrayBSize;
	}

	public void setArrayBSize(Integer arrayBSize) {
		this.arrayBSize = arrayBSize;
	}

	public Boolean getArrayAIntoHashSet() {
		return arrayAIntoHashSet;
	}

	public void setArrayAIntoHashSet(Boolean arrayAIntoHashSet) {
		this.arrayAIntoHashSet = arrayAIntoHashSet;
	}

	@Override
	public String toString() {
		return "SeekerConfig [arrayASize=" + arrayASize + ", arrayBSize=" + arrayBSize + ", arrayAIntoHashSet="
				+ arrayAIntoHashSet + "]";
	}
}
