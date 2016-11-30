package com.khanintel.a_stage_1_98.lesson70_TestFile;

import java.io.File;

/**
 */
public class TestFile {

    public static void main(String[] args) {

        File file = new File("C:\\Justin\\Java\\java_bjsxt_尚学堂_高淇_java300集");
        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);
        System.out.println(File.separator);
        System.out.println(File.separatorChar);

        System.out.println(file.getPath());
        System.out.println(file.getName());

        File file2 = new File(file, "justin.hello");
//        try {
//            file2.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());



//        File file3 = new File(file, "aaa");
//        file3.mkdir();
//
//        File file4 = new File(file, "bbb/ccc/ddd/eee");
//        file4.mkdirs();
//
//        File file5 = new File(file, "www/xxx/a.txt");
//        file5.mkdirs();




    }




}
