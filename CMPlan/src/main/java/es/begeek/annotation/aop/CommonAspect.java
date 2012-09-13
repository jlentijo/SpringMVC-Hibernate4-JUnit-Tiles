package es.begeek.annotation.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class CommonAspect {

	@SuppressWarnings({ "unchecked", "rawtypes" })  
    protected Method getCallMethod(ProceedingJoinPoint call){  
        Method metodo =  null;  
        try {  
			Signature sig = call.getSignature();  
			Class clase = sig.getDeclaringType();  
			String methodName = sig.getName();  
			Object[] args = call.getArgs();  
			Class[] params = new Class[args.length];  
			for (int i = 0, count = args.length; i < count; i++){
            	params[i] = args[i].getClass();
			}
			metodo   = clase.getMethod(methodName, params);  
        } catch (Exception e) {  
        	// Ignoramos: SecurityException, NoSuchMethodException  
        }
        return metodo;  
    }
	
}
