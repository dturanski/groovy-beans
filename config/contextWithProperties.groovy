package org.springframework.samples.groovy

import org.springframework.core.io.ClassPathResource

def properties = new Properties()
properties.load(new ClassPathResource('spring.properties').inputStream);

beans {
    if (properties.color=='red') {
        foo String, 'hello'
    } else {
        foo String, 'world'
    }
}
