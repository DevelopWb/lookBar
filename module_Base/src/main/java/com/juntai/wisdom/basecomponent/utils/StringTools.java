package com.juntai.wisdom.basecomponent.utils;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ma
 * on 2019/4/16
 */
public class StringTools {
    /**
     * 判断str是否为空或者是空字符串
     *
     * @param str
     * @return
     */
    public static boolean isStringValueOk(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 设置文字部分颜色
     *
     * @return
     */
    public static void setTextPartColor(TextView textView, String content, int startIndex, int endIndex, String textColor) {
        SpannableString spannableString = null;
        if (StringTools.isStringValueOk(content)) {
            spannableString = new SpannableString(content);
            ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor(textColor));
            spannableString.setSpan(colorSpan, startIndex, endIndex, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            textView.setText(spannableString);
        }
    }

    /**
     * 大图
     * @param str
     * @return
     */
    public static ArrayList<String> getImagesBig(String str) {
        String[] ss = getStrings(str);
        for (int i = 0; i < ss.length; i++) {
//            ss[i] = getImageUrlBig(ss[i]);
        }
        return new ArrayList<>(Arrays.asList(ss));
    }

    /**
     * 分割字符串
     * @param str
     * @return
     */
    public static String[] getStrings(String str) {
        if (str != null && !"".equals(str))
            if (str.contains(","))
                return str.split(",");
            else
                return new String[]{str};
        else
            return new String[]{};
    }

    /**
     * 手机号用****号隐藏中间数字
     *
     * @param phone
     * @return
     */
    public static String settingPhone(String phone) {
        String phone_s = phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        return phone_s;
    }

    /**
     * 邮箱用****号隐藏前面的字母
     *
     * @return
     */
    public static String settingEmail(String email) {
        String emails = email.replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)", "$1****$3$4");
        return emails;
    }

    /**
     * 身份证号用****隐藏前面数字
     *
     * @param IDNumber
     * @return
     */
    public static String settingIDNumber(String IDNumber){
        StringBuilder stringBuilder = new StringBuilder(IDNumber);
        stringBuilder.replace(4, 14, "****");
        return stringBuilder.toString();
    }

}
