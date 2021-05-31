package com.project.blog.exception;

class NotFoundEx extends RuntimeException{
    public NotFoundEx(String message){super(message);}
    public NotFoundEx(String message, Throwable cause){super(message,cause);
    }
}
