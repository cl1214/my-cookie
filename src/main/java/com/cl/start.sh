rm -f tpid
nohup java -Xms50m -Xmx50m -XX:+HeapDumpOnOutOfMemoryError  -XX:HeapDumpPath=/usr/local/software/my-cookie/bin -jar ./memory-out-1.0-SNAPSHOT.jar > log-memory-out.log 2>&1 &
echo $! > tpid
echo Start Success!
tail -f log-memory-out.log
