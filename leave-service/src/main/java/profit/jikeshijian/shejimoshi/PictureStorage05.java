package profit.jikeshijian.shejimoshi;

/**
 *
 *
 *
 *
在上面的这段代码中，我们利用 Java 中的 interface 接口语法来实现抽象特性
 调用者在使用图片存储功能的时候，只需要了解 IPictureStorage 这个接口类暴露了哪些方法就可以了
 不需要去查看 PictureStorage 类里的具体实现逻辑
 实际上：
     1。抽象这个特性是非常容易实现的，并不需要非得依靠接口类或者抽象类这些特殊语法机制来支持
     2。换句话说，并不是说一定要为实现类(PictureStorage)抽象出接口类 (IPictureStorage)，才叫作抽象
     3。即便不编写 IPictureStorage 接口类，单纯的 PictureStorage 类本身就满足抽象特性。
 原因：
 1。类的方法是通过编程语言中的“函数”这一语法机制来实现的。
 2。通过函数包裹具体的实现逻辑，这本身就是一种抽象
 3。调用者在使用函数的时候，并不需要去研究函数内部的实现逻辑，只需要通过函数的命名、注释或者文档，了解其提供了什么功能，就可以直接使用了
 4。比如，我们在使用 C 语言的 malloc() 函数的时候，并不需要了解 它的底层代码是怎么实现的。
 *
 *
 *
 *
 *
 *
 */





public class PictureStorage05 implements IPictureStorage05 {
//    // ... 省略其他属性...
// @Override
// public void savePicture(Picture picture) { ... }
// @Override
// public Image getPicture(String pictureId) { ... }
// @Override
// public void deletePicture(String pictureId) { ... }
// @Override
// public void modifyMetaInfo(String pictureId, PictureMetaInfo metaInfo) { ...
//     }

}
