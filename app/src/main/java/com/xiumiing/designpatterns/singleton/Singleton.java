package com.xiumiing.designpatterns.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * ----------BigGod be here!----------/
 * ***┏┓******┏┓*********
 * *┏━┛┻━━━━━━┛┻━━┓*******
 * *┃             ┃*******
 * *┃     ━━━     ┃*******
 * *┃             ┃*******
 * *┃  ━┳┛   ┗┳━  ┃*******
 * *┃             ┃*******
 * *┃     ━┻━     ┃*******
 * *┃             ┃*******
 * *┗━━━┓     ┏━━━┛*******
 * *****┃     ┃神兽保佑*****
 * *****┃     ┃代码无BUG！***
 * *****┃     ┗━━━━━━━━┓*****
 * *****┃              ┣┓****
 * *****┃              ┏┛****
 * *****┗━┓┓┏━━━━┳┓┏━━━┛*****
 * *******┃┫┫****┃┫┫********
 * *******┗┻┛****┗┻┛*********
 * ━━━━━━神兽出没━━━━━━
 * 版权所有：个人
 * 作者：Created by a.wen.
 * 创建时间：2018/6/16
 * Email：13872829574@163.com
 * 内容描述：
 * 修改人：a.wen
 * 修改时间：${DATA}
 * 修改备注：
 * 修订历史：1.0
 */
public class Singleton {

    private static Singleton singleton;

    //构造方法为private,防止外部代码直接通过new来构造多个对象
    private Singleton() {
    }

    //----------------懒汉式-------------------------------------------------

    /**
     * 懒汉式（线程不安全）
     * 优点：实现了懒加载的效果。
     * 缺点：线程不安全。
     *
     * @return
     */
    public static Singleton getInstance_1() {
        if (singleton == null) {
            singleton = new Singleton();  //在第一次调用getInstance()时才实例化，实现懒加载,所以叫懒汉式
        }
        return singleton;
    }

    /**
     * 懒汉式（线程安全）
     * 优点：实现了懒加载的效果，线程安全。
     * 缺点：使用synchronized会造成不必要的同步开销，而且大部分时候我们是用不到同步的。
     *
     * @return
     */
    public static synchronized Singleton getInstance_2() { //加上synchronized同步
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    /**
     * 双重检查锁定（DCL）
     * 优点：懒加载，线程安全，效率较高
     * 缺点：volatile影响一点性能，高并发下有一定的缺陷，某些情况下DCL会失效，虽然概率较小。
     *
     * @return
     */
    public static Singleton getSingleton_3() {
        if (singleton == null) {  //第一次检查，避免不必要的同步
            synchronized (Singleton.class) {  //同步
                if (singleton == null) {   //第二次检查，为null时才创建实例
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    /**
     * 静态内部类
     * 优点：懒加载，线程安全，推荐使用
     *
     * @return
     */
    public static Singleton getSingleton_4() {
        //第一次调用getInstance方法时才加载SingletonHolder并初始化sInstance
        return SingletonHolder.sInstance;
    }

    //静态内部类
    private static class SingletonHolder {
        private static final Singleton sInstance = new Singleton();
    }

    /**
     * 使用容器实现单例模式
     */
    private static Map<String, Object> objMap = new HashMap<String, Object>();

    public static void registerService(String key, Object instance) {
        if (!objMap.containsKey(key)) {
            objMap.put(key, instance);//添加单例
        }
    }

    public static Object getService(String key) {
        return objMap.get(key);//获取单例
    }

    //----------------懒汉式-------------------------------------------------


    /**
     * 饿汉式
     */
    private static final Singleton single = new Singleton();  //在类初始化时，已经自行实例化,所以是线程安全的。

    public static Singleton getInstance() {  //通过getInstance()方法获取实例对象
        return single;
    }


}
