package es.begeek.cache;

import java.lang.reflect.Method;

import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.TriggersRemove;
import com.googlecode.ehcache.annotations.resolver.CacheResolverFactory;
import com.googlecode.ehcache.annotations.resolver.CacheableCacheResolver;
import com.googlecode.ehcache.annotations.resolver.TriggersRemoveCacheResolver;

public class CustomCacheResolver implements CacheResolverFactory {

	public CacheableCacheResolver getCacheResolver(Cacheable name, Method methos) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public TriggersRemoveCacheResolver getCacheResolver(TriggersRemove triggerRemove, Method method) {
		// TODO Auto-generated method stub
		return null;
	}

}
