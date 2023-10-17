package eu.pedrazamiguez.newsaggregator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NewsAggregatorApplication

fun main(args: Array<String>) {
	runApplication<NewsAggregatorApplication>(*args)
}
