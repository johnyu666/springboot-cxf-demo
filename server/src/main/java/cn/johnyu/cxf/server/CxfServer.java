package cn.johnyu.cxf.server;

import cn.johnyu.common.service.PaymentService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.xml.ws.Endpoint;

@SpringBootApplication
public class CxfServer {
    public static void main(String[] args) {
        SpringApplication.run(CxfServer.class,args);
    }
    @Autowired
    private Bus bus;
    @Autowired
    private PaymentService paymentService;

    @Bean
    public Endpoint userEndpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus,paymentService);
        endpoint.publish("/payments");
        return endpoint;
    }
}
