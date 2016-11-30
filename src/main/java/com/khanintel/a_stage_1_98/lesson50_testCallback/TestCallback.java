package com.khanintel.a_stage_1_98.lesson50_testCallback;

/**
 */
public class TestCallback {

    public static void main(String[] args) {

        DrawCircle drawCircle = new DrawCircle();
        DrawRectangle drawRectangle = new DrawRectangle();

        /**
         * 这里，就是把 回掉函数（子类）对象 注册到现有的函数里
         * 然后运行 整个函数
         */
        drawFrame(drawCircle);
        drawFrame(drawRectangle);

//        DrawCircle2 drawCircle2 = new DrawCircle2();
//        DrawRectangle2 drawRectangle2 = new DrawRectangle2();
//
//        drawFrame2(drawCircle2);
//        drawFrame2(drawRectangle2);



    }

    public static void drawFrame (IMyFrame iMyFrame) {
        System.out.println("启动线程");
        System.out.println("增加循环");
        System.out.println("查看消息栈");

        iMyFrame.paint();

        System.out.println("启动缓存，增加效率");
    }

//    public static void drawFrame2 (MyFrame myFrame) {
//        System.out.println("启动线程");
//        System.out.println("增加循环");
//        System.out.println("查看消息栈");
//
//        myFrame.paint();
//
//        System.out.println("启动缓存，增加效率");
//    }

}



interface IMyFrame {
    public abstract void paint();
}

/**
 * 这个应该就是 实现回掉函数（实现子类），定义回调函数
 */
class DrawCircle implements IMyFrame {
    @Override
    public void paint() {
        System.out.println("DrawCircle.paint");
    }
}

class DrawRectangle implements IMyFrame {
    @Override
    public void paint() {
        System.out.println("DrawRectangle.paint");
    }
}

//abstract class MyFrame {
//    public abstract void paint();
//}
//
//class DrawCircle2 extends MyFrame {
//    @Override
//    public void paint() {
//        System.out.println("DrawCircle2.paint");
//    }
//}
//
//class DrawRectangle2 extends MyFrame {
//    @Override
//    public void paint() {
//        System.out.println("DrawRectangle2.paint");
//    }
//}