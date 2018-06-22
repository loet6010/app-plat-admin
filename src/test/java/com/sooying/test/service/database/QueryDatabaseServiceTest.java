package com.sooying.test.service.database;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sooying.pay.app.api.controller.database.dto.DatabaseInfoDto;
import com.sooying.pay.app.api.service.database.QueryDatabaseService;
import com.sooying.test.base.SpringTestBase;

/**
 * @Description QueryDatabaseServiceTest
 * @author liurh
 * @date 2018年6月22日
 */
public class QueryDatabaseServiceTest extends SpringTestBase {
    @Autowired
    private QueryDatabaseService queryDatabaseService;

    @Test
    public void getOverallDataInfoTest() {
        DatabaseInfoDto databaseInfoDto = new DatabaseInfoDto();
        databaseInfoDto.setBeginTime("2018-06-19 00:00:00");
        databaseInfoDto.setEndTime("2018-06-20 00:00:00");
        databaseInfoDto.setAppId("100216");
        
        String result = queryDatabaseService.getOverallDataInfo(databaseInfoDto);

        System.out.println(result);
    }
    
    @Test
    public void getSuccessRateInfoListTest() {
        DatabaseInfoDto databaseInfoDto = new DatabaseInfoDto();
        databaseInfoDto.setBeginTime("2018-06-20 00:00:00");
        databaseInfoDto.setEndTime("2018-06-21 00:00:00");
        
        String result = queryDatabaseService.getSuccessRateInfoList(databaseInfoDto);

        System.out.println(result);
    }
    
    @Test
    public void getProvinceSuccessRateInfoListTest() {
        DatabaseInfoDto databaseInfoDto = new DatabaseInfoDto();
        databaseInfoDto.setNetType("电信");
        databaseInfoDto.setBeginTime("2018-06-20 00:00:00");
        databaseInfoDto.setEndTime("2018-06-21 00:00:00");
        
        String result = queryDatabaseService.getProvinceSuccessRateInfoList(databaseInfoDto);

        System.out.println(result);
    }

    @Test
    public void getOverallFeeInfoListTest() {
        DatabaseInfoDto databaseInfoDto = new DatabaseInfoDto();
        databaseInfoDto.setBeginTime("2018-06-17 00:00:00");
        databaseInfoDto.setEndTime("2018-06-24 00:00:00");

        String result = queryDatabaseService.getOverallFeeInfoList(databaseInfoDto);

        System.out.println(result);
    }
}
