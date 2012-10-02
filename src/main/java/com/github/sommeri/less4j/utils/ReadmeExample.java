package com.github.sommeri.less4j.utils;

import com.github.sommeri.less4j.ILessCompiler;
import com.github.sommeri.less4j.core.DefaultLessCompiler;

public class ReadmeExample {
  public static void main(String[] args) {
    ILessCompiler compiler = new DefaultLessCompiler();
    String css = compiler.compile("* { margin: 1 1 1 1; }");
    System.out.println(css);
  }
}