---

### logback简单日志配置
spring boot内部使用Commons Logging来记录日志，但也保留外部接口可以让一些日志框架来进行实现，例如Java Util Logging,Log4J2还有Logback。如果你想用某一种日志框架来进行实现的话，就必须先配置，默认情况下，spring boot使用Logback作为日志实现的框架。

---

默认情况下，spring boot从控制台打印出来的日志级别只有ERROR, WARN 还有INFO，如果你想要打印debug级别的日志，可以通过application.properites配置debug=true

#### 配置logging.level.*来具体输出哪些包的日志级别
logging.level.root=INFO
logging.level.org.springframework.web=DEBUG
logging.level.org.hibernate=ERROR

#### 配置日志路径
logging.path=F:\\demo
logging.file=demo.log
logging.level.root=info

### logback 介绍



### logback取代log4j的理由
   Logback和log4j是非常相似的，如果你对log4j很熟悉，那对logback很快就会得心应手。下面列了logback相对于log4j的一些优点：

* **更快的实现**  Logback的内核重写了，在一些关键执行路径上性能提升10倍以上。而且logback不仅性能提升了，初始化内存加载也更小了。

* **非常充分的测试**  Logback经过了几年，数不清小时的测试。Logback的测试完全不同级别的。在作者的观点，这是简单重要的原因选择logback而不是log4j。

* **Logback-classic非常自然实现了SLF4j** Logback-classic实现了 SLF4j。在使用SLF4j中，你都感觉不到logback-classic。而且因为logback-classic非常自然地实现了SLF4J，  所 以切换到log4j或者其他，非常容易，只需要提供成另一个jar包就OK，根本不需要去动那些通过SLF4JAPI实现的代码。

* **非常充分的文档**  官方网站有两百多页的文档。

* **自动重新加载配置文件** 当配置文件修改了，Logback-classic能自动重新加载配置文件。扫描过程快且安全，它并不需要另外创建一个扫描线程。这个技术充分保证了应用程序能跑得很欢在JEE环境里面。

* **Lilith**   Lilith是log事件的观察者，和log4j的chainsaw类似。而lilith还能处理大数量的log数据 。

* **谨慎的模式和非常友好的恢复** 在谨慎模式下，多个FileAppender实例跑在多个JVM下，能 够安全地写道同一个日志文件。RollingFileAppender会有些限制。Logback的FileAppender和它的子类包括 RollingFileAppender能够非常友好地从I/O异常中恢复。

* **配置文件可以处理不同的情况** 开发人员经常需要判断不同的Logback配置文件在不同的环境下（开发，测试，生产）。而这些配置文件仅仅只有一些很小的不同，可以通过,和来实现，这样一个配置文件就可以适应多个环境。

* **Filters（过滤器）** 有些时候，需要诊断一个问题，需要打出日志。在log4j，只有降低日志级别，不过这样会打出大量的日志，会影响应用性能。在Logback，你可以继续 保持那个日志级别而除掉某种特殊情况，如alice这个用户登录，她的日志将打在DEBUG级别而其他用户可以继续打在WARN级别。要实现这个功能只需 加4行XML配置。可以参考MDCFIlter 。

* **SiftingAppender（一个非常多功能的Appender）** 它可以用来分割日志文件根据任何一个给定的运行参数。如，SiftingAppender能够区别日志事件跟进用户的Session，然后每个用户会有一个日志文件。

* **自动压缩已经打出来的log** RollingFileAppender在产生新文件的时候，会自动压缩已经打出来的日志文件。压缩是个异步过程，所以甚至对于大的日志文件，在压缩过程中应用不会受任何影响。

* **堆栈树带有包版本** Logback在打出堆栈树日志时，会带上包的数据。

* **自动去除旧的日志文件** 通过设置TimeBasedRollingPolicy或者SizeAndTimeBasedFNATP的maxHistory属性，你可以控制已经产生日志文件的最大数量。如果设置maxHistory 1. 那那些log文件超过12个月的都会被自动移除。
