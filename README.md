<div id="table-of-contents">
<h2>Table of Contents</h2>
<div id="text-table-of-contents">
<ul>
<li><a href="#sec-1">1. Introduction</a></li>
<li><a href="#sec-2">2. Dropwizard tutorial</a></li>
</ul>
</div>
</div>


# Introduction

Develop REST web services with:
-   [Dropwizard](https://dropwizard.github.io/dropwizard/index.html)
-   [Gradle](http://www.gradle.org)
-   java 8

# Dropwizard tutorial

It is a gradle version of the [tutorial](https://dropwizard.github.io/dropwizard/getting-started.html).

    gradle --daemon
    gradle clean build
    gradle shadowJar
    java -jar build/libs/dropwizard-tutorial-1.0-all.jar server hello-world.yml
