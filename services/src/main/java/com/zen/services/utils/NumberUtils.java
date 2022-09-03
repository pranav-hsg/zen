//package com.zen.services.utils;
//
//import lombok.extern.slf4j.Slf4j;
//
//import java.math.BigDecimal;
//
//@Slf4j
//public class NumberUtils {
//
//    public static BigDecimal parse(String s) {
//        try {
//            return new BigDecimal(s);
//        } catch(NumberFormatException e1) {
//            String []pieces = s.split("[xX*^]");
//            if(pieces.length != 3) {
//                log.error(s + " is not in exp[5x10^-5] format either", e1);
//                return null;
//            }
//            try {
//                double constant = Double.parseDouble(pieces[0].trim());
//                String baseStr = pieces[1]; // Could be e or E or a Integer
//                Double base = null;
//                if (baseStr.equalsIgnoreCase("e"))
//                    base = Math.E;
//                else base = Double.valueOf(baseStr);
//                double exponent = Double.parseDouble(pieces[2]);
//                double result = constant * Math.pow(base, exponent);
//                return BigDecimal.valueOf(result);
//            } catch(NumberFormatException e2) {
//                log.error("Failed to parse " + s + " into BigDecimal", e2);
//                return null;
//            }
//         }
//    }
//
//    // Convenience method that allows 0.1% of first input as tolerance
//    public static boolean fuzzyEquals(double a, double b) {
//        return fuzzyEquals(a, b, Math.abs(a * 0.001));
//    }
//
//
//    // Copied over from Guava DoubleMath
//    public static boolean fuzzyEquals(double a, double b, double tolerance) {
//        checkNonNegative("tolerance", tolerance);
//        return Math.copySign(a - b, 1.0) <= tolerance
//                // copySign(x, 1.0) is a branch-free version of abs(x), but with different NaN semantics
//                || (a == b) // needed to ensure that infinities equal themselves
//                || (Double.isNaN(a) && Double.isNaN(b));
//    }
//
//    // Copied over from Guava DoubleMath
//    static double checkNonNegative(String role, double x) {
//        if (!(x >= 0)) { // not x < 0, to work with NaN.
//            throw new IllegalArgumentException(role + " (" + x + ") must be >= 0");
//        }
//        return x;
//    }
//
//    public static String ordinal(int i) {
//        int mod100 = i % 100;
//        int mod10 = i % 10;
//        if(mod10 == 1 && mod100 != 11) {
//            return i + "st";
//        } else if(mod10 == 2 && mod100 != 12) {
//            return i + "nd";
//        } else if(mod10 == 3 && mod100 != 13) {
//            return i + "rd";
//        } else {
//            return i + "th";
//        }
//    }
//}
