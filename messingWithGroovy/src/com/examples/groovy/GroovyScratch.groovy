package com.examples.groovy
@Grab(group='org.ccil.cowan.tagsoup', module='tagsoup', version='1.2' )
class GroovyScratch {

	def doSomething(){
		"Here is something"
	}

	def fetchSomeHtml(){
		def tagsoupParser = new org.ccil.cowan.tagsoup.Parser()
		def slurper = new XmlSlurper(tagsoupParser)

		slurper.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false)
		def htmlParser = slurper.parse("http://www.usacycling.org/results/?compid=282794")

		htmlParser.'**'.findAll{ it.@class == 'homearticleheader'}.each{ println it }
	}
}
