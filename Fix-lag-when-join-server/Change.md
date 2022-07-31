ServerAddress.fromString(serverData.serverIP); in the thread because there is a lag when processing it

I have created two separate methods for connecting locally and connecting to a server.

Before
```java
    public GuiConnecting(GuiScreen p_i1181_1_, Minecraft mcIn, ServerData p_i1181_3_)
    {
        this.mc = mcIn;
        this.previousGuiScreen = p_i1181_1_;
        ServerAddress serveraddress = ServerAddress.fromString(p_i1181_3_.serverIP); //Lag occurs when processing this
        mcIn.loadWorld(null);
        mcIn.setServerData(p_i1181_3_);
        this.connect(serveraddress.getIP(), serveraddress.getPort());
    }
```
After
```java
    public GuiConnecting(GuiScreen p_i1181_1_, Minecraft mcIn, ServerData p_i1181_3_)
    {
        this.mc = mcIn;
        this.previousGuiScreen = p_i1181_1_;
        mcIn.loadWorld(null);
        mcIn.setServerData(p_i1181_3_);
        this.connectServerData(p_i1181_3_); //Put ServerData instead of IP, Port directly.
    }
```

```java
        //Insert these codes in public void run()
        ServerAddress serveraddress = ServerAddress.fromString(serverData.serverIP); //Parallel processing of lagged portions
        String ip = serveraddress.getIP();
        int port = serveraddress.getPort();
```
