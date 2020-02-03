package org.springframework.samples.beans

beans {
    framework String, 'Grails'
    foo String, 'hello'
    bar(Bar, s:'hello', i:123)
}
