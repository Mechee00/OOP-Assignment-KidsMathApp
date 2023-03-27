package gui;

import adt.*; // For array implementation
import entity.*; // For objects

import javax.swing.*;
import java.awt.Point;
import java.awt.event.*;

public class KidsMathApp extends JFrame {
    // Array for 5 rounds of games
    private ArrayList<Game> gameArr = new ArrayList<Game>();
    // User object to store user name
    private Player player = new Player();
    // To drag and move the windows around
    private Point mouoseCoordinate;

    private final double SCALE_ADJUST = 0.0; // Adjust of hover scaling effect

    private JPanel Container; // Master panel 

    // Title Panel, static and exist in whole game
    private JPanel PaneTitle; // Panel container for title
    private JPanel ContentPaneContainer; // Panel container for changing panel, in card layout
    private JLabel lblTitle;
    private JButton btnExit;
    private JButton btnBack;
    private final double LBLTITLE_SCALE = 0.8;
    private final double BTNEXIT_SCALE = 0.5;
    private final double BTNBACK_SCALE = 0.5;

    // Start
    private JPanel ContentStart; // Start Panel
    private JLabel lblWelcomeMsg;
    private JLabel lblWhatName;
    private JLabel lblLeftBrac;
    private JLabel lblRightBrac;
    private JLabel lblNameWarning;
    private JTextField textField_Name;
    private JButton btnConfirm;
    private final double LBLWELCOMEMSG_SCALE = 0.4;
    private final double LBLWHATNAME_SCALE = 0.4;
    private final double LBLBRAC_SCALE = 0.4;
    private final double BTNCONFIRM_SCALE = 0.7;

    // Menu
    private JPanel ContentMenu; // Menu Panel
    private JLabel lblGreeting;
    private JLabel lblGameDescription;
    private JButton btnModeAdd;
    private JButton btnModeMinus;
    private JButton btnModeMultiply;
    private JButton btnModeMix;
    private final double BTNMODE_SCALE = 0.75;

    // Game
    private JPanel ContentGame; // Game Panel
    private JLabel lblQuestionNum;
    private JLabel lblNum1;
    private JLabel lblOp;
    private JLabel lblNum2;
    private JLabel lblEqual;
    private JLabel lblEqualBrac;
    private JLabel lblAnswer;
    private JTextField textField_Answer;
    private JButton btnNext;
    private JLabel lblAnsWarning;
    private JLabel lblQN;
    private final double LBLQUESTIONNUM_SCALE = 0.8;
    private final double LBLNUM_SCALE = 1;
    private final double LBLSIGN_SCALE = 1;
    private final double LBLEQUALBRAC_SCALE = 1;
    private final double LBLANSWER_SCALE = 0.65;
    private final double BTNNEXT_SCALE = 0.65;
    private final double LBLQN_SCALE = 1;

    // Score
    private JPanel ContentScore; // Score Panel
    private JLabel lblScoreBoard;
    private JLabel lblScoreMode;

    private JLabel lblScoreNo;
    private JLabel lblScoreNo1;
    private JLabel lblScoreNo5;
    private JLabel lblScoreNo4;
    private JLabel lblScoreNo3;
    private JLabel lblScoreNo2;

    private JLabel lblScoreQuestion;
    private JLabel lblScoreQ1;
    private JLabel lblScoreQ2;
    private JLabel lblScoreQ3;
    private JLabel lblScoreQ4;
    private JLabel lblScoreQ5;

    private JLabel lblScoreAnswer;
    private JLabel lblScoreAns1;
    private JLabel lblScoreAns2;
    private JLabel lblScoreAns3;
    private JLabel lblScoreAns4;
    private JLabel lblScoreAns5;

    private JLabel lblScoreScore;
    private JLabel lblScoreScore1;
    private JLabel lblScoreScore2;
    private JLabel lblScoreScore3;
    private JLabel lblScoreScore4;
    private JLabel lblScoreScore5;

    private JLabel lblCrrAns;
    private JLabel lblCrrAns1;
    private JLabel lblCrrAns2;
    private JLabel lblCrrAns3;
    private JLabel lblCrrAns4;
    private JLabel lblCrrAns5;

    private JButton btnFinish;
    private final double LBLSCOREBOARD_SCALE = 0.45;
    private final double LBLSCOREMODE_SCALE = 0.9;
    private final double LBLSCORENO_SCALE = 0.4;
    private final double LBLSCORENON_SCALE = 0.4;
    private final double LBLSCOREQUESTION_SCALE = 0.4;
    private final double LBLSCOREANSWER_SCALE = 0.4;
    private final double LBLSCORESCORE_SCALE = 0.4;
    // private final double LBLSCORESCOREN_SCALE = 0.3;
    private final double LBLCRRANS = 0.3;
    private final double BTNFINISH_SCALE = 0.6;

    // A counter or tracker for tracking current panel
    private enum paneIndex {
        Start, Menu, Game1, Game2, Game3, Game4, Game5, Score
    }

    paneIndex currentPane;

    // Game Methods
    private void gameSetAns(int index, int answer) {
        // Store user answer
        gameArr.getItemOf(index).setUserAnswer(answer);
        // Check user answer
        gameArr.getItemOf(index).checkUserAnswer();
    }

    private void gameInit(int index) {

        String iconPath;

        // Set game graphics
        // Set Question Counter
        iconPath = "img/Q" + (index) + "5.png";
        GUI_Util.setComptIcon(lblQuestionNum, LBLQUESTIONNUM_SCALE, iconPath);
        iconPath = "img/Q" + (index) + ".png";
        GUI_Util.setComptIcon(lblQN, LBLQN_SCALE, iconPath);

        // Set Num 1 and Num 2 icon
        iconPath = "img/" + String.valueOf(gameArr.getItemOf(index).getVar1()) + ".png";
        GUI_Util.setComptIcon(lblNum1, LBLNUM_SCALE, iconPath);
        iconPath = "img/" + gameArr.getItemOf(index).getVar2() + ".png";
        GUI_Util.setComptIcon(lblNum2, LBLNUM_SCALE, iconPath);

        // Set Op icon
        iconPath = "img/Op" + gameArr.getItemOf(index).getModeOp() + ".png";
        GUI_Util.setComptIcon(lblOp, LBLSIGN_SCALE, iconPath);

        // Reset answer field
        textField_Answer.setText("");
        textField_Answer.requestFocus();
    }

    private void gameAddInit() {
        gameArr.clear(); // Clear Game Question
        gameArr.add(new ModeAdd()); // Set Question 1
        gameArr.add(new ModeAdd()); // Set Question 2
        gameArr.add(new ModeAdd()); // Set Question 3
        gameArr.add(new ModeAdd()); // Set Question 4
        gameArr.add(new ModeAdd()); // Set Question 5
        gameInit(1); // Set Question 1 Graphics

    }

    private void gameMinusInit() {
        gameArr.clear(); // Clear Game Question
        gameArr.add(new ModeMinus()); // Set Question 1
        gameArr.add(new ModeMinus()); // Set Question 2
        gameArr.add(new ModeMinus()); // Set Question 3
        gameArr.add(new ModeMinus()); // Set Question 4
        gameArr.add(new ModeMinus()); // Set Question 5
        gameInit(1); // Set Question 1 Graphics
    }

    private void gameMultiplyInit() {
        gameArr.clear(); // Clear Game Question
        gameArr.add(new ModeMultiply()); // Set Question 1
        gameArr.add(new ModeMultiply()); // Set Question 2
        gameArr.add(new ModeMultiply()); // Set Question 3
        gameArr.add(new ModeMultiply()); // Set Question 4
        gameArr.add(new ModeMultiply()); // Set Question 5
        gameInit(1); // Set Question 1 Graphics
    }

    private void gameMixInit() {
        gameArr.clear(); // Clear Game Question
        gameArr.add(new ModeMix()); // Set Question 1
        gameArr.add(new ModeMix()); // Set Question 2
        gameArr.add(new ModeMix()); // Set Question 3
        gameArr.add(new ModeMix()); // Set Question 4
        gameArr.add(new ModeMix()); // Set Question 5
        gameInit(1); // Set Question 1 Graphics
    }

    private void scoreBoardInit() {
        // Set Mode graphics
        GUI_Util.setComptIcon(lblScoreMode, LBLSCOREMODE_SCALE, strIconPathOfGMode(1));
        // Set Question graphics
        lblScoreQ1.setText(strOfNum(1, 1) + " " + strOfGMode(1) + " " + strOfNum(1, 2));
        lblScoreQ2.setText(strOfNum(2, 1) + " " + strOfGMode(2) + " " + strOfNum(2, 2));
        lblScoreQ3.setText(strOfNum(3, 1) + " " + strOfGMode(3) + " " + strOfNum(3, 2));
        lblScoreQ4.setText(strOfNum(4, 1) + " " + strOfGMode(4) + " " + strOfNum(4, 2));
        lblScoreQ5.setText(strOfNum(5, 1) + " " + strOfGMode(5) + " " + strOfNum(5, 2));

        // Set Correct Answer
        lblCrrAns1.setText(strOfAnswer(1));
        lblCrrAns2.setText(strOfAnswer(2));
        lblCrrAns3.setText(strOfAnswer(3));
        lblCrrAns4.setText(strOfAnswer(4));
        lblCrrAns5.setText(strOfAnswer(5));

        // Set Answer
        lblScoreAns1.setText(strOfUserAnswer(1));
        lblScoreAns2.setText(strOfUserAnswer(2));
        lblScoreAns3.setText(strOfUserAnswer(3));
        lblScoreAns4.setText(strOfUserAnswer(4));
        lblScoreAns5.setText(strOfUserAnswer(5));

        // Set Score
        GUI_Util.setComptIcon(lblScoreScore1, LBLSCORESCORE_SCALE, strIPathOfAns(1));
        GUI_Util.setComptIcon(lblScoreScore2, LBLSCORESCORE_SCALE, strIPathOfAns(2));
        GUI_Util.setComptIcon(lblScoreScore3, LBLSCORESCORE_SCALE, strIPathOfAns(3));
        GUI_Util.setComptIcon(lblScoreScore4, LBLSCORESCORE_SCALE, strIPathOfAns(4));
        GUI_Util.setComptIcon(lblScoreScore5, LBLSCORESCORE_SCALE, strIPathOfAns(5));
    }

    private String strOfNum(int index, int numVar) {
        // Return string of 1st random number and 2nd random number
        switch (numVar) {
        case 1:
            return Integer.toString(gameArr.getItemOf(index).getVar1()); // Return 1st var
        case 2:
            return Integer.toString(gameArr.getItemOf(index).getVar2()); // Return 2nd var
        default:
            return ""; // Return empty string
        }
    }

    private String strOfGMode(int index) {
        // Return string of the operator
        switch (gameArr.getItemOf(index).getModeOp()) {
        case Add:
            return "+"; // Return +
        case Minus:
            return "-"; // Return -
        case Multiply:
            return "x"; // Return x
        default:
            return ""; // Return empty string
        }
    }

    private String strIconPathOfGMode(int index) {
        // Return string of the game mode graphic path base on the game mode 
        switch (gameArr.getItemOf(index).getGameMode()) {
        case Add:
            return "img/Add.png"; // Return add mode graphic
        case Minus:
            return "img/Minus.png"; // Return minus mode grpahics
        case Multiply:
            return "img/Multiply.png"; // Return multiply mode graphics
        case Mix:
            return "img/Mixed.png"; // Return mixed mode graphics
        default:
            return ""; // Return nothing
        }
    }

    private String strOfAnswer(int index) {
        // Return the correct answer as string
        return Integer.toString(gameArr.getItemOf(index).getAnswer());
    }

    private String strOfUserAnswer(int index) {
        // Return user's answer as string
        return Integer.toString(gameArr.getItemOf(index).getUserAnswer());
    }

    private String strIPathOfAns(int index) {
        // Return icon path as string of the right or wrong answer base on
        // the user's answer
        if (gameArr.getItemOf(index).getAnsIsCorrect()) {
            // Return the right answer graphic if the answer is correct
            return "img/Right.png";
        } else {
            // Return the wrong answer graphic if the answer is wrong
            return "img/Wrong.png";
        }
    }

    // Constructor of the JFrame
    public KidsMathApp() {
        // Set Graphics Title Pane
        GUI_Util.setComptIcon(lblTitle, LBLTITLE_SCALE, "img/Title.png");
        GUI_Util.setComptIcon(btnExit, BTNEXIT_SCALE, "img/Exit.png");
        GUI_Util.setComptIcon(btnBack, BTNBACK_SCALE, "img/Back.png");

        // Set Graphics Content Start Pane
        GUI_Util.setComptIcon(lblWelcomeMsg, LBLWELCOMEMSG_SCALE, "img/WelcomeMsg.png");
        GUI_Util.setComptIcon(lblWhatName, LBLWHATNAME_SCALE, "img/WhatName.png");
        GUI_Util.setComptIcon(lblLeftBrac, LBLBRAC_SCALE, "img/LeftBrac.png");
        GUI_Util.setComptIcon(lblRightBrac, LBLBRAC_SCALE, "img/RightBrac.png");
        GUI_Util.setComptIcon(btnConfirm, BTNCONFIRM_SCALE, "img/Confirm.png");
        GUI_Util.makeTransparent(textField_Name);
        btnBack.setEnabled(false);

        // Set Graphics Content Menu Pane
        GUI_Util.setComptIcon(btnModeAdd, BTNMODE_SCALE, "img/Add.png");
        GUI_Util.setComptIcon(btnModeMinus, BTNMODE_SCALE, "img/Minus.png");
        GUI_Util.setComptIcon(btnModeMultiply, BTNMODE_SCALE, "img/Multiply.png");
        GUI_Util.setComptIcon(btnModeMix, BTNMODE_SCALE, "img/Mixed.png");

        // Set Graphics Content Game Pane
        GUI_Util.setComptIcon(lblEqual, LBLSIGN_SCALE, "img/OpEqual.png");
        GUI_Util.setComptIcon(lblEqualBrac, LBLEQUALBRAC_SCALE, "img/BracEqual.png");
        GUI_Util.setComptIcon(lblAnswer, LBLANSWER_SCALE, "img/Answer_1.png");
        GUI_Util.setComptIcon(btnNext, BTNNEXT_SCALE, "img/Next.png");
        GUI_Util.makeTransparent(textField_Answer);

        // Set Graphics Content Score
        GUI_Util.setComptIcon(lblScoreBoard, LBLSCOREBOARD_SCALE, "img/ScoreBoard.png");
        GUI_Util.setComptIcon(lblScoreNo, LBLSCORENO_SCALE, "img/Number.png");
        GUI_Util.setComptIcon(lblScoreNo1, LBLSCORENON_SCALE, "img/Q1.png");
        GUI_Util.setComptIcon(lblScoreNo2, LBLSCORENON_SCALE, "img/Q2.png");
        GUI_Util.setComptIcon(lblScoreNo3, LBLSCORENON_SCALE, "img/Q3.png");
        GUI_Util.setComptIcon(lblScoreNo4, LBLSCORENON_SCALE, "img/Q4.png");
        GUI_Util.setComptIcon(lblScoreNo5, LBLSCORENON_SCALE, "img/Q5.png");
        GUI_Util.setComptIcon(lblScoreQuestion, LBLSCOREQUESTION_SCALE, "img/Question.png");
        GUI_Util.setComptIcon(lblCrrAns, LBLCRRANS, "img/CrrAnswer.png");
        GUI_Util.setComptIcon(lblScoreAnswer, LBLSCOREANSWER_SCALE, "img/Answer.png");
        GUI_Util.setComptIcon(lblScoreScore, LBLSCORESCORE_SCALE, "img/Score.png");
        GUI_Util.setComptIcon(btnFinish, BTNFINISH_SCALE, "img/Finish.png");

        // Frame Initialize
        GUI_Util.cInit(this, Container);

        // Events Title Pane, Set mouse hover, and click effect
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                GUI_Util.setComptIcon(btnExit, BTNEXIT_SCALE + SCALE_ADJUST, "img/ExitHvr.png");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                GUI_Util.setComptIcon(btnExit, BTNEXIT_SCALE, "img/Exit.png");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                GUI_Util.setComptIcon(btnExit, BTNEXIT_SCALE - SCALE_ADJUST, "img/ExitPress.png");
                JFrame frame = (JFrame)SwingUtilities.getWindowAncestor(btnExit);
                frame.dispose();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                GUI_Util.setComptIcon(btnExit, BTNEXIT_SCALE + SCALE_ADJUST, "img/ExitHvr.png");
                JFrame frame = (JFrame)SwingUtilities.getWindowAncestor(btnExit);
                frame.dispose();
            }

        });

        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                GUI_Util.setComptIcon(btnBack, BTNBACK_SCALE + SCALE_ADJUST, "img/BackHvr.png");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                GUI_Util.setComptIcon(btnBack, BTNBACK_SCALE, "img/Back.png");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                GUI_Util.setComptIcon(btnBack, BTNBACK_SCALE - SCALE_ADJUST, "img/BackPress.png");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                GUI_Util.setComptIcon(btnBack, BTNBACK_SCALE + SCALE_ADJUST, "img/BackHvr.png");
                switch (currentPane) {
                case Menu:
                    GUI_Util.setContentPane(ContentPaneContainer, ContentStart);
                    currentPane = paneIndex.Start;
                    btnBack.setEnabled(false);
                    break;
                case Game1:
                case Game2:
                case Game3:
                case Game4:
                case Game5:
                case Score:
                    GUI_Util.setContentPane(ContentPaneContainer, ContentMenu);
                    currentPane = paneIndex.Menu;
                    break;
                default:
                    break;
                }
            }
        });

        // Events Content Start Pane, Set text field key checking
        textField_Name.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                // Check for illegal key
                if ((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || (e.getKeyChar() >= 65 && e.getKeyChar() <= 90)
                        || (e.getKeyChar() >= 97 && e.getKeyChar() <= 122) || e.getKeyChar() == 8
                        || e.getKeyChar() == 32 || e.getKeyChar() == 127) {
                    if (textField_Name.getText().length() >= 25) {
                        // Length > 25
                        // Set brac warning
                        GUI_Util.setComptIcon(lblLeftBrac, LBLBRAC_SCALE, "img/LeftBracWarning.png");
                        GUI_Util.setComptIcon(lblRightBrac, LBLBRAC_SCALE, "img/RightBracWarning.png");
                        // Set error message
                        lblNameWarning.setText("Warning! Only 25 characters allowed.");
                        e.setKeyChar('\0');
                    } else {
                        // Allow key
                        // Reset Brack
                        GUI_Util.setComptIcon(lblLeftBrac, LBLBRAC_SCALE, "img/LeftBrac.png");
                        GUI_Util.setComptIcon(lblRightBrac, LBLBRAC_SCALE, "img/RightBrac.png");
                        // Reset error message
                        lblNameWarning.setText("");
                    }
                } else {
                    // Set brac warning
                    GUI_Util.setComptIcon(lblLeftBrac, LBLBRAC_SCALE, "img/LeftBracWarning.png");
                    GUI_Util.setComptIcon(lblRightBrac, LBLBRAC_SCALE, "img/RightBracWarning.png");
                    // Block key press
                    e.setKeyChar('\0'); // Block key press
                    lblNameWarning.setText("Warning! Please use alphabets, numbers, and space only.");
                }
            }
        });

        btnConfirm.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                GUI_Util.setComptIcon(btnConfirm, BTNCONFIRM_SCALE + SCALE_ADJUST, "img/ConfirmHvr.png");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                GUI_Util.setComptIcon(btnConfirm, BTNCONFIRM_SCALE, "img/Confirm.png");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                GUI_Util.setComptIcon(btnConfirm, BTNCONFIRM_SCALE - SCALE_ADJUST, "img/ConfirmPress.png");

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                GUI_Util.setComptIcon(btnConfirm, BTNCONFIRM_SCALE + SCALE_ADJUST, "img/ConfirmHvr.png");
                // Retrieve player name
                String temp = textField_Name.getText(); // Get name
                temp = temp.strip(); // Remove traling and leading space
                if (temp.length() == 0) {
                    // Name field empty
                    // Reset name field
                    textField_Name.setText("");
                    // Set brac warning
                    GUI_Util.setComptIcon(lblLeftBrac, 0.4, "img/LeftBracWarning.png");
                    GUI_Util.setComptIcon(lblRightBrac, 0.4, "img/RightBracWarning.png");
                    lblNameWarning.setText("Warning! Your name cannot be empty!");
                } else {
                    // Name field filled
                    // Change to Menu pane
                    GUI_Util.setContentPane(ContentPaneContainer, ContentMenu);
                    currentPane = paneIndex.Menu; // Set pane index
                    player.setPName(textField_Name.getText()); // Set player name
                    lblGreeting.setText("Hello dear " + player.getPName() + "."); // Set Greeting Text
                    btnBack.setEnabled(true); // Enable back button
                    lblNameWarning.setText(""); // Reset error message
                }
            }

        });

        //  Events Content Menu Pane, Set mouse hover, and click effect
        btnModeAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                GUI_Util.setComptIcon(btnModeAdd, BTNMODE_SCALE, "img/AddHvr.png");
                lblGameDescription.setText("Combind 2 numbers to find their total sum."); // Set description for Add
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                GUI_Util.setComptIcon(btnModeAdd, BTNMODE_SCALE, "img/Add.png");
                lblGameDescription.setText("What would you like to play today?"); // Reset description 
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                GUI_Util.setComptIcon(btnModeAdd, BTNMODE_SCALE, "img/AddPress.png");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                GUI_Util.setComptIcon(btnModeAdd, BTNMODE_SCALE, "img/Add.png");

                // Change to Game Pane
                GUI_Util.setContentPane(ContentPaneContainer, ContentGame);
                gameAddInit(); // Start game 1
                currentPane = paneIndex.Game1; // Set pane index
            }
        });

        btnModeMinus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                GUI_Util.setComptIcon(btnModeMinus, BTNMODE_SCALE, "img/MinusHvr.png");
                lblGameDescription.setText("Find the difference betweren 2 numbers."); // Set description for Subtract
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                GUI_Util.setComptIcon(btnModeMinus, BTNMODE_SCALE, "img/Minus.png");
                lblGameDescription.setText("What would you like to play today?"); // Reset description 
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                GUI_Util.setComptIcon(btnModeMinus, BTNMODE_SCALE, "img/MinusPress.png");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                GUI_Util.setComptIcon(btnModeMinus, BTNMODE_SCALE, "img/Minus.png");

                // Change to Game Pane
                GUI_Util.setContentPane(ContentPaneContainer, ContentGame);
                gameMinusInit(); // Start game 1
                currentPane = paneIndex.Game1; // Set pane index
            }

        });

        btnModeMultiply.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                GUI_Util.setComptIcon(btnModeMultiply, BTNMODE_SCALE, "img/MultiplyHvr.png");
                lblGameDescription.setText("Find the product of 2 numbers."); // Set description for Multiply
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                GUI_Util.setComptIcon(btnModeMultiply, BTNMODE_SCALE, "img/Multiply.png");
                lblGameDescription.setText("What would you like to play today?"); // Reset description 
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                GUI_Util.setComptIcon(btnModeMultiply, BTNMODE_SCALE, "img/MultiplyPress.png");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                GUI_Util.setComptIcon(btnModeMultiply, BTNMODE_SCALE, "img/Multiply.png");

                // Change to Game Pane
                GUI_Util.setContentPane(ContentPaneContainer, ContentGame);
                gameMultiplyInit(); // Start game 1
                currentPane = paneIndex.Game1; // Set pane index
            }

        });

        btnModeMix.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                GUI_Util.setComptIcon(btnModeMix, BTNMODE_SCALE, "img/MixedHvr.png");
                lblGameDescription.setText("Do you have what it takes to do it?!"); // Set description for Multiply
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                GUI_Util.setComptIcon(btnModeMix, BTNMODE_SCALE, "img/Mixed.png");
                lblGameDescription.setText("What would you like to play today?"); // Reset description 
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                GUI_Util.setComptIcon(btnModeMix, BTNMODE_SCALE, "img/MixedPress.png");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                GUI_Util.setComptIcon(btnModeMix, BTNMODE_SCALE, "img/Mixed.png");

                // Change to Game Pane
                GUI_Util.setContentPane(ContentPaneContainer, ContentGame);
                gameMixInit(); // Start game 1
                currentPane = paneIndex.Game1; // Set pane index                
            }

        });

        // Events Content Game Pane, Set mouse hover, and click effect
        btnNext.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                GUI_Util.setComptIcon(btnNext, BTNNEXT_SCALE + SCALE_ADJUST, "img/NextHvr.png");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                GUI_Util.setComptIcon(btnNext, BTNNEXT_SCALE, "img/Next.png");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                GUI_Util.setComptIcon(btnNext, BTNNEXT_SCALE - SCALE_ADJUST, "img/NextPress.png");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                GUI_Util.setComptIcon(btnNext, BTNNEXT_SCALE + SCALE_ADJUST, "img/NextHvr.png");

                // Set next game
                String userAnswer = textField_Answer.getText().strip();
                if (userAnswer.length() != 0) {
                    // Answer is not empty
                    // Reset warning message
                    lblAnsWarning.setText("");

                    // Next Question
                    switch (currentPane) {
                    case Game1:
                        // Set answer
                        gameSetAns(1, Integer.valueOf(userAnswer));
                        // Set next question
                        gameInit(2);
                        currentPane = paneIndex.Game2;
                        break;
                    case Game2:
                        // Set answer
                        gameSetAns(2, Integer.valueOf(userAnswer));
                        // Set next question
                        gameInit(3);
                        currentPane = paneIndex.Game3;
                        break;
                    case Game3:
                        // Set answer
                        gameSetAns(3, Integer.valueOf(userAnswer));
                        // Set next question
                        gameInit(4);
                        currentPane = paneIndex.Game4;
                        break;
                    case Game4:
                        // Set answer
                        gameSetAns(4, Integer.valueOf(userAnswer));
                        // Set next question
                        gameInit(5);
                        currentPane = paneIndex.Game5;
                        break;
                    case Game5:
                        // Set answer
                        gameSetAns(5, Integer.valueOf(userAnswer));

                        // Change To Score Pane
                        GUI_Util.setContentPane(ContentPaneContainer, ContentScore);
                        scoreBoardInit(); // Set score board graphics
                        currentPane = paneIndex.Score; // Set pane index
                        break;

                    default:
                        break;
                    }
                } else {
                    // Answer is empty
                    // Show warnign message
                    lblAnsWarning.setText("Warning! Answer cannot be empty.");
                }
            }

        });

        textField_Answer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                // Check for illegal key
                if ((e.getKeyChar() >= 48 && e.getKeyChar() <= 57) || e.getKeyChar() == 8) {
                    if (textField_Answer.getText().length() > 2) {
                        // Length > 3
                        // Set error message
                        lblAnsWarning.setText("Warning! Only 3 numbers allowed.");
                        e.setKeyChar('\0');
                    } else {
                        // Allow key
                        // Reset error message
                        lblAnsWarning.setText("");
                    }
                } else {
                    // Block key press
                    e.setKeyChar('\0'); // Block key press
                    lblAnsWarning.setText("Warning! Please enter numbers only.");
                }
            }
        });

        // Evetns Content Score
        btnFinish.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                GUI_Util.setComptIcon(btnFinish, BTNCONFIRM_SCALE + SCALE_ADJUST, "img/FinishHvr.png");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                GUI_Util.setComptIcon(btnFinish, BTNCONFIRM_SCALE, "img/Finish.png");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                GUI_Util.setComptIcon(btnFinish, BTNCONFIRM_SCALE - SCALE_ADJUST, "img/FinishPress.png");

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                GUI_Util.setComptIcon(btnFinish, BTNCONFIRM_SCALE + SCALE_ADJUST, "img/FinishHvr.png");
                // Reset Game
                gameArr.clear();
                // Return to Mode page
                GUI_Util.setContentPane(ContentPaneContainer, ContentMenu);
            }

        });

        // Set mouse listener for the frame itself
        // Used for drag and move the window
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                mouoseCoordinate = null;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mouoseCoordinate = e.getPoint();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                Point currCoords = e.getLocationOnScreen();
                setLocation(currCoords.x - mouoseCoordinate.x, currCoords.y - mouoseCoordinate.y);
            }
        });

    }

    public static void main(String[] args) {

        JFrame frame = new KidsMathApp();

        // Alternative method to add drag and drop to frame.
        // Backup option for testing and degbug
        // frame.addMouseListener(new MouseAdapter() {
        //     @Override
        //     public void mouseReleased(MouseEvent e) {
        //         setMouoseCoordinate(null);
        //     }
        //     @Override
        //     public void mousePressed(MouseEvent e) {
        //         mouoseCoordinate = e.getPoint();
        //     }
        // });
        // frame.addMouseMotionListener(new MouseMotionAdapter() {
        //     @Override
        //     public void mouseDragged(MouseEvent e) {
        //         super.mouseDragged(e);
        //         Point currCoords = e.getLocationOnScreen();
        //         frame.setLocation(currCoords.x - mouoseCoordinate.x, currCoords.y - mouoseCoordinate.y);
        //     }
        // });

    }
}
