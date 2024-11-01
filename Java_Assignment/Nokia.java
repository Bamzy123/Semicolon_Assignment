import java.util.Scanner;

public class Nokia {
 	public static void main(String[] args){

	Scanner input = new Scanner(System.in);

	System.out.println("List of menu functions:\n 1. Phonebook \n 2. Message \n 3. Chat \n 4. Call register \n 5. Tone \n 6. Settings \n 7. Call divert \n 8. Games \n 9. Calculator \n 10. Reminder \n 11. Clock \n 12. Profiles \n 13. Sim services");

	int function = input.nextInt();

	switch(function){
		case 1:
			System.out.println("Phonebook:\n 1. Search \n 2. Service no \n 3. Add name \n 4. Erase \n 5. Edit \n 6. Assign tone \n 7. Send b' card \n 8. Option \n 9. Speed dials \n 10. Voice tags");
               		int phonebooks = input.nextInt();
		
		 	  switch(phonebooks){
				case 1: 
					System.out.println("search");break;
				case 2: 
					System.out.println("service no");break;
				case 3:
					System.out.println("Add name");break;
				case 4:
					System.out.println("erase");break;
				case 5:
					System.out.println("edit");break;
				case 6:
					System.out.println("assign tone");break;
				case 7:
					System.out.println("send b' card");break;
				case 8:
				System.out.println("Option:\n 1. Type of view \n 2. Memory status");
				int option = input.nextInt();
					switch(option) {
						case 1:
							System.out.println("type of view");break;
						case 2:
							System.out.println("memory status");break;
					}
						break;
				case 9:
					System.out.println("speed dials");break;
				case 10:
					System.out.println("voice tags");break;
			}
						break;
		case 2: 
			System.out.println("Message:\n 1. Write messages \n 2. Inbox \n 3. Outbox \n 4. Picture messages \n 5. Templates \n 6. Smileys \n 7. Messages settings \n 8. Info Service \n 9. Voice mailbox \n 10. Service command editor");
			int message = input.nextInt();

			  switch(message){
				case 1:
					System.out.println("write messages");break;
				case 2:
					System.out.println("inbox");break;
				case 3:
					System.out.println("outbox");break;
				case 4:
					System.out.println("picture messages");break;
				case 5:
					System.out.println("templates");break;
				case 6:
					System.out.println("smileys");break;
				case 7:
					System.out.println("please choose:\n 1. Set \n 2. Common");
					int messages = input.nextInt();
						
						switch(messages){
							case 1:
								System.out.println("please choose:\n 1. message centre number\n 2. messages sent as\n 3. messages validity");
								int sets = input.nextInt();
				
							switch(sets){
								case 1: 
									System.out.println("message centre number");break;
								case 2:
									System.out.println("messages sent as");break;
								case 3:
									System.out.println("messages validity");break;
							}
										break;
						        case 2:
								System.out.println("common:\n 1. delivery\n 2. Reply via same centre\n 3. Character support");
								int common = input.nextInt();
								
						        switch(common){
								case 1:
									System.out.println("delivery");break;
								case 2:
									System.out.println("Reply via same centre");break;
								case 3:
									System.out.println("Character support");break;
								}
										break;
						}
							break;
                                 case 8:
					System.out.println("Info service");break;
			         case 9:
					System.out.println("Voice mailbox number");break;
			        case 10:
					System.out.println("Service command editor");break;
						}
						break;		
	    case 3:
		    System.out.println("Chat");break;
		
	    case 4:   
   		    System.out.println("call register:\n 1. Missed calls \n 2. Received calls \n 3. Dialled number \n 4. Erase recent call lists \n 5. Show call duration \n 6. Show call costs \n 7. Call cost settings \n 8. Prepaid credit");
		    int calls = input.nextInt();

			switch(calls){
				case 1:
					System.out.println("missed calls");break;
				case 2:
					System.out.println("received calls");break;
				case 3:
					System.out.println("dialled numbers");break;
				case 4:
					System.out.println("erase recent call lists");break;
				case 5:
					System.out.println("duration:\n 1. last call duration \n 2. all calls' duration \n 3. received calls' duration \n 4. dialled calls' duration \n 5. clear timer");
					int duration = input.nextInt();
				
					switch(duration){
						case 1:
							System.out.println("last call duration");break;
						case 2:
							System.out.println("alls' duration");break;
						case 3:
							System.out.println("received calls' duration");break;
						case 4:
							System.out.println("dialled calls' duration");break;
						case 5:
							System.out.println("clear timer");
					}break;
		 	      case 6:
				      System.out.println("cost:\n 1. last call costs \n 2. all calls' \n 3. clear counters");
				      int cost = input.nextInt();
				
					switch(cost){
						case 1:
							System.out.println("last call costs");break;
						case 2:
							System.out.println("all calls' cost");break;
						case 3:
							System.out.println("clear counters");
					}break;
			      case 7:
				    System.out.println("cost settings:\n 1. Call cost limit \n 2. Show costs in");
				    int costSettings = input.nextInt();
						
						switch(costSettings){
							case 1:
								System.out.println("Call cost limit");break;
							case 2:
								System.out.println("Show costs in");
				}break;
			      case 8:
				   System.out.println("Prepaid credit");break;
				}
				break;
	     case 5:
			System.out.println("Tone:\n 1. Ringing tone \n 2. Ring volume \n 3. Incoming call alert \n 4. Composer \n 5. Messages alert tone \n 6. Keyboard \n 7.Warning \n 8. Vibrating alert \n 9. Screen saver");
			int tone = input.nextInt();

				switch(tone){
					case 1:
						System.out.println("Ringing tone");break;
					case 2:
						System.out.println("Ring volume");break;
					case 3:
						System.out.println("Incoming call alert");break;
					case 4:
						System.out.println("Composer");break;
					case 5:
						System.out.println("Messages alert tone");break;
					case 6:
						System.out.println("Keyboard");break;
					case 7:
						System.out.println("Warning");break;
					case 8:
						System.out.println("Vibrating alert");break;
					case 9:
						System.out.println("Screen saver");
				}break;
		case 6:
			  System.out.println("Settings:\n 1. Call settings \n 2. Phone settings \n 3. Security settings \n 4. Restore factory settings");
			  int setting = input.nextInt();

				switch(setting){
					case 1:
						System.out.println("Calls:\n 1. Automatic redial \n 2. Speed dialling \n 3. Call waiting options \n 4. Own number sending \n 5. Phone line in use \n 6. Automatic answer");
						int calling = input.nextInt();

							switch(calling){
								case 1:
									System.out.println("Automatic redial");break;
								case 2:
									System.out.println("Speed dialling");break;
								case 3:
									System.out.println("Call waiting options");break;
								case 5:
									System.out.println("Phone line in use");break;
								case 6:
									System.out.println("Automatic answer");
					}break;
					case 2:
						System.out.println("Phone:\n 1. Language \n 2. Cell info display \n 3. Welcome note \n 4. Network selection \n 5. light \n 6. Confirm SIM service actions");
						int phone = input.nextInt();

							switch(phone){
								case 1:
									System.out.println("Language");break;
								case 2:
									System.out.println("Cell info display");break;
								case 3:
									System.out.println("Welcome note");break;
								case 4:
									System.out.println("Network selection");break;
								case 5:
									System.out.println("light");break;
								case 6:
									System.out.println("Confirm SIM service actions");
					}break;
					case 3:
						System.out.println("security:\n 1. Pin code request \n 2. Call barring service \n 3. Fixed dailing \n 4. Closed user group \n 5. phone security \n 6. Change access codes");
						int security = input.nextInt();

							switch(security){
								case 1:
									System.out.println("Pin code request");break;
								case 2:
									System.out.println("Call barring service");break;
								case 3:
									System.out.println("Fixed dialling");break;
								case 4:
									System.out.println("Closed user group");break;
								case 5:
									System.out.println("phone security");break;
								case 6:
									System.out.println("Change access codes");
					}break;
					case 4:
						System.out.println("restore factory settings");
					}
					 break;
		case 7:
			System.out.println("Call divert");break;
		case 8:
			System.out.println("Games");break;
		case 9:
			System.out.println("Calculator");break;
		case 10:
			System.out.println("Reminders");break;
		case 11:
			System.out.println("Clock:\n 1. Alarm clock \n 2. Clock settings \n 3. Date setting \n 4. Stopwatch \n 5. Countdown timer \n 6. Auto update and time");
			int time = input.nextInt();

				switch(time){
					case 1:
						System.out.println("Alarm clock");break;
					case 2:
						System.out.println("Clock settings");break;
					case 3:
						System.out.println("Date setting");break;
					case 4:
						System.out.println("Stopwatch");break;
					case 5:
						System.out.println("Countdown timer");break;
					case 6:
						System.out.println("Auto update and time");
				}break;
		case 12:
			 System.out.println("Profiles");break;
		case 13:
			 System.out.println("SIM services");break;
			}
		}
	}