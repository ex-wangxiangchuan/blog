package com.wanxp.blog.constant;

import java.util.Arrays;

public enum ICON {
    BOOK("bg-ico-book"),
    GAME("bg-ico-game"),
    NOTE( "bg-ico-note"),
    CHAT( "bg-ico-chat"),
    CODE( "bg-ico-code"),
    IMAGE( "bg-ico-image"),
    WEB( "bg-ico-web"),
    LINK( "bg-ico-link"),
    DESIGN( "bg-ico-design"),
    LOCK("bg-ico-lock");

    private String iconClassName;

    private ICON(String iconClassName) {
        this.iconClassName = iconClassName;
    }

    public String getIconClassName() {
        return iconClassName;
    }

    public static ICON getICON(String iconClassName) {
        return Arrays.stream(ICON.values()).filter(x ->
            x.name().equals(iconClassName)).findFirst().orElse(BOOK);
    }

}
