//package com.zen.services.utils;
//
//import java.security.SecureRandom;
//
//public class StringUtils {
//    private static final String ALLOWED_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//    private static final SecureRandom RANDOM = new SecureRandom();
//
//    /**
//     * <p>Checks if a CharSequence is empty (""), null or whitespace only.</p>
//     *
//     * <p>Whitespace is defined by {@link Character#isWhitespace(char)}.</p>
//     *
//     * <pre>
//     * StringUtils.isBlank(null)      = true
//     * StringUtils.isBlank("")        = true
//     * StringUtils.isBlank(" ")       = true
//     * StringUtils.isBlank("bob")     = false
//     * StringUtils.isBlank("  bob  ") = false
//     * </pre>
//     *
//     * @param cs  the CharSequence to check, may be null
//     * @return {@code true} if the CharSequence is null, empty or whitespace only
//     * @since 2.0
//     * @since 3.0 Changed signature from isBlank(String) to isBlank(CharSequence)
//     */
//    public static boolean isBlank(final CharSequence cs) {
//        final int strLen = length(cs);
//        if (strLen == 0) {
//            return true;
//        }
//        for (int i = 0; i < strLen; i++) {
//            if (!Character.isWhitespace(cs.charAt(i))) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    // Empty checks
//    //-----------------------------------------------------------------------
//    /**
//     * <p>Checks if a CharSequence is empty ("") or null.</p>
//     *
//     * <pre>
//     * StringUtils.isEmpty(null)      = true
//     * StringUtils.isEmpty("")        = true
//     * StringUtils.isEmpty(" ")       = false
//     * StringUtils.isEmpty("bob")     = false
//     * StringUtils.isEmpty("  bob  ") = false
//     * </pre>
//     *
//     * <p>NOTE: This method changed in Lang version 2.0.
//     * It no longer trims the CharSequence.
//     * That functionality is available in isBlank().</p>
//     *
//     * @param cs  the CharSequence to check, may be null
//     * @return {@code true} if the CharSequence is empty or null
//     * @since 3.0 Changed signature from isEmpty(String) to isEmpty(CharSequence)
//     */
//    public static boolean isEmpty(final CharSequence cs) {
//        return cs == null || cs.length() == 0;
//    }
//
//    public static int length(final CharSequence cs) {
//        return cs == null ? 0 : cs.length();
//    }
//
//    public static String randomString(int length) {
//        return randomString(length, ALLOWED_CHARS);
//    }
//
//    public static String randomString(int length, String allowedChars) {
//        StringBuilder sb = new StringBuilder( length );
//        for( int i = 0; i < length; i++ )
//            sb.append( allowedChars.charAt(RANDOM.nextInt(allowedChars.length())) );
//        return sb.toString();
//    }
//
//}