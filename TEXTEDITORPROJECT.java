import java.util.*;

import java.io.*;

import java.awt.*;

import java.awt.event.*;

import javax.swing.plaf.metal.*;

import javax.swing.text.*;

import javax.swing.*;


class OOPM_Project_1 extends JFrame implements ActionListener,AdjustmentListener

{

   

    JTextArea t;


    JFrame f;


    JScrollPane scroll ;



    OOPM_Project_1()

    {

        t=new JTextArea();

        f=new JFrame("OOPM Project Text Editor");

        try

        {

         
           

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
     

        }

        catch(Exception e)

        {}



        JMenuBar mb=new JMenuBar();



        JMenu m1=new JMenu("File");



        JMenuItem m1a=new JMenuItem("New");

        JMenuItem m1b=new JMenuItem("Open");

        JMenuItem m1c=new JMenuItem("Save");

        JMenuItem m1d=new JMenuItem("Print");



        m1a.addActionListener(this);

        m1b.addActionListener(this);

        m1c.addActionListener(this);

        m1d.addActionListener(this);

        m1.add(m1a);

        m1.add(m1b);

        m1.add(m1c);

        m1.add(m1d);



        JMenu m2=new JMenu("Edit");


        JMenuItem m2a=new JMenuItem("Cut");

        JMenuItem m2b=new JMenuItem("Copy");

        JMenuItem m2c=new JMenuItem("Paste");


        m2a.addActionListener(this);

        m2b.addActionListener(this);

        m2c.addActionListener(this);

        m2.add(m2a);

        m2.add(m2b);

        m2.add(m2c);



        JMenu m3 = new JMenu("Fonts");



        JMenuItem m3a=new JMenuItem("Agency FB");

        JMenuItem m3b=new JMenuItem("SansSerif");

        JMenuItem m3c=new JMenuItem("Arial");
       
        JMenuItem m3d=new JMenuItem("Calibri Light");
       
        JMenuItem m3e=new JMenuItem("Elephant");
       
        JMenuItem m3f=new JMenuItem("Times New Roman");
       
        JMenuItem m3g=new JMenuItem("Bahnschrift");



        m3a.addActionListener(this);

        m3b.addActionListener(this);

        m3c.addActionListener(this);
       
        m3d.addActionListener(this);

        m3e.addActionListener(this);
       
        m3f.addActionListener(this);
       
        m3g.addActionListener(this);
       
        m3.add(m3a);

        m3.add(m3b);

        m3.add(m3c);
       
        m3.add(m3d);
       
        m3.add(m3e);
       
        m3.add(m3f);
       
        m3.add(m3g);


       

        JMenu m4=new JMenu("Help");

        JMenuItem m4a=new JMenuItem("About");

        m4a.addActionListener(this);

        m4.add(m4a);


        JMenuItem mc=new JMenuItem("Close");

       

        mc.addActionListener(this);

       

        mb.add(m1);

        mb.add(m2);

        mb.add(m3);

        mb.add(m4);

        mb.add(mc);

        //Setting menubar on the frame

        f.setJMenuBar(mb);


        f.add(t);


        f.setVisible(true);


        scroll = new JScrollPane(t);

        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        f.add(scroll);


        scroll.setSize(20,500);

        f.setSize(500,500);


        t.setSize(400,500);



    }


    public void adjustmentValueChanged(AdjustmentEvent e){}

    //If a button is pressed

    @Override

    public void actionPerformed(ActionEvent ae)

    {

       

        String s=ae.getActionCommand();

     

        if(s.equals("Copy"))

        {

            t.copy();

        }


        else if(s.equals("Cut"))

        {

            t.cut();

        }


        else if(s.equals("Paste"))

        {

            try

            {

                t.paste();

            }

            catch (Exception evt)

            {

                JOptionPane.showMessageDialog(f, evt.getMessage());

            }

        }


        else if(s.equals("Print"))

        {

            try{t.print();}//was throwing Excetion so put it in try catch block

            catch(Exception e){}

        }


       

        else if(s.equals("Open"))

        {

           

            JFileChooser fileopener = new JFileChooser("f:");

           

            int r = fileopener.showOpenDialog(null);

            if (r == JFileChooser.APPROVE_OPTION){

                File fileo = new File(fileopener.getSelectedFile().getAbsolutePath());

                try{

                   

                    String s1 = "",s2="";

                   

                    FileReader fr = new FileReader(fileo);

                    BufferedReader br = new BufferedReader(fr);

                    s2=br.readLine();

                   

                    while ((s1 = br.readLine()) != null){

                        s2 = s2 + "\n" + s1;

                    }


                   

                    t.setText(s2);

                }

                catch (Exception evt){

                    JOptionPane.showMessageDialog(f, evt.getMessage());

                }

            }

        }


       

        else if(s.equals("Save"))

        {

           

            JFileChooser filesaver = new JFileChooser("f:");

           

            int r = filesaver.showSaveDialog(null);

            if (r == JFileChooser.APPROVE_OPTION) {

               

                File files = new File(filesaver.getSelectedFile().getAbsolutePath());


                try {

                   

                    FileWriter wr=new FileWriter(files, false);

                   

                    BufferedWriter w=new BufferedWriter(wr);

                    w.write(t.getText());

                    w.flush();

                    w.close();

                }

                catch (Exception evt) {

                    JOptionPane.showMessageDialog(f,evt.getMessage());

                }

            }

        }

        else if (s.equals("Print")) {

            try {

               

                t.print();

            }

            catch (Exception evt) {

                JOptionPane.showMessageDialog(f,evt.getMessage());

            }

        }


        //If new is pressed

        else if(s.equals("New"))

        {

            t.setText("");

        }

        else if(s.equals("Close"))

        {

            f.setVisible(false);

            System.exit(0);

        }


        else if(s.equals("Agency FB"))

        {

            Font fo = new Font("Agency FB",Font.PLAIN,16);

            t.setFont(fo);

        }

        else if(s.equals("Arial"))

        {

            Font fo = new Font("Arial",Font.PLAIN,16);

            t.setFont(fo);

        }

        else if(s.equals("SansSerif"))

        {

            Font fo = new Font("SansSerif",Font.PLAIN,16);

            t.setFont(fo);

        }

        else if(s.equals("About"))

        {

            String newLine = System.getProperty("line.separator");


           

            JOptionPane.showMessageDialog(f, "Aurobita & Sifat : Worked on database using JFileChooser plus minimal changes in Tuba's code " + newLine + " Tuba: Added File,Edit,Close button,Frame,Panel " + newLine + " Nafisa : Added themes, fonts,scroll bar and the box in which you're reading this message...Thank You !");


        }


    }

    //Main Method

    public static void main(String args[])

    {

        OOPM_Project_1 o=new OOPM_Project_1();

    }

}





