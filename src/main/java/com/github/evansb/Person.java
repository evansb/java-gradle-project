package com.github.evansb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Person {
  @NonNull private String name;
  private int age;
}
