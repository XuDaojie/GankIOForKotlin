# GankIOForKotlin

## 内部类
1. Kotlin内部类默认不会包含对外部类的引用,需要在类名前增加`inner`关键后才支持
2. 编译时出现了**Error:(9, 8) Unresolved reference: kotlinx**错误
    解决方案 http://stackoverflow.com/questions/34169562/unresolved-reference-kotlinx/34250825
3. Kotlin对所有引用的**layout**都可以简化`findViewById`