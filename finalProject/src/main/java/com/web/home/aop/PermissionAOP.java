package com.web.home.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.stereotype.Component;

import com.web.home.account.model.AccountDTO;
import com.web.home.aop.annotation.Perm;
import com.web.home.member.model.PermissionDTO;
import com.web.home.member.service.PermissionService;


@Component
@EnableAspectJAutoProxy
@Aspect 
public class PermissionAOP {
	private static Logger logger = LoggerFactory.getLogger(PermissionAOP.class);
	
	@Autowired
	PermissionService service;
	
	
	@Before("@annotation(com.web.home.aop.annotation.Perm)")  
	public void getPerm(JoinPoint jp) throws Exception {
		
		MethodSignature mSignature = (MethodSignature) jp.getSignature();
		
		Method method = mSignature.getMethod();
		
		
		Perm perm = method.getAnnotation(Perm.class); 
		String table = perm.table(); 
		String crud = perm.crud();
		System.out.println("table : " + table);
		System.out.println("crud : " + crud);
		//권한 체크 작업
		this.checkPerm(jp, table, crud);

		
	}

	public void checkPerm(JoinPoint jp, String table, String crud) throws Exception{ 
		HttpSession session = this.getSession(jp);
		AccountDTO data = (AccountDTO)session.getAttribute("account"); 
		PermissionDTO perm = new PermissionDTO(); 
		perm.setAid(data.getA_id());
		perm.setTName(table); //해당 테이블 이름도 받을것
		String msg = "";
		switch(crud){
			case "select" : msg = "조회"; break;				
			case "insert" : msg = "등록"; break;
			case "update" : msg = "업데이트"; break;
			case "delete" : msg = "삭제";
		}

		if(!service.existedPerm(perm, crud)) {
			throw new PermissionDeniedDataAccessException(data.getA_uid() + "계정에는" + table + msg + " 권한이 없습니다.", null);
		}
	}
	
	private HttpSession getSession(JoinPoint jp) {
		HttpSession session = null;
		for(Object arg: jp.getArgs()) {

			if(arg instanceof HttpSession) { 
				session = (HttpSession)arg; 
			}
		}
		return session;
	}
	
	@Pointcut(value="execution(* com.web.home..*Service.select*(..))") 
	private void selectPermCut() {
		
	}
	@Pointcut(value="execution(* com.web.home..*Service.insert*(..))") 
	private void insertPermCut() {
		
	}
	@Pointcut(value="execution(* com.web.home..*Service.update*(..))") 
	private void updatePermCut() {
		
	}
	@Pointcut(value="execution(* com.web.home..*Service.delete*(..))") 
	private void deletePermCut() {
		
	}
	
	
}
