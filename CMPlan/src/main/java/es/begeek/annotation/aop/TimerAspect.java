package es.begeek.annotation.aop;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component @Aspect
public class TimerAspect extends CommonAspect{
	
	private double time_elapsed;

	@Around("@annotation(es.begeek.annotation.Timer)")
    public Object timer(ProceedingJoinPoint call) throws Throwable {
		Method method = super.getCallMethod(call);
		this.time_elapsed = (double)System.currentTimeMillis();
		Object result_method;
		try{
			result_method = call.proceed();
		}finally{
			this.time_elapsed = ((double)System.currentTimeMillis()-this.time_elapsed)/1000.0;
			Logger.getLogger(call.getTarget().getClass().getName()).info("<- "+ method.getName() +"( TIME_ELAPSED := "+ this.time_elapsed +" )");
		}
		return result_method;
    }
}
