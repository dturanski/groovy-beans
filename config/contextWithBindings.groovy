package org.springframework.samples.groovy

beans {
    if (profiles.contains("prof1")) {
        foo String, mode == 'test'? 'test':'hello'
    } else {
        foo String, 'world'
    }
}
