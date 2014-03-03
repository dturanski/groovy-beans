package org.springframework.samples.groovy

beans {
    // org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader
    if (environment.activeProfiles.contains("prof1")) {
        foo String, 'hello'
    } else {
        foo String, 'world'
    }
}
