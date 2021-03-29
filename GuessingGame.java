import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import java.util.Random;

public class GuessingGame implements ActionListener  {
    JTextField userGuess;
    JButton guessButton, playAgainButton;
    JLabel jlabPrompt, jlabHL, jlabLast;
    
    Random r = new Random();
   
int randomInt;
GuessingGame(){
    
 randomInt = r.nextInt(100) + 1;

    JFrame frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240, 120);
    userGuess  = new JTextField(10);
    userGuess.setActionCommand("myTF");

   JButton guessButton = new JButton("Guess");
   JButton playAgainButton = new JButton("Play Again");

    userGuess.addActionListener(this);
    guessButton.addActionListener(this);
    playAgainButton.addActionListener(this);

    jlabPrompt = new JLabel("Enter your guess: ");
    jlabHL = new JLabel("");
    jlabLast = new JLabel("");

    frame.add(jlabPrompt);
    frame.add(userGuess);
    frame.add(guessButton);
    frame.add(jlabHL);
    frame.add(jlabLast);
    frame.add(playAgainButton);

frame.setVisible(true);

}

public void actionPerformed(ActionEvent ae){
    

if(ae.getActionCommand().equals("Guess")){
 int guess = Integer.parseInt(userGuess.getText());
 if(guess > randomInt){
    jlabHL.setText("Too High!");
    jlabLast.setText("Last guess was: " + userGuess.getText());
 }
 else if(guess < randomInt){
    jlabHL.setText("Too Low!");
  jlabLast.setText("Last guess was: " + userGuess.getText());
}
 
else{
  jlabHL.setText("You got it!");
  jlabLast.setText("Last guess was: " + userGuess.getText());
}
}

if(ae.getActionCommand().equals("Play Again")){
  Random r = new Random();
    randomInt = r.nextInt(100) + 1;
    jlabPrompt.setText("Enter your guess");
    jlabHL.setText("");
    jlabLast.setText("");
    userGuess.setText("");   
}
else{
  jlabHL.setText("You pressed Enter. Please press the Guess Button");
}
}

}

