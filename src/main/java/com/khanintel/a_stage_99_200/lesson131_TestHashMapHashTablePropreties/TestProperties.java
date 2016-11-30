package com.khanintel.a_stage_99_200.lesson131_TestHashMapHashTablePropreties;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

/**
 * 1. Properties 的使用 与 使用场景
 * 2. 如何正确的使用相对路径
 *      TestProperties.class.getResource();
 *      Thread.currentThread().getContextClassLoader().getResource();
 *
 *      TestProperties.class.getResourceAsStream("db.properties")
 *      Thread.currentThread().getContextClassLoader().getResourceAsStream("com/khanintel/lesson131_TestHashMapHashTablePropreties/properties.properties");

 *
 */
public class TestProperties {

    public static void main(String[] args) {


        /**
         * Properties，经常被用作 资源配置文件，在 Hibernate 等工具中被用的非常频繁
         *
         * 让我们可以在框架下，利用资源配置文件，无需调整代码，只需使用不同的配置文件，再结合反射技术，就可以动态的使用其他数据库了
         *
         */
        Properties pro = new Properties();
        pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
        pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:orcl");
        pro.setProperty("user", "justin");
        pro.setProperty("pwd", "ThePassWord");

        // 默认存储到 相对路径里更好，配置文件跟着项目文件夹一起
        // 为了避免生成之后，影响到整个项目（可能有的就会有依赖的key正好和配置文件的关键字一样，不好删，也可能影响到运行时的环境，所以还是先别乱来了）
        // 我们用到的相对路径
        /*
        try {
            pro.store(new FileWriter("db.properties"), "Comments for db.properties");
            //pro.store(new FileWriter("src/db.properties"), "Comments for db.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        ///////////////////////////////////////////////////////

        Properties properties = new Properties();

        properties.setProperty("Key_1", "Value_a");
        properties.setProperty("Key_2", "Value_b");
        properties.setProperty("Key_3", "Value_c");



        System.out.println(properties.getProperty("Key_1"));
        System.out.println(properties.getProperty("Key_111"));
        System.out.println(properties.getProperty("Key_111", "DefaultValue"));


        try {
            //准备文件
            File file = new File("C:\\temp\\properties.txt");
            File fileXML = new File("C:\\temp\\properties.xml");

            file.createNewFile();
            fileXML.createNewFile();

            //准备  Writer OutputStream
            //写入到 Writer OutputStream
            FileWriter fileWriter = new FileWriter(file);
            properties.store(fileWriter, "Store the properties");

            FileOutputStream fileOutputStream = new FileOutputStream(fileXML);
            properties.storeToXML(fileOutputStream, "Store the properties in XML");

            //清空properties
            // 若 properties = null; 这么执行的话，就是 nullPointerException了
            properties.clear();
            System.out.println(properties);

            // 从 Reader 里面获得 Properties
            FileReader fileReader = new FileReader(file);
            properties.load(fileReader);
            System.out.println(properties);

            //清空properties
            properties.clear();
            System.out.println(properties);

            // 从 InputStream 里面获得 Properties
            FileInputStream fileInputStream = new FileInputStream(fileXML);
            properties.loadFromXML(fileInputStream);
            System.out.println(properties);


            /**
             * 单纯的 store(Writer, String)，store(OutputStream, String)，并没有较大的差别
             * 一个是字符流 Writer，一个是原始的字节流 OutputStream (比如用来传输图片等)
             *
             * 输出来的，都是纯文本文件，内容都一样的
             *
             */
            File propertyFile = new File("C:\\temp\\properties.properties");
            propertyFile.createNewFile();
            OutputStream outputStream = new FileOutputStream(propertyFile);
            properties.store(outputStream, "Comments for .properties file");

            ///////////////////////////////////////////////////////

            /**
             *
             * ### 使用 类相对路径 读取配置文件 ###
             *
             * getResource
             * getResourceAsStream
             *
             * TestProperties.class.getResource();
             * Thread.currentThread().getContextClassLoader().getResource();
             *
             * TestProperties.class.getResourceAsStream("db.properties")
             * Thread.currentThread().getContextClassLoader().getResourceAsStream("com/khanintel/lesson131_TestHashMapHashTablePropreties/properties.properties");
             *
             * 这才是我们经常存储使用的方式，使用函数获取路径，并在此基础上使用相对路径，做好文件的存储
             *
             * BTW，只有查到有 InputStream，没有OutStream方法的（如果想有，自己创建文件来搞）
             *
             */
            URL url1 = TestProperties.class.getResource("");
            URL url2 = Thread.currentThread().getContextClassLoader().getResource("");
            System.out.println(url1.toString());
            System.out.println(url2.toString());


            /**
             * URL url001 url002，可以确创建的前提，是文件已经存在了
             * 如果文件不存在，则 url001 url002 都是 null
             *
             */

            URL url001 = TestProperties.class.getResource("db.properties");
            URL url002 = Thread.currentThread().getContextClassLoader().getResource("com/khanintel/a_stage_99_200/lesson131_TestHashMapHashTablePropreties/properties.properties");
            System.out.println(url001);
            System.out.println(url002);
            File fileStoreInLocal001 = new File(url001.toURI());
            File fileStoreInLocal002 = new File(url002.toURI());
            //fileStoreInLocal001.createNewFile();
            //fileStoreInLocal002.createNewFile();
            properties.store(new FileOutputStream(fileStoreInLocal001), "Comments");
            properties.store(new FileOutputStream(fileStoreInLocal002), "Comments");

            Properties newPro1 = new Properties();
            Properties newPro2 = new Properties();

            InputStream inputStream1 = TestProperties.class.getResourceAsStream("db.properties");
            newPro1.load(inputStream1);

            InputStream inputStream2 = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/khanintel/a_stage_99_200/lesson131_TestHashMapHashTablePropreties/properties.properties");
            newPro2.load(inputStream2);

            System.out.println(newPro1.getProperty("Key_1"));
            System.out.println(newPro2.getProperty("Key_2"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


    }


}
