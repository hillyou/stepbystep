/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.mybatis.util;

import java.util.Properties;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.constructs.CacheDecoratorFactory;

/**
 *
 * @author colin.you
 */
public class EhcacheDecorator extends CacheDecoratorFactory {

    @Override
    public Ehcache createDecoratedEhcache(Ehcache ehch, Properties prprts) {
        return createDefaultDecoratedEhcache(ehch,prprts);
    }

    @Override
    public Ehcache createDefaultDecoratedEhcache(Ehcache ehch, Properties prprts) {
//        BlockingCache newBlockingCache = new BlockingCache(ehch);
//        return newBlockingCache.getCacheManager().getEhcache(DASH);
        return ehch;
    }

}
