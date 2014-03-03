package org.springframework.samples.groovy

import org.springframework.core.io.ClassPathResource

def url = new ClassPathResource('spring.config').URL;
def config = new ConfigSlurper().parse(url);

beans {
    xmlns([ctx:'http://www.springframework.org/schema/context'])
    ctx.'component-scan'('base-package':config.basePackage)
}