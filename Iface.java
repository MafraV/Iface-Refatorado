import java.util.*;

public class Iface {

    private Map<String, Account> accounts = new HashMap<String, Account>();
    private Map<String, Community> communitys = new HashMap<String, Community>();
    Scanner input = new Scanner(System.in);

    public void addAccount()
    {
        System.out.print("Please, enter your name and last name: ");
        String name = input.nextLine();

        System.out.print("Please, enter your password: ");
        String password = input.nextLine();

        System.out.print("Please, enter your nick name: ");
        String nick = input.nextLine();

        Account conta = new Account(name, nick, password);

        if(accounts.containsKey(conta.getNick()))
        {
            System.out.print("\nNick name already registered!\n\n");
        }

        else
        {
            accounts.put(conta.getNick(), conta);
            System.out.print("\nAccount Successfully Registered!\n");
        }

        System.out.print("Returning to the Main Menu...\n\n");
    }

    public void login()
    {
        boolean logged;
        Account conta;
        System.out.print("Please, enter your Nick Name: ");
        String nick = input.nextLine();

        System.out.print("Please, enter your password: ");
        String password = input.nextLine();

        if(accounts.containsKey(nick))
        {
            if(Objects.equals(accounts.get(nick).getPassword(), password))
            {
                logged = true;
            }

            else
            {
                System.out.print("\nPassword Incorrect!\n\n");
                logged = false;
            }
        }

        else
        {
            System.out.print("\nAccount isn't registered!\n\n");
            logged = false;
        }

        if(logged)
        {
            conta = accounts.get(nick);
            int op = 0;
            boolean correctInput;
            System.out.print("\nWelcome " + conta.getNick() + "!\n\n");

            while(op != 14)
            {
                System.out.print("What do you want to do?\n");
                correctInput = false;

                while(!correctInput)
                {
                    try{
                        System.out.print("1 - Verify Account information;\n");
                        System.out.print("2 - Change account information;\n");
                        System.out.print("3 - Add a friend;\n");
                        System.out.print("4 - Check for friendship requests;\n");
                        System.out.print("5 - Verify friend list;\n");
                        System.out.print("6 - Send a message;\n");
                        System.out.print("7 - Check for messages;\n");
                        System.out.print("8 - Verify message list;\n");
                        System.out.print("9 - Create a community;\n");
                        System.out.print("10 - Join a community;\n");
                        System.out.print("11 - Manage community;\n");
                        System.out.print("12 - Verify community list;\n");
                        System.out.print("13 - Delete account;\n");
                        System.out.print("14 - Log out.\n");
                        op = Integer.parseInt(input.nextLine());

                        correctInput = true;
                    }

                    catch(Exception e){
                        System.out.print("\nInput isn't a Integer!" + "\n" + "Please, try again:\n\n");
                    }
                }

                if(op == 1)
                {
                    conta.printInfo();
                }

                if(op == 2)
                {
                    System.out.print("What information do you want to change?\n");
                    correctInput = false;
                    int op2 = 0;

                    while(!correctInput)
                    {
                        try{
                            System.out.print("1 - Name\n");
                            System.out.print("2 - Password\n");
                            System.out.print("3 - Nick Name\n");
                            op2 = Integer.parseInt(input.nextLine());

                            correctInput = true;
                        }

                        catch (Exception e){
                            System.out.print("\nInput isn't a Integer!" + "\n" + "Please, try again:\n\n");
                        }
                    }

                    if(op2 == 1)
                    {
                        System.out.print("Please, enter your new name: ");
                        String name = input.nextLine();
                        conta.setName(name);

                        System.out.print("\nName Changed!\n\n");
                    }

                    if(op2 == 2)
                    {
                        System.out.print("Please, enter your new password: ");
                        String newPassword = input.nextLine();
                        conta.setPassword(newPassword);

                        System.out.print("\nPassword Changed!\n\n");
                    }

                    if(op2 == 3)
                    {
                        System.out.print("Please, enter your new nick name: ");
                        String newNick = input.nextLine();

                        if(accounts.containsKey(newNick))
                        {
                            System.out.print("\nNick name already registered!\n\n");
                        }

                        else
                        {
                            conta.setNick(newNick);

                            accounts.remove(nick);
                            accounts.put(newNick, conta);

                            System.out.print("\nNick Name Changed!\n\n");
                        }
                    }
                }

                if(op == 3)
                {
                    System.out.print("Please, enter your friend's nick name: ");
                    String friendNick = input.nextLine();
                    Account friend = accounts.get(friendNick);

                    if(!accounts.containsKey(friendNick))
                    {
                        System.out.print("\nAccount not found!\n\n");
                    }

                    else if(conta.haveFriend(friendNick))
                    {
                        System.out.print("\nAlready friends!\n\n");
                    }

                    else if(friend.haveRequested(conta.getNick()))
                    {
                        System.out.print("\nAlready requested!\n\n");
                    }

                    else
                    {
                        friend.addRequest(conta);
                        System.out.print("\nRequest Sent!\n\n");
                    }
                }

                if(op == 4)
                {
                    ArrayList<String> friend_requests = conta.getRequests();
                    int accept = 1;

                    while(!friend_requests.isEmpty())
                    {
                        correctInput = false;
                        String friendNick = friend_requests.get(0);

                        System.out.print("You have a friend request from " + friendNick + "\n");

                        while(!correctInput)
                        {
                            try{
                                System.out.print("Press 1 to accept or 2 to deny\n");
                                accept = Integer.parseInt(input.nextLine());

                                correctInput = true;
                            }

                            catch(Exception e){
                                System.out.print("\nInput isn't a Integer!" + "\n" + "Please, try again:\n\n");
                            }
                        }

                        friend_requests.remove(0);

                        if(accept == 1)
                        {
                            Account friend = accounts.get(friendNick);
                            conta.addFriend(friend);
                            friend.addFriend(conta);
                        }
                    }

                    if(friend_requests.isEmpty()) System.out.print("\nNo friend requests!\n\n");
                }

                if(op == 5)
                {
                    conta.printFriends();
                }

                if(op == 6)
                {
                    System.out.print("Please, enter your friend's nick name: ");
                    String friendNick = input.nextLine();

                    if(!conta.haveFriend(friendNick) || !accounts.containsKey(friendNick))
                    {
                        System.out.print("\nFriend not found!\n\n");
                    }

                    else {
                        System.out.print("Please, write your message:\n");
                        String content = input.nextLine();

                        Message message = new Message(conta, accounts.get(friendNick), content);
                        Account friend = accounts.get(friendNick);
                        friend.addMessage(message);

                        System.out.print("\nMessage Sent!\n\n");
                    }
                }

                if(op == 7)
                {
                    conta.checkMessages();
                }

                if(op == 8)
                {
                    conta.printMessages();
                }

                if(op == 9)
                {
                    System.out.print("Please, enter the name of your's new community: ");
                    String name = input.nextLine();

                    if(communitys.containsKey(name))
                    {
                        System.out.print("\nCommunity already exist!\n\n");
                    }

                    else
                    {
                        System.out.print("Please, enter the community's description: ");
                        String description = input.nextLine();

                        Community newCommunity = new Community(name, description, conta);
                        communitys.put(name, newCommunity);
                        conta.addCommunity(newCommunity);

                        System.out.print("\nCommunity successfully created!\n\n");
                    }
                }

                if(op == 10)
                {
                    System.out.print("Please, enter the community's name: ");
                    String name = input.nextLine();

                    if(!communitys.containsKey(name))
                    {
                        System.out.print("\nCommunity not found!\n\n");
                    }

                    else if(communitys.get(name).containsMember(conta.getNick()))
                    {
                        System.out.print("\nYou are already a member of this community!\n\n");
                    }

                    else
                    {
                        communitys.get(name).addRequest(conta);

                        System.out.print("\nJoin request sent to the community's owner!\n\n");
                    }
                }

                if(op == 11)
                {
                    System.out.print("Please, enter your community name: ");
                    String name = input.nextLine();

                    if(!communitys.containsKey(name))
                    {
                        System.out.print("\nCommunity not found!\n\n");
                    }

                    else if(!Objects.equals(conta.getNick(), communitys.get(name).getOwnerNick()))
                    {
                        System.out.print("\nYou aren't the owner of this community!\n\n");
                    }

                    else {
                        int op_manage = 0;
                        Community managing = communitys.get(name);

                        while (op_manage != 5) {
                            correctInput = false;
                            System.out.print("What do you want to do?\n\n");

                            while (!correctInput) {
                                try {
                                    System.out.print("1 - Add member\n");
                                    System.out.print("2 - Check join requests\n");
                                    System.out.print("3 - Remove member\n");
                                    System.out.print("4 - Check members\n");
                                    System.out.print("5 - Return to the Iface main menu\n");
                                    op_manage = Integer.parseInt(input.nextLine());

                                    correctInput = true;
                                } catch (Exception e) {
                                    System.out.print("\nInput isn't a Integer!" + "\n" + "Please, try again:\n\n");
                                }
                            }

                            if (op_manage == 1) {
                                System.out.print("Please, enter the new member's nick name: ");
                                String memberName = input.nextLine();

                                if (!accounts.containsKey(memberName)) {
                                    System.out.print("\nAccount not found!\n\n");
                                } else if (managing.containsMember(memberName)) {
                                    System.out.print("\nAccount is already a member!\n\n");
                                } else {
                                    managing.addMember(accounts.get(memberName));

                                    System.out.print("\nMember successfully added!\n\n");
                                }
                            }

                            if (op_manage == 2) {
                                managing.checkRequests();
                            }

                            if (op_manage == 3) {

                                System.out.print("Please, enter the new member's nick name: ");
                                String memberName = input.nextLine();

                                if (!accounts.containsKey(memberName)) {
                                    System.out.print("\nAccount not found!\n\n");
                                } else if (!managing.containsMember(memberName)) {
                                    System.out.print("\nAccount isn't a member!\n\n");
                                } else {
                                    Account exMember = accounts.get(memberName);
                                    managing.removeMember(exMember);
                                    exMember.removeCommunity(managing);

                                    System.out.print("\nMember kicked!\n\n");
                                }
                            }

                            if (op_manage == 4) {
                                managing.printMembers();
                            }

                            if(op_manage>5 || op_manage<1){
                                System.out.print("\nPlease, enter a valid operation number.\n\n");
                            }

                        }
                    }
                }

                if(op == 12)
                {
                    conta.printCommunitys();
                }

                if(op == 13)
                {
                    conta.removeFromCommunitys();
                    conta.removeFriends();
                    accounts.remove(conta.getNick(), conta);
                    System.out.print("\nAccount deleted!\n\n");

                    op = 14;
                }

                if(op<1 || op>14)
                {
                    System.out.print("\nPlease, enter a valid operation number.\n\n");
                }
            }
        }
    }
}
