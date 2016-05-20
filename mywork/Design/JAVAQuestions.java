Garbage collection in Java
-----------------------------------------------------------
    Generational GC
        Mark, Delete/Sweep, Compacting
        Eden Gen/Young Gen and Old Gen
        Minor GC and Major GC
        Eden Gen => Survivor space 1 & Survivor Space 2, survivor cycles
        --XXMaxTenuringThreshold => Number of cycle by which an opject need to
                survive to get promoted from Eden space to Old space
        Latency/Responsiveness
        Types of GC
            (a) Serial GC
            (b) Concurrent GC
            (c) Parallel GC
            (d) G1 GC (Garbage First) - Java 1.7
        Selecting GC
            -XX:+UseSerialGC
            -XX:+UseParallelGC
            -XX:+UseConcMarkSweepGC
            -XX:+UseG1GC
        Tuning the heap
            -Xmsvalue
            -Xmxvalue  (256 MB)
            -XX:PermSize
            -XX:MaxPermSize (64 MB)
        GC logging
            -verbose:gc
            -XX:PrintGCDetatils
            -Xloggc:gc.log
        Tools
            jvisualvm with visual gc plugin


Class loading in Java
------------------------------------------------------------
    Types of Class loaders
        Application CL (CLASSPATH -classpath -cp Manifest)
        Extension CL (jre/lib/rt.jar)
        Bootstrap CL (jre/lib/ext)
    Class.forName("classname"), Class.forName("classname", )
    Object.class.getClassLoader().getParent() => Ext class loader
