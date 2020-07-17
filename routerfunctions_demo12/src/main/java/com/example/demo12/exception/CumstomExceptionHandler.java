package com.example.demo12.exception;

import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

/**
 * 自定义异常处理器：当异常发生时返回400，并返回异常信息。
 * company: www.kaikeba.com
 * Author: Rey
 */
@Component
// 默认情况下系统内部定义的异常处理器的优先级要高于自定义异常处理器。可通过@Order指定优先级级别。
// 指定的数值越小，优先级越高。支持负数。
@Order(-99)
public class CumstomExceptionHandler implements WebExceptionHandler {
    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        // 获取Http响应对象
        ServerHttpResponse response = exchange.getResponse();
        // 设置响应码400
        response.setStatusCode(HttpStatus.BAD_REQUEST);
        // 设置响应类型普通文本
        response.getHeaders().setContentType(MediaType.TEXT_PLAIN);
        // 获取异常信息
        String message = this.formatExceptionMassage(ex);
        // 获取数据缓存对象
        DataBuffer buffer = response.bufferFactory().wrap(message.getBytes());
        // 给出响应
        return response.writeWith(Mono.just(buffer));
    }

    // 格式化异常信息
    private String formatExceptionMassage(Throwable ex) {
        // 发生普通异常后的信息
        String msg = "发生异常：" + ex.getMessage();
        // 发生StudentException后的信息
        if(ex instanceof StudentException) {
            StudentException e = (StudentException) ex;
            msg = msg + "【" + e.getErrField() + ":" + e.getErrValue() + "】";
        }
        return msg;
    }
}
