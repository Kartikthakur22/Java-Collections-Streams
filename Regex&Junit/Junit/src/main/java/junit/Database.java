package junit;

public class Database {
    public boolean connection=false;
    public void connect(){
        connection=true;
    }
    public void disconnect(){
        connection=false;
    }
    public boolean isConnected(){
        return connection==true;
    }
}
