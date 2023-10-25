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

    @ExceptionHandler(DuplicateException::class)
    fun handleDuplicateException(e: DuplicateException) = ProblemDetail
        .forStatusAndDetail(HttpStatus.CONFLICT, e.message ?: "")


    @ExceptionHandler(NotValidException::class)
    fun handleNotValidException(e: NotValidException) = ProblemDetail
        .forStatusAndDetail(HttpStatus.UNPROCESSABLE_ENTITY, e.message?:"")

}