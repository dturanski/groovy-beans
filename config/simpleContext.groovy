package org.springframework.samples.groovy

beans {
    framework String, 'Grails'
    foo String, 'hello'
    bar(Bar,s:'hello',i:123)
}
