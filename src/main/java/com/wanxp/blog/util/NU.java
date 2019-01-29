package com.wanxp.blog.util;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * <pre>
 *   Title: NumberUtils.java
 *   Description: 
 *   Project:智能地址归集系统
 *   Copyright: yundaex.com Copyright (c) 2013
 *   Company: 上海韵达货运有限公司
 * </pre>
 * 
 * @author LuZQ
 * @version 3.0
 * @date 2014年5月23日
 */
public class NU {
	/**
	 * Parse the given text into a number instance of the given target class,
	 * using the corresponding {@code decode} / {@code valueOf} methods.
	 * <p>Trims the input {@code String} before attempting to parse the number.
	 * Supports numbers in hex format (with leading "0x", "0X" or "#") as well.
	 * @param text the text to convert
	 * @param targetClass the target class to parse into
	 * @return the parsed number
	 * @throws IllegalArgumentException if the target class is not supported
	 * (i.e. not a standard Number subclass as included in the JDK)
	 * @see Byte#decode
	 * @see Short#decode
	 * @see Integer#decode
	 * @see Long#decode
	 * @see #decodeBigInteger(String)
	 * @see Float#valueOf
	 * @see Double#valueOf
	 * @see BigDecimal#BigDecimal(String)
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Number> T parseNumber(String text, Class<T> targetClass) {
		String trimmed = trimAllWhitespace(text);

		if (targetClass.equals(Byte.class)) {
			return (T) (isHexNumber(trimmed) ? Byte.decode(trimmed) : Byte.valueOf(trimmed));
		}
		else if (targetClass.equals(Short.class)) {
			return (T) (isHexNumber(trimmed) ? Short.decode(trimmed) : Short.valueOf(trimmed));
		}
		else if (targetClass.equals(Integer.class)) {
			return (T) (isHexNumber(trimmed) ? Integer.decode(trimmed) : Integer.valueOf(trimmed));
		}
		else if (targetClass.equals(Long.class)) {
			return (T) (isHexNumber(trimmed) ? Long.decode(trimmed) : Long.valueOf(trimmed));
		}
		else if (targetClass.equals(BigInteger.class)) {
			return (T) (isHexNumber(trimmed) ? decodeBigInteger(trimmed) : new BigInteger(trimmed));
		}
		else if (targetClass.equals(Float.class)) {
			return (T) Float.valueOf(trimmed);
		}
		else if (targetClass.equals(Double.class)) {
			return (T) Double.valueOf(trimmed);
		}
		else if (targetClass.equals(BigDecimal.class) || targetClass.equals(Number.class)) {
			return (T) new BigDecimal(trimmed);
		}
		else {
			throw new IllegalArgumentException(
					"Cannot convert String [" + text + "] to target class [" + targetClass.getName() + "]");
		}
	}

	/**
	 * Determine whether the given value String indicates a hex number, i.e. needs to be
	 * passed into {@code Integer.decode} instead of {@code Integer.valueOf} (etc).
	 */
	private static boolean isHexNumber(String value) {
		int index = (value.startsWith("-") ? 1 : 0);
		return (value.startsWith("0x", index) || value.startsWith("0X", index) || value.startsWith("#", index));
	}

	/**
	 * Decode a {@link BigInteger} from a {@link String} value.
	 * Supports decimal, hex and octal notation.
	 * @see BigInteger#BigInteger(String, int)
	 */
	private static BigInteger decodeBigInteger(String value) {
		int radix = 10;
		int index = 0;
		boolean negative = false;

		// Handle minus sign, if present.
		if (value.startsWith("-")) {
			negative = true;
			index++;
		}

		// Handle radix specifier, if present.
		if (value.startsWith("0x", index) || value.startsWith("0X", index)) {
			index += 2;
			radix = 16;
		}
		else if (value.startsWith("#", index)) {
			index++;
			radix = 16;
		}
		else if (value.startsWith("0", index) && value.length() > 1 + index) {
			index++;
			radix = 8;
		}

		BigInteger result = new BigInteger(value.substring(index), radix);
		return (negative ? result.negate() : result);
	}

	/**
	 * Trim <i>all</i> whitespace from the given String:
	 * leading, trailing, and inbetween characters.
	 * @param str the String to check
	 * @return the trimmed String
	 * @see Character#isWhitespace
	 */
	public static String trimAllWhitespace(String str) {
		if (!hasLength(str)) {
			return str;
		}
		StringBuilder sb = new StringBuilder(str);
		int index = 0;
		while (sb.length() > index) {
			if (Character.isWhitespace(sb.charAt(index))) {
				sb.deleteCharAt(index);
			}
			else {
				index++;
			}
		}
		return sb.toString();
	}
	
	/**
	 * Check that the given CharSequence is neither {@code null} nor of length 0.
	 * Note: Will return {@code true} for a CharSequence that purely consists of whitespace.
	 * <p><pre>
	 * StringUtils.hasLength(null) = false
	 * StringUtils.hasLength("") = false
	 * StringUtils.hasLength(" ") = true
	 * StringUtils.hasLength("Hello") = true
	 * </pre>
	 * @param str the CharSequence to check (may be {@code null})
	 * @return {@code true} if the CharSequence is not null and has length
	 * @see #hasText(String)
	 */
	public static boolean hasLength(CharSequence str) {
		return (str != null && str.length() > 0);
	}

	/**
	 * Check that the given String is neither {@code null} nor of length 0.
	 * Note: Will return {@code true} for a String that purely consists of whitespace.
	 * @param str the String to check (may be {@code null})
	 * @return {@code true} if the String is not null and has length
	 * @see #hasLength(CharSequence)
	 */
	public static boolean hasLength(String str) {
		return hasLength((CharSequence) str);
	}
}
