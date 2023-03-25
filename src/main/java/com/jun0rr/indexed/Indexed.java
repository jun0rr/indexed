/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jun0rr.indexed;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/**
 *
 * @author Juno
 */
public record Indexed<T>(int index, T value) {
  
  public static <U> Function<U,Indexed<U>> indexed(int start) {
    AtomicInteger i = new AtomicInteger(start);
    return o->new Indexed(i.getAndIncrement(), o);
  }
  
  public static <U> Function<U,Indexed<U>> indexed() {
    return indexed(0);
  }
  
}
