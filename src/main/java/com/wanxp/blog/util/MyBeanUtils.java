package com.wanxp.blog.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class MyBeanUtils extends BeanUtils {

  public static void copyProperties(Object source, Object target, boolean isNull)
		    throws BeansException
  {
    copyProperties(source, target, null, null,null, isNull);
  }

  public static void copyProperties(Object source, Object target, Class<?> editable, boolean isNull)
    throws BeansException
  {
    copyProperties(source, target, editable, null,null, isNull);
  }

  public static void copyProperties(Object source, Object target, String[] ignoreProperties, boolean isNull)
    throws BeansException
  {
    copyProperties(source, target, null, ignoreProperties,null, isNull);
  }
  public static void copyProperties(Object source, Object target, String[] ignoreProperties, String[] markProperties, boolean isNull)
		  throws BeansException
  {
	  copyProperties(source, target, null, ignoreProperties,markProperties, isNull);
  }
  
  /**
   * 
   * @param source
   * @param target
   * @param editable
   * @param ignoreProperties 忽略的属性
   * @param markProperties 不忽略的属性
   * @param isNull isNull=true：表示字段为null时不进行copy,false反之
   * @throws BeansException
   */
  private static void copyProperties(Object source, Object target, Class<?> editable, 
		  String[] ignoreProperties, String[] markProperties, boolean isNull)
		    throws BeansException
		  {
		    Assert.notNull(source, "Source must not be null");
		    Assert.notNull(target, "Target must not be null");

		    Class actualEditable = target.getClass();
		    if (editable != null) {
		      if (!editable.isInstance(target)) {
		        throw new IllegalArgumentException("Target class [" + target.getClass().getName() + "] not assignable to Editable class [" + editable.getName() + "]");
		      }

		      actualEditable = editable;
		    }
		    PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
		    List ignoreList = ignoreProperties != null ? Arrays.asList(ignoreProperties) : null;
		    List markList = markProperties != null ? Arrays.asList(markProperties) : null;

		    for (PropertyDescriptor targetPd : targetPds)
		      if ((targetPd.getWriteMethod() != null) && ((ignoreProperties == null) || (!ignoreList.contains(targetPd.getName())))
		    		  && ((markProperties == null) || (markList.contains(targetPd.getName()))))
		      {
		        PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
		        if ((sourcePd != null) && (sourcePd.getReadMethod() != null))
		          try {
		            Method readMethod = sourcePd.getReadMethod();
		            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
		              readMethod.setAccessible(true);
		            }
		            Object value = readMethod.invoke(source, new Object[0]);
		            if(!isNull || (isNull && value != null) ) {
			            Method writeMethod = targetPd.getWriteMethod();
			            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
			              writeMethod.setAccessible(true);
			            }
			            writeMethod.invoke(target, new Object[] { value });
		            }
		           
		          }
		          catch (Throwable ex) {
		            throw new FatalBeanException("Could not copy properties from source to target", ex);
		          }
		      }
		  }
}