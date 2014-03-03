/*
 *
 *  * Copyright 2014 the original author or authors.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  * http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package org.springframework.samples.groovy;

import groovy.lang.Binding;
import my.beans.Foo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import static org.junit.Assert.assertEquals;

public class GroovyBeanBuilderTests {
    @Test
    public void testSimple() {
        ApplicationContext context = new GenericGroovyApplicationContext("file:config/simpleContext.groovy");
        String foo =  context.getBean("foo",String.class);

        assertEquals("hello",foo);
        Bar bar = context.getBean("bar",Bar.class);
        assertEquals(123,bar.getI());
    }

    @Test
    public void testVariableIdAndClass() {
        ApplicationContext context = new GenericGroovyApplicationContext("file:config/contextWithVariableIdAndClass.groovy");
        String foo =  context.getBean("foo",String.class);

        assertEquals("hello",foo);
        Bar bar = context.getBean("bar",Bar.class);
        assertEquals(123,bar.getI());
    }


    @Test
    public void testProfiles() {
        GenericGroovyApplicationContext context = new GenericGroovyApplicationContext();

        context.getEnvironment().addActiveProfile("prof1");
        context.load("file:config/contextWithProfiles.groovy");
        context.refresh();
        String foo =  context.getBean("foo",String.class);
        assertEquals("hello",foo);
    }
    @Test
    public void testProfiles2() {
        GenericGroovyApplicationContext context = new GenericGroovyApplicationContext("file:config/contextWithProfiles.groovy");
        String foo =  context.getBean("foo",String.class);
        assertEquals("world",foo);
    }

    @Test
    public void testConfig() {
        ApplicationContext context = new GenericGroovyApplicationContext("file:config/contextWithConfig.groovy");
        String foo =  context.getBean("foo",String.class);
        assertEquals("hello",foo);
    }

    @Test
    public void testProperties() {
        ApplicationContext context = new GenericGroovyApplicationContext("file:config/contextWithProperties.groovy");
        String foo =  context.getBean("foo",String.class);
        assertEquals("hello",foo);
    }

    @Test
    public void testBindings() {
        GenericGroovyApplicationContext context = new GenericGroovyApplicationContext();
        context.getEnvironment().addActiveProfile("prof1");

        Binding binding = new Binding();
        binding.setVariable("profiles",context.getEnvironment().getActiveProfiles());
        binding.setVariable("mode","test");

        context.getReader().setBinding(binding);

        context.load("file:config/contextWithBindings.groovy");
        context.refresh();
        String foo =  context.getBean("foo",String.class);
        assertEquals("test",foo);
    }

    @Test
    public void testComponentScan() {
        ApplicationContext context = new GenericGroovyApplicationContext("file:config/contextComponentScan.groovy");
        Foo foo = context.getBean(Foo.class);
    }

    @Test(expected = org.springframework.beans.factory.BeanDefinitionStoreException.class)
    public void testComponentScanWithXml() {
        ApplicationContext context = new FileSystemXmlApplicationContext("config/contextComponentScan.xml");
        Foo foo = context.getBean(Foo.class);
    }
}
