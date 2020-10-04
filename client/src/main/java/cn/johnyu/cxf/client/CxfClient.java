package cn.johnyu.cxf.client;

import cn.johnyu.common.pojo.Payment;
import cn.johnyu.common.service.PaymentService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CxfClient {
    public static void main(String[] args) {
       ApplicationContext context= SpringApplication.run(CxfClient.class,args);
       PaymentService paymentService=context.getBean(PaymentService.class);
       String rs=paymentService.getPayment(10);
        System.out.println(rs);

        String[] rs2=paymentService.findAllPayments();
        for (String s:rs2) {
            System.out.println(s);
        }

        List<Payment> list=paymentService.findAllPaymentsPro();
        list.forEach(px-> System.out.println(px.getSn()));

    }
    @Bean
    public JaxWsProxyFactoryBean createJaxWsProxyFactoryBean(){
        String address = "http://127.0.0.1:8080/services/payments?wsdl";
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        // 设置代理地址
        jaxWsProxyFactoryBean.setAddress(address);
        return jaxWsProxyFactoryBean;
    }

    @Bean
    public PaymentService createPaymentService(@Autowired JaxWsProxyFactoryBean jaxWsProxyFactoryBean){
        jaxWsProxyFactoryBean.setServiceClass(PaymentService.class);
        return (PaymentService) jaxWsProxyFactoryBean.create();
    }

    //不使用Spring的代码
    public static void main1(String[] args) {
            try {
                // 接口地址
                String address = "http://127.0.0.1:8080/services/payments?wsdl";
                // 代理工厂
                JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
                // 设置代理地址
                jaxWsProxyFactoryBean.setAddress(address);
                // 设置接口类型
                jaxWsProxyFactoryBean.setServiceClass(PaymentService.class);
                // 创建一个代理接口实现
                PaymentService paymentService = (PaymentService) jaxWsProxyFactoryBean.create();
                // 调用代理接口的方法调用并返回结果
                String result = paymentService.getPayment(12);
                System.out.println("返回结果:" + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
