package org.springframework.samples.beans

beans {
    if (profiles.contains("prof1")) {
        foo String, mode == 'test'? 'test':'hello'
    } else {
        foo String, 'world'
    }
}
