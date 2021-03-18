## 结构型设计模式

结构型模式描述如何将类或对象按某种布局组成更大的结构

-- --

## 结构型设计模式分为以下七种：

- 代理（Agency）模式：创建一个类代理实际目标对象，客服端直接使用代理类完成操作。对外隐藏具体实现，增强方法

- 适配器（Adapter）模式：将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作

- 桥接（Bridge）模式：将不同特性的抽象与实现分离，使它们可以独立变化

- 装饰器（Decorator）模式：指在不改变现有对象结构的情况下，动态地给该对象增加一些职责的模式

- 外观（Facade）模式：通过为多个复杂的子系统提供一个一致的接口，而使这些子系统更加容易被访问的模式

- 享元（Flyweight）模式：通过共享已经存在的对象来大幅度减少需要创建的对象数量、避免大量相似类的开销，从而提高系统资源的利用率

- 组合（Composite）模式：将对象组合成树状的层次结构，表示“整体-部分”的关系，使用户对单个对象和组合对象具有一致的访问性

-- --

## 常见问题：

```
1、如何区分代理模式、适配器模式、桥接模式、装饰器模式以及外观模式的区别：

首先这五种设计模式的实现是非常相似的，并且很多时候可以互相替换使用。这里我主要从功能的层面对他们做区分：

- 代理模式：代码模式通过中介代理的设计模式隐藏实现细节，增强方法，常见有 Spring AOP 切面插入打印日志等操作
- 适配器模式：适配器模式主要为了将不能兼容的接口统一起来，这里需要特别注意"不能兼容"，也就是说接口本身是不兼容的，我们通过新接口统一起来对外服务，接口内部进行划分
- 桥接模式：桥接模式是指将多种对象性质分别在不同的接口中实现，实现部分属性的共享，它和适配器模式最大区别在于适配器模式统一不能兼容的接口，而它统一的是可以兼容的属性，各属性独立实现
- 装饰器模式：装饰器模式的主要功能在于拓展功能，它和代理模式的区别在于：代理模式一般增强方法的公共模块，如打印日志，处理请求头等，而装饰器模式更像是新增一个新的功能。也就是说，代理模式主要增强已有功能，而装饰器模式增加新功能
- 外观模式：外观模式的主要功能在于统一接口，随着系统的拓展，子系统越来越多，外观模式就在于增加公共接口，减少系统复杂度

```