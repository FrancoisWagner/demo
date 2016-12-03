package com.wagner.demo.bean;

import java.util.List;
import java.util.Set;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimer {
	/*
	 * Profile the time elapsed when we are using the HashSet
	 */
	@Pointcut("execution(* com.wagner.demo.service.SeekerService.findIntersection(java.util.Set, java.util.List, SeekerData)) && args(set, list, seekerData)")
	public void findIntersection(Set<Integer> set, List<Integer> list, SeekerData seekerData) {
	}

	@Around("findIntersection(set, list, seekerData)")
	public Object profile(ProceedingJoinPoint pjp, Set<Integer> set, List<Integer> list, SeekerData seekerData)
			throws Throwable {
		long start = System.currentTimeMillis();
		Object output = pjp.proceed();
		long elapsedTime = System.currentTimeMillis() - start;
		seekerData.setExecutionTime(elapsedTime);
		return output;
	}

	/*
	 * Profile the time elapsed when we are using the "Naive" method
	 */
	@Pointcut("execution(* com.wagner.demo.service.SeekerService.findIntersectionNaiveMethod(SeekerData)) && args(seekerData)")
	public void findIntersectionNaiveMethod(SeekerData seekerData) {
	}

	@Around("findIntersectionNaiveMethod(seekerData)")
	public Object profile(ProceedingJoinPoint pjp, SeekerData seekerData) throws Throwable {
		long start = System.currentTimeMillis();
		Object output = pjp.proceed();
		long elapsedTime = System.currentTimeMillis() - start;
		seekerData.setExecutionTimeNaiveMethod(elapsedTime);
		return output;
	}
}
