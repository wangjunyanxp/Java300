package com.khanintel.a_stage_1_98.lesson70_TestFile;

import java.io.File;

/**
 * 用递归的方式，打印出整个目录来
 */
public class FileTree {

    /**
     * 1. 输入检查，看要打印的文件树是否存在（是文件/文件夹）
     * 2. 获得子文件/子文件夹，如果是子文件，打印文件，如果是子文件夹，调用打印文件夹的函数（递归调用自身），打印文件夹
     * 3. 打印文件夹的时候，顶端的文件夹没有 “|-” ，子文件夹按照深度打印 n 个 “|-”
     */
    public static void main(String[] args) {

        String directoryString = "C:\\temp";
        printDirectory(directoryString, 0);

    }

    public static void printDirectory(String directoryString, int depth){

        File directory = new File(directoryString);

        if (!directory.exists()) {
            System.out.println("目标文件夹不存在");
            return;
        }

        if (directory.isFile()) {
            System.out.println(directory.getName());
            return;
        }

        String[] filesUnderDirectory = null;
        filesUnderDirectory = directory.list();

        for (String s : filesUnderDirectory) {
            for (int i=0; i<depth; i++) {
                System.out.print("\t");
            }
            if (depth >0 ) {
                System.out.print("|-");
            }
            File file = new File(directory, s);
            if (file.isFile()) {
                System.out.println(file.getName());
            } else {
                String parentDirectoryString = file.getPath();
                System.out.println(file.getName());
                printDirectory(parentDirectoryString, depth+1);
            }
        }

        /*

            │           │   │   ├── Memory.pm
            │           │   │   ├── Network.pm
            │           │   │   ├── Packages
            │           │   │   │   └── APT.pm
            │           │   │   ├── Ports.pm
            │           │   │   ├── Processes.pm
            │           │   │   └── SysInfo.pm
            │           │   ├── DataGetter.pm
            │           │   ├── Logger.pm
            │           │   ├── STDERRLogger.pm
            │           │   └── Util.pm
            │           └── Longview.pl
            └── upgrade-LTS12-LTS14
                ├── apticron.conf.UseNew
                ├── jail.conf.diff.Justin.useNew
                ├── nginx.conf.Justin.I_keep_OldVersion
                ├── php.ini.diff.Justin.I_use_the_new_without_old_modification
                ├── php.ini_new
                ├── php.ini_old
                ├── upgrade_file_log
                │   ├── apt.log
                │   ├── iptables-persistent.0.crash
                │   ├── main.log
                │   ├── sources.list.distUpgrade
                │   └── _usr_bin_apt-listchanges.0.crash
                └── www.conf.diff.Justin.I_keep_OldVersion

            664 directories, 3046 files



            justin@www:/tmp$ tree
            .
            ├── supervisord.pid
            └── supervisor.sock

            0 directories, 2 files

            上图这种实现
            难度在打印 apt.log  APT.pm  Longview.pl 这些文件时，前面的"|"
            这些 "|" 有以下特定
            1. 数量不固定
            2. 在什么位置打印，什么位置不打印等等

            我的解决思路
            利用一个数据结构，ArrayList，记录其 父文件夹 需要打印的 "|" 的安排，并传给子文件夹
            打印的时候，先打印父文件夹的安排，再打印子文件夹的东西

            这次先不做了


         */


    }



}
