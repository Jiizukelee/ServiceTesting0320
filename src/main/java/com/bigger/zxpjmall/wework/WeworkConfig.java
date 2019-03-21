package com.bigger.zxpjmall.wework;

public class WeworkConfig {
    public String agentId = "1000002";
    public String secret = "CLSNLFADacD-UYUJG7dkx1ZTT3yqp9z58yH2HsMUEpQ";
    public String contactSecret = "N4hlTYPuyD1L8GgbK6suhf-kJ8hKQ8RTWK0WsgsR63M";
    public String corpid = "ww606c3e9c019cd26d";

    private WeworkConfig(){}
    private static WeworkConfig weworkConfig;
    public  static synchronized  WeworkConfig getInstance(){
        if (weworkConfig == null){
            weworkConfig = new WeworkConfig();
        }
        return weworkConfig;
    }

}
