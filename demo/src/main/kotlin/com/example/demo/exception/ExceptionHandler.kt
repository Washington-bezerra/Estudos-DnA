package com.example.demo.exception

import com.example.demo.view.ErrorView
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(expection: NotFoundException, request: HttpServletRequest) : ErrorView{

        return ErrorView(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = expection.message,
            path = request.servletPath
        )
    }

    @ExceptionHandler(AlreadyRegisteredException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    fun handleAlreadyRegisteredException(expection: AlreadyRegisteredException, request: HttpServletRequest) : ErrorView{

        return ErrorView(
            status = HttpStatus.CONFLICT.value(),
            error = HttpStatus.CONFLICT.name,
            message = expection.message,
            path = request.servletPath
        )
    }

    @ExceptionHandler(BadRequestException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleBadRequest(expection: BadRequestException, request: HttpServletRequest) : ErrorView{

        return ErrorView(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = expection.message,
            path = request.servletPath
        )
    }
}