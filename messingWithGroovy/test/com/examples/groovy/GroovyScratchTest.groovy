package com.examples.groovy;

import static org.junit.Assert.*;

import org.junit.Test

class GroovyScratchTest {

	def groovyScratch = new GroovyScratch()
	
	@Test public void doSomethingWorks(){
		assert "Here is something" == groovyScratch.doSomething()
	}
	
	@Test public void tryGettingSomeHtml(){
		groovyScratch.fetchSomeHtml()
	}
}
