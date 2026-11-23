import java.util.Map;

public class ConfiguracaoJogo {

    private final String appId;
    private final String userName;
    private final String language;
    private final String offline;
    private final String autoDlc;
    private final String buildId;
    private final String dlcName;
    private final String updateDb;
    private final String signature;
    private final String windowInfo;
    private final String lvWindowInfo;
    private final String applicationPath;
    private final String workingDirectory;
    private final String waitForExit;
    private final String noOperation;

    public ConfiguracaoJogo(Map<String, String> valores) {
        this.appId = valores.getOrDefault("AppId", "");
        this.userName = valores.getOrDefault("UserName", "");
        this.language = valores.getOrDefault("Language", "");
        this.offline = valores.getOrDefault("Offline", "");
        this.autoDlc = valores.getOrDefault("AutoDLC", "");
        this.buildId = valores.getOrDefault("BuildId", "");
        this.dlcName = valores.getOrDefault("DLCName", "");
        this.updateDb = valores.getOrDefault("UpdateDB", "");
        this.signature = valores.getOrDefault("Signature", "");
        this.windowInfo = valores.getOrDefault("WindowInfo", "");
        this.lvWindowInfo = valores.getOrDefault("LVWindowInfo", "");
        this.applicationPath = valores.getOrDefault("ApplicationPath", "");
        this.workingDirectory = valores.getOrDefault("WorkingDirectory", "");
        this.waitForExit = valores.getOrDefault("WaitForExit", "");
        this.noOperation = valores.getOrDefault("NoOperation", "");
    }

    public String getAppId() {
        return appId;
    }

    public String getUserName() {
        return userName;
    }

    public String getLanguage() {
        return language;
    }

    public String getOffline() {
        return offline;
    }

    public String getAutoDlc() {
        return autoDlc;
    }

    public String getBuildId() {
        return buildId;
    }

    public String getDlcName() {
        return dlcName;
    }

    public String getUpdateDb() {
        return updateDb;
    }

    public String getSignature() {
        return signature;
    }

    public String getWindowInfo() {
        return windowInfo;
    }

    public String getLvWindowInfo() {
        return lvWindowInfo;
    }

    public String getApplicationPath() {
        return applicationPath;
    }

    public String getWorkingDirectory() {
        return workingDirectory;
    }

    public String getWaitForExit() {
        return waitForExit;
    }

    public String getNoOperation() {
        return noOperation;
    }

    @Override
    public String toString() {
        return "AppId=" + appId + System.lineSeparator()
                + "UserName=" + userName + System.lineSeparator()
                + "Language=" + language + System.lineSeparator()
                + "Offline=" + offline + System.lineSeparator()
                + "AutoDLC=" + autoDlc + System.lineSeparator()
                + "BuildId=" + buildId + System.lineSeparator()
                + "DLCName=" + dlcName + System.lineSeparator()
                + "UpdateDB=" + updateDb + System.lineSeparator()
                + "Signature=" + signature + System.lineSeparator()
                + "WindowInfo=" + windowInfo + System.lineSeparator()
                + "LVWindowInfo=" + lvWindowInfo + System.lineSeparator()
                + "ApplicationPath=" + applicationPath + System.lineSeparator()
                + "WorkingDirectory=" + workingDirectory + System.lineSeparator()
                + "WaitForExit=" + waitForExit + System.lineSeparator()
                + "NoOperation=" + noOperation;
    }
}
