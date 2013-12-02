# Tiles / mustache webapp example
Most web applications at FINN are built with Spring MVC, Apache Tiles and a JSP/mustache combination. 
This example is ment to illustrate how we combine these parts into a working web application and share the tricks we have learned along the way.

[![travis status](https://api.travis-ci.org/finn-no/tiles-mustache-example.png)](http://travis-ci.org/finn-no/tiles-mustache-example)

## Get it started
```shell
$ mvn jetty:run
```

## Why mustache?
There are mainly two reasons to why we tried mustache:
- logic-less
- share template between server and client

Logic-less and lack of features are very important. It forces developers to behave! As taglibs in JSP wonderland provide us all the magic in the world, we have often felt the need to fix (read: hack) complex problems in the top of our presentation layer. Such JSPs end up error prone and difficult to change without worrying about breaking something. 

If we ever had tests on these JSPs it would be cumbersome integration tests which takes ages to run and often didnt cover the functionality good enough. When using logic-less mustache templates it forces any business logic to be pushed further down the stack where it belongs and most importantly: unit tests! Providing developers instant feedback with unit tests which fails fast is how we like it.

We have to admit there are times when the lack of features in mustache feels silly. But the bottom line is that it helps us to do things better than we normally would have, it's the best of two evils!

The ability to share one and the same template when rendering serverside, then clientside on subsequent updates also helps us a great deal. It prevents duplication of logic and markup aswell as keeping our clientside scripts simpler.

Read more about mustache itself and supported languages on [mustache.github.io](http://mustache.github.io/)

## JSP <-> mustache
In a JSP when wanting to insert a mustache template, you use the tiles taglib as with ordinary JSPs.
```jsp
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertAttribute name="any_attribute_pointing_to_a_mustache_file" />
```

Within a mustache template all the tiles attributes configured are available as partials. But beware that trying to include a JSP as a partial will **fail**. You cannot leave the world of mustache once you have entered. That might seem like a major flaw, but remember that JSP cannot be rendered clientside which is one of reasons why one chooses mustache, remember?

Including a partial into a mustache template
```mustache
{{> any_tiles_attribute}}
```

### STILL WORK IN PROGRESS
