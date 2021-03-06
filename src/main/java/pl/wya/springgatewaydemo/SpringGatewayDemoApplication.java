package pl.wya.springgatewaydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
@RestController
public class SpringGatewayDemoApplication {

	@RequestMapping("/")
	public String root() {
		return "Gateway Up and Running!";
	}

	@Bean
	RouteLocator testRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
				.route("test", r -> r.path("/test/**").filters(f -> f.rewritePath("/test(?<path>.*)", "/${path}")).uri("https://www.google.com"))
				.route("get", r -> r.path("/get/**").filters(f -> f.addRequestHeader("X-Gateway-Test", "Foo")).uri("https://httpbin.org")).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringGatewayDemoApplication.class, args);
	}

}
