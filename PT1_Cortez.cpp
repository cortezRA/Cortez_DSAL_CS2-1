//Ryan Abe Cortez

#include <iostream>
#include <conio.h>
#include <iomanip>
#include <string>

using namespace std;

void Display() {
    cout << "\nWelcome to Kakegurui's 'ROCK-PAPER-SCISSORS' Game\n" << endl;
    cout << "[1] - Start Game\n[2] - View Instructions\n[3] - Quit Game\n" << endl;
}

void Instructions() {
    cout << "\nHere are the instructions to Kakegurui's 'ROCK-PAPER-SCISSORS' Game\n" << endl;
    cout << "There are three types of cards in this game: ROCK, PAPER, and SCISSORS" << endl;
    cout << "It will follow the rules as per the original ROCK-PAPER-SCISSORS GAME:\n" << endl;
    cout << "- PAPER beats ROCK\n- SCISSORS beats PAPER\n- ROCK BEATS SCISSORS\n" << endl;
    getch();
    cout << "The game consists of 8 rounds.\n" << endl;
    cout << "- When the game starts, you will have your ROCK, PAPER, and SCISSORS cards where" << endl;
    cout << " you need to choose one card per round" << endl;
    cout << "- When your card beats the opponent's card, you will gain a point and vice versa" << endl;
    cout << "- The one with the most points wins.. Goodluck!\n" << endl;
    cout << "-- RETURNING TO MAIN MENU --" << endl;
}

void Refresh() {
    cout << "You have inputted a wrong key...\n" << endl;
    cout << "-- REFRESHING MENU --" << endl;
}

void Opponent(int OpponentCard[8], int OpponentRandom, string OpponentConvert[7]) {
    bool duplicate;
    
    srand(time(NULL));
    int duplicate1 = 3; int duplicate2 = 3; int duplicate3 = 3;
	
	for (int ctr = 0; ctr < 8; ctr++) {
		do {
            duplicate = true;
			OpponentRandom = rand() % 6 + 4;

            if (OpponentRandom == 4) {
                if (duplicate1 <= 0) {
                    duplicate = true;
                }
                else {
                    duplicate1--;
                    duplicate = false;
                }
            }
            else if (OpponentRandom == 5) {
                if (duplicate2 <= 0) {
                    duplicate = true;
                }
                else {
                    duplicate2--;
                    duplicate = false;
                }
            }
            else if (OpponentRandom == 6) {
                if (duplicate3 <= 0) {
                    duplicate = true;
                }
                else {
                    duplicate3--;
                    duplicate = false;
                }
            }	
		} while (duplicate == true);
		OpponentCard[ctr] = OpponentRandom;

        if (OpponentCard[ctr] == 4) {
            OpponentConvert[ctr] = "Rock";
        }
        else if (OpponentCard[ctr] == 5) {
            OpponentConvert[ctr] = "Paper";
        }
        else if (OpponentCard[ctr] == 6) {
            OpponentConvert[ctr] = "Scissors";
        }
	}
}

void GameStart (int PlayerCard[3], int OpponentCard[8], string RPSConvert[3], string OpponentConvert[8], int total) {
    int PlayerScore = 0, OpponentScore = 0;
    int choice = 0;

    for (int round = 0; round < total; round++) {
        int go = 0;
        do {
            cout << "_________________________________________________________________________________" << endl;
            cout << "\n--Round  " << (round+1) << "--\n" << endl;
            cout << "Opponent Score: " << OpponentScore << endl;
            cout << endl;
            cout << "[]|[]|[]" <<endl;
            cout << endl;
            cout << "----VS----" <<endl;
            cout << endl;
            cout << "Rock(1)|Paper(2)|Scissors(3)" << endl;
            cout << endl;
            cout << "Player Score: " << PlayerScore << "\n\n" << endl;
            cout << "Press the number of the card you want to play: "<< endl;
            cout << endl;

            cin >> choice;

            cout << "_________________________________________________________________________________" << endl;
            cout << "\n--Round  " << (round+1) << "--" <<endl;
            cout << "Opponent Score: " << OpponentScore << endl;
            cout << endl;
            cout << OpponentConvert[round] <<endl;
            cout << endl;
            cout << "----VS----" <<endl;
            cout << endl;

            if (choice == 1) {
                go = 1;
                cout << "Rock" << endl;
                cout << endl;
                cout << "Player Score: " << PlayerScore << endl;
                getch();
            }
            else if (choice == 2) {
                go = 1;
                cout << "Paper" << endl;
                cout << endl;
                cout << "Player Score: " << PlayerScore << endl;
                getch();
           }
            else if (choice == 3) {
                go = 1;
                cout << "Scissors" << endl;
                cout << endl;
                cout << "Player Score: " << PlayerScore << endl;
                getch();
            }
            else {
                Refresh();
                getch();
            }
        } while (go != 1);

        getch();
        if(choice == 1) {
            if(OpponentCard[round] == 5) {
                cout << "\n--YOU LOSE--" << endl;
                OpponentScore++;
            }
            else if(OpponentCard[round] == 4) {
                cout << "\n--- DRAW ---" << endl;
            }
            else if(OpponentCard[round] == 6) {
                cout << "\n--YOU  WIN--" << endl;
                PlayerScore++;
            }
        }
        else if(choice == 2) {
            if(OpponentCard[round] == 5) {
                cout << "\n--- DRAW ---" << endl;
            }
            else if(OpponentCard[round] == 4) {
                cout << "\n--YOU  WIN--" << endl;
                PlayerScore++;
            }
            else if(OpponentCard[round] == 6) {
                cout << "\n--YOU LOSE--" << endl;
                OpponentScore++;
            }
        }
        if(choice == 3) {
            if(OpponentCard[round] == 5) {
                cout << "\n--YOU  WIN--" << endl;
                PlayerScore++;
            }
            else if(OpponentCard[round] == 4) {
                cout << "\n--YOU LOSE--" << endl;
                OpponentScore++;
            }
            else if(OpponentCard[round] == 6) {
                cout << "\n--- DRAW ---" << endl;
            }
        }
        getch();
    }
    
    cout << "\n_________________________________________________________________________________" << endl;
    cout << "\n--WE HAVE REACHED THE END OF THE MATCH--\n" << endl;

    if (PlayerScore > OpponentScore) {
        cout << "You won against the opponent with " << PlayerScore << "-" << OpponentScore << " score difference!\n" << endl;
        cout << "---- CONGRATULATIONS! ----" << endl;
    }
    else if (PlayerScore == OpponentScore) {
        cout << "The match ended to a draw!!!\n" << endl;
        cout << "---- CONGRATULATIONS TO BOTH OUR PLAYERS!!! ----" << endl;
    }
    else {
        cout << "You lost against the opponent with " << PlayerScore << "-" << OpponentScore << " score difference!\n" << endl;
        cout << "-- BETTER LUCK NEXT TIME! --" << endl;
    }
    getch();
}

void Quit() {
    cout << "Are you sure you want to quit the game?" << endl;
    cout << "[Y] - Yes\t[N] - No\n" << endl;
}

//-------------------------------------------------------------------------------------

int main() {
    int quit = 0; 
    int total = 8;
    int CardRandom, CardCustom, OpponentRandom;
    int* PlayerCard = new int[8];
    string* RPSConvert = new string[8];
    int* OpponentCard = new int[8];
    string* OpponentConvert = new string[8];

    while (quit == 0) {
        int key;
        Display();
        cin >> key;

        if(key == 1) {
            cout << "Starting the game...\n\n" << endl;
            Opponent(OpponentCard, OpponentRandom, OpponentConvert);
            getch();
            GameStart(PlayerCard, OpponentCard, RPSConvert, OpponentConvert, total);
            
        }
        else if(key == 2) {
            Instructions();
            getch();
        }
        else if(key == 3) {
            int remain = 1;
            
            do {
                char choice;
                Quit();
                cin >> choice;

                if(choice == 'Y' || choice == 'y'){
                    remain = 0; quit = 1;
                }
                else if(choice == 'N' || choice == 'n'){
                    remain = 0; cout << "-- RETURNING TO MAIN MENU --" << endl;
                    getch();
                }
            } while(remain == 1);
        }
        else {
            Refresh();
            getch();
        }
    }

    return 0;
}
