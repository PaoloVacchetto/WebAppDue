package com.example.server


class NotFoundException(message: String) : RuntimeException(message)
class DuplicateException(message: String) : RuntimeException(message)
class NotValidException(message: String) : RuntimeException(message)