package com.greencloud.website.util;

import java.io.Serializable;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author Internet
 *
 */
public class EhcacheUtil {  
 
        final static Log log = LogFactory.getLog(EhcacheUtil.class);    
        private static final String appointPath="ehcache.xml";  
        private CacheManager cacheManager;  
        private static EhcacheUtil ehcacheUtil;  
 
        private EhcacheUtil(String appointPath){  
            cacheManager=CacheManager.create(this.getClass().getClassLoader().getResource(appointPath));
        }  
 
       public static EhcacheUtil getInstance(){  
           if(ehcacheUtil==null){  
               ehcacheUtil=new EhcacheUtil(appointPath);  
           }  
           return ehcacheUtil;  
       }  
 
        /**  
         * 从缓存中获取对象  
         * @param cache_name  
         * @param key  
         * @return  
         */    
        public Serializable getObjectCached(String cache_name, Serializable key){    
            Cache cache = getCache(cache_name);    
            if(cache!=null){    
                try {    
                    Element elem = cache.get(key);    
                    if(elem!=null && !cache.isExpired(elem))    
                        return elem.getValue();    
                } catch (Exception e) {    
                    log.error("Get cache("+cache_name+") of "+key+" failed.", e);    
                }    
            }    
            return null;    
        }    
 
        /**  
         * 把对象放入缓存中  
         * @param cache_name  
         * @param key  
         * @param value  
         */    
        public synchronized void put(String cache_name, Object key, Object value){    
            Cache cache = getCache(cache_name);    
            if(cache==null){  
                /** 
                 * 2:允许内存中缓存对象的大小，这里是10000000 
                 * 3：允许在内存达到最大后写入磁盘 
                 * 4：表示永久保存 
                 * 5：最后两个参数表示element存活时间无穷大 
                 */  
                cache= new Cache(cache_name, 1000000, true, true, 0, 0);  
                cacheManager.addCache(cache);  
            }else{  
                try {    
                    cache.remove(key);    
                    Element elem = new Element(key, value);    
                    cache.put(elem);    
                } catch (Exception e) {    
                    log.error("put cache("+cache_name+") of "+key+" failed.", e);    
                }    
            }    
        }    
 
        /**  
         * 获取指定名称的缓存  
         * @param arg0  
         * @return  
         * @throws IllegalStateException  
         */    
        public Cache getCache(String arg0) throws IllegalStateException {    
            return cacheManager.getCache(arg0);    
        }    
 
        /**  
         * 获取缓冲中的信息  
         * @param cache  
         * @param key  
         * @return  
         * @throws IllegalStateException  
         * @throws CacheException  
         */    
        public Element getElement(String cache, Object key){    
            Cache cCache = getCache(cache);    
            return cCache.get(key);    
        }    
 
 
        public void removeElement(String cacheName, Object key) {    
            Cache cache = cacheManager.getCache(cacheName);    
            if (cache != null) {    
                cache.remove(key);    
            }    
        }  
 
        public void removeCache(String cacheName) {    
            Cache cache = cacheManager.getCache(cacheName);    
            if (cache != null) {    
                cacheManager.removeCache(cacheName);  
            }    
        }  
 
 
        /**  
         * 停止缓存管理器  
         */    
        public void shutdown(){    
            if(cacheManager!=null)    
                cacheManager.shutdown();    
        }    
 
 
        public static void main(String[] args) {  
            System.out.println(EhcacheUtil.getInstance().getCache("testCache"));  
        }  
}