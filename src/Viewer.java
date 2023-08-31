/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Qwerty
 */
import java.util.Random;
import javax.microedition.lcdui.*;

class Cunt extends Canvas implements Runnable {
    public Cunt(){
        this.setCommandListener(new CommandListener() {
            public void commandAction(Command c, Displayable d) {
                System.out.println(c);
            }
        });
    }
    //public int i=0;
    public boolean do_run=false;

    //Game variables
    int GAMEPLAY=0;
    int GAMEEND=1;
    int state=GAMEPLAY;
    int enemy_val=0;
    int enemy_x=0;
    int enemy_y=0;
    int DELAY_MIN=100;
    int DELAY_CONST=2;
    int delay=1000;
    long score=0;
    int wands=0;
    int wand_y=-1;
    Random _rand=new Random();
    int rand_const=_rand.nextInt(65535);
    char wall[]={0,0,0,0,0,0,0,0,0,0,0,0};
    
    protected void paint(Graphics g) {
        /*g.setColor(0x000000);
        g.fillRect(0,0,getWidth(),getHeight());*/
        g.setColor(0xFFFFFF);
        g.fillRect(0,0,128,160);
        g.setColor(0x000000);
        //g.drawString(String.valueOf(i), 10, 10, 0);
        if(state==GAMEEND){
            g.drawString("Game Over!", 0, (wall.length+1)*9, 0);
        }
        if(do_run==false){
            g.drawString("Paused", 0, (wall.length+2)*9, 0);
        }
        for(int i=0;i<wall.length;i++){
            if(wall[i]==0){
                g.drawString("#", 0, i*9, 0);
            }
        }
        if(wand_y!=-1){
            g.drawString("¥", 9*3, (wand_y)*9, 0);
        }
        g.drawString(String.valueOf(enemy_val), enemy_x*8, (enemy_y)*9, 0);
        g.drawString("Score:"+String.valueOf(score), 0, (wall.length)*9, 0);
        if(state==GAMEEND){
            g.drawString("Game Over!", 0, (wall.length+1)*9, 0);
        }else{
            g.drawString("¥:"+String.valueOf(wands)+" Wait:"+String.valueOf(delay), 0, ((wall.length+1)*9), 0);
        }
    }
    public void run() {
        while(do_run){
            if(state==GAMEEND){
                repaint();
            }
            if(state==GAMEPLAY){
                //i++;
                repaint();
                if(enemy_x==0){
                    if(wall[enemy_y]==0){
                        wall[enemy_y]=1;
                    }else{
                        state=GAMEEND;
                    }
                    if(state==GAMEPLAY){
                        new_enemy();
                    }
                }
                enemy_x--;
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    public void new_enemy(){
        enemy_val=rand_const%10;
        enemy_y=rand_const%(wall.length);
        enemy_x=15;
        rand_const=Math.abs((5*rand_const+1)%65536);
        if(rand_const%3==0){
            wand_y=_rand.nextInt(65535)%(wall.length);
        }else{
            wand_y=-1;
        }
    }
    public void start() {
        Thread t=new Thread(this);
        t.start();
        new_enemy();
        do_run=true;
    }
    public void stop(){
        do_run=false;
    }
    protected void keyPressed(int keyCode){
        if(do_run==false || state!=GAMEPLAY){
            return;
        }
        switch(keyCode){
            case Canvas.KEY_NUM0:
                if(enemy_val==0){
                    new_enemy();
                    if(wand_y==enemy_y){
                        wands++;
                    }
                    score++;
                    delay=(delay>DELAY_MIN?delay-DELAY_CONST:DELAY_MIN);
                    repaint();
                }
                break;
            case Canvas.KEY_NUM1:
                if(enemy_val==1){
                    new_enemy();
                    if(wand_y==enemy_y){
                        wands++;
                    }
                    score++;
                    delay=(delay>DELAY_MIN?delay-DELAY_CONST:DELAY_MIN);
                    repaint();
                }
                break;
            case Canvas.KEY_NUM2:
                if(enemy_val==2){
                    enemy_val--;
                    repaint();
                }
                break;
            case Canvas.KEY_NUM3:
                if(enemy_val==3){
                    enemy_val--;
                    repaint();
                }
                break;
            case Canvas.KEY_NUM4:
                if(enemy_val==4){
                    enemy_val--;
                    repaint();
                }
                break;
            case Canvas.KEY_NUM5:
                if(enemy_val==5){
                    enemy_val--;
                    repaint();
                }
                break;
            case Canvas.KEY_NUM6:
                if(enemy_val==6){
                    enemy_val--;
                    repaint();
                }
                break;
            case Canvas.KEY_NUM7:
                if(enemy_val==7){
                    enemy_val--;
                    repaint();
                }
                break;
            case Canvas.KEY_NUM8:
                if(enemy_val==8){
                    enemy_val--;
                    repaint();
                }
                break;
            case Canvas.KEY_NUM9:
                if(enemy_val==9){
                    enemy_val--;
                    repaint();
                }
                break;
            case Canvas.KEY_POUND:
                if(wands>0){
                    for(int i=0;i<wall.length;i++){
                        wall[i]=0;
                    }
                    wands--;
                    repaint();
                }
                break;
        }
    }
}
