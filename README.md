# app-plat-admin

拦截器：AuthInterceptor.java
    拦截所有的.json访问，验证token有效性
    
AOP操作日志记录：OperateLogAspect.java
    扫描DAO层，所有insert*、update*、delete*的方法，并记录操作到日志表中
