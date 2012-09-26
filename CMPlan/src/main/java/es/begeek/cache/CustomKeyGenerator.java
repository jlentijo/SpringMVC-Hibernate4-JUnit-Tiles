package es.begeek.cache;

import java.io.Serializable;

import org.aopalliance.intercept.MethodInvocation;

import com.googlecode.ehcache.annotations.key.CacheKeyGenerator;

import es.begeek.view.UserView;

public class CustomKeyGenerator implements CacheKeyGenerator<Serializable> {

	@Override
	public Serializable generateKey(MethodInvocation method) {
		String key = method.getMethod().getName()+"_UserLogged_"+UserView.ID_USER_LOGGED; 
		return key.hashCode();
	}

	@Override
	public Serializable generateKey(Object... arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
