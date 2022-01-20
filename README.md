# 3LuckyDuckies
### Nora Miller, Ziying Jian, Gloria Lee

## Chain Reaction

Our trio’s proposal is to create a Chain Reaction game in terminal - a grid based game in which each box of the grid contains a maximum of 2, 3, or 4 dots.
Corner boxes contain at most 2 dots; edge boxes at most 3; middle boxes at most 4. When this maximum is reached, the box ‘explodes’ - each dot contained in the box is sent to one neighboring box.

Since this is a 2 (or more)-player game, the objective is to eliminate all of the other player’s dots.
Each player’s dots have a color unique to them (red or green etc.).
All boxes can contain the dots of only one player, and when one of your boxes explodes into a box containing dots of the other player, the other player’s dots become yours.
Once the board only has dots of your color, you’ve won.
Since explosions in one box can often lead to chain reactions of explosions in other boxes, hence the name Chain Reaction.

Essentially, we’re trying to create a version of the game that can be run in the terminal.
https://play.google.com/store/apps/details?id=com.BuddyMattEnt.ChainReaction&hl=en_US&gl=US

## How to Launch
Open the terminal and run:

`cd 3LuckyDuckies`

`javac *.java`

`java Woo`
