package com.yikai.springcloud.service;

import com.yikai.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2020/3/15 11:35
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
