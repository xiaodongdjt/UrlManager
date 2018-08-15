package com.offcn.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

public class ResourceUtil {

	public static List getResourceKeyList(String filename){
		List list=new ArrayList();
		
		ResourceBundle rb = ResourceBundle.getBundle(filename);
		
		Enumeration<String> keys = rb.getKeys();
		while(keys.hasMoreElements()){
			String key=keys.nextElement();
			list.add(key);
		}
		return list;
	}
}
