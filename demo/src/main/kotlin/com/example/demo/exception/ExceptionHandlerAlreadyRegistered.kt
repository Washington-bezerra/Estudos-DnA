package com.example.demo.exception

import com.example.demo.view.ErrorView
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandlerAlreadyRegistered {

    @ExceptionHandler(AlreadyRegistered::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    fun handleNotFound(expection: AlreadyRegistered, request: HttpServletRequest) : ErrorView{

        return ErrorView(
            status = HttpStatus.CONFLICT.value(),
            error = HttpStatus.CONFLICT.name,
            message = expection.message,
            path = request.servletPath
        )
    }
}