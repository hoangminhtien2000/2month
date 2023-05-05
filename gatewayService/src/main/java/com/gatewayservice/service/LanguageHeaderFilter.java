//package com.gatewayservice.service;
//
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//@Component
//public class LanguageHeaderFilter implements GlobalFilter {
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//        String acceptLanguage = request.getHeaders().getFirst(HttpHeaders.ACCEPT_LANGUAGE);
//        if (acceptLanguage != null && !acceptLanguage.isEmpty()) {
//            exchange.getAttributes().put("acceptLanguage", acceptLanguage);
//            System.out.println("Accept-Language: " + acceptLanguage);
//            return chain.filter(exchange);
//        }
//        else {
//            System.out.println("Không có Accept-Language " );
//            String errorMessage = "Không có Accept-Language";
//            exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
//            exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
//            return exchange.getResponse().writeWith(Mono.just(exchange.getResponse()
//                    .bufferFactory().wrap(errorMessage.getBytes())));
//        }
//    }
//
//
//}
//
//
