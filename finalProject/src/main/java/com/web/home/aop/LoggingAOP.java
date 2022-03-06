package com.web.home.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component 
@Aspect //aop 
public class LoggingAOP { 
	private static Logger logger = LoggerFactory.getLogger(LoggingAOP.class);
	
	@Pointcut(value="execution(* com.web.home..*Controller.*(..) )") 
	private void controllerLoggingCut() {
		
	}
	@Pointcut(value="execution(* com.web.home..*.Service.*(..) )") 
	private void serviceLoggingCut() {
		
	}
	@Pointcut(value="execution(* com.web.home..*.DAO.*(..) )") 
	private void daoLoggingCut() {
		
	}
	
	private String getJoinPointName(JoinPoint jp) { 
		String pkgName = jp.getThis().getClass().getPackage().getName();
		String clsName = jp.getThis().getClass().getSimpleName().split("\\$\\$")[0];
		return pkgName + "." + clsName; //패키지이름 클래스이름
	}

	private String getStringParameters(JoinPoint jp) { //문자열 추출, 생성
		StringBuilder sb = new StringBuilder();
		MethodSignature method = (MethodSignature) jp.getSignature(); 
		
		for(int i = 0; i < jp.getArgs().length; i++) {
			String[] typNames = method.getParameterTypes()[i].getTypeName().split("\\.");
			sb.append(typNames[typNames.length - 1] + " ");
			sb.append(method.getParameterNames()[i] + ": ");
			sb.append(jp.getArgs()[i]);
			
			if(i + 1 != jp.getArgs().length) {
				sb.append(", ");
			}
		}
		
		return sb.toString();
	}
	@Before("controllerLoggingCut() || serviceLoggingCut() || daoLoggingCut()") 
	public void loggingBefore(JoinPoint jp) {
		String mthName = jp.getSignature().getName(); 
		this.printLog(jp, mthName, "Before");
		
	}
	@After("controllerLoggingCut() || serviceLoggingCut() || daoLoggingCut()")
	public void loggingAfter(JoinPoint jp) {
		String mthName = jp.getSignature().getName();
		this.printLog(jp, mthName, "After");
	}
	
	public void printLog(JoinPoint jp, String mthName, String advPoint) {
	
		logger = LoggerFactory.getLogger(this.getJoinPointName(jp)); 
		logger.debug("@" + advPoint + " " + mthName + "(" + this.getStringParameters(jp) + ")");		
		
	}

}
