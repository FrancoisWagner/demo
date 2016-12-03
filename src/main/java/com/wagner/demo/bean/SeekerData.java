package com.wagner.demo.bean;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class SeekerData {
	private List<Integer> arrayA;
	private List<Integer> arrayB;
	private Long executionTime;
	private Set<Integer> resultSet;
	private Long executionTimeNaiveMethod;
	private Set<Integer> resultSetNaiveMethod;

	public List<Integer> getArrayA() {
		return arrayA;
	}

	public void setArrayA(List<Integer> arrayA) {
		this.arrayA = arrayA;
	}

	public List<Integer> getArrayB() {
		return arrayB;
	}

	public void setArrayB(List<Integer> arrayB) {
		this.arrayB = arrayB;
	}

	public Long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Long executionTime) {
		this.executionTime = executionTime;
	}

	public Set<Integer> getResultSet() {
		return resultSet;
	}

	public void setResultSet(Set<Integer> resultSet) {
		this.resultSet = resultSet;
	}

	public Long getExecutionTimeNaiveMethod() {
		return executionTimeNaiveMethod;
	}

	public void setExecutionTimeNaiveMethod(Long executionTimeNaiveMethod) {
		this.executionTimeNaiveMethod = executionTimeNaiveMethod;
	}

	public Set<Integer> getResultSetNaiveMethod() {
		return resultSetNaiveMethod;
	}

	public void setResultSetNaiveMethod(Set<Integer> resultSetNaiveMethod) {
		this.resultSetNaiveMethod = resultSetNaiveMethod;
	}
}
