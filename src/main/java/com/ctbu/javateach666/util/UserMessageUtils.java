package com.ctbu.javateach666.util;

import java.util.Collection;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * 集合操作工具类
 *
 * @author Direct
 */
public class UserMessageUtils {
    
	
	/**
	 * 获取当前用户的id
	 * @return
	 */
    public static Integer getNowUserId() {
    	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(userDetails.getUsername());
    	return null;
    }

}
