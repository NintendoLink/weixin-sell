package com.hik.weixinsell.study;

/**
 * 1.错误写法：
 *  public class GeneratorImpl implements Generator<T> 未传入泛型实参时，与泛型定义相同
 *  在声明类的同时，需要将泛型一起生命，如果不声明，则编译器会报错
 *  正确的写法：
 *  public class GeneratorImpl<T> implements Generator<T>
 * 2.传入泛型时,可以对接口上的泛型传入无数个参数，例如传入String类型
 *  如果已经传入了类型参数，则在实现方法中需要把所有的泛型换成相应的传入类型
 */
//public class GeneratorImpl<T> implements Generator<T> {
//    @Override
//    public void print(T t) {
//
//    }
//}
public class GeneratorImpl implements Generator<String> {
    @Override
    public void print(String s) {
        System.out.println(s);
    }
}
