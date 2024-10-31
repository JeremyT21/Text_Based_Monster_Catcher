/*
  Jeremy Thummel, David Cacorovski, Sohail Meghani
  November 16th, 2021
  Unit 3 Java Console Assignment
  This is the main file for our unit 3 java console assignment
*/
//These statements import all of the neccesary libraries in order to ensure that our code can function properly
import java.io.*;
import java.util.*;
import java.lang.*;
import java.lang.Thread;

class Main {
  //Below are the global variables declared to access them from multiple functions
  public static int startChoose = 0;
  public static boolean choseStarter=false;
  public static String enterCont = null;
  public static String[][] usersData=null;
  public static boolean caught=false;
  public static boolean weezingCaught=false;
  public static boolean alakazamCaught=false;
  public static boolean dittoCaught=false;
  public static boolean dragoniteCaught=false;
  public static boolean electabuzzCaught=false;
  public static boolean exeggutorCaught=false;
  public static boolean gengarCaught=false;
  public static boolean laprasCaught=false;
  public static boolean magmarCaught=false;
  public static boolean onixCaught=false;
  public static boolean scytherCaught=false;
  //Sohail Meghani - November 20th
  public static boolean charizardCaught=false;
  public static boolean blastoiseCaught=false;
  public static boolean venusaurCaught=false;

  public static void main(String[] args) throws IOException
  {
    
    String fileName = "logo.txt";

    //Below is the initialization for the Scanner object, the BufferedReader object and the BufferedWriter object
    Scanner scan=new Scanner(System.in);
    //FILE READER AND WRITER
    BufferedWriter bw=new BufferedWriter(new FileWriter("saveData.txt", true));
    BufferedReader br=new BufferedReader(new FileReader(fileName));
    String line=br.readLine();

    while(line!=null)//if you read an empty line readLine returns null
    {
      System.out.println("\u001b[31m" + line);
      line=br.readLine();
    }

    //code taken from https://newbedev.com/java-how-to-execute-a-function-after-2-sec-in-java-code-example || Modified by Jeremy, David and Sohail
    //the purpose of this code is to make sure that the code within the run() function executes once the time limit (5000 ms or 5secs) has elapsed
    
    //Jeremy Thummel - November 16th @ 11:05am added the beginning of the game (making your name and only accepting it if it's a limited amount of characters)
    new java.util.Timer().schedule( 
      new java.util.TimerTask() 
      {
        @Override
        public void run() 
        {
          emptySpace(30);
          System.out.println("\u001b[0m" + "\n\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
          System.out.println("- Welcome to the world of Minimons! -");
          System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

          System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
          System.out.println("- Enter your first name young one:  -");
          System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        }
      }, 
      5000 
    );

    String name=scan.nextLine();
    arrayCreation();
    saveFunction(name,usersData);
    //System.out.println(weezingCaught);
    
    while(true)
    {
      if(name.length()>8)
      {
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("- Hmmm, it seems your name is too \n  long! Please enter a nickname:    -");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        name=scan.nextLine();
      }

      else
        break;
      
    }
    
    if(choseStarter==false)
    {

      System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
      System.out.println("    Well "+name+", it's time for you to     \n      start your journey! Good luck            \n     capturing the legendary Minimon!     ");
      System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

      System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
      System.out.println("-   Please choose your starter Minimon!   -");
      System.out.println("-             1. Venusaur                 -");
      System.out.println("-             2. Blastoise                -");
      System.out.println("-             3. Charizard                -");
      System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
      System.out.println("Please enter 1, 2 or 3 to select your starter!");
      String starter = scan.nextLine();

      while(true)
      {
        if(!starter.equals("1") && !starter.equals("2") && !starter.equals("3"))
        {
          System.out.println("I'm sorry but there are only 3 starters to choose from!");
          System.out.println("Please enter 1, 2 or 3 to select your starter!");
          starter = scan.nextLine();
        }
        else
          break;
      }   

      if(starter.equals("1"))
      {
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("  Congratulations " +name+ "! You have chosen \n Venusaur as your Minimon! ");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        startChoose=1;
        bw.newLine();
        venusaurCaught=true;
        bw.write(name+",Venusaur");
        bw.close();
      }
      else if(starter.equals("2"))
      {
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("  Congratulations " +name+ "! You have chosen \n Blastoise as your Minimon! ");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        startChoose=2;
        bw.newLine();
        blastoiseCaught=true;
        bw.write(name+",Blastoise");
        bw.close();
      } 
      else if(starter.equals("3"))
      {
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("  Congratulations " +name+ "! You have chosen \n Charizard as your Minimon!");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        startChoose=3;
        bw.newLine();
        charizardCaught=true;
        bw.write(name+",Charizard");
        bw.close();
      }

    }//end of choosing starter which will skip if person has already chose a starter

    //Jeremy Thummel - November 18th @ 10:25 added the ability for you to skip choosing the starter if save data exists 
    else
    {
      System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
      System.out.println("  Welcome back to Minimons Evolution "+name+"!");
      System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    System.out.println("    You better get prepared, " +name+"! Here \n             comes a Minimon! ");
    System.out.println("         Press Enter to Continue:         ");
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

    enterCont=scan.nextLine();
    
    
    if(weezingCaught == true && alakazamCaught == true && dittoCaught == true && electabuzzCaught == true && exeggutorCaught == true && gengarCaught == true && laprasCaught == true && magmarCaught == true && onixCaught == true && scytherCaught == true)
    {
      legendary();
    }
    else
    {
      while(true)
      {
        safari(name);
      }
    }
  }//end of void main

  //The purpose of this function is to print the designated number of empty lines in order to make sure that there is enough separation between the ASCII art and the contents of the game
  //David Cacorovski - November 17th @ 6:17pm - Added emptySpace function
  /**********FUNCTION WITH PARAMETER AND NO RETURN****************/
  public static void emptySpace(int lines){
    for(int i=0;i<lines;i++)
      System.out.println();
  }//end of emptySpace function

  //the purpose this function is to determine the Minimon that the player will encounter within the confines of the game
  //Jeremy Thummel and Sohail Meghani - November 17th @ 5:39pm - Added randomize function
  /**********FUNCTION WITH PARAMETER AND RETURN****************/
  public static int randomize(int lower, int upper){
    int randInt = (int)(Math.random() * upper + lower);
    return randInt;
  }//end of randomize function;

  //Sohail Meghani, Jeremy Thummel and David Cacorovski - November 18th @ 10:19pm - Added and edited safari function
  /**********FUNCTION WITH PARAMETER AND NO RETURN****************/
  public static void safari(String nameOfUser) throws IOException{
    caught = false;
    //The below code is the start of the encounter system for the various Minimons you will be encountering within the game
    Scanner scan = new Scanner(System.in);
    int randMini = randomize(1, 10);
    String[] pokemonArray = {"weezing.txt", "lapras.txt", "alakazam.txt", "ditto.txt", "electabuzz.txt", "exeggutor.txt", "gengar.txt", "magmar.txt", "onix.txt", "scyther.txt"};
    String[] miniNames = {"Weezing", "Lapras", "Alakazam", "Ditto", "Electabuzz", "Exeggutor", "Gengar", "Magmar", "Onix", "Scyther"};
    String[] miniColors = {"\u001b[35m", "\u001b[34m", "\u001b[33m", "\u001b[35m", "\u001b[33m", "\u001b[32m", "\u001b[35m", "\u001b[31m", "\u001b[37m", "\u001b[32m"};
    String minimonName = miniNames[randMini-1];
    String hexColor = miniColors[randMini-1];
    String fileName = pokemonArray[randMini-1];
    //FILE READER
    BufferedReader br=new BufferedReader(new FileReader(fileName));
    String moveSelect="0";
    String line = br.readLine();
    //below code decides the outcome of if the minimon will be caught or not
    
    int annoyedNumber=0;
    int luredNumber=0;

    //the minimon appearing when the random number = 10
    fileName = pokemonArray[randMini-1];

    while(line!=null)//if you read an empty line readLine returns null
    {
      System.out.println(hexColor + line);
      line=br.readLine();
    }
    int firstEncounter=0;

    //all the below code will run AFTER THE MINIMON picture is shown
    while(true)
    {
      if(firstEncounter==0)
      {
        new java.util.Timer().schedule( 
          new java.util.TimerTask() 
          {
            @Override
            public void run() 
            {
              emptySpace(30);
              System.out.println("\u001b[0m" +"\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
              System.out.println("       You encountered a " + minimonName + "!");
              System.out.println("            What will you do?            ");
              System.out.println("                1. BALL                  ");
              System.out.println("                2. BAIT                  ");
              System.out.println("                3. ROCK                  ");
              System.out.println("                4. RUN                   ");
              System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            } 
          }, 
          3000 
        );
      }
      else
      {
        emptySpace(30);      
        System.out.println("\u001b[0m"+"\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("            What will you do?            ");
        System.out.println("                1. BALL                  ");
        System.out.println("                2. BAIT                  ");
        System.out.println("                3. ROCK                  ");
        System.out.println("                4. RUN                   ");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
      }      

      moveSelect=scan.nextLine();

      while(true)
      {
        if(!moveSelect.equals("1") && !moveSelect.equals("2") && !moveSelect.equals("3") && !moveSelect.equals("4"))
        {
          System.out.println("I'm sorry but there are only 4 moves to choose from!");
          System.out.println("Please enter 1, 2, 3, or 4 to select your move!");
          moveSelect = scan.nextLine();
        }
        else
          break;
      }

      if(moveSelect.equals("1"))
      {
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("          You threw a Safari Ball!         ");
        System.out.println("          Press Enter to Continue:         ");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        String pokeball = "pokeball.txt";
        BufferedReader brBall=new BufferedReader(new FileReader(pokeball));
        BufferedWriter bwBall=new BufferedWriter(new FileWriter("saveData.txt",true));
        line = brBall.readLine();
        enterCont=scan.nextLine();
        while(line!=null)
        {
          System.out.println(line);
          line=brBall.readLine();
        }
        for(int x = 1; x < 5; x++)
        {
          int chanceRandBad = randomize(1, 2);
          int chanceRandOk = randomize(1, 4);
          int chanceRandGood = randomize(1, 8);
          int chanceRandGreat = randomize(1, 12);
          if(luredNumber < 4 && luredNumber > 1)
          {
            chanceRandBad = chanceRandOk;
          }
          else if(luredNumber < 6 && luredNumber > 3)
          {
            chanceRandBad = chanceRandGood;
          }
          else if (luredNumber > 6)
          {
            chanceRandBad = chanceRandGreat;
          }
          if(chanceRandBad == 1)
          {
            timer(1000);
            System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("-         The Minimon broke free!         -");
            System.out.println("-         Press Enter to Continue:        -");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            enterCont=scan.nextLine();
            break;
          }
          else
          {
            timer(1000);
            if(x == 4)
            {
              caught = true;
              System.out.println("Clink!");
            }
            else
            {
              System.out.println(x + "...");
            }
          }
        }
        
        if(caught == true)
        {
          //Jeremy Thummel - November 20th @ 5:00pm - Improved the catching system by making it more effecient (it will record minimon based on its name using a variable and no longer will it use )
          bwBall.newLine();
          bwBall.write(nameOfUser+","+minimonName);
          timer(1000);
          System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
          System.out.println("          You caught "+minimonName+"!      ");
          System.out.println("          Press Enter to Continue:         ");
          System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
          enterCont=scan.nextLine();
          bwBall.close();
          return;
        }
      }

      else if(moveSelect.equals("2"))
      {
        luredNumber+=(int)(Math.random()*1+2);
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("            The "+minimonName+" started to ");       
        System.out.println("            nibble on the bait!            ");
        System.out.println("          Press Enter to Continue:         ");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        enterCont=scan.nextLine();
      }

      else if(moveSelect.equals("3"))
      {

        annoyedNumber+=(int)(Math.random()*2+1);

        if(annoyedNumber==3 || annoyedNumber==2)
        {
          System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
          System.out.println("     The "+minimonName+" ran since you were   ");
          System.out.println("           throwing rocks at it!           ");
          System.out.println("          Press Enter to Continue:         ");
          System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
          enterCont=scan.nextLine();
          return;
        }
        else if(annoyedNumber==1)
        {
          luredNumber+=(int)(Math.random()*2+4);
          System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
          System.out.println("          "+minimonName+" is angry!          ");
          System.out.println("          Press Enter to Continue:         ");
          System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
          enterCont=scan.nextLine();
        }
      }
      else if(moveSelect.equals("4"))
      {
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("-              You ran away!              -");
        System.out.println("-         Press Enter to Continue:        -");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        enterCont=scan.nextLine();
        return;
      }
      int runAwayChance = randomize(1, 6);
      if(runAwayChance == 1)
      {
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("-          The Minimon ran away!          -");
        System.out.println("-         Press Enter to Continue:        -");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        enterCont=scan.nextLine();
        return;
      }
      
      firstEncounter+=1;

    }//end of loop

  }//end of safari function
  
  //Sohail Meghani - November 20th @ 7:25pm - Added arrayCreation function
  /**********FUNCTION WITH NO PARAMETER AND RETURN****************/
  public static String[][] arrayCreation() throws IOException
  {
    //FILE READER
    BufferedReader br=new BufferedReader(new FileReader("saveData.txt"));
    
    String line=br.readLine();
    //above code used to count number of lines in the file and therefore this will determine the length of the 2D array

    String[] lineArray=null;//new String[2]
    int i=0;//row number counter

    int lineCount=0;//row number initializer

    while(line!=null){
      lineCount++;
      line=br.readLine();
    }

    usersData = new String[lineCount][2];
    //FILE READER
    br=new BufferedReader(new FileReader("saveData.txt"));
    line=br.readLine();

    while(line!=null)
    {
      lineArray=line.split(",");//split is a function that takes a delimeter and splits a string into a 1D array using that delimeter
      //in our case the delimeter was a comma

      if (lineArray.length > 1)
      {
        usersData[i][0]=lineArray[0];//the name
        usersData[i][1]=lineArray[1];//the minimon
      }

      else if (lineArray.length == 1) //when the user starts this makes sure there's no out of bound error
      {
        usersData[i][0]=lineArray[0];//the name
        usersData[i][1]="";//the minimon
      }

      line=br.readLine();
      i++;
    }
    
    br.close();
    //above loop will make an array storing which users have caught which minimons using their entered name

    return usersData;
  }

  //Jeremy Thummel - November 17th @ 10:13am - Added saveFunction and created arrays
  //Jeremy Thummel - November 19th @ 11:00am - Changed saveFunction and solved checking for each minimon 
  /**********FUNCTION WITH PARAMETER AND NO RETURN****************/
  public static void saveFunction(String userName, String[][] arrayUser) throws IOException
  {

    for(int y=0;y<arrayUser.length;y++)
    {
      if(arrayUser[y][0].equals(userName))
      {
        choseStarter=true;
        if(arrayUser[y][1].equals("Weezing"))
        {
          weezingCaught=true;
        }
        if(arrayUser[y][1].equals("Alakazam"))
        {
          alakazamCaught=true;
        }
        if(arrayUser[y][1].equals("Ditto"))
        {
          dittoCaught=true;
        }
        if(arrayUser[y][1].equals("Dragonite"))
        {
          dragoniteCaught=true;
        }
        if(arrayUser[y][1].equals("Electabuzz"))
        {
          electabuzzCaught=true;
        }
        if(arrayUser[y][1].equals("Exeggutor"))
        {
          exeggutorCaught=true;
        }
        if(arrayUser[y][1].equals("Gengar"))
        {
          gengarCaught=true;
        }
        if(arrayUser[y][1].equals("Magmar"))
        {
          magmarCaught=true;
        }
        if(arrayUser[y][1].equals("Onix"))
        {
          onixCaught=true;
        }
        if(arrayUser[y][1].equals("Scyther"))
        {
          scytherCaught=true;
        }
        if(arrayUser[y][1].equals("Lapras"))
        {
          laprasCaught=true;
        }
        if(arrayUser[y][1].equals("Charizard"))
        {
          charizardCaught=true;
        }
        if(arrayUser[y][1].equals("Venusaur"))
        {
          venusaurCaught=true;
        }
        if(arrayUser[y][1].equals("Blastoise"))
        {
          blastoiseCaught=true;
        }  
      }
    }
  }//end of saveFunction

  //David Cacorovski - November 20th @ 3:25pm - Added timer function
  /****************** FUNCTION WITH PARAMETER, NO RETURN  *****************/
  public static void timer(int time){
    try//I dont know how but putting this in a try catch was the only way this worked
    {
      Thread.sleep(time);
    }
    catch(InterruptedException e)
    {
      System.out.println("There was an issue executing this code!");
    }
  }//end of timer function

  //Sohail Meghani and David Cacorovski - November 20th @ 8:53pm - Added and edited the legendary function
  /***************** FUNCTION WITH NO PARAMETER, NO RETURN **************/
  public static void legendary() throws IOException
  {
    /***********CONSTANT ITS THE ONLY ONE SORRY*******************/
    final int dragoniteDamage=5;
    int dragoniteHealth=30;
    int starterDamage=3;
    int starterHealth=20;
    String moveSelect="0";
    Scanner scan = new Scanner(System.in);
    timer(1000);
    emptySpace(30);
    System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    System.out.println("              Congratulations!");
    System.out.println("       You have caught all the Minimons!");
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    
    timer(2500);
    System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    System.out.println("            Uh oh, what's this?!");
    System.out.println("     The legendary Minimon, Dragonite,");
    System.out.println("           has challenged you!");
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

    timer(2500);
    //FILE READER
    BufferedReader br=new BufferedReader(new FileReader("dragonite.txt"));
    String line = br.readLine();
    String hexColor="\u001b[33m";

    while(line!=null)
    {
      System.out.println(hexColor + line);
      line=br.readLine();
    }

    br.close();
    timer(3000);
    emptySpace(30);

    if(charizardCaught==true)
    {
      //FILE READER
      br=new BufferedReader(new FileReader("charizard.txt"));
      line = br.readLine();
      System.out.println("\u001b[0m"+"\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
      System.out.println("          You sent out Charizard!");
      System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
      timer(2000);
      hexColor="\u001b[31m";
      while(line!=null)
      {
        System.out.println(hexColor + line);
        line=br.readLine();
      }
      timer(2000);
      
      emptySpace(30);
      br.close();

    }

    else if(blastoiseCaught==true)
    {
      //FILE READER
      br=new BufferedReader(new FileReader("blastoise.txt"));
      line = br.readLine();
      System.out.println("\u001b[0m"+"\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
      System.out.println("          You sent out Blastoise!");
      System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
      timer(2000);
      hexColor="\u001b[34m";
      while(line!=null)
      {
        System.out.println(hexColor + line);
        line=br.readLine();
      }
      timer(2000);
      
      emptySpace(30);
      br.close();

    }

    else if(venusaurCaught==true)
    {
      //FILE READER
      br=new BufferedReader(new FileReader("venusaur.txt"));
      line = br.readLine();
      System.out.println("\u001b[0m"+"\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
      System.out.println("          You sent out Venusaur!");
      System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
      timer(2000);
      hexColor="\u001b[32m";
      while(line!=null)
      {
        System.out.println(hexColor + line);
        line=br.readLine();
      }
      timer(2000);
      br.close();
    }
    while(true)
    {
      emptySpace(30);
      System.out.println("\u001b[0m"+"\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
      System.out.println("            What will you do?            ");
      System.out.println("                1. FIGHT                  ");
      System.out.println("                2. REST                  ");
      System.out.println("                3. BOOST                  ");
      System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

      moveSelect=scan.nextLine();

      while(true)
      {
        if(!moveSelect.equals("1") && !moveSelect.equals("2") && !moveSelect.equals("3"))
        {
          System.out.println("I'm sorry but there are only 3 moves to choose from!");
          System.out.println("Please enter 1, 2, or 3 to select your move!");
          moveSelect = scan.nextLine();
        }
        else
          break;
      }

      if(moveSelect.equals("1"))
      {
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("            Your Minimon attacked!        ");
        dragoniteHealth -= starterDamage;
        System.out.println("        He dealt " + starterDamage + " damage to Dragonite!");
        if(dragoniteHealth < 1)
        {
          dragoniteHealth = 0;
        }
        System.out.println("          Dragonite has " + dragoniteHealth + " HP left!");
        System.out.println("           Press Enter to Continue:         ");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        enterCont=scan.nextLine();
        if(dragoniteHealth == 0)
        {
          System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
          System.out.println("         Dragonite is unable to battle!");
          System.out.println("     Congrats you beat the legendary Minimon!");
          System.out.println("          Thanks for playing our game!");
          System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
          System.exit(0);
        }
      }
      else if(moveSelect.equals("2"))
      {
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("           Your Minimon took a rest!         ");
        starterHealth = 20;
        System.out.println("          He healed back up to " + starterHealth + " HP!");
        System.out.println("           Press Enter to Continue:         ");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        enterCont=scan.nextLine();
      }
      else if(moveSelect.equals("3"))
      {
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("   Your Minimon's stats got boosted by x2! ");
        starterDamage *= 2;
        System.out.println("           Press Enter to Continue:         ");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        enterCont=scan.nextLine();
      }

      System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
      System.out.println("             Dragonite attacked!");
      starterHealth -= dragoniteDamage;
      System.out.println("             He dealt " + dragoniteDamage + " damage!");
      System.out.println("            You have " + starterHealth + " HP left!");
      System.out.println("           Press Enter to Continue:         ");
      System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
      enterCont=scan.nextLine();

      if(starterHealth < 1)
      {
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("      Your Minimon is unable to battle!");
        System.out.println("             Better luck next time!");
        System.out.println("  Your game will be saved by the name you inputted!");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.exit(0);
      }
    }
  }//end of legendary function
}//end of Main class