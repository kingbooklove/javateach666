package com.ctbu.javateach666.util;

import java.util.Collection;


/**
 * 集合操作工具类
 *
 * @author Direct
 */
public class CollectionUtils {
    /**
     * 判断一个Collection集合不能为空
     *
     * @param collection 传人collection类型参数
     * @return boolean 返回判断结果
     */
    public static boolean isNotBlank(Collection<?> collection) {
        return collection != null && collection.size() > 0;
    }

}
