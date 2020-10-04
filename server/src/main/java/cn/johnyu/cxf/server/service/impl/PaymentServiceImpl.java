package cn.johnyu.cxf.server.service.impl;

import cn.johnyu.common.pojo.Payment;
import cn.johnyu.common.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String getPayment(int id) {
        return "payment id is " + id + ", sn is " + UUID.randomUUID().toString();
    }

    @Override
    public String[] findAllPayments() {
        String[] ps = new String[2];
        for (int i = 0; i < ps.length; i++) {
            ps[i] = "payment" + i;
        }
        return ps;
    }
    @Override
    public List<Payment> findAllPaymentsPro() {
        List<Payment> list=new ArrayList<>();
        for (long i = 0; i < 2; i++) {
            Payment p=new Payment();
            p.setId(i);
            p.setSn(UUID.randomUUID().toString());
            list.add(p);
        }
        return list;
    }
}
