package com.rivittv.aws;

public enum Accounts {
    dev("959585562641"),
    qa("161105178057"),
    stage("234742742555"),
    prod("449332660992"),
    shared("638837820455")

    private String accountId;
    
    public Accounts(String accountName) {
        this.accountId = accountName;
    };
    
    public String getAccountId() {
        return accountId;
    }
}
