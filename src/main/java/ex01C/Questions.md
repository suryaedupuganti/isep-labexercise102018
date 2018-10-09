## Questions

### Q1. In the lo4j.properties, change the level from INFO to DEBUG, what happens?

When the level is INFO, only INFO related logs are displayed, as:
```
12:02:33,306  INFO Log4jBasics:11 - INFO: Cool !
```

If we change the level from INFO to DEBUG, the output is:
```
12:01:14,481 DEBUG Log4jBasics:10 - DEBUG: Cool !
12:01:14,482  INFO Log4jBasics:11 - INFO: Cool !
```