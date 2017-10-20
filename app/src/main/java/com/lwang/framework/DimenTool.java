package com.lwang.framework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * MainActivity.class
 *
 * @author lwang
 * @date 2017/10/20.
 */
public class DimenTool {

    /**
     * 默认dimension 屏幕 dp值 ,defaultDp
     */
    public final static int DEFAULT_DP = 400;


    public static void main(String[] args) {

        mDavn();
    }


    public static void mDavn() {

        //以此文件夹下的dimens.xml文件内容为初始值参照
        File file = new File("./app/src/main/res/values/dimens.xml");

        BufferedReader reader = null;
        StringBuilder sw240 = new StringBuilder();
        StringBuilder sw320 = new StringBuilder();
        StringBuilder sw360 = new StringBuilder();
        StringBuilder sw384 = new StringBuilder();
        StringBuilder sw400 = new StringBuilder();
        StringBuilder sw411 = new StringBuilder();
        StringBuilder sw480 = new StringBuilder();
        StringBuilder sw533 = new StringBuilder();
        StringBuilder sw600 = new StringBuilder();
        StringBuilder sw640 = new StringBuilder();
        StringBuilder sw720 = new StringBuilder();
        StringBuilder sw768 = new StringBuilder();
        StringBuilder sw800 = new StringBuilder();
        StringBuilder sw820 = new StringBuilder();

        try {

            System.out.println("生成不同分辨率：");

            reader = new BufferedReader(new FileReader(file));
            String tempString;
            int line = 1;

            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {

                if (tempString.contains("</dimen>")) {

                    String start = tempString.substring(0, tempString.indexOf(">") + 1);
                    String end = tempString.substring(tempString.lastIndexOf("<") - 2);

                    //截取<dimen></dimen>标签内的内容，从>右括号开始，到左括号减2，取得配置的数字
                    Double num = Double.parseDouble
                            (tempString.substring(tempString.indexOf(">") + 1,
                                    tempString.indexOf("</dimen>") - 2));

                    //根据不同的尺寸，计算新的值，拼接新的字符串，并且结尾处换行。
                    sw240.append(start).append(num * DEFAULT_DP / 240).append(end).append("\r\n");
                    sw320.append(start).append(num * DEFAULT_DP / 320).append(end).append("\r\n");
                    sw360.append(start).append(num * DEFAULT_DP / 360).append(end).append("\r\n");
                    sw384.append(start).append(num * DEFAULT_DP / 384).append(end).append("\r\n");
                    sw400.append(start).append(num * DEFAULT_DP / 400).append(end).append("\r\n");
                    sw411.append(start).append(num * DEFAULT_DP / 411).append(end).append("\r\n");
                    sw480.append(start).append(num * DEFAULT_DP / 480).append(end).append("\r\n");
                    sw533.append(start).append(num * DEFAULT_DP / 533).append(end).append("\r\n");
                    sw600.append(start).append(num * DEFAULT_DP / 600).append(end).append("\r\n");
                    sw640.append(start).append(num * DEFAULT_DP / 640).append(end).append("\r\n");
                    sw720.append(start).append(num * DEFAULT_DP / 720).append(end).append("\r\n");
                    sw768.append(start).append(num * DEFAULT_DP / 768).append(end).append("\r\n");
                    sw800.append(start).append(num * DEFAULT_DP / 800).append(end).append("\r\n");
                    sw820.append(start).append(num * DEFAULT_DP / 820).append(end).append("\r\n");
                } else {

                    sw240.append(tempString).append("");
                    sw320.append(tempString).append("");
                    sw360.append(tempString).append("");
                    sw384.append(tempString).append("");
                    sw400.append(tempString).append("");
                    sw411.append(tempString).append("");
                    sw480.append(tempString).append("");
                    sw533.append(tempString).append("");
                    sw600.append(tempString).append("");
                    sw640.append(tempString).append("");
                    sw720.append(tempString).append("");
                    sw768.append(tempString).append("");
                    sw800.append(tempString).append("");
                    sw820.append(tempString).append("");
                }
                line++;
            }

            reader.close();
            System.out.println("<!--  sw240 -->");
            System.out.println(sw240);

            System.out.println("<!--  sw320 -->");
            System.out.println(sw320);

            System.out.println("<!--  sw360 -->");
            System.out.println(sw360);

            System.out.println("<!--  SW384 -->");
            System.out.println(sw384);

            System.out.println("<!--  sw400 -->");
            System.out.println(sw400);

            System.out.println("<!--  sw411 -->");
            System.out.println(sw411);

            System.out.println("<!--  sw480 -->");
            System.out.println(sw480);

            System.out.println("<!--  sw533 -->");
            System.out.println(sw533);

            System.out.println("<!--  sw600 -->");
            System.out.println(sw600);

            System.out.println("<!--  sw640 -->");
            System.out.println(sw640);

            System.out.println("<!--  sw720 -->");
            System.out.println(sw720);

            System.out.println("<!--  sw768 -->");
            System.out.println(sw768);

            System.out.println("<!--  sw800 -->");
            System.out.println(sw800);

            System.out.println("<!--  sw820 -->");
            System.out.println(sw820);

            //直接指定文件夹路径，以及文件名及格式。上来就是干！
            File w240 = new File("./app/src/main/res/values-w240dp/dimens.xml");
            File w320 = new File("./app/src/main/res/values-w320dp/dimens.xml");
            File w360 = new File("./app/src/main/res/values-w360dp/dimens.xml");
            File w384 = new File("./app/src/main/res/values-w384dp/dimens.xml");
            File w400 = new File("./app/src/main/res/values-w400dp/dimens.xml");
            File w411 = new File("./app/src/main/res/values-w411dp/dimens.xml");
            File w480 = new File("./app/src/main/res/values-w480dp/dimens.xml");
            File w533 = new File("./app/src/main/res/values-w533dp/dimens.xml");
            File w600 = new File("./app/src/main/res/values-w600dp/dimens.xml");
            File w640 = new File("./app/src/main/res/values-w640dp/dimens.xml");
            File w720 = new File("./app/src/main/res/values-w720dp/dimens.xml");
            File w768 = new File("./app/src/main/res/values-w768dp/dimens.xml");
            File w800 = new File("./app/src/main/res/values-w800dp/dimens.xml");
            File w820 = new File("./app/src/main/res/values-w820dp/dimens.xml");

            mMake(w240);
            mMake(w320);
            mMake(w360);
            mMake(w384);
            mMake(w400);
            mMake(w411);
            mMake(w480);
            mMake(w533);
            mMake(w600);
            mMake(w640);
            mMake(w720);
            mMake(w768);
            mMake(w800);
            mMake(w820);

            //将新的内容，写入到指定的文件中去
            writeFile(w240, sw240.toString());
            writeFile(w320, sw320.toString());
            writeFile(w360, sw360.toString());
            writeFile(w384, sw384.toString());
            writeFile(w400, sw400.toString());
            writeFile(w411, sw411.toString());
            writeFile(w480, sw480.toString());
            writeFile(w533, sw480.toString());
            writeFile(w600, sw600.toString());
            writeFile(w640, sw640.toString());
            writeFile(w720, sw720.toString());
            writeFile(w768, sw768.toString());
            writeFile(w800, sw800.toString());
            writeFile(w820, sw820.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }


    /**
     * 写入方法
     */
    public static void writeFile(File file, String text) {

        PrintWriter out = null;

        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.close();
    }


    /**
     * 自定义检测生成指定文件夹下的指定文件
     * @param file
     */
    public static void mMake(File file) {

        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}