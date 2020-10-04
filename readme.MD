## 结合了SpringBoot和Apache CXF的WebService项目
#### common模块：
1.Service接口（使用Jax-ws标准进行了注解）
2.Payment类，用于Server和Client的数据封装

#### Client模块
分别使用SpringBoot和纯Java完成了向服务端的调用
#### Server模块
使用SpringBoot与CXF的整合技术
