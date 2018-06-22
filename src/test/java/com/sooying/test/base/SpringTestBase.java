package com.sooying.test.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 

/**
 * 单元测试基类
 * 
 * @Description SpringTestBase
 * @author liurh
 * @date 2018年6月22日
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-service.xml","classpath:spring/spring-web.xml"})
public class SpringTestBase {

}
