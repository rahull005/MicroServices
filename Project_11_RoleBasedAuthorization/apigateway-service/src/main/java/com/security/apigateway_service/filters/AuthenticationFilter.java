package com.security.apigateway_service.filters;

import com.security.apigateway_service.jwtutils.JwtUtil;
import com.security.apigateway_service.validator.RouteValidator;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    RouteValidator validator;

    @Autowired
    JwtUtil jwtUtil;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return((exchange, chain) -> {

            if(validator.isSecured.test(exchange.getRequest())){
                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                    throw new RuntimeException("Missing Authorization Header");
                }
                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                String token = null;

                if(authHeader != null && authHeader.startsWith("Bearer ")){
                    token = authHeader.substring(7);
                    try {
                        jwtUtil.validateToken(token);
                        Claims claims = jwtUtil.getClaims(token);
                        String username = claims.getSubject();

                        List<String> roles = claims.get("roles", List.class);
                        String roleHeader = String.join(",", roles);

                        ServerHttpRequest request = exchange.getRequest().mutate()
                                .header("X-User", username)
                                .header("X-Roles", roleHeader)
                                .build();

                        return chain.filter(exchange.mutate().request(request).build());
                    } catch (Exception e) {
                        System.out.println("invalid access...!");
                        throw new RuntimeException("un-authorized access to application");
                    }
                }
            }
            return chain.filter(exchange);
        });
    }

    public static class Config{

    }
}
