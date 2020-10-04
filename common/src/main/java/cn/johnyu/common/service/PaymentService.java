package cn.johnyu.common.service;

import cn.johnyu.common.pojo.Payment;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://service.johnyu.cn")
public interface PaymentService {
    @WebMethod(operationName = "getPayment")
    String getPayment(@WebParam(name = "id") int id);
    @WebMethod(operationName = "findAllPayments")
    String[] findAllPayments();
    @WebMethod(operationName = "findAllPaymentsPro")
    List<Payment> findAllPaymentsPro();

}
