```
bin/flume-ng agent --conf conf --conf-file job/netcat-flume-logger.conf --name a1 -Dflume.root.logger=INFO,console

bin/flume-ng agent -n $agent_name -c conf -f conf/flume-conf.properties.template
```

