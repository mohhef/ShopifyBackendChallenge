package com.imagenest.exception;

public class ExceptionType {

  public static class IoException extends RuntimeException {

    public IoException(String s) {
      super(s);
    }
  }

  public static class IdNotFoundException extends RuntimeException {

    public IdNotFoundException(String s) {
      super(s);
    }
  }
}
