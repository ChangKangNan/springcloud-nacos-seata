/*
 *  Copyright 1999-2021 Seata.io Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.worker.order.service;

import com.worker.order.feign.AccountFeignClient;
import com.worker.order.feign.StockFeignClient;
import com.worker.order.model.Order;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Program Name: springcloud-nacos-seata
 * <p>
 * Description:
 * <p>
 *
 * @author zhangjianwei
 * @version 1.0
 * @date 2019/8/28 4:05 PM
 */
@Service
public class OrderService {
    Logger logger= LoggerFactory.getLogger(OrderService.class);

    @Resource
    private AccountFeignClient accountFeignClient;
    @Resource
    private StockFeignClient stockFeignClient;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 下单：创建订单、减库存，涉及到两个服务
     *
     * @param userId
     * @param commodityCode
     * @param count
     */
    @GlobalTransactional
  //  @Transactional(rollbackFor = Exception.class)
    public void placeOrder(String userId, String commodityCode, Integer count){
        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));
        jdbcTemplate.update("insert order_tbl(user_id,commodity_code,count,money) values(?,?,?,?)",
                new Object[] {userId, commodityCode, count, orderMoney});

        stockFeignClient.deduct(commodityCode, count);
//        logger.info("条件校验>>>>>>>>>>>>>>>>>>>>>>"+"U100000".equals(userId));
//        if("U100000".equals(userId)){
//            throw new RuntimeException("异常回滚!");
//        }
        accountFeignClient.reduce(userId, orderMoney);
    }
}
