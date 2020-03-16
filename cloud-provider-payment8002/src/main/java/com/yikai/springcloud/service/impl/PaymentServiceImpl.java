package com.yikai.springcloud.service.impl;

import com.yikai.springcloud.dao.PaymentDao;
import com.yikai.springcloud.entities.Payment;
import com.yikai.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2020/3/15 11:35
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    };

    public Payment getPaymentById(@Param("id") Long id){
        return paymentDao.getPaymentById(id);
    };

}
