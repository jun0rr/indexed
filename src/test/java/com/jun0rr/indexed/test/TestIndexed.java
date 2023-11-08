/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jun0rr.indexed.test;

import com.jun0rr.indexed.Indexed;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 *
 * @author Juno
 */
public class TestIndexed {
  
  @Test
  public void test() {
    AtomicInteger idx = new AtomicInteger(0);
    AtomicInteger val = new AtomicInteger((int)'a');
    IntStream.iterate((int)'a', i->i<=(int)'z', i->++i)
        .mapToObj(Integer::valueOf)
        .map(Indexed.builder())
        .peek(System.out::println)
        .peek(i->Assertions.assertEquals(idx.getAndIncrement(), i.index()))
        .forEach(i->Assertions.assertEquals(val.getAndIncrement(), i.value().intValue()))
        ;
  }
  
}
