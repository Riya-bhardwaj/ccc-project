import javax.imageio.ImageIO;
import java.awt.event.*;
import java.util.Random;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BouncingBall extends JFrame implements MouseListener {

    static boolean hiddenballoon []= new boolean [4];

    static int score = 0;

    BouncingBall() {
        this.addMouseListener(this);
    }

    private static Graphics graphics;
    static int Score=0;
    static int num = 0;
    static int xCord[] = new int[4];
    static int yCord[] = new int[4];
    static int prizeX, prizeY;
    static int bX, bY;
    static boolean blackHidden = false;
    static boolean parasuit=false;
    static int t[] = new int[4];
    static int b = 1;
    static int yCord1 = 0;
    static int y1 = 0;
    static Image im1 = null;
    static int angryX;
    static  int angryY;
    static boolean hiddenangry;
    static  int number=0;

    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        for (int i = 0; i < 4; i++) {
            t[i] = 0;
        }
        //for(int a=0;a<4;a++)
         // hiddenballoon=false;
        hiddenballoon[0]=false;
        hiddenballoon[1]=false;
        hiddenballoon[2]=false;
        hiddenballoon[3]=false;
        hiddenangry=false;


        panel.setPreferredSize(new Dimension(800, 800));
        frame.setVisible(true);
        /* JButton b = new JButton("riya"); */
        frame.setFocusable(true);
        frame.add(panel);

        BouncingBall ball = new BouncingBall();

        frame.addMouseListener(ball);
        frame.pack();
        // frame.add(b);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        graphics = panel.getGraphics();

        //  Image im1=null;
        Image imgP = null;
        Image imgB = null;
        Image background = null;
        Image angry=null;
        Image blue=null;

        graphics.setColor(Color.blue);

          background = ImageIO.read(BouncingBall.class.getClassLoader().getResource("images/a2.jpg"));
        im1 = ImageIO.read(BouncingBall.class.getClassLoader().getResource("images/balloon1cs.png"));
        imgP = ImageIO.read(BouncingBall.class.getClassLoader().getResource("images/para.png"));
        imgB = ImageIO.read(BouncingBall.class.getClassLoader().getResource("images/bomb.png"));
        angry= ImageIO.read(BouncingBall.class.getClassLoader().getResource("images/angrybird.png"));
        blue = ImageIO.read(BouncingBall.class.getClassLoader().getResource("images/blue .png"));
                //catch (IOException e) {
        //e.printStackTrace();

        Random disc = new Random();

        int yVel = 10;
        yCord[0]=-200;
        yCord[1]=-300;
        yCord[2]=-400;
        yCord[3]=-500;
        prizeY=-450;
        angryY=-450;



        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (yCord[0] == -150)
                xCord[0] =  30+ disc.nextInt(700);
            if (yCord[1] == -150)
                xCord[1] =  40+ disc.nextInt(700);
            if (yCord[2] == -150)
                xCord[2] =  50+ disc.nextInt(700);
            if (yCord[3] == -150)
                xCord[3] =  60+ disc.nextInt(670);

           if (prizeY == -150)
                prizeX = 40 + disc.nextInt(700);



         // if (prizeY > 800)               prizeY = 0;

            prizeY += 10;
           bY += 10;
           angryY+=10;

            graphics.clearRect(0, 0, 800, 800);
           // graphics.drawImage(background,0,0,null);



            if ((!hiddenballoon[0]) ||(yCord[0]>=850 && hiddenballoon[0]))
            {
                if (hiddenballoon[0]){
                    hiddenballoon[0] = false;
                }

                if(yCord[0]>850){
                    yCord[0]=-100;
                }
                graphics.drawImage(im1, xCord[0], yCord[0], null);

            }
            yCord[0] += yVel;



            if ((!hiddenballoon[1]) ||(yCord[0]>=900 && hiddenballoon[1]))
            {
                if (hiddenballoon[1]){
                    hiddenballoon[1] = false;
                }

                if(yCord[1]>850){
                    yCord[1]=-200;
                }
                graphics.drawImage(im1, xCord[1], yCord[1], null);
                number++;
            }
            yCord[1] += yVel;




            if ((!hiddenballoon[2]) ||(yCord[2]>=950 && hiddenballoon[2]))
            {
                if (hiddenballoon[2]){
                    hiddenballoon[2] = false;
                }

                if(yCord[2]>850){
                    yCord[2]=-300;
                }
                graphics.drawImage(im1, xCord[2], yCord[2], null);

            }
            yCord[2] += yVel;




            if ((!hiddenballoon[3]) ||(yCord[3]>=850 && hiddenballoon[3]))
            {
                if (hiddenballoon[3]){
                    hiddenballoon[3] = false;
                }

                if(yCord[3]>850){
                    yCord[3]=-350;
                }
                graphics.drawImage(im1, xCord[3], yCord[3], null);

            }
            yCord[3] += yVel;





            if ((!hiddenballoon[3]) ||(yCord[3]>=850 && hiddenballoon[3]))
            {
                if (hiddenballoon[3]){
                    hiddenballoon[3] = false;
                }

                if(yCord[3]>850){
                    yCord[3]=-350;
                }
                graphics.drawImage(im1, xCord[3], yCord[3], null);

            }




            if (!hiddenangry ||(angryY>=850 && hiddenangry))
            {
                if (hiddenangry){
                    hiddenangry = false;
                }

                if(angryY>850){
                    angryY=-100;
                }
                graphics.drawImage(angry, angryX, angryY, null);
            }




            if(score>100)
              im1=blue;


            yCord[3] += yVel;
            if ((!parasuit) ||(prizeY>=850 &&parasuit))
            {
                if (parasuit){
                    parasuit = false;
                }

                if(prizeY>850){
                    prizeY=-100;
                }
                if(score%7==0)
                graphics.drawImage(imgP, prizeX, prizeY, null);
            }
            prizeY += yVel;

            if (bY > 800 )
                bY = -200;
            if (bY == -100)
                bX = 40 + disc.nextInt(680);
            bY+=yVel;

            graphics.drawImage(imgB,bX,bY,null);


          //  if (score % 5 == 0) {

           ///}
//            if (score % 3 == 0)
//
//                if (prizeY > 700 || b == 1) {
//                    b = 1;
//                    graphics.drawImage(imgB, 350, bY, null);
//                }


        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("xfdgchj");
        Graphics g = graphics;
        g.setColor(Color.black);
        g.fillOval(e.getX(), e.getY(), 30, 30);
    }

    @Override
    public void mousePressed(MouseEvent e) {


        int locX = e.getX();
        int locY = e.getY();
            if ((locX >= xCord[0] &&locX <= xCord[0] + 150) && (locY >= yCord[0] && locY <= yCord[0] + 150)) {

                hiddenballoon[0] = true;
              //  System.out.println("score="score);
                score+=10;

            }
        if ((locX >= xCord[1] && locX <=xCord[1] + 150) && (locY >=yCord[1] && locY <= yCord[1] + 150)) {

            hiddenballoon[1] = true;
           // System.out.println("score="score);
            score+=10;


            //g.setColor(Color.white);
            // graphics.fillOval(xCord[i], yCord[i], 200, 200);
        }
        if ((locX >= xCord[2] && locX <=xCord[2] + 150) && (locY >= yCord[2] && locY <= yCord[2] + 150)) {

            hiddenballoon[2] = true;
          // System.out.println("score="score);
           score+=10;
            //  System.out.println("hellok\n");
            //g.setColor(Color.white);
            // graphics.fillOval(xCord[i], yCord[i], 200, 200);
        }
        if ((locX >=xCord[3] && locX <=xCord[3] + 150) && (locY>= yCord[3] && locY <= yCord[3] + 150)) {

            hiddenballoon[3] = true;
           //System.out.println("score="score);
            score+=10;
            //  System.out.println("hellok\n");
            //g.setColor(Color.white);
            // graphics.fillOval(xCord[i], yCord[i], 200, 200);
        }

        if ((locX>=bX && locX<=bX+150) && (locY>=bY && locY<=bY+150)){
            //blackHidden=true;
            System.out.println("score=" + score);
            System.out.println("Game Over");
            System.exit(0);
        }
         if ((locX>=prizeX && locX<=prizeX+150) && (locY>=prizeY && locY<=prizeY+150)){
            score=score+25;
            parasuit =true;

        }
        if ((locX >= angryX &&locX <= angryX + 150) && (locY >= angryY && locY <= angryY + 150)) {

            hiddenangry = true;
            //  System.out.println("score="score);
            score-=5;

        }

        score = score + 5;
        if (locX == prizeX && locY == prizeY)
            score = score + 10;
        if (locX == bX && locY == bY) {
            score = score - 4;
            System.exit(0);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}




