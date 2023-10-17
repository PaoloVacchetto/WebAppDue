package com.example.server


import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class ServerExceptionHandler : ResponseEntityExceptionHandler()  {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(e: NotFoundException) = ProblemDetail
        .forStatusAndDetail(HttpStatus.NOT_FOUND, e.message ?: "")


}