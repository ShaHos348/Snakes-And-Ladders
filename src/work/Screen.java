package work;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Screen{
//Variables used in multiple classes
	private JFrame obj = new JFrame(); //Screen
	private JLabel outputDisplay1 = new JLabel("");   	//Displays labels
	private JLabel outputDisplay2 = new JLabel("");   	//Displays labels
	private JLabel outputDisplay3 = new JLabel("");   	//Displays labels
	private JLayeredPane layers = new JLayeredPane();   //Used to sort frame layout
	private Game game = new Game();						//Gives game background
	private boolean doneSetup = false;					//Checks if startPos is done
	private int playerNum = 0;							//Number of players
	private int i = 1;									//Keeps track of whose turn it is
	private int moveNum = 0;							//Keeps track of how much to move
	ArrayList<ImageIcon> piecePics = new ArrayList<ImageIcon>();	//Used to make JLabels for ArrayList<JLabel> pieces
	private ArrayList<JLabel> pieces = new ArrayList<JLabel>();		//Keeps track of pieces in game
	private static ArrayList<Snakes> snakes = new ArrayList<Snakes>();		//List of all the snakes
	private static ArrayList<Ladders> ladders = new ArrayList<Ladders>();	//List of all the ladders
	private static ArrayList<Player> players = new ArrayList<Player>();		//Keeps track of player positions
	private ArrayList<Point> points = new ArrayList<Point>();		//All points of the board
//Creates first screen
     public Screen() {
		obj.setSize(640, 724);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setResizable(true);
		//Brings in images for number if player selection
			ImageIcon one = new ImageIcon(getClass().getClassLoader().getResource("oneplayer.png"));
			ImageIcon two = new ImageIcon(getClass().getClassLoader().getResource("twoplayers.png"));
			ImageIcon three = new ImageIcon(getClass().getClassLoader().getResource("threeplayers.png"));
			ImageIcon four = new ImageIcon(getClass().getClassLoader().getResource("fourplayers.png"));
			ImageIcon five = new ImageIcon(getClass().getClassLoader().getResource("fiveplayers.png"));
			ImageIcon six = new ImageIcon(getClass().getClassLoader().getResource("sixplayers.png"));
		//Creates buttons for player selection
			JLabel playerRequest = new JLabel("How many players?");
				playerRequest.setFont(new Font("Serif", Font.BOLD, 60));
				playerRequest.setBounds(50, 0, 550, 90);
				playerRequest.setHorizontalAlignment(SwingConstants.CENTER);
			JButton oneplayer = new JButton(one);
				oneplayer.setBounds(75, 101, 200, 100);
			JButton twoplayer = new JButton(two);
				twoplayer.setBounds(349, 101, 200, 100);
			JButton threeplayer = new JButton(three);
				threeplayer.setBounds(75, 251, 200, 100);
			JButton fourplayer = new JButton(four);
				fourplayer.setBounds(349, 251, 200, 100);
			JButton fiveplayer = new JButton(five);
				fiveplayer.setBounds(75, 401, 200, 100);
			JButton sixplayer = new JButton(six);
				sixplayer.setBounds(349, 401, 200, 100);
		//Adds buttons to panel
			JPanel panel1 = new JPanel();
			panel1.setLayout(null);	
			panel1.add(playerRequest);	
			panel1.add(oneplayer);		
			panel1.add(twoplayer);		
			panel1.add(threeplayer);		
			panel1.add(fourplayer);
			panel1.add(fiveplayer);		
			panel1.add(sixplayer);
			panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			panel1.setSize(624, 624);
		obj.add(panel1);
		obj.setVisible(true);
		//Gives actions to buttons and removes them once clicked
			oneplayer.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
							obj.getContentPane().removeAll();
							obj.repaint();
							playerNum = 1;
							playerSelection();
				        }  
				    });  
			twoplayer.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
							obj.getContentPane().removeAll();
							obj.repaint();
							playerNum = 2;
							playerSelection();
				        }  
				    });  
			threeplayer.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
							obj.getContentPane().removeAll();
							obj.repaint();
							playerNum = 3;
							playerSelection();
				        }  
				    });  
			fourplayer.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
							obj.getContentPane().removeAll();
							obj.repaint();
							playerNum = 4;
							playerSelection();
				        }  
				    });  
			fiveplayer.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
							obj.getContentPane().removeAll();
							obj.repaint();
							playerNum = 5;
							playerSelection();
				        }  
				    });  
			sixplayer.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
							obj.getContentPane().removeAll();
							obj.repaint();
							playerNum = 6;
							playerSelection();
				        }  
				    }); 
    }
//Changes to second screen
    public void playerSelection() {
    	//Brings in images for pieces
			ImageIcon red = new ImageIcon(getClass().getClassLoader().getResource("red.png"));
			red.setDescription("Red");
			ImageIcon orange = new ImageIcon(getClass().getClassLoader().getResource("orange.png"));
			orange.setDescription("Orange");
			ImageIcon yellow = new ImageIcon(getClass().getClassLoader().getResource("yellow.png"));
			yellow.setDescription("Yellow");
			ImageIcon green = new ImageIcon(getClass().getClassLoader().getResource("green.png"));
			green.setDescription("Green");
			ImageIcon blue = new ImageIcon(getClass().getClassLoader().getResource("blue.png"));
			blue.setDescription("Blue");
			ImageIcon purple = new ImageIcon(getClass().getClassLoader().getResource("purple.png"));
			purple.setDescription("Purple");
			ImageIcon pink = new ImageIcon(getClass().getClassLoader().getResource("pink.png"));
			pink.setDescription("Pink");
			ImageIcon black = new ImageIcon(getClass().getClassLoader().getResource("black.png"));
			black.setDescription("Black");
			ImageIcon gray = new ImageIcon(getClass().getClassLoader().getResource("gray.png"));
			gray.setDescription("Gray");
		//Makes label
			JLabel request = new JLabel("Choose a piece for player ");
			request.setFont(new Font("Serif", Font.BOLD, 30));
			request.setBounds(0, 200, 550, 90);
			request.setHorizontalAlignment(SwingConstants.CENTER);
		//Make buttons
			JButton redplayer = new JButton(red);
				redplayer.setBounds(150, 200, 50, 50);
			JButton orangeplayer = new JButton(orange);
				orangeplayer.setBounds(225, 200, 50, 50);
			JButton yellowplayer = new JButton(yellow);
				yellowplayer.setBounds(300, 200, 50, 50);
			JButton greenplayer = new JButton(green);
				greenplayer.setBounds(375, 200, 50, 50);
			JButton blueplayer = new JButton(blue);
				blueplayer.setBounds(150, 275, 50, 50);
			JButton purpleplayer = new JButton(purple);
				purpleplayer.setBounds(225, 275, 50, 50);
			JButton pinkplayer = new JButton(pink);
				pinkplayer.setBounds(300,275, 50, 50);
			JButton blackplayer = new JButton(black);
				blackplayer.setBounds(375, 275, 50, 50);
		//add buttons and label to panel
			JPanel panel2 = new JPanel();
			panel2.add(request);
			panel2.add(redplayer);
			panel2.add(orangeplayer);
			panel2.add(yellowplayer);
			panel2.add(greenplayer);
			panel2.add(blueplayer);
			panel2.add(purpleplayer);
			panel2.add(pinkplayer);
			panel2.add(blackplayer);
		    panel2.setBounds(100, 200, 400, 200);
		obj.add(panel2);
		obj.add(new Game());
		obj.setVisible(true);
		String numText = i + "";
		request.setText("Choose a piece for player " + numText);
		//Removes piece from screen once picked
			redplayer.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
							panel2.remove(redplayer);
							obj.repaint();
							i++;
							String numText = i + "";
							request.setText("Choose a piece for player " + numText);
							piecePics.add(red);
							if(i>playerNum) {
								i = 1;
								if(playerNum == 1) {piecePics.add(gray);}
								startGame();
							}
				        }  
				    });  
			orangeplayer.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
							panel2.remove(orangeplayer);
							obj.repaint();
							i++;
							String numText = i + "";
							request.setText("Choose a piece for player " + numText);
							piecePics.add(orange);
							if(i>playerNum) {
								i = 1;
								if(playerNum == 1) {piecePics.add(gray);}
								startGame();
							}
				        }  
				    });  
			yellowplayer.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
							panel2.remove(yellowplayer);
							obj.repaint();
							i++;
							String numText = i + "";
							request.setText("Choose a piece for player " + numText);
							piecePics.add(yellow);
							if(i>playerNum) {
								i = 1;
								if(playerNum == 1) {piecePics.add(gray);}
								startGame();
							}
				        }  
				    });  
			greenplayer.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
							panel2.remove(greenplayer);
							obj.repaint();
							i++;
							String numText = i + "";
							request.setText("Choose a piece for player " + numText);
							piecePics.add(green);
							if(i>playerNum) {
								i = 1;
								if(playerNum == 1) {piecePics.add(gray);}
								startGame();
							}
				        }  
				    });  
			blueplayer.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
							panel2.remove(blueplayer);
							obj.repaint();
							i++;
							String numText = i + "";
							request.setText("Choose a piece for player " + numText);
							piecePics.add(blue);
							if(i>playerNum) {
								i = 1;
								if(playerNum == 1) {piecePics.add(gray);}
								startGame();
							}
				        }  
				    });  
			purpleplayer.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
							panel2.remove(purpleplayer);
							obj.repaint();
							i++;
							String numText = i + "";
							request.setText("Choose a piece for player " + numText);
							piecePics.add(purple);
							if(i>playerNum) {
								i = 1;
								if(playerNum == 1) {piecePics.add(gray);}
								startGame();
							}
				        }  
				    });  
			pinkplayer.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
							panel2.remove(pinkplayer);
							obj.repaint();
							i++;
							String numText = i + "";
							request.setText("Choose a piece for player " + numText);
							piecePics.add(pink);
							if(i>playerNum) {
								i = 1;
								if(playerNum == 1) {piecePics.add(gray);}
								startGame();
							}
				        }  
				    });  
			blackplayer.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
							panel2.remove(blackplayer);
							obj.repaint();
							i++;
							String numText = i + "";
							request.setText("Choose a piece for player " + numText);
							piecePics.add(black);
							if(i>playerNum) {
								i = 1;
								if(playerNum == 1) {piecePics.add(gray);}
								startGame();
							}
				        }  
				    }); 	
    }
//Method to play game    
    public void gamePlay() throws InterruptedException {
	    	obj.getContentPane().removeAll();
	    	ImageIcon rollingDiePic = new ImageIcon(getClass().getClassLoader().getResource("rollingDie.gif"));
	    	ImageIcon rollDiePic = new ImageIcon(getClass().getClassLoader().getResource("rollDie.png"));
	    	JButton rollDie = new JButton(rollDiePic);
	    	rollDie.setBounds(470, 548, 100, 100);
	    	rollDie.setBackground(Color.WHITE);
	    	rollDie.setBorderPainted(false);
	    	obj.add(layers);
	    	layers.setBounds(450,525,100,100);
	    	game.setBounds(0, 0, 624, 724);
	    	layers.add(game,0);
	    	layers.add(rollDie,1,0);
	    	log();
	    	//To place pieces for game
		    	if(!doneSetup) {
		    		startPos();
		    	}
	    	obj.setVisible(true);
	    	updateLogs(piecePics.get(i-1).getDescription()+"'s turn. Click die to roll.");
	    	//Action for when dice to roll is clicked
	    	rollDie.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
							layers.remove(rollDie);
							obj.repaint();
							JLabel rollingDie = new JLabel(rollingDiePic);
					    	rollingDie.setBounds(450, 525, 140, 140);
					    	layers.add(rollingDie,1,0);
					    	obj.setVisible(true);
					    	updateLogs("Rolling...");
					    	//Timer for dice rolling animation
					    	Timer tm = new Timer(2000, new ActionListener() {
					            @Override
					            public void actionPerformed(ActionEvent arg0) {
					               java.awt.EventQueue.invokeLater(new Runnable() {
					                  @Override
					                  public void run() {
					                     layers.remove(rollingDie);
					                     obj.repaint();
					                     moveNum = (int)((Math.random()*6)+1);      //Rolls die
					                     ImageIcon dieFacePic;
					                     //Chooses face of die to display
						                     if(moveNum<2) {
						                    	 dieFacePic = new ImageIcon(getClass().getClassLoader().getResource("dieOne.png"));
						                     }else  if(moveNum<3) {
						                    	 dieFacePic = new ImageIcon(getClass().getClassLoader().getResource("dieTwo.png"));
						                     }else if(moveNum<4) {
						                    	 dieFacePic = new ImageIcon(getClass().getClassLoader().getResource("dieThree.png"));
						                     }else if(moveNum<5) {
						                    	 dieFacePic = new ImageIcon(getClass().getClassLoader().getResource("dieFour.png"));
						                     }else if(moveNum<6) {
						                    	 dieFacePic = new ImageIcon(getClass().getClassLoader().getResource("dieFive.png"));
						                     }else {
						                    	 dieFacePic = new ImageIcon(getClass().getClassLoader().getResource("dieSix.png"));
						                     }
					                     JLabel dieFace = new JLabel(dieFacePic);
				                    	 dieFace.setBounds(450, 525, 140, 140);
				 				    	 layers.add(dieFace,1,0);
				 				    	 obj.repaint();
				 				    	 obj.setVisible(true);
				 				    	updateLogs(piecePics.get(i-1).getDescription()+" rolled a "+moveNum+".");
				 				    	Timer tm = new Timer(2000, new ActionListener() {
								            @Override
								            public void actionPerformed(ActionEvent arg0) {
								               java.awt.EventQueue.invokeLater(new Runnable() {
								                  @Override
								                  public void run() {
								                	  if(playerNum!=1) {
							                		  //Action for multiplayer
								                		  move();
								                		  i++;
								                		  if(i>playerNum) {i=1;}
								                		  Timer tm = new Timer(3000, new ActionListener() {
													            @Override
													            public void actionPerformed(ActionEvent arg0) {
													               java.awt.EventQueue.invokeLater(new Runnable() {
													                  @Override
													                  public void run() {
													                	  try {
													                		obj.remove(dieFace);
													                		obj.repaint();
																			gamePlay();
																		} catch (InterruptedException e) {
																			e.printStackTrace();
																		}
													                  }
													               });
													            }
													            
													         });
								                		    if(players.get(i-1).getPos()==100) {
							                					winScreen();
							                				}else{
							                					tm.setRepeats(false);
													            tm.start();
							                				}
								                	  }else{
							                		  //Action for single player
							                			  move();
							                			  Timer tm2 = new Timer(3000, new ActionListener() {
													            @Override
													            public void actionPerformed(ActionEvent arg0) {
													               java.awt.EventQueue.invokeLater(new Runnable() {
													                  @Override
													                  public void run() {
													                	  JLabel rollDie = new JLabel(rollDiePic);
													          	    	  rollDie.setBounds(475, 548, 100, 100);
													          	    	  layers.remove(dieFace);
													          	    	  layers.repaint();
													                	  layers.add(rollDie,1,0);
													                	  updateLogs(piecePics.get(i).getDescription()+"'s turn. Bot will roll.");
													                	  bot();
													                  }
													               });
													            }
													            
													         });
							                			    if(players.get(i-1).getPos()==100) {
							                					winScreen();
							                				}else  if(players.get(i).getPos()==100) {
							                					winScreen();
							                				}else if(moveNum!=6){
							                					tm2.setRepeats(false);
													            tm2.start();
							                				}
									 				    	
								                	  }
								                  }
								               });
								            }
								            
								         });
				 				    	tm.setRepeats(false);
								        tm.start();
					                  }
					               });
					            }
					            
					         });
					        tm.setRepeats(false);
					        tm.start();
				        }  
				    });  
    }
//Moves piece after roll    
    public void move() {
    	pieces.get(i-1).setLocation(point());	//Gets piece and changes its location
    	if(moveNum==6&&playerNum!=1) {
    		if(i!=1) {
    			i--;
    		}else {
    			i = playerNum;
    		}
    		updateLogs("Rolled a 6. Can roll again");
    		try {
				gamePlay();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}else if(moveNum==6&&playerNum==1) {
    		updateLogs("Rolled a 6. Can roll again");
    		try {
				gamePlay();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }
//gets location of piece   
    public Point point() {
    	Player player = players.get(i-1);
    	
    	if(player.getPos()==0&&moveNum!=1) {
    		updateLogs(piecePics.get(i-1).getDescription()+" must roll a 1 to enter!");
			return new Point(pieces.get(i-1).getLocation());
		}else if(player.getPos()+moveNum>100) {
			updateLogs(piecePics.get(i-1).getDescription()+"'s position exceeds 100.");
			return new Point(pieces.get(i-1).getLocation());
		}else{
			player.addPos(moveNum);
			for(int j = 0;j<snakes.size();j++) {
				Snakes snake = snakes.get(j);
				if(player.getPos()==snake.getHead()) {
					updateLogs(piecePics.get(i-1).getDescription()+" got eaten by snake!");
	        	    player.setPos(snake.getTail());        
				}
			}
			for(int j = 0;j<ladders.size();j++) {
				Ladders ladder = ladders.get(j);
				if(player.getPos()==ladder.getBot()) {
					updateLogs(piecePics.get(i-1).getDescription()+" climbed ladder!");
	        	    player.setPos(ladder.getTop());				          
				}
			}
		}
    	return points.get(player.getPos()-1);
    }
//Plays bot piece during single player    
    public void bot() {
	//Copy of gamePlay() but without player input
    	Timer tm = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               java.awt.EventQueue.invokeLater(new Runnable() {
                  @Override
                  public void run() {
						obj.getContentPane().removeAll();
						ImageIcon rollingDiePic = new ImageIcon(getClass().getClassLoader().getResource("rollingDie.gif"));
						JLabel rollingDie = new JLabel(rollingDiePic);
						rollingDie.setBounds(475, 548, 100, 100);
						obj.add(layers);
						layers.setBounds(450,525,100,100);
						layers.add(rollingDie,1,0);
						obj.setVisible(true);
						updateLogs("Rolling...");
				    	Timer tm = new Timer(3000, new ActionListener() {
				            @Override
				            public void actionPerformed(ActionEvent arg0) {
				               java.awt.EventQueue.invokeLater(new Runnable() {
				                  @Override
				                  public void run() {
					                     layers.remove(rollingDie);
					                     obj.repaint();
					                     moveNum = (int)((Math.random()*6)+1);
					                     ImageIcon dieFacePic;
					                     if(moveNum<2) {
					                    	 dieFacePic = new ImageIcon(getClass().getClassLoader().getResource("dieOne.png"));
					                     }else  if(moveNum<3) {
					                    	 dieFacePic = new ImageIcon(getClass().getClassLoader().getResource("dieTwo.png"));
					                     }else if(moveNum<4) {
					                    	 dieFacePic = new ImageIcon(getClass().getClassLoader().getResource("dieThree.png"));
					                     }else if(moveNum<5) {
					                    	 dieFacePic = new ImageIcon(getClass().getClassLoader().getResource("dieFour.png"));
					                     }else if(moveNum<6) {
					                    	 dieFacePic = new ImageIcon(getClass().getClassLoader().getResource("dieFive.png"));
					                     }else {
					                    	 dieFacePic = new ImageIcon(getClass().getClassLoader().getResource("dieSix.png"));
					                     }
					                     JLabel dieFace = new JLabel(dieFacePic);
				                    	 dieFace.setBounds(450, 525, 140, 140);
				 				    	 layers.add(dieFace,1,0);
				 				    	 obj.repaint();
				 				    	 obj.setVisible(true);
				 				    	updateLogs(piecePics.get(i).getDescription()+" rolled a "+moveNum+".");
				 				    	Timer tm = new Timer(2000, new ActionListener() {
				 				    	    @Override
				 				    	    public void actionPerformed(ActionEvent arg0) {
				 				    	       java.awt.EventQueue.invokeLater(new Runnable() {
				 				    	          @Override
				 				    	          public void run() {
				 				    					pieces.get(i).setLocation(pointBot());
				 				    					layers.remove(dieFace);
				 				    					Timer tm = new Timer(3000, new ActionListener() {
				 				    					    @Override
				 				    					    public void actionPerformed(ActionEvent arg0) {
				 				    					       java.awt.EventQueue.invokeLater(new Runnable() {
				 				    					          @Override
				 				    					          public void run() {
				 				    					        	  if(moveNum==6) {
				 				    					        		  updateLogs("Bot rolls again!");
				 				    					        		  bot();
				 				    					        	  }else {
				 				    					        		  try {
																			gamePlay();
																		} catch (InterruptedException e) {
																			e.printStackTrace();
																		}
				 				    					        	  }
				 				    					          }
				 				    					       });
				 				    					    }
				 				    					    
				 				    					 });
				 				    					if(players.get(i).getPos()==100) {
						                					winScreen();
						                				}else {
						                					tm.setRepeats(false);
												            tm.start();
						                				}
				 				    	          }
				 				    	       });
				 				    	    }
				 				    	    
				 				    	 });
				 				    	tm.setRepeats(false);
				 				    	tm.start();
				                  }
				               });
				            }
				            
				         });
					    tm.setRepeats(false);
					    tm.start();
                  }
               });
            }
            
         });
		tm.setRepeats(false);
		tm.start();
    }
  //gets location of piece   
    public Point pointBot() {
    	Player player = players.get(i);
    	
    	if(player.getPos()==0&&moveNum!=1) {
    		updateLogs(piecePics.get(i).getDescription()+" must roll a 1 to enter!");
			return new Point(pieces.get(i).getLocation());
		}else if(player.getPos()+moveNum>100) {
			//System.out.println(player.getName()+"'s position exceeds 100.");
			return new Point(pieces.get(i).getLocation());
		}else{
			player.addPos(moveNum);
			for(int j = 0;j<snakes.size();j++) {
				Snakes snake = snakes.get(j);
				if(player.getPos()==snake.getHead()) {
					player.setPos(snake.getTail());
					updateLogs(piecePics.get(i).getDescription()+" got eaten by snake!");
				}
			}
			for(int j = 0;j<ladders.size();j++) {
				Ladders ladder = ladders.get(j);
				if(player.getPos()==ladder.getBot()) {
					player.setPos(ladder.getTop());
					updateLogs(piecePics.get(i).getDescription()+" climbed ladder!");
				}
			}
		}
    	return points.get(player.getPos()-1);
    }
//Sets up pieces on game screen  
    public void startPos() {
    	doneSetup = true;
    	ImageIcon piecePic;
    	JLabel piece;
    	//Adds piece to start position depending on color
    	for(int i = 1;i<=piecePics.size();i++) {
    		piecePic = piecePics.get(i-1);
    		piece = new JLabel(piecePic);
    		if(piecePic.getDescription().equals("Red")) {
    			piece.setBounds(0,535,48,48);
    			layers.add(piece,1,0);
    			pieces.add(piece);
    			obj.setVisible(true);
    		}else if(piecePic.getDescription().equals("Orange")) {
    			piece.setBounds(50,535,48,48);
    			layers.add(piece,1,0);
    			pieces.add(piece);
    			obj.setVisible(true);
    		}else if(piecePic.getDescription().equals("Yellow")) {
    			piece.setBounds(100,535,48,48);
    			layers.add(piece,1,0);
    			pieces.add(piece);
    			obj.setVisible(true);
    		}else if(piecePic.getDescription().equals("Green")) {
    			piece.setBounds(0,585,48,48);
    			layers.add(piece,1,0);
    			pieces.add(piece);
    			obj.setVisible(true);
    		}else if(piecePic.getDescription().equals("Blue")) {
    			piece.setBounds(50,585,48,48);
    			layers.add(piece,1,0);
    			pieces.add(piece);
    			obj.setVisible(true);
    		}else if(piecePic.getDescription().equals("Purple")) {
    			piece.setBounds(100,585,48,48);
    			layers.add(piece,1,0);
    			pieces.add(piece);
    			obj.setVisible(true);
    		}else if(piecePic.getDescription().equals("Pink")) {
    			piece.setBounds(0,635,48,48);
    			layers.add(piece,1,0);
    			pieces.add(piece);
    			obj.setVisible(true);
    		}else if(piecePic.getDescription().equals("Black")) {
    			piece.setBounds(50,635,48,48);
    			layers.add(piece,1,0);
    			pieces.add(piece);
    			obj.setVisible(true);
    		}else if(piecePic.getDescription().equals("Gray")) {
    			piece.setBounds(100,635,48,48);
    			layers.add(piece,1,0);
    			pieces.add(piece);
    			obj.setVisible(true);
    		}
    	}
    }
//Displays what is happening
    public void log() {
    	JLabel outputTitle = new JLabel("Log");
	    	outputTitle.setBounds(470, 75, 150, 40);
	    	outputTitle.setOpaque(true);
	    	outputTitle.setBackground(Color.BLUE);
	    	outputTitle.setFont(new Font("Serif", Font.BOLD, 30));
	    	outputTitle.setForeground(Color.RED);
    	layers.add(outputTitle,1,0);
	    	outputDisplay1.setBounds(470, 115, 150, 40);
	    	outputDisplay1.setOpaque(true);
	    	outputDisplay1.setBackground(new Color(0,204,204));
	    	outputDisplay1.setFont(new Font("Serif", Font.PLAIN, 12));
	    	outputDisplay1.setForeground(new Color(102,0,51));
    	layers.add(outputDisplay1,1,0);
	    	outputDisplay2.setBounds(470, 155, 150, 40);
	    	outputDisplay2.setOpaque(true);
	    	outputDisplay2.setBackground(new Color(0,255,225));
	    	outputDisplay2.setFont(new Font("Serif", Font.PLAIN, 12));
	    	outputDisplay2.setForeground(new Color(255,0,127));
    	layers.add(outputDisplay2,1,0);
	    	outputDisplay3.setBounds(470, 195, 150, 40);
	    	outputDisplay3.setOpaque(true);
	    	outputDisplay3.setBackground(new Color(102,255,255));
	    	outputDisplay3.setFont(new Font("Serif", Font.PLAIN, 12));
	    	outputDisplay3.setForeground(new Color(255,102,178));
    	layers.add(outputDisplay3,1,0);
    }
//Update logs
    public void updateLogs(String text) {
    	outputDisplay1.setText(outputDisplay2.getText());
    	outputDisplay2.setText(outputDisplay3.getText());
    	outputDisplay3.setText(text);
    }
//Changes to win screen
    public void winScreen() {
    	JPanel winScreen = new JPanel();
    	JButton restart = new JButton(new ImageIcon(getClass().getClassLoader().getResource("restart.png")));
    	JLabel winDisplay = new JLabel();
    	String name = "";
    	for(int k =0;k<players.size();k++) {
    		if(players.get(k).getPos()==100) {
    			name = piecePics.get(k).getDescription();
    			winDisplay.setIcon(piecePics.get(k));
    			break;
    		}
    	}
    	winScreen.setBounds(112, 200, 400, 150);
    	winDisplay.setBounds(0, 0, 200, 100);
    	restart.setBounds(0, 50, 200, 50);
    	restart.setBorderPainted(false);
    	winScreen.add(winDisplay);
    	winScreen.add(restart);
    	winDisplay.setText(name+" reached 100. "+name+" wins!");
    	layers.add(winScreen,2,0);
    	obj.setVisible(true);
    	restart.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
						obj.dispose();
						new Screen();
			        }  
			    });  
    }
//Changes to game screen
	public void startGame() {
    	snakes = Board.makeSnakes();
    	ladders = Board.makeLadders();
    	points = Board.board(points);
    	for(int i = 0;i<piecePics.size();i++) {
    		players.add(new Player());
    	}
    	try {
			gamePlay();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }   
//Main method    
    public static void main(String[] args) {
    	new Screen();
     }
 }