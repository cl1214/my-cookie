# 1.内存溢出

- ## 开启dump
  -XX: HeapDumpOnOutOfMemoryError

- ## 设置dump文件路径
  -XX: HeapDumpPath
- ## 分析dump文件
    如：jvisiovm

# 2.事务传播行为

- ## REQUIRED


  ​	外层有事务，加入外层事务，内外层共用一个事务，一起提交或者回滚；外层无事务，内层新建一个事务；

- ## SUPPORTS


  ​	外层有事务，加入外层事务；外层无事务，内层也以非事务方式运行

- ## REQUIRES_NEW


  ​	总是开启一个新的事务，内外层事务互不影响

- ## NOT_SUPPORTED


  ​	以非事务方式运行，外层事务的提交和回滚不影响内层

- ## NEVER


  ​	总是以非事务方式运行，外层存在事务则抛出异常

- ## NESTED


  ​	内层事务嵌套到外层事务，内层事务相当于使用一个保存点（savePoint）。内部事务回滚不影响外层事务，外层事务回滚的同时内层事务也会回滚

