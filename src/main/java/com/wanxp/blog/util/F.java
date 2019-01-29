package com.wanxp.blog.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 */
public final class F {
	public static boolean empty(String value) {
		return value == null || value.trim().length() == 0;
	}
	public static boolean empty(Integer value) {
		return value == null || value == 0;
	}
	public static boolean empty(Long value) {
		return value == null || value == 0;
	}
	
	public static boolean empty(Boolean value) {
		return value == null;
	}
	
	
	public static String cs(Object value) {
		return cv(value, String.class);
	}

	@SuppressWarnings("unchecked")
	public static <T> T cv(Object value, Class<T> requiredType) {
		if (value == null) {
			return null;
		}
		if (requiredType.isInstance(value)) {
			return (T) value;
		}
		if (String.class.equals(requiredType)) {
			return (T) value.toString();
		} else if (isNumberType(requiredType)) {
			if (value instanceof Number) {
				return (T) convertNumberToTargetClass(((Number) value), (Class<Number>) requiredType);
			} else if (isNumber(value.toString())) {
				return (T) NU.parseNumber(value.toString(), (Class<Number>) requiredType);
			} else {
				return null;
			}
		} else if (Date.class.isAssignableFrom(requiredType)) {
			String dv = value.toString();
			if (dv.length() == 0) {
				return null;
			}
			try {
				if (dv.length() == 10) {
					SimpleDateFormat df1 = (SimpleDateFormat) Constants.df1.clone();
					return (T) df1.parse(dv);
				} else if (dv.length() == 16) {
					SimpleDateFormat df2 = (SimpleDateFormat) Constants.df2.clone();
					return (T) df2.parse(dv);
				} else if (dv.length() == 19) {
					SimpleDateFormat df3 = (SimpleDateFormat) Constants.df3.clone();
					return (T) df3.parse(dv);
				}
			} catch (ParseException e) {
				throw new IllegalArgumentException("解析日期异常：" + dv);
			}
			return null;
		} else {
			throw new IllegalArgumentException("Value [" + value + "] is of type [" + value.getClass().getName() + "] and cannot be converted to required type [" + requiredType.getName() + "]");
		}
	}

	private static boolean isNumberType(Class<?> clazz) {
		if (Number.class.isAssignableFrom(clazz)) {
			return true;
		}
		if (int.class.equals(clazz) || long.class.equals(clazz) || double.class.equals(clazz) || float.class.equals(clazz)) {
			return true;
		}
		return false;
	}

	/**
	 * 根据两点经纬度计算距离
	 * 
	 * @param lng1
	 * @param lat1
	 * @param lng2
	 * @param lat2
	 * @return
	 */
	public static double distance(double lng1, double lat1, double lng2, double lat2) {
		// return qc(x1 - x2) + qc(y1 - y2);
		double radLat1 = lat1 * Math.PI / 180;
		double radLat2 = lat2 * Math.PI / 180;
		double a = radLat1 - radLat2;
		double b = lng1 * Math.PI / 180 - lng2 * Math.PI / 180;
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * 6378137.0;// 取WGS84标准参考椭球中的地球长半径(单位:m)
		s = Math.round(s * 10000) / 10000;
		return s;
	}

	// ================================================
	@SuppressWarnings("unchecked")
	public static <T extends Number> T convertNumberToTargetClass(Number number, Class<T> targetClass) throws IllegalArgumentException {

		if (targetClass.isInstance(number)) {
			return (T) number;
		} else if (targetClass.equals(Byte.class)) {
			long value = number.longValue();
			if (value < Byte.MIN_VALUE || value > Byte.MAX_VALUE) {
				raiseOverflowException(number, targetClass);
			}
			return (T) new Byte(number.byteValue());
		} else if (targetClass.equals(Short.class)) {
			long value = number.longValue();
			if (value < Short.MIN_VALUE || value > Short.MAX_VALUE) {
				raiseOverflowException(number, targetClass);
			}
			return (T) new Short(number.shortValue());
		} else if (targetClass.equals(Integer.class)) {
			long value = number.longValue();
			if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
				raiseOverflowException(number, targetClass);
			}
			return (T) new Integer(number.intValue());
		} else if (targetClass.equals(Long.class)) {
			return (T) new Long(number.longValue());
		} else if (targetClass.equals(BigInteger.class)) {
			if (number instanceof BigDecimal) {
				// do not lose precision - use BigDecimal's own conversion
				return (T) ((BigDecimal) number).toBigInteger();
			} else {
				// original value is not a Big* number - use standard long conversion
				return (T) BigInteger.valueOf(number.longValue());
			}
		} else if (targetClass.equals(Float.class)) {
			return (T) new Float(number.floatValue());
		} else if (targetClass.equals(Double.class)) {
			return (T) new Double(number.doubleValue());
		} else if (targetClass.equals(BigDecimal.class)) {
			// always use BigDecimal(String) here to avoid unpredictability of BigDecimal(double)
			// (see BigDecimal javadoc for details)
			return (T) new BigDecimal(number.toString());
		} else {
			throw new IllegalArgumentException("Could not convert number [" + number + "] of type [" + number.getClass().getName() + "] to unknown target class [" + targetClass.getName() + "]");
		}
	}

	/**
	 * Raise an overflow exception for the given number and target class.
	 * 
	 * @param number the number we tried to convert
	 * @param targetClass the target class we tried to convert to
	 */
	private static void raiseOverflowException(Number number, Class<?> targetClass) {
		throw new IllegalArgumentException("Could not convert number [" + number + "] of type [" + number.getClass().getName() + "] to target class [" + targetClass.getName() + "]: overflow");
	}

	/**
	 * <p>
	 * Checks whether the String a valid Java number.
	 * </p>
	 * 
	 * <p>
	 * Valid numbers include hexadecimal marked with the <code>0x</code> qualifier, scientific notation and numbers
	 * marked with a type qualifier (e.g. 123L).
	 * </p>
	 * 
	 * <p>
	 * <code>Null</code> and empty String will return <code>false</code>.
	 * </p>
	 * 
	 * @param str the <code>String</code> to check
	 * @return <code>true</code> if the string is a correctly formatted number
	 */
	public static boolean isNumber(String str) {
		if (empty(str)) {
			return false;
		}
		char[] chars = str.toCharArray();
		int sz = chars.length;
		boolean hasExp = false;
		boolean hasDecPoint = false;
		boolean allowSigns = false;
		boolean foundDigit = false;
		// deal with any possible sign up front
		int start = (chars[0] == '-') ? 1 : 0;
		if (sz > start + 1) {
			if (chars[start] == '0' && chars[start + 1] == 'x') {
				int i = start + 2;
				if (i == sz) {
					return false; // str == "0x"
				}
				// checking hex (it can't be anything else)
				for (; i < chars.length; i++) {
					if ((chars[i] < '0' || chars[i] > '9') && (chars[i] < 'a' || chars[i] > 'f') && (chars[i] < 'A' || chars[i] > 'F')) {
						return false;
					}
				}
				return true;
			}
		}
		sz--; // don't want to loop to the last char, check it afterwords
				// for type qualifiers
		int i = start;
		// loop to the next to last char or to the last char if we need another digit to
		// make a valid number (e.g. chars[0..5] = "1234E")
		while (i < sz || (i < sz + 1 && allowSigns && !foundDigit)) {
			if (chars[i] >= '0' && chars[i] <= '9') {
				foundDigit = true;
				allowSigns = false;

			} else if (chars[i] == '.') {
				if (hasDecPoint || hasExp) {
					// two decimal points or dec in exponent
					return false;
				}
				hasDecPoint = true;
			} else if (chars[i] == 'e' || chars[i] == 'E') {
				// we've already taken care of hex.
				if (hasExp) {
					// two E's
					return false;
				}
				if (!foundDigit) {
					return false;
				}
				hasExp = true;
				allowSigns = true;
			} else if (chars[i] == '+' || chars[i] == '-') {
				if (!allowSigns) {
					return false;
				}
				allowSigns = false;
				foundDigit = false; // we need a digit after the E
			} else {
				return false;
			}
			i++;
		}
		if (i < chars.length) {
			if (chars[i] >= '0' && chars[i] <= '9') {
				// no type qualifier, OK
				return true;
			}
			if (chars[i] == 'e' || chars[i] == 'E') {
				// can't have an E at the last byte
				return false;
			}
			if (chars[i] == '.') {
				if (hasDecPoint || hasExp) {
					// two decimal points or dec in exponent
					return false;
				}
				// single trailing decimal point after non-exponent is ok
				return foundDigit;
			}
			if (!allowSigns && (chars[i] == 'd' || chars[i] == 'D' || chars[i] == 'f' || chars[i] == 'F')) {
				return foundDigit;
			}
			if (chars[i] == 'l' || chars[i] == 'L') {
				// not allowing L with an exponent
				return foundDigit && !hasExp;
			}
			// last character is illegal
			return false;
		}
		// allowSigns is true iff the val ends in 'E'
		// found digit it to make sure weird stuff like '.' and '1E-' doesn't pass
		return !allowSigns && foundDigit;
	}
	//首字母转小写
	public static String toLowerCaseFirst(String s) {
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder())
					.append(Character.toLowerCase(s.charAt(0)))
					.append(s.substring(1)).toString();
	}

	// 首字母转大写
	public static String toUpperCaseFirst(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder())
					.append(Character.toUpperCase(s.charAt(0)))
					.append(s.substring(1)).toString();
	}
	
	public static String join(Object[] set, String segs) {
		if (set == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (Object item : set) {
			sb.append(segs).append(item);
		}
		if (sb.length() > 0) {
			return sb.substring(segs.length());
		} else {
			return sb.toString();
		}
	}
}
