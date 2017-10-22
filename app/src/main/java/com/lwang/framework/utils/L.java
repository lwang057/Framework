package com.lwang.framework.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.Locale;

/**
 * Log util
 * Created by spc on 2016/3/24.
 */
@SuppressWarnings({"unused", "JavaDoc", "WeakerAccess"})
public class L {

    private static final int VERBOSE = 2;
    private static final int DEBUG = 3;
    private static final int INFO = 4;
    private static final int WARN = 5;
    private static final int ERROR = 6;
    private static final Gson sGson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").setPrettyPrinting().create();
    //    public static final int ASSERT = 7;

    private L() {
    }

    private static boolean debuggable = false;

    public static void setDebuggable(boolean debuggable) {
        L.debuggable = debuggable;
    }


    /**
     * Send a {@link #VERBOSE} log message.
     *
     * @param json json string to print
     */
    public static int json(String json) {
        return debuggable ? println(VERBOSE, generateTag(), sGson.toJson(new JsonParser().parse(json))) : -1;
    }

    /**
     * Send a {@link #VERBOSE} log message.
     *
     * @param o PoJo to print
     */
    public static int json(Object o) {
        return debuggable ? println(VERBOSE, generateTag(), sGson.toJson(o)) : -1;
    }

    /**
     * Send a {@link #VERBOSE} log message.
     *
     * @param msg The message you would like logged.
     */
    public static int v(String msg) {
        return debuggable ? println(VERBOSE, generateTag(), msg) : -1;
    }

    /**
     * Send a {@link #VERBOSE} log message.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static int v(String tag, String msg) {
        return debuggable ? println(VERBOSE, tag, msg) : -1;
    }

    /**
     * Send a {@link #VERBOSE} log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param tr  tr
     */
    public static int v(String msg, Throwable tr) {
        return debuggable ? println(VERBOSE, generateTag(), msg + '\n' + getStackTraceString(tr)) : -1;
    }

    /**
     * Send a {@link #VERBOSE} log message and log the exception.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr  An exception to log
     */
    public static int v(String tag, String msg, Throwable tr) {
        return debuggable ? println(VERBOSE, tag, msg + '\n' + getStackTraceString(tr)) : -1;
    }

    /**
     * Send a {@link #DEBUG} log message.
     *
     * @param msg The message you would like logged.
     */
    public static int d(String msg) {
        return debuggable ? println(DEBUG, generateTag(), msg) : -1;
    }

    /**
     * Send a {@link #DEBUG} log message.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static int d(String tag, String msg) {
        return debuggable ? println(DEBUG, tag, msg) : -1;
    }

    /**
     * Send a {@link #DEBUG} log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param tr  tr
     */
    public static int d(String msg, Throwable tr) {
        return debuggable ? println(DEBUG, generateTag(), msg + '\n' + getStackTraceString(tr)) : -1;
    }

    /**
     * Send a {@link #DEBUG} log message and log the exception.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr  An exception to log
     */
    public static int d(String tag, String msg, Throwable tr) {
        return debuggable ? println(DEBUG, tag, msg + '\n' + getStackTraceString(tr)) : -1;
    }

    /**
     * Send an {@link #INFO} log message.
     *
     * @param msg The message you would like logged.
     */
    public static int i(String msg) {
        return debuggable ? println(INFO, generateTag(), msg) : -1;
    }

    /**
     * Send an {@link #INFO} log message.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static int i(String tag, String msg) {
        return debuggable ? println(INFO, tag, msg) : -1;
    }

    /**
     * Send a {@link #INFO} log message and log the exception.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr  An exception to log
     */
    public static int i(String tag, String msg, Throwable tr) {
        return debuggable ? println(INFO, tag, msg + '\n' + getStackTraceString(tr)) : -1;
    }

    /**
     * Send a {@link #WARN} log message.
     *
     * @param msg The message you would like logged.
     */
    public static int w(String msg) {
        return println(WARN, generateTag(), msg);
    }

    /**
     * Send a {@link #WARN} log message.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static int w(String tag, String msg) {
        return println(WARN, tag, msg);
    }

    /**
     * Send a {@link #WARN} log message and log the exception.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr  An exception to log
     */
    public static int w(String tag, String msg, Throwable tr) {
        return println(WARN, tag, msg + '\n' + getStackTraceString(tr));
    }

    /*
     * Send a {@link #WARN} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param tr An exception to log
     */
    public static int w(Throwable tr) {
        return println(WARN, generateTag(), getStackTraceString(tr));
    }

    /*
         * Send a {@link #WARN} log message and log the exception.
         * @param tag Used to identify the source of a log message.  It usually identifies
         *        the class or activity where the log call occurs.
         * @param tr An exception to log
         */
    public static int w(String tag, Throwable tr) {
        return println(WARN, tag, getStackTraceString(tr));
    }

    /**
     * Send an {@link #ERROR} log message.
     *
     * @param msg The message you would like logged.
     */
    public static int e(String msg) {
        return println(ERROR, generateTag(), msg);
    }

    /**
     * Send an {@link #ERROR} log message.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    public static int e(String tag, String msg) {
        return println(ERROR, tag, msg);
    }

    /**
     * Send a {@link #ERROR} log message and log the exception.
     *
     * @param tr
     */
    public static int e(Throwable tr) {
        return println(ERROR, generateTag(), getStackTraceString(tr));
    }

    /**
     * Send a {@link #ERROR} log message and log the exception.
     *
     * @param msg The message you would like logged.
     * @param tr
     */
    public static int e(String msg, Throwable tr) {
        return println(ERROR, generateTag(), msg + '\n' + getStackTraceString(tr));
    }

    /**
     * Send a {@link #ERROR} log message and log the exception.
     *
     * @param tag Used to identify the source of a log message.  It usually identifies
     *            the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr  An exception to log
     */
    public static int e(String tag, String msg, Throwable tr) {
        return println(ERROR, tag, msg + '\n' + getStackTraceString(tr));
    }

    /**
     * Handy function to get a loggable stack trace from a Throwable
     *
     * @param tr An exception to log
     */
    private static String getStackTraceString(Throwable tr) {
        if (tr == null) {
            return "";
        }

        // This is to reduce the amount of log spew that apps do in the non-error
        // condition of the network being unavailable.
        Throwable t = tr;
        while (t != null) {
            if (t instanceof UnknownHostException) {
                return "";
            }
            t = t.getCause();
        }

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        tr.printStackTrace(pw);
        pw.flush();
        return sw.toString();
    }

    /**
     * Low-level logging call.
     *
     * @param priority The priority/type of this log message
     * @param tag      Used to identify the source of a log message.  It usually identifies
     *                 the class or activity where the log call occurs.
     * @param msg      The message you would like logged.
     * @return The number of bytes written.
     */
    private static int println(int priority, String tag, String msg) {
        if (debuggable || priority > WARN) {
            return Log.println(priority, tag, msg);
        } else {
            return -1;
        }
    }

    private static StackTraceElement getCallerStackTraceElement() {
        return Thread.currentThread().getStackTrace()[5];
    }

    private static String generateTag() {return generateTag(getCallerStackTraceElement());}

    private static String generateTag(StackTraceElement caller) {
        String callerClazzName = caller.getClassName(); // 获取到类名
        callerClazzName = callerClazzName.substring(callerClazzName
                .lastIndexOf(".") + 1);
        return String.format(Locale.CHINA, "%s.%s(Line:%d)",
                callerClazzName, caller.getMethodName(), caller.getLineNumber());
    }

}
