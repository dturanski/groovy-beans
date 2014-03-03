package org.springframework.samples.groovy

import org.springframework.core.io.ClassPathResource

def url = new ClassPathResource('spring.config').URL;
def config = new ConfigSlurper().parse(url);

beans {
    if (config.color=='red') {
        foo String, 'hello'
    } else {
        foo String, 'world'
    }
}
