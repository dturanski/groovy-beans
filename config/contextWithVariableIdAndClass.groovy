package org.springframework.samples.beans

def id1='bar'
def clazz=Bar.class

beans {
    framework String, 'Grails'
    foo String, 'hello'
    "$id1"(clazz, s:'hello', i:123)
}
