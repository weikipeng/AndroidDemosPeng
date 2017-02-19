package com.pengjunwei.android.demos.util;

import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by WikiPeng on 2017/2/19 08:40.
 */
public class PLog {
    public static final String TAG = PLog.class.getSimpleName();

    public static void e(String message) {
//        String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
//        String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
//        int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
//
//        String logMessage = "(" + className + ":" + lineNumber + ") : " + message;
//        Log.println(Log.INFO, logTag, logMessage);


//        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        for (int i = 1; i < stackTraceElements.length && i <= 4; i++) {
//            StackTraceElement stackTraceElement = stackTraceElements[i];
//            System.out.println(stackTraceElement.getClassName() + " Method "
//                    + stackTraceElement.getMethodName());
//
//        }


        String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
        String className     = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
        int    lineNumber    = Thread.currentThread().getStackTrace()[3].getLineNumber();
        String methodName    = Thread.currentThread().getStackTrace()[3].getMethodName(); // output : main


        StringBuilder stringBuilder = new StringBuilder(className);
        stringBuilder.append(" ===> ");
        stringBuilder.append(methodName);
        stringBuilder.append(" ===> ");
        stringBuilder.append(message);
        stringBuilder.append("\t\t\t\t\t\tLine:");
        stringBuilder.append(lineNumber);

//        Log.e("tag", "TouchEventActivity ===> dispatchTouchEvent ===> MotionEvent.ACTION_UP");

        Log.println(Log.INFO, TAG, stringBuilder.toString());
    }

    public static String motionEventToString(MotionEvent ev) {
        String result = "";

        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                result = "MotionEvent.ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                result = "MotionEvent.ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                result = "MotionEvent.ACTION_UP";
                break;
            case MotionEvent.ACTION_CANCEL:
                result = "MotionEvent.ACTION_CANCEL";
                break;
//            case MotionEvent.ACTION_DOWN:
//                break;
//            case MotionEvent.ACTION_DOWN:
//                break;
//            case MotionEvent.ACTION_DOWN:
//                break;
//            case MotionEvent.ACTION_DOWN:
//                break;
//            case MotionEvent.ACTION_DOWN:
//                break;
        }
        return result;
    }

    public static boolean motionEventToString(MotionEvent ev, boolean flag) {
        String message = "";

        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                message = "MotionEvent.ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                message = "MotionEvent.ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                message = "MotionEvent.ACTION_UP";
                break;
            case MotionEvent.ACTION_CANCEL:
                message = "MotionEvent.ACTION_CANCEL";
                break;
        }

        message += "\t return " + flag;


        String fullClassName = Thread.currentThread().getStackTrace()[3].getClassName();
        String className     = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
        int    lineNumber    = Thread.currentThread().getStackTrace()[3].getLineNumber();
        String methodName    = Thread.currentThread().getStackTrace()[3].getMethodName(); // output : main


        StringBuilder stringBuilder = new StringBuilder(className);
        stringBuilder.append(" ===> ");
        stringBuilder.append(methodName);
        stringBuilder.append(" ===> ");
        stringBuilder.append(message);
        stringBuilder.append("\t\t\t\t\t\tLine:");
        stringBuilder.append(lineNumber);

        Log.println(Log.INFO, TAG, stringBuilder.toString());

        return flag;
    }
}
