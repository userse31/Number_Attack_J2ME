import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

//Fucking hell. What a TERRIBLE programming language.

public class Game_PRICE extends MIDlet {
    public void startApp(){
        final Cunt ass=new Cunt();
        ass.start();
        ass.addCommand(new Command("Exit",Command.EXIT,0));
        ass.setCommandListener(new CommandListener(){
            public void commandAction(Command c,Displayable s){
                    ass.stop();
                    notifyDestroyed();
            }
        });
        Display.getDisplay(this).setCurrent(ass);
    }

    protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
    }

    protected void pauseApp() {
    }
}