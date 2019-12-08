package dev.lockedthread.longshot.enums;

public enum Message {

    COMMAND_ONLY_PLAYERS("&cYou can only use this command as a player!"),
    COMMAND_ONLY_NOT_PLAYING("You can't use this command because you are not playing!");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getKey() {
        return this.name().toLowerCase().replace('_', '-');
    }

    public String getMessage(String... strings) {
        String message = toString();
        if (strings.length >= 2) {
            for (int i = 0; i < strings.length; i += 2) {
                message = message.replace(strings[i], strings[i + 1]);
            }
        }
        return message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
