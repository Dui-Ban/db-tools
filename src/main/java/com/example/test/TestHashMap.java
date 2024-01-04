package com.example.test;

import org.springframework.util.StringUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.*;

/**
 * @Copyright (c) 2018 政采云有限公司
 * @Date: 2021/11/17
 * @Time: 2:20 下午
 * @Author: 对半
 */
public class TestHashMap {

    /**
     * The load factor used when none specified in constructor.
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    private  static BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(10);

    private static ExecutorService threadPoolExecutor = new ThreadPoolExecutor(4, 4,
            2L, TimeUnit.SECONDS, queue);

    private static final HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        // map.put("A", "a");
        /**
         * 测试算法异或 ^
         */
        // test1();

        /**
         * >>>：无符号右移。无论正数还是负数，高位通通补0.
         * >>:带符号右移。正数右移高位补0，负数右移高位补1.
         */
         // test2();

        /**
         * new HashMap
         * 手动设置容量
         */
        // test3(131073);
        // test4();
        // System.out.println(checkRule("1 "));
        test5();
    }

    private static void test1() {
        int i = 10 ^ 4;
        System.out.println(i);
        int j = 2 ;
        j |= j >>> 1;
        System.out.println(j);
    }

    private static void test2() {
        int x = 12 >>> 1;
        System.out.println(x);
        int n = 12 >> 1;
        System.out.println(n);
        int y = x | 12;
        Integer a = 11;

        System.out.println(a.hashCode());
    }

    private static void test3(int initialCapacity) {
        int n = initialCapacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int s = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        System.out.println(s);
    }

    private static void test4() {
//        String str = "0601";
//        String substring = str.substring(0, 2);
//        System.out.println(substring);
        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        System.out.println(c.get(Calendar.YEAR));
    }

    private static Boolean checkRule(String a) {
        String str = "(%s == 1)";
        String rule = String.format(str, a);
        if (StringUtils.isEmpty(rule)) {
            return Boolean.FALSE;
        }

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        try {
            Object result = engine.eval(rule);
            return Boolean.parseBoolean(result.toString());
        } catch (ScriptException e) {
        }
        return Boolean.FALSE;
    }

    private static void test5() {
        int i = 0;
        while (true && i < 10000) {
            i = i + 200;
            System.out.println(i);
        }
//        Double aDouble = new Double("1.11");
//        System.out.println(aDouble.toString());
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//            Date starCreateAt = df.parse("2021-12-14 20:00:00");
//            Date endCreateAt = df.parse("2021-12-15 01:00:00");
//            System.out.println(starCreateAt);
//            System.out.println(endCreateAt);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }

    private static void test6() throws Exception {
        throw new Exception("错误文案");
    }
}
