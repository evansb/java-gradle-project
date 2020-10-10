package com.github.evansb;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class PersonTest {

  @Test
  void test() {
    var person = new Person("Evan", 20);
    assertThat(person.getAge()).isEqualTo(20);
    assertThat(person.getName()).isEqualTo("Evan");
  }
}
