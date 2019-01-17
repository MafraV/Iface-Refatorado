import java.util.*;

public class Community{

    private String name;
    private String description;
    private Account owner;
    private Map<String, Account> members = new HashMap<String, Account>();
    private ArrayList<Account> joinRequests = new ArrayList<Account>();
    Scanner input = new Scanner(System.in);

    public Community(String name, String description, Account owner)
    {
        this.name = name;
        this.description = description;
        this.owner = owner;
        members.put(owner.getNick(), owner);
    }

    public boolean containsMember(String nick){ return members.containsKey(nick); }

    public void addRequest(Account x) { joinRequests.add(x); }

    public String getOwnerNick() { return owner.getNick(); }

    public void addMember(Account x){ members.put(x.getNick(), x); }

    public void checkRequests()
    {
        if(joinRequests.isEmpty())
        {
            System.out.print("\nNo join requests!\n\n");
        }

        else
        {
            while(!joinRequests.isEmpty())
            {
                boolean correctInput = false;
                int accept = 0;
                String nick = joinRequests.get(0).getNick();
                System.out.print(nick + " want to join your community\n");


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

                if(accept == 1)
                {
                    Account member = joinRequests.get(0);
                    members.put(nick, member);
                    member.addCommunity(this);

                    joinRequests.remove(0);
                    System.out.print("\nMember accepted!\n\n");
                }
            }
        }
    }

    public void removeMember(Account x){ members.remove(x.getNick(), x); }

    public void printMembers()
    {
        Set membersKeys = members.keySet();
        System.out.print("\nMembers:\n" + membersKeys + "\n\n");
    }

    public String getName(){ return this.name; };
}
