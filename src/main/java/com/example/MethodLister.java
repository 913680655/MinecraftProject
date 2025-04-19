package com.example;

import java.lang.reflect.Method;

public class MethodLister {
    public static void listMethods() {
        try {
            // 获取 ArmorFeatureRenderer 类
            Class<?> clazz = Class.forName("net.minecraft.client.render.entity.feature.ArmorFeatureRenderer");
            // 获取所有声明的方法
            Method[] methods = clazz.getDeclaredMethods();
            // 输出每个方法的名称和签名
            for (Method method : methods) {
                System.out.println(method.getName() + " " + method.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
