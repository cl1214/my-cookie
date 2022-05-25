# Spring生命周期

## prepareRefresh

​	设置启动时间、标志，校验必要属性存在性

## obtainFreshBeanFactory

1. 如果有beanFactory，销毁Beans，关闭beanFactory
2. 创建beanFactory对象，DefaultListableBeanFactory
3. 设置beanFactory对象属性，如allowBeanDefinitionOverriding、allowCircularReferences
4. 加载BeanDefinition，使用BeanDefinitionReader读取Bean定义，如xml文件定义，读取文件流，解析成Document对象，最后封装成BeanDefinitionHolder对象，注册到Bean容器里

## prepareBeanFactory

​	设置类加载器，EL表达式解析器、设置忽略装配的各类Aware接口、注册容器环境Enviroment Bean

## postProcessBeanFactory

​	空实现

## invokeBeanFactoryPostProcessors

​	如果beanFactory是BeanDefinitionRegistry对象，则先执行bean工厂及其自身的实现了BeanDefinitionRegistry的postProcessBeanDefinitionRegistry方法，执行顺序如下：

1. 实现了PriorityOrdered接口的BeanDefinitionRegistry对象
2. 实现了Ordered接口的BeanDefinitionRegistry对象
3. 剩余的BeanDefinitionRegistry对象
4.  bean工厂自身实现了BeanDefinitionRegistry和BeanFactoryPostProcessor接口的postProcessBeanFactory方法
5. bean工厂自身只实现了postProcessBeanFactory接口的postProcessBeanFactory方法

​	处理完beanFactory对象自身的BeanDefinitionRegistry、BeanFactoryPostProcessor和bean工厂里的BeanDefinitionRegistry，继续处理bean工厂里的BeanFactoryPostProcessor，执行顺序如下

1. 实现了PriorityOrdered接口
2. 实现了Ordered接口
3. 剩余的BeanFactoryPostProcessor

## registerBeanPostProcessors

​	getBeanNamesForType找出所有实现了BeanPostProcessor的bean名称，然后遍历bean名称，按顺序注册BeanPostProcessor,顺序如下
1. 实现了PriorityOrdered接口
2. 实现了Ordered接口
3. 常规的BeanPostProcessor
4. Spring内部的BeanPostProcessor





