package com.ikamobile.ikasoa.core.cache;

import org.junit.Test;
import com.ikamobile.ikasoa.core.cache.impl.FIFOCacheImpl;
import com.ikamobile.ikasoa.core.cache.impl.LFUCacheImpl;
import com.ikamobile.ikasoa.core.cache.impl.LRUCacheImpl;

import junit.framework.TestCase;

/**
 * 缓存单元测试
 */
public class CacheTest extends TestCase {

	/**
	 * FIFO缓存测试
	 */
	@Test
	public void testFIFOCacheImpl() {
		Cache<String, String> cache = new FIFOCacheImpl<String, String>(2, 0);
		cache.put("1", "一");
		cache.put("2", "二");
		cache.put("3", "三");
		assertNull(cache.get("1"));
	}

	/**
	 * LFU缓存测试
	 */
	@Test
	public void testLFUCacheImpl() {
		Cache<String, String> cache = new LFUCacheImpl<String, String>(2, 0);
		cache.put("1", "一");
		cache.get("1");
		cache.get("1");
		cache.put("2", "二");
		cache.get("1");
		cache.get("2");
		cache.get("2");
		cache.put("3", "三");
		assertNull(cache.get("2"));
	}

	/**
	 * LRU缓存测试
	 */
	@Test
	public void testLRUCacheImpl() {
		Cache<String, String> cache = new LRUCacheImpl<String, String>(3, 0);
		cache.put("1", "一");
		cache.get("1");
		cache.get("1");
		cache.put("2", "二");
		cache.get("1");
		cache.get("2");
		cache.put("3", "三");
		cache.get("3");
		cache.get("3");
		cache.put("4", "四");
		assertNull(cache.get("1"));
	}

}
