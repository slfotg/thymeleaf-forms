package com.github.slfotg;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.ha.tcp.SimpleTcpCluster;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class TomcatCustomizer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        factory.addContextCustomizers(context -> {
            context.getParent().getParent().setCluster(new SimpleTcpCluster());
        });
        factory.addAdditionalTomcatConnectors(redirectConnector());
    }

    private Connector redirectConnector() {
        Connector connector = new Connector("AJP/1.3");
        connector.setScheme("http");
        connector.setPort(8009);
        connector.setSecure(false);
        connector.setAllowTrace(false);
        return connector;
     }
}
