package com.examples.groovy
class GroovyScratch {

	def doSomething(){
		"Here is something"
	}

	def fetchSomeHtml(){
		def tagsoupParser = new org.ccil.cowan.tagsoup.Parser()
		def slurper = new XmlSlurper(tagsoupParser)
		// 		this line wouldn't work...
		//		slurper.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false)
		def parsedHtml = slurper.parse("http://www.usacycling.org/results/index.php?compid=282794")
		//def parsedHtml = slurper.parse("/home/bruzer/projects/testGithubRepo/messingWithGroovy/test/results282794.html")

		println "printing homearticlebody"
		parsedHtml.'**'.findAll{ it.@class == 'homearticlebody'}.each{ dateAndLocation ->
			boolean doDifferentStuff 
			if(dateAndLocation.@colspan == '7'){
				println "there is a colspan"
			}
			else{
				doDifferentStuff = true
			}

			println "----child nodes----"
			println "how many children? " + dateAndLocation.childNodes().size()
			
			if(doDifferentStuff){
				println "  Rank: " + dateAndLocation?.childNodes()[0]?.text()
				println "Points: " + dateAndLocation?.childNodes()[1]?.text()
				println "  Name: " + dateAndLocation?.childNodes()[2]?.text()
				println " USAC#: " + dateAndLocation?.childNodes()[3]?.text()
				println "  Time: " + dateAndLocation?.childNodes()[4]?.text()
				println "  Bib#: " + dateAndLocation?.childNodes()[5]?.text()
				println "  Team: " + dateAndLocation?.childNodes()[6]?.text()
			}
		}
	}

	def main(String[] args){
		fetchSomeHtml()
	}
}
