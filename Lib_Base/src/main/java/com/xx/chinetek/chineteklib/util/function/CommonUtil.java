package com.xx.chinetek.chineteklib.util.function;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


public class CommonUtil {

    /**
     * 判断是否为数字
     *
     * @param
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    public static boolean isFloat(String str) {
        Pattern pattern = Pattern.compile("^(-?\\d+)(\\.\\d+)?$");
        return pattern.matcher(str).matches();
    }



    /**
     * 实现过滤
     *
     * @param str
     * @return
     * @throws PatternSyntaxException
     */
    public static String stringFilter(String str) throws PatternSyntaxException {

        // 只允许字母和数字
        String regEx = "[^a-zA-Z0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();

    }

    /**
     * 获取外置SD卡路径
     *
     * @return
     */
    public static String getSDCardPath() {
        String cmd = "cat /proc/mounts";
        Runtime run = Runtime.getRuntime();// 返回与当前 Java 应用程序相关的运行时对象
        try {
            Process p = run.exec(cmd);// 启动另一个进程来执行命令
            BufferedInputStream in = new BufferedInputStream(p.getInputStream());
            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));

            String lineStr;
            while ((lineStr = inBr.readLine()) != null) {
                // 获得命令执行后在控制台的输出信息
                if (lineStr.contains("sdcard") && lineStr.contains(".android_secure")) {
                    String[] strArray = lineStr.split(" ");
                    if (strArray != null && strArray.length >= 5) {
                        String result = strArray[1].replace("/.android_secure", "");
                        return result;
                    }
                }
                // 检查命令是否执行失败。
                if (p.waitFor() != 0 && p.exitValue() == 1) {
                    // p.exitValue()==0表示正常结束，1：非正常结束
                }
            }
            inBr.close();
            in.close();

        } catch (Exception e) {
            return Environment.getExternalStorageDirectory().getPath();
        }

        return Environment.getExternalStorageDirectory().getPath();
    }

    /**
     * 保存图片到本地
     *
     * @param bitmap
     * @return
     */
    public static String saveBitmpToFile(Bitmap bitmap) {
        File file = new File(CommonUtil.getSDCardPath() + "/temp.jpg");
        String filePath = "";
        FileOutputStream out = null;
        try {
            file.createNewFile();
            out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
            filePath = file.getPath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }


    /**
     * 日期转成毫秒 params 日期字符串
     */
    public static String dateStrConvertTimes(String dateStr) {
        String times = "";
        // DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = (Date) df.parse(dateStr);
            times = date.getTime() + "";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return times;
    }

    /**
     * 日期字符串转成日期 params 日期
     */
    public static Date dateStrConvertDate(String dateStr,String Format) {
        Date date = null;
        if(Format==null) Format="yyyy-MM-dd";
        SimpleDateFormat df = new SimpleDateFormat(Format);
        try {
            date = (Date) df.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }



    /**
     * 毫秒转成日期
     *
     * @param times 毫秒
     * @return
     */
    public static String timesConvertDateStr(String times) {
        String dateStr = "";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            dateStr = df.format(new Date(Long.valueOf(times)));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dateStr;
    }

    public static String DateToString(Date date,String Format){
        //"yyyy-MM-dd"
        if(Format==null) Format="yyyy-MM-dd";
        String dateStr = "";
        SimpleDateFormat df = new SimpleDateFormat(Format);
        try {
            dateStr = df.format(date);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dateStr;
    }

    /**
     * 获取系统日期
     *
     * @return
     */
    public static String getSystemDate() {
        // 获得当前的日期：
        final Calendar currentDate = Calendar.getInstance();
        int month = currentDate.get(Calendar.MONTH) + 1;
        int day = currentDate.get(Calendar.DAY_OF_MONTH);
        // 设置文本的内容：
        StringBuffer dateStr = new StringBuffer();
        dateStr.append(currentDate.get(Calendar.YEAR)).append("-").append( String.format("%02d", month)).append("-").append(String.format("%02d", day));
        return dateStr.toString();
    }

    /**
     * 获取系统时间
     *
     * @return
     */
    public static String getSystemTime() {
        // 获得当前的日期：
        final Calendar currentDate = Calendar.getInstance();
        // 设置文本的内容：
        StringBuffer dateStr = new StringBuffer();
        dateStr.append(currentDate.get(Calendar.HOUR)).append(":").append(currentDate.get(Calendar.MINUTE)).append(":").append(currentDate.get(Calendar.SECOND));
        return dateStr.toString();
    }

    // 获取设备序列号
    public static String GetSimSerialNumber(Context context) {
        TelephonyManager tManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tManager.getDeviceId();
    }

    //隐藏虚拟键盘
    public static void HideKeyboard(View v) {
        InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);

        }
    }

    /***
     * 隐藏系统键盘，并显示光标
     *
     * @param context
     * @param ed
     */
    public static void hideSoftInputMethod(Activity context, EditText ed) {
        context.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        int currentVersion = android.os.Build.VERSION.SDK_INT;
        String methodName = null;
        if (currentVersion >= 16) {
            // 4.2
            methodName = "setShowSoftInputOnFocus";
        } else if (currentVersion >= 14) {
            // 4.0
            methodName = "setSoftInputShownOnFocus";
        }

        if (methodName == null) {
            ed.setInputType(InputType.TYPE_NULL);
        } else {
            Class<EditText> cls = EditText.class;
            Method setShowSoftInputOnFocus;
            try {
                setShowSoftInputOnFocus = cls.getMethod(methodName, boolean.class);
                setShowSoftInputOnFocus.setAccessible(true);
                setShowSoftInputOnFocus.invoke(ed, false);
            } catch (NoSuchMethodException e) {
                ed.setInputType(InputType.TYPE_NULL);
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 将焦点放在输入框中并选中全部 如果想要选中输入框中的文本必须要将焦点放在输入框中 如果想要焦点在输入框中必须设置下面三个方法
     *
     * @param editText
     */
    public static void setEditFocus(EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        editText.selectAll();
    }

    public static void setButtonFocus(Button button) {
        button.setFocusable(true);
        button.setFocusableInTouchMode(true);
        button.requestFocus();
        button.requestFocusFromTouch();
        button.findFocus();
    }

    /**
     * 如果字符串的长度不够，则补充空格输出
     *
     * @param str
     * @param leng
     * @return
     */
    public static String PadRight(String str,String padChar, int leng) {
        int temp = 0;
        if (IsInputChinese(str)) {
            temp = leng - str.length() * 2;
        } else {
            temp = leng - str.length();
        }

        if (temp > 0) {
            for (int i = 0; i < temp; i++) {
                str += padChar;
            }
        }
        return str;
    }



    /***
     * 判断输入的是否中文字符
     *
     * @param str
     * @return
     */
    public static boolean IsInputChinese(String str) {
        char[] strTemp = str.toCharArray();
        Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
        for (int i = 0; i < strTemp.length; i++) {
            Matcher matcher = pattern.matcher(String.valueOf(strTemp[i]));
            if (!matcher.matches()) {
                return false;
            }
        }

        return true;
    }

    /**
     * 判断输入的是否是英文字符
     *
     * @return
     */
    public static boolean IsInputWords(String str) {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    /**
     * 获取当前时间 格式 2012-12-21 12:12:12
     *
     * @return
     */
    public static String getCurrentDate() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sDateFormat.format(new Date());
        return date;
    }



    /**
     * 验证IP地址
     *
     * @param ip
     * @return
     */
    public static boolean MatcherIP(String ip) {
        Pattern pattern = Pattern.compile("^((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])"
                + "\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])"
                + "\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])"
                + "\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])");

        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }


}
